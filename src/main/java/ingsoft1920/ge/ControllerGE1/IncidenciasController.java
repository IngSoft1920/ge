package ingsoft1920.ge.ControllerGE1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.Controller.datosController;
import ingsoft1920.ge.ControllerGE1.VerReservasController;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class IncidenciasController {

	final static Logger logger = LogManager.getLogger(IncidenciasController.class.getName());

	Calendar calendario = Calendar.getInstance();
	static Date fechaActual = new Date();
	static DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
	DateFormat formatoHora = new SimpleDateFormat("HH:mm");

	@Autowired
	SesionBean sesion;
	VerReservasBean reservas;

	// enviar incidencia
	@PostMapping("/procesarIncidencias")
	public String enviarIncidencias(@Valid @ModelAttribute("Incidencia") IncidenciasBean Incidencia, Model model)
			throws Exception {

		String mensaje_enviado = Incidencia.getMensaje();

		if (mensaje_enviado.startsWith("Otro")) {
			mensaje_enviado = mensaje_enviado.replaceFirst("Otro,", ""); // se quita la parte de 'otro'
			System.out.println("SE METE   " + mensaje_enviado);
			System.out.println("HOTEL   " + VerReservasController.reservilla.getNombre_hotel());
		}

		HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/informarIncidencia", "POST");

		JsonObject json = new JsonObject();
		json.addProperty("cliente_id", datosController.ALFONSO);
		json.addProperty("asunto", Incidencia.getAsunto());
		json.addProperty("descripcion", mensaje_enviado);
		json.addProperty("nombre_hotel", VerReservasController.reservilla.getNombre_hotel());
		//json.addProperty("nombre_hotel", "hotel_prueba");
		json.addProperty("fecha", formatoFecha.format(fechaActual));
		json.addProperty("hora", formatoHora.format(fechaActual));
		json.addProperty("lugar", VerReservasController.reservilla.getNum_hab());

		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		if (respCode == 200) {
			client.getResponseBody();
		}

		return "procesarIncidencias";
	}
	
	@GetMapping("/incidencias")
	public static ModelAndView recibirIncidencias(Model model) throws Exception{
		
		
		IncidenciasBean Incidencia = new IncidenciasBean(); //crear bean de incidencias
		model.addAttribute("Incidencia", Incidencia); //añadir el bean al modelo

		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/pasarIncidenciasCliente/"+datosController.ALFONSO, "POST");
		
		
		 //madamos el id de cliente

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		System.out.print(resp.toString());
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		
		JsonArray incidencias_hechas= obj.get("tipo_incidencia").getAsJsonArray();//cogemos el nombre de la incidencia

		List<String> incidencias= new LinkedList<>();
		for (int i=0;i<incidencias_hechas.size();i++) {
			incidencias.add(incidencias_hechas.get(i).getAsString());
			System.out.print(incidencias.get(i));
		}
		
		JsonArray incidencias_fechas= obj.get("fecha").getAsJsonArray();//cogemos la fecha en la que se ha procesado la incidencia
		JsonArray incidencias_horas= obj.get("hora").getAsJsonArray();//cogemos la hora a la que se ha procesado la incidencia

		List<String> fechas= new LinkedList<>();
		for (int i=0;i<incidencias_fechas.size();i++) {
			fechas.add(incidencias_fechas.get(i).getAsString());
		}
		
		List<String> horas= new LinkedList<>();
		for (int i=0;i<incidencias_horas.size();i++) {
			fechas.add(incidencias_horas.get(i).getAsString());
		}
		
		
		Map<String,List<String>> map= new HashMap<>();
		map.put("nombre", incidencias);
		map.put("fechas", fechas);
		map.put("horas", horas);
		//System.out.println(reservas);
		//System.out.println(fechas);
        //System.out.println((JsonObject) JsonParser.parseString(resp)); //both reservas & fechas
        
		
		return new ModelAndView("incidencias", "incidencias_realizadas", map);
	}

	// CODIGO DE PRUEBA ABAJO
	// @RequestMapping("/procesarIncidencias")
	// public String index(@ModelAttribute("Incidencia") IncidenciasBean Incidencia,
	// HttpServletRequest request) {
	//
	//// System.out.println("ASUNTO " + Incidencia.getAsunto());
	//// System.out.println("MENSAJE " + Incidencia.getMensaje());
	//// System.out.println("ID_USER " + sesion.getUsuarioID());
	//// //System.out.println("NOMBRE_HOTEL " + reservas.getNombre_hotel());
	//// System.out.println("FECHA " + formatoFecha.format(fechaActual));
	//// System.out.println("HORA " + formatoHora.format(fechaActual));
	//// System.out.println("LUGAR " + "H49");
	//
	// String mensaje_enviado = Incidencia.getMensaje();
	//
	// if(mensaje_enviado.startsWith("Otro")) {
	// mensaje_enviado=mensaje_enviado.replaceFirst("Otro,", ""); //se quita la
	// parte de 'otro'
	// System.out.println("SE METE " + mensaje_enviado);
	// }
	//
	// return "procesarIncidencias";
	// }

	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);
		return JSON;
	}
}