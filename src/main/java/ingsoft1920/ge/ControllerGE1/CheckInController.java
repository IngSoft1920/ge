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
	public String checkinEnviar(@Valid @ModelAttribute("checkInBean") CheckInBean checkInBean,
			Model model) throws Exception {
		
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/envioCheckIn", "POST");
		JsonObject json = new JsonObject();
		json.addProperty("usuarioID", sesion.getUsuarioID());
		json.addProperty("idReserva", checkin.getIdReserva());
		json.addProperty("horaLlegada", checkin.getHoraLlegada());
		json.addProperty("comentario", checkin.getComentario());
	
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}

		return "";
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
