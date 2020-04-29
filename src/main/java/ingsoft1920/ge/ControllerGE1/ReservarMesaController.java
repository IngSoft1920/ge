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
import ingsoft1920.ge.Controller.datosController;
import ingsoft1920.ge.HttpClient.HttpClient;
import ingsoft1920.ge.ControllerGE1.VerReservasController;
import ingsoft1920.ge.ControllerGE1.ServiciosController;

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
	
	
	public static ModelAndView enviarComanda(@Valid@ModelAttribute("ReservarMesaBean") ReservarMesaBean reserva_mesa) throws Exception{
	
		Map<String,List<String>> map= new HashMap<>();

		map.put("servicios", ServiciosController.renewServicios);
		map.put("restaurantes", ServiciosController.renewRestaurantes);
		map.put("servicos_reservados", ServiciosController.recibirServiciosReservados().get("reservas"));
		map.put("horasRestaurantes", ServiciosController.renewHorasRestaurantes);
		map.put("horasServicios",ServiciosController.renewHorasServicios);
		map.put("fechas_reservadas",ServiciosController.recibirServiciosReservados().get("fechas"));
		
		
		
		System.out.print(reserva_mesa.toString()); //reservar mesa bean
		return new ModelAndView("servicios","muchas_cosas", map);
			
	}

	//reservar servicios a DHO
	@GetMapping("/enviarReserva")	
		public ModelAndView serviciosReservados(@Valid @ModelAttribute("reservarMesaBean") ReservarMesaBean mesa) throws Exception{
				
		
		int id_servicio_dho=0;
		for (int i=0;i<ServiciosController.servicios_id.length;i++) {
			if(ServiciosController.servicios_nombre.get(i).equals("restaurante")) {
				id_servicio_dho=ServiciosController.servicios_id[i];
			}
		}
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/recibirServicio", "POST");
			JsonObject json = new JsonObject();
			json.addProperty("id_servicio",id_servicio_dho);
			json.addProperty("fecha", mesa.getFecha());
			json.addProperty("hora", mesa.getHora());
			json.addProperty("cliente_id", datosController.ALFONSO);
			json.addProperty("lugar", "Mamma Mia");
			json.addProperty("num_personas", 1);
			json.addProperty("id_reserva", VerReservasController.reservilla.getId_reserva());
			json.addProperty("tipoServicio", 2);
			json.addProperty("hora_salida", (String)null);
			json.addProperty("restaurante ", "Mamma Mia");
			
			
			client.setRequestBody(json.toString());
			int respCode = client.getResponseCode();
			System.out.println(respCode+"\n");
			if(respCode==200)
			{
				client.getResponseBody();
			}
			
			Map<String,List<String>> map= new HashMap<>();

			map.put("servicios", ServiciosController.renewServicios);
			map.put("restaurantes", ServiciosController.renewRestaurantes);
			map.put("servicos_reservados", ServiciosController.recibirServiciosReservados().get("reservas"));
			map.put("fechas_reservadas",ServiciosController.recibirServiciosReservados().get("fechas"));
			map.put("horasRestaurantes", ServiciosController.renewHorasRestaurantes);
			map.put("horasServicios",ServiciosController.renewHorasServicios);
			
			
			return new ModelAndView("servicios","muchas_cosas",map);
		}
	
	
	
	
	
	
		
		
		
		
		
}
