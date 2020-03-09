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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class IncidenciasController {

	final static Logger logger = LogManager.getLogger(IncidenciasController.class.getName());


	@Autowired
	IncidenciasBean incidenciasBean;
	
	@Autowired
	 SesionBean sesion;

	
	//enviar incidencia
	@PostMapping("/incidencias") //cambiar endpoint
	public  String enviarIncidencias(@Valid @ModelAttribute("incidenciasBean") IncidenciasBean incidenciasBean,
			Model model) throws Exception {
			
			HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "POST");
			
			JsonObject json = new JsonObject();
			
			client.setRequestBody(""+sesion.getUsuarioID()+beanToJson(incidenciasBean)); //añadir id usuario y id reserva
			
			int respCode = client.getResponseCode();

			String resp="";
			if(respCode==200) {
				resp=client.getResponseBody();
			}
	        model.addAttribute("sesionBean", sesion);

			return "incidencias";
	}
	
	//pedir asuntos disponibles
//	@GetMapping("/incidencias") //cambiar endpoint
//	public String recibirAsuntos(@Valid @ModelAttribute("incidenciasBean") IncidenciasBean incidenciasBean,
//			Model model) throws Exception {
//
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "GET");
//		
//		String respuesta=client.getResponseBody();
//
//		int respCode = client.getResponseCode();
//
//		String resp="";
//		if(respCode==200) {
//			resp=client.getResponseBody();
//		}
//        model.addAttribute("sesionBean", sesion);
//
//		return respuesta;
//	}
	
	

	@GetMapping("/incidencias")
	public String Incidencias(Model model) {
        model.addAttribute("sesionBean", sesion);
        
		return "incidencias";
	}
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}
}