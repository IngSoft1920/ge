
package ingsoft1920.ge.Controller;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.HotelesDisponiblesBean;
import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.ReservaHotel;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class CambiarReservasController {

	final static Logger logger = LogManager.getLogger(CambiarReservasController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	ReservaBean reservaBean;
	
	MostrarServiciosPostReservaBean[] misServicios;
	
	List<HabitacionBean> habsDispo;
	
	int reserva_id;
	
	// Método para extraer toda la información de la reserva y meterla en el objeto ReservaHotel
	public void recuperarReservas () throws Exception {
		// Obtenemos la inforación de la reserva de la habitación
		/*
		 * 	{
			  reserva_id : 21,
			  hotel_id : 1,
			  hotel_nombre: "New Japón",
			  tipo_hab_id: 1,
			  tipo_hab_nombre : “normal”,
			  regimen : “no_aplica”,
			  importe : “300”,
			  fecha_entrada : “2020-02-10”,
			  fecha_salida : “2020-02-15”,
			  valoracion: 4
			},
		 */
		
		HttpClient serverReservas = new HttpClient( HttpClient.urlCM +"reserva/cliente/" + sesionBean.getUsuarioID(), "GET");

		String response = "";
		if (serverReservas.getResponseCode() == 200) {// Si encuentra el servidor
			response = serverReservas.getResponseBody(); 
		}
		
		Type tipo = new TypeToken<List<ReservaBean>>(){}.getType();
		List<ReservaBean> reservas = new Gson().fromJson(response, tipo);
		
		reservaBean = reservas.stream().filter
				(reserva -> reserva.getReserva_id() == reserva_id)
				.collect(Collectors.toList()).get(0);
		
		/*Esta llamada es para encontrar el id_estancia de DHO
		 *  /////// Esto fallará si hay más de una reserva entre los mismos dias
		 *  /////// por parte del mismo cliente, ya que la única forma que 
		 *  /////// tenemos de identificar la reserva correcta es por las 
		 *  /////// fechas de entrada y salida
		 * 	{
			 "id_estancia_lista": Integer[],
			 "num_hab_lista": Integer,
			 "fecha_Inicio_Lista": String[],
			 "fecha_Fin_Lista": String[],
			 "nombre_hotel_Lista":String[],
			 "is_check_in": Boolean
			}
		 */
		HttpClient serverServicios = new HttpClient( HttpClient.urlDHO +"reservas", "POST");
		JsonObject cliente = new JsonObject();
		cliente.addProperty("id_cliente", sesionBean.getUsuarioID());
		serverServicios.setRequestBody(cliente.toString());
		if (serverServicios.getResponseCode() == 200) {// Si encuentra el servidor
			response = serverServicios.getResponseBody(); 
		}
		
		JsonObject jsonReservas = new Gson().fromJson(response, JsonObject.class);
		String[] fechas_inicio = new Gson().fromJson(
				jsonReservas.get("fecha_Inicio_Lista"), String[].class);
		String[] fechas_fin = new Gson().fromJson(
				jsonReservas.get("fecha_Fin_Lista"), String[].class);
		int[] ids_estancia = new Gson().fromJson(
				jsonReservas.get("id_estancia_lista"), int[].class);
		
		int id_estancia = -1;
		for (int i = 0; i < fechas_inicio.length; i++) {
			if (fechas_inicio[i].compareToIgnoreCase(
						reservaBean.getFecha_entrada()) == 0 &&
				fechas_fin[i].compareToIgnoreCase(
						reservaBean.getFecha_salida()) == 0) {
				id_estancia = ids_estancia[i];
			}
		}
		
		if(id_estancia == -1)
			System.out.println("ERROR: MELÓN");
		
		/* Llamamos a /serviciosReservados con el cliente y la estancia
		 * 	{
			   "id_cliente": Integer,
			   "id_estancia": Integer
			}
		 */
		HttpClient serverEstancia = new HttpClient( HttpClient.urlDHO +"serviciosReservados", "POST");
		JsonObject estancia = new JsonObject();
		estancia.addProperty("id_cliente", sesionBean.getUsuarioID());
		estancia.addProperty("id_estancia", id_estancia);
		serverEstancia.setRequestBody(estancia.toString());
		if (serverEstancia.getResponseCode() == 200) {// Si encuentra el servidor
			response = serverEstancia.getResponseBody(); 
		}
		JsonObject servicio = new Gson().fromJson(response, JsonObject.class);
		String[] fecha = new Gson().fromJson(servicio.get("fecha"), String[].class);
		String[] nombreServicio = new Gson().fromJson(servicio.get("nombreServicio"), String[].class);
		
		misServicios = new MostrarServiciosPostReservaBean[fecha.length];
		for (int i = 0; i < fecha.length; i++) {
			misServicios[i] = new MostrarServiciosPostReservaBean();
			misServicios[i].setFecha(fecha[i]);
			misServicios[i].setTipoServicio(nombreServicio[i]);
		}
		
	}
	
	public void habitacionesDisponibles() throws Exception {
		
		String response = "";
		
		HttpClient server = new HttpClient(
				HttpClient.urlCM+"hotel/disponibles?" + 
				"fecha_inicio=" + reservaBean.getFecha_entrada() +
				"&fecha_fin=" + reservaBean.getFecha_salida(), "GET");

		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		Type typeHoteles = new TypeToken<List<JsonObject>>(){}.getType();
		ArrayList<JsonObject> habitaciones = 
				new Gson().fromJson(response,typeHoteles);
		
		JsonObject hab = habitaciones.stream()
				.filter(habi -> habi.get("hotel_id").getAsInt() == reservaBean.getHotel_id())
				.collect(Collectors.toList()).get(0);
		
		Type typeHabitaciones = new TypeToken<List<HabitacionBean>>(){}.getType();
		habsDispo = new Gson().fromJson(hab.get("habitaciones"), typeHabitaciones);
		logger.info(hab.toString());
	}
	
	@GetMapping("/cambiarReservas/{reserva_id}")
	public String cambiarReservasGet(@PathVariable int reserva_id, Model model) throws Exception {
		this.reserva_id = reserva_id;
		
		recuperarReservas();
		
		habitacionesDisponibles();
		
		model.addAttribute("reserva", reservaBean);
		model.addAttribute("tipoHabitacion", habsDispo);
		model.addAttribute("sesionBean", sesionBean);
		
		return "cambiarReservas";
	}

	@PostMapping("/cambiarFecha")
	public String cambiarFecha(
			@Valid @ModelAttribute("fechaInicio") String fechaInicio, 
			@Valid @ModelAttribute("fechaFin") String fechaFin, 
			Model model) throws Exception{
		logger.info("Nueva fechaInicio: " + fechaInicio + ". Nueva fechaFin: "+ fechaFin);
		// Faltaría comprobar que las fechas son correctas, que hay disponibilidad, etc.
		reservaBean.setFecha_entrada(fechaInicio);
		reservaBean.setFecha_salida(fechaFin);
		
		cancelarHabitacion();
		this.reserva_id = reservaHabitacion();
		
		return "redirect:cambiarReservas/"+this.reserva_id;
	}
	
	@PostMapping("/cambiarHabitacionTipo")
	public String cambiarHabitacionTipo(
			@Valid @ModelAttribute("habitacionTipo") int habitacionTipo, 
			Model model) throws Exception {
		
		logger.info("Nuevo id habitacion " + habitacionTipo);
		reservaBean.setTipo_hab_id(habitacionTipo);
		
		cancelarHabitacion();
		this.reserva_id = reservaHabitacion();
		
		return "redirect:cambiarReservas/"+this.reserva_id;
		
	}
	
	@PostMapping("/cambiarRegimen")
	public String cambiarRegimen(
			@Valid @ModelAttribute("comidas") String regimen, 
			Model model) throws Exception {
		
		logger.info("Nuevo regimen " + regimen);
		String valor = "";
		if (regimen.compareTo("1") == 0) valor= "no_aplica";
		else if (regimen.compareTo("2") == 0) valor= "media_pension";
		else if (regimen.compareTo("3") == 0) valor= "pension_completa";
		else if (regimen.compareTo("4") == 0) valor= "todo_incluido";
		reservaBean.setRegimen(valor);
		
		cancelarHabitacion();
		this.reserva_id = reservaHabitacion();
		
		return "redirect:cambiarReservas/"+this.reserva_id;
		
	}
	
	@PostMapping("/cancelarCR")
	public String cancelarReserva(@Valid @ModelAttribute("reserva_id") String reserva_id) throws Exception {

		HttpClient serverReservas = new HttpClient( HttpClient.urlCM + "reserva/eliminar/" + reserva_id, "POST");
		int codigoRespuesta = serverReservas.getResponseCode();
		if(codigoRespuesta==200)	
		{
			//serverReservas.getResponseBody();
		}
		logger.info("Cancelando la reserva " + reserva_id);

		return "redirect:/misReservas";
	}
	
	public void cancelarHabitacion() throws Exception {
		HttpClient serverReservas = new HttpClient( HttpClient.urlCM + "reserva/eliminar/" + reserva_id, "POST");
		int codigoRespuesta = serverReservas.getResponseCode();
		if(codigoRespuesta==200)	
		{
			//serverReservas.getResponseBody();
		}
		logger.info("Cancelando la reserva " + reserva_id);
	}
	
	public int reservaHabitacion () throws Exception {
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
		json_reserva.addProperty("hotel_id", reservaBean.getHotel_id());
		json_reserva.addProperty("tipo_hab_id", reservaBean.getTipo_hab_id());
		json_reserva.addProperty("fecha_entrada", reservaBean.getFecha_entrada());
		json_reserva.addProperty("fecha_salida", reservaBean.getFecha_salida());
		json_reserva.addProperty("importe", reservaBean.getImporte());
		json_reserva.addProperty("regimen", reservaBean.getRegimen());
		json_reserva.addProperty("numero_acompanantes", 1);
		json_reserva.addProperty("metodo_pago", "pagado");
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		JsonObject reserva_id = new Gson().fromJson(response, JsonObject.class);
		
		return reserva_id.get("id").getAsInt();
		
	}
	
}

