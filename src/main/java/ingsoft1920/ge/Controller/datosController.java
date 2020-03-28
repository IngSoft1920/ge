package ingsoft1920.ge.Controller;

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

import ingsoft1920.ge.Beans.ReservaHotel;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class datosController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	@Autowired 
	ReservaHotel reserva;
	
	@GetMapping("/datos")
	public String opcionesAutentificacion(Model model) {
		
		
		
		return "datos";

	}
	
	@PostMapping("/reserva/login")
	public String reserva(Model model) throws Exception {
		
		/*
		 * Se envía la reserva 
		 * 
		 * {
 		 *		"fecha_entrada" : “2020-02-10”,
 		 *		"fecha_salida" : “2020-02-15”,
 		 *		"importe" : 400,
 		 *		"regimen" : “no_aplica”, // Valores posibles:"no_aplica","media_pension","pension_completa","todo_incluido"
 		 *		"cliente_id" : 14,
 		 *		"hotel_id" : 11,
 		 *		"tipo_hab_id" : 9,
 		 *		"numero_acompanantes" : 21
		 * }
		 */
		
		JsonObject json_reserva = new JsonObject();
		json_reserva.addProperty("cliente_id", sesionBean.getUsuarioID());
		json_reserva.addProperty("hotel_id", reserva.getHotel_id());
		json_reserva.addProperty("tipo_hab_id", reserva.getHabitacion_id());
		json_reserva.addProperty("fecha_entrada", reserva.getFecha_inicio());
		json_reserva.addProperty("fecha_salida", reserva.getFecha_fin());
		json_reserva.addProperty("importe", reserva.getTarifa());
		json_reserva.addProperty("regimen", "no_aplica");
		json_reserva.addProperty("numero_acompanantes", 1);
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		JsonObject reserva_id = new Gson().fromJson(response, JsonObject.class);
		
		reserva.resetReserva();
		
		return "redirect:misReservas";
	}
	
	@PostMapping("/reservaAnonima")
	public String reservaAnonima(Model model, 
			@Valid @ModelAttribute("email") String email) throws Exception {
		
		/*
		 * Se envía la resrva anónima
		 * 
		 * {
 		 *		"fecha_entrada" : “2020-02-10”,
 		 *		"fecha_salida" : “2020-02-15”,
 		 *		"importe" : 400,
 		 *		"regimen" : “no_aplica”, // Valores posibles:"no_aplica","media_pension","pension_completa","todo_incluido"
 		 *		"email_cliente" : "juan@gmail.com",
 		 *		"hotel_id" : 11,
 		 *		"tipo_hab_id" : 9,
 		 *		"numero_acompanantes" : 21
		 * }
		 */
		
		JsonObject json_reserva = new JsonObject();
		json_reserva.addProperty("email_cliente", email);
		json_reserva.addProperty("hotel_id", reserva.getHotel_id());
		json_reserva.addProperty("tipo_hab_id", reserva.getHabitacion_id());
		json_reserva.addProperty("fecha_entrada", reserva.getFecha_inicio());
		json_reserva.addProperty("fecha_salida", reserva.getFecha_fin());
		json_reserva.addProperty("importe", reserva.getTarifa());
		json_reserva.addProperty("regimen", "no_aplica");
		json_reserva.addProperty("numero_acompanantes", 1);
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva/anonima", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		JsonObject reserva_cliente = new Gson().fromJson(response, JsonObject.class);
		
		reserva.resetReserva();
		
		return "redirect:";
	}
}