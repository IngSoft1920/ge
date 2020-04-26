package ingsoft1920.ge.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ReservaHotel;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class MetodoPagoController {

	final static Logger logger = LogManager.getLogger(MetodoPagoController.class.getName());
	
	@Autowired
	SesionBean sesionBean;
	
	@Autowired
	ReservaHotel reserva;
	
	
	@GetMapping("/metodopago")
	public String metodopago(Model model) {
		
		
		return "metodopago";
	}
	
	@GetMapping("/efectivo")
	public String efectivo(Model model) throws Exception {
		
		reserva.setPagado("efectivo");
		
		if (reserva.getCliente().length() != 0) {
			reservaAnonima();
		}
		else {
			reservaHabitacion();
		}
		
		return "redirect:misReservas";
	}
	
	@GetMapping("/tarjeta")
	public String tarjeta(Model model) throws Exception {
		
		reserva.setPagado("pagado");
		
		if (reserva.getCliente().length() != 0) {
			reservaAnonima();
		}
		else {
			reservaHabitacion();
		}
		
		return "redirect:misReservas";
	}
	
	public void reservaServicios (int cliente_id) throws Exception {
		
		/*
		 * Formato de servicios
		 * 
		 * { 
  		 *		"lugar":String 
  		 *		"id_servicioHotel":int
  		 *		"fecha": Date
  		 *		"hora": Time
  		 *		"cliente_id":int
		 * }
		 */
		
		for(MostrarServiciosPostReservaBean s: reserva.getServicios()) {
			
			HttpClient server = new HttpClient(HttpClient.urlDHO + "recibirServicio", "POST");
			
			JsonObject json_reserva = new JsonObject();
			json_reserva.addProperty("lugar", s.getTipoServicio());
			json_reserva.addProperty("id_servicioHotel", s.getId());
			json_reserva.addProperty("fecha", s.getFecha());
			json_reserva.addProperty("hora", s.getHora());
			json_reserva.addProperty("cliente_id", cliente_id);

			server.setRequestBody(json_reserva.toString());
			server.getResponseCode();
		}


	}	
	
	public void reservaHabitacion () throws Exception {
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
 		 *		"numero_acompanantes" : 21,
 		 *		"pagado": "efectivo" // ó "pagado"
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
		json_reserva.addProperty("pagado", reserva.getPagado());
		
		
		
		//String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			//response = server.getResponseBody();
			server.getResponseBody();
		}
		//JsonObject reserva_id = new Gson().fromJson(response, JsonObject.class);
		
		reservaServicios(sesionBean.getUsuarioID());
		
		reserva.resetReserva();
	}
	
	public void reservaAnonima() throws Exception {
		
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
		json_reserva.addProperty("email_cliente", reserva.getCliente());
		json_reserva.addProperty("hotel_id", reserva.getHotel_id());
		json_reserva.addProperty("tipo_hab_id", reserva.getHabitacion_id());
		json_reserva.addProperty("fecha_entrada", reserva.getFecha_inicio());
		json_reserva.addProperty("fecha_salida", reserva.getFecha_fin());
		json_reserva.addProperty("importe", reserva.getTarifa());
		json_reserva.addProperty("regimen", reserva.regimen());
		json_reserva.addProperty("numero_acompanantes", 1);
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva/anonima", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		JsonObject reserva_cliente = new Gson().fromJson(response, JsonObject.class);
		
		reservaServicios(reserva_cliente.get("cliente_id").getAsInt());
		int alfonso = reserva_cliente.get("cliente_id").getAsInt();
		System.out.println(alfonso);
		reserva.resetReserva();
		
		sesionBean.setUsuarioID(reserva_cliente.get("cliente_id").getAsInt());
		sesionBean.setUsuario(reserva.getCliente().split("@")[0]);
	}
	

}
