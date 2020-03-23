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
		List<String> num_reserva= new LinkedList<>();
		for (int i=0;i<numeros_reservas.size();i++) {
			num_reserva.add(numeros_reservas.get(i).getAsString());
		}
		//numero de habitacion
		JsonArray numeros_habitaciones= obj.get("num_hab_lista").getAsJsonArray();
		List<String> num_hab= new LinkedList<>();
		for (int i=0;i<numeros_habitaciones.size();i++) {
			num_hab.add(numeros_habitaciones.get(i).getAsString());
		}
		//fecha inicio
		JsonArray inicio_fechas= obj.get("fecha_Inicio_Lista").getAsJsonArray();
		List<String> fech_i= new LinkedList<>();
		for (int i=0;i<inicio_fechas.size();i++) {
			fech_i.add(inicio_fechas.get(i).getAsString());
		}
		//fecha final
		JsonArray final_fechas= obj.get("fecha_Fin_Lista").getAsJsonArray();
		List<String> fech_f= new LinkedList<>();
		for (int i=0;i<final_fechas.size();i++) {
			fech_f.add(final_fechas.get(i).getAsString());
		}
		//nombre hotel
		JsonArray nombre_hoteles= obj.get("nombre_hotel_Lista").getAsJsonArray();
		List<String> nombres= new LinkedList<>();
		for (int i=0;i<nombre_hoteles.size();i++) {
			nombres.add(nombre_hoteles.get(i).getAsString());
		}
		
		//mapa con todas las list
		Map<String, List<String>> map= new HashMap<>();
		map.put("num_reserva", num_reserva);
		map.put("num_hab", num_hab);
		map.put("fecha_inicial", fech_i);
		map.put("fecha_final", fech_f);
		map.put("nombres", nombres);
		
		
		return new ModelAndView("reservaServicios","todo", map);
		
	}

	@GetMapping("/cogerReserva")
	public static String enviarComanda(@Valid@ModelAttribute("VerReservasBean") VerReservasBean mandar_reserva) {
		System.out.print(mandar_reserva.toString());
		return "reservaServicios";
			
	}
	
	//recibimos los datos de un cliente
	public JsonObject datosCliente(@Valid @ModelAttribute("verReservasBean") VerReservasBean reservas) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/datosCliente","POST");
		JsonObject json= new JsonObject();
		json.addProperty("reserva_id",reservas.getId_reserva());
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp); 
		return obj;
		
		
	}

}
