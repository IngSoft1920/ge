package ingsoft1920.ge.ControllerGE1;


import java.util.HashMap;
import java.util.LinkedList;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
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
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import ingsoft1920.ge.ControllerGE1.VerReservasController;

@Controller
public class ReservarMesaController {
	
	public static JsonObject restaurantes;
	public static List<String> horasDisponibles;
	
	@Autowired
	 SesionBean sesion;
	ReservarMesaBean mesa;
	VerReservasBean reservas;
	
	//recibimos los posibles restaurantes¿no nos hace falta mandar el hotel?
	
	public static  List<String> recibirRestaurantes() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/infoRest", "GET");
		
		
		int respCode = client.getResponseCode();
		
		System.out.print(respCode+"\n");
		String resp="";
		if(respCode==200) {
			 resp= client.getResponseBody();}
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray nombres= obj.get("nombre").getAsJsonArray();
		List<String> prueba= new LinkedList<>();
		for (int i=0;i<nombres.size();i++) {
			prueba.add(nombres.get(i).getAsString());
		}
		
		restaurantes=obj;
		return prueba;

	}
	
	//mandamos un restaurante, el num de personas y la fecha y nos devuelven las horas disponibles
	public static  JsonObject horasDisponibles() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/checkReservRest", "POST");
		
		JsonObject json = new JsonObject();
		  json.addProperty("rest_nom", "Mamma Mia");
		  json.addProperty("capacidad", 4);
		  json.addProperty("fecha", "2020-02-24");
		  
		  
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		System.out.print(respCode+"\n");
		String resp="";
		if(respCode==200) {
			 resp= client.getResponseBody();}
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray items= obj.get("horas_disp").getAsJsonArray();
		List<String> item= new LinkedList<>();
		for (int i=0;i<items.size();i++) {
			item.add(items.get(i).getAsString());
		}
		horasDisponibles=item;
		return obj;
		}
	
	@GetMapping("/enviarReserva")
	public static ModelAndView enviarComanda(@Valid@ModelAttribute("ReservarMesaBean") ReservarMesaBean reserva_mesa) throws Exception{
	
		Map<String,List<String>> map= new HashMap<>();

		map.put("servicios", ServiciosController.renewServicios);
		map.put("restaurantes", ServiciosController.renewRestaurantes);
		map.put("servicos_reservados", ServiciosController.renewServiciosReservados);
		map.put("horasRestaurantes", ServiciosController.renewHorasRestaurantes);
		map.put("horasServicios",ServiciosController.renewHorasServicios);
		
		
		
		System.out.print(reserva_mesa.toString()); //reservar mesa bean
		return new ModelAndView("servicios","muchas_cosas", map);
			
	}

	//reservar servicios a DHO
			
		public String serviciosReservados(@Valid @ModelAttribute("reservarMesaBean") ReservarMesaBean mesa) throws Exception{
				
			HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/recibirServicio", "POST");
			JsonObject json = new JsonObject();
			json.addProperty("id_servicio",1 );//se puede mandar el servicio en vez del id??
			json.addProperty("fecha", mesa.getFecha());
			json.addProperty("hora", mesa.getHora());
			json.addProperty("cliente_id", 1);
			json.addProperty("lugar", "me da igual");
			json.addProperty("num_personas", 1);
			json.addProperty("id_reserva", VerReservasController.reservilla.getId_reserva());
			json.addProperty("tipoServicio", 2);
			json.addProperty("hora_salida", "18:50");
			json.addProperty("restaurante ", "tostus");
			
			
			client.setRequestBody(json.toString());
			int respCode = client.getResponseCode();
			System.out.println(respCode+"\n");
			if(respCode==200)
			{
				client.getResponseBody();
			}
			
			
			return "";
		}
}
