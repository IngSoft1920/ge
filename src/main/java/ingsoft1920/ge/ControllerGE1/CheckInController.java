package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import com.google.gson.*;

@Controller
public class CheckInController {
	
	final static Logger logger = LogManager.getLogger(CheckInController.class.getName());
	
	@Autowired
	CheckInBean checkin;
	
	
	@Autowired
	SesionBean sesion;
	
	
	//enviar check-in
	@PostMapping("/envioCheckIn")
	public JsonObject checkinEnviar(@Valid @ModelAttribute("checkInBean") CheckInBean checkInBean,
			Model model) throws Exception {
		
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/*no se sabe", "POST");
		JsonObject json = new JsonObject();
		json.addProperty("usuarioID", sesion.getUsuarioID());
	
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp ="";
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			resp=client.getResponseBody();
		}
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		String cliente_id = obj.get("cliente_id").toString();
		String nombre = obj.get("nombre").toString();
		String apellidos = obj.get("apellidos").toString();
		String DNI = obj.get("DNI").toString();
		String email = obj.get("email").toString();
		String password = obj.get("password").toString();
		String nacionalidad = obj.get("nacionalidad").toString();
		String telefono = obj.get("telefono").toString();
		
		//si algun campo esta vacio hay que redirigir a una pagna que todavia no esta hecha
		if(cliente_id.isEmpty() && nombre.isEmpty() && DNI.isEmpty() && email.isEmpty() && 
				password.isEmpty() && nacionalidad.isEmpty() && telefono.isEmpty()){
			//redireccionar a pagina
		}
		
		
		return obj;
	}
	
	@GetMapping("/checkin")
	public static String checkInEnviar() {
		return "checkin";
	}
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

	

}
