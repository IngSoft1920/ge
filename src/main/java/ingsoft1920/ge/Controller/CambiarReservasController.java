
package ingsoft1920.ge.Controller;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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
	
	ReservaHotel miReserva;
	
	MostrarServiciosPostReservaBean[] misServicios;
	
	
	// Método para extraer toda la información de la reserva y meterla en el objeto ReservaHotel
	public void recuperarReservas (int reserva_id) throws Exception {
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
			misServicios[i].setFecha(fecha[i]);
			misServicios[i].setTipoServicio(nombreServicio[i]);
		}
		
	}
	
	@GetMapping("/cambiarReservas/{reserva_id}")
	public String cambiarReservasGet(@PathVariable int reserva_id, Model model) throws Exception {
		
		
		recuperarReservas(reserva_id);
		model.addAttribute("reserva", reservaBean);
		
		return "cambiarReservas";
	}

	@PostMapping("/cambiarReservas")
	public String cambiarReservasPost( Model model) throws Exception{
		return null;
		
	}	
	
}

