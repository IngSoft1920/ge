package ingsoft1920.ge.ControllerGE1;

import java.util.Calendar;

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
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class IncidenciasController {

	final static Logger logger = LogManager.getLogger(IncidenciasController.class.getName());

	Calendar calendario = Calendar.getInstance();
	
	@Autowired
	SesionBean sesion;
	VerReservasBean reservas;

	//ruta a pagina de incidencias
	@GetMapping("/incidencias")
	public String Incidencias(Model model) {
		model.addAttribute("sesionBean", sesion);

		return "incidencias";
	}

	//enviar incidencia
	@PostMapping("/incidencias") //cambiar endpoint
	public  String enviarIncidencias(@Valid @ModelAttribute("incidenciasBean") IncidenciasBean incidencias,
			Model model) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/endpoint", "POST");

		JsonObject json = new JsonObject();
		json.addProperty("asunto",incidencias.getAsunto());
		json.addProperty("descripcion", incidencias.getMensaje());
		json.addProperty("nombre_hotel", reservas.getNombre_hotel());
		json.addProperty("fecha", calendario.get(Calendar.YEAR) + "-" +
				calendario.get(Calendar.MONTH) + "-" + calendario.get(Calendar.DATE));
		json.addProperty("hora", calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE));
		json.addProperty("lugar", "H49");//habitacion de prueba, de momento solo se pueden enviar habitaciones
		
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		return "incidencias";
	}

	//recibir asuntos disponibles
	public String recibirAsuntos(Model model) throws Exception {

		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/*no se sabe endpoint", "POST");

		client.setRequestBody("*no se sabe que piden*");

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		return resp;
	}


	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}
}