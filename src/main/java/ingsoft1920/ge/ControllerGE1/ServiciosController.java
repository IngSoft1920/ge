package ingsoft1920.ge.ControllerGE1;

import java.util.HashMap;
import java.util.LinkedList;


import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {
	public static String[] servicios_nombre;
	public static int[] servicios_id;
	public static List<String> servicios_reservados;

	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());


	@Autowired
	ServiciosBean servicios;
	@Autowired
	SesionBean sesion;
	VerReservasBean reservas;


	//recibir servicios
  
	@GetMapping("/recibirServicios")
	public static  ModelAndView recibirServicios() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");

		//enviar nombre del hotel
		JsonObject json = new JsonObject();
		json.addProperty("nombre_Hotel", "hotel_prueba");//habria que cogerlo de VerReservasBean, ¿como?
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
	
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		
		JsonArray nombres= obj.get("servicios_disponibles_nombre").getAsJsonArray();
		
		List<String> serviciosList= new LinkedList<>();
		System.out.print(nombres.size());
		
		for(int i=0;i<nombres.size();i++) {
			serviciosList.add(nombres.get(i).getAsString());	
		}
		
		//igual pero con los identificadores de los servicios
		JsonArray ids= obj.get("servicios_disponibles_id").getAsJsonArray();
		int[] ides= new int[ids.size()];
		for(int i=0;i<ides.length;i++) {
			ides[i]=ids.get(i).getAsInt();	
		}
		servicios_id=ides;
		Map<String,List<String>> map= new HashMap<>();
		map.put("servicios", serviciosList);
		map.put("restaurantes", ReservarMesaController.recibirRestaurantes());
		map.put("servicos_reservados", servicios_reservados);
		
		return new ModelAndView("servicios","muchas_cosas", map);
	}


	//recibir horas disponibles de cada servicio
	public JsonObject recibirHorasServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicios) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosHoras", "POST");
		
		int id_servicio=0;
		for (int i=0;i<servicios_nombre.length;i++) {
			
			if(servicios.getTipoServicio().equals(servicios_nombre[i])) {
				id_servicio=servicios_id[i];
				
		}}
		JsonObject json = new JsonObject();
		
		json.addProperty("servicio_id",id_servicio);
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		

		return obj;
	}


	//recibir servicios reservados por un cliente
	public  List<String> recibirServiciosReservados() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosReservados", "POST");

		//enviar id_cliente e id_reserva
		JsonObject json = new JsonObject();
		json.addProperty("id_cliente", sesion.getUsuarioID()); //coger id_usuario de la sesionBean
		json.addProperty("id_estancia", reservas.getId_reserva()); //coger id_reserva de VerReservasBean
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray reservas_hechas= obj.get("reservas_hechas").getAsJsonArray();//los nombres me los he inventado

		List<String> reservas= new LinkedList<>();
		for (int i=0;i<reservas_hechas.size();i++) {
			reservas.add(reservas_hechas.get(i).getAsString());
		}
		this.servicios_reservados= reservas;
		return reservas;
	}


	//reservar servicios

	public int reservarServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicos) throws Exception{

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservar_servicio", "POST");

		//Para averiguar el identificador del servicio liamos todo esto
		int id_servicio_dho=0;
		for (int i=0;i<servicios_id.length;i++) {
			if(servicios_nombre[i].equals(servicios.getTipoServicio())) {
				id_servicio_dho=servicios_id[i];
			}
		}

		JsonObject json = new JsonObject();
		json.addProperty("id_servicio", id_servicio_dho);//se puede mandar el servicio en vez del id??
		json.addProperty("fecha", servicios.getFecha());
		json.addProperty("hora", servicios.getHoras());
		json.addProperty("cliente_id", sesion.getUsuarioID());
		json.addProperty("lugar", (String)null);

		//cosas que faltan
		json.addProperty("numPersonas", servicios.getNumPersonas());
		json.addProperty("idReserva", reservas.getId_reserva());
		json.addProperty("platos", (String)null);
		json.addProperty("items", (String)null);
		json.addProperty("type", 1);
		//IMPORTANTE:falta el nombre del restaurante al reservar una mesa

		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}


		return respCode;
	}


}
