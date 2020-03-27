package ingsoft1920.ge.ControllerGE1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestMapping;

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
		}

		HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/informarIncidencia", "POST");

		JsonObject json = new JsonObject();
		json.addProperty("asunto", Incidencia.getAsunto());
		json.addProperty("descripcion", mensaje_enviado);
		// json.addProperty("nombre_hotel", reservas.getNombre_hotel());
		json.addProperty("nombre_hotel", "hotel_prueba");
		json.addProperty("fecha", formatoFecha.format(fechaActual));
		json.addProperty("hora", formatoHora.format(fechaActual));
		json.addProperty("lugar", "H49");// habitacion de prueba, de momento solo se pueden enviar habitaciones

		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		if (respCode == 200) {
			client.getResponseBody();
		}

		return "procesarIncidencias";
	}

	// CODIGO DE PRUEBA ABAJO no borrar
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