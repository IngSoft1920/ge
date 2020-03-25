package ingsoft1920.ge.ControllerGE1;

import java.util.HashMap;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Objetillos.Reserva;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ReservarMesaBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class VerReservasController {
public static JSONObject receivedJSON = new JSONObject();
	
@Autowired
 SesionBean sesion;


@GetMapping("/recibirReservas")
	public  ModelAndView reservasEnviar() throws Exception {
		
		receivedJSON.put("datosReserva", "Datos de su reserva");

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservas","POST");
		JsonObject json= new JsonObject();
		json.addProperty("id_cliente", "1");
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		//numero de reserva
		JsonArray numeros_reservas= obj.get("id_estancia_lista").getAsJsonArray();
		
		//numero de habitacion
		JsonArray numeros_habitaciones= obj.get("num_hab_lista").getAsJsonArray();
		
		
		//fecha inicio
		JsonArray inicio_fechas= obj.get("fecha_Inicio_Lista").getAsJsonArray();
		
		
		//fecha final
		JsonArray final_fechas= obj.get("fecha_Fin_Lista").getAsJsonArray();
		
		
		//nombre hotel
		JsonArray nombre_hoteles= obj.get("nombre_hotel_Lista").getAsJsonArray();
		JsonArray estado= obj.get("estado").getAsJsonArray();
		List<Reserva> reservas= new LinkedList<>();
		for (int i=0;i<nombre_hoteles.size();i++) {
			reservas.add(new Reserva(numeros_reservas.get(i).getAsInt(),numeros_habitaciones.get(i).getAsInt(),inicio_fechas.get(i).getAsString(),final_fechas.get(i).getAsString(),nombre_hoteles.get(i).getAsString(),estado.get(i).getAsString()));
		}
		
		
		
		
	
		
		
		return new ModelAndView("reservaServicios","reservas", reservas);
		
	}

	@GetMapping("/cogerReserva")
	public static String enviarComanda(@Valid@ModelAttribute("VerReservasBean") VerReservasBean mandar_reserva) {
		System.out.print("HOLAAAAA"+mandar_reserva.toString());
		return "index";
			
	}
	
}
