package ingsoft1920.ge.ControllerGE1;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
import ingsoft1920.ge.BeansGE1.ReservarMesaBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

public class pruebaConexion {

	@Autowired
	SesionBean sesion;
	@Autowired
	VerReservasBean reservas;
	static IncidenciasBean incidencias;

	static Calendar calendario = Calendar.getInstance();
	static Date fechaActual = new Date();
	static DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");

	
	public static void main(String[]agrs) throws Exception {

		//Calendar calendario = Calendar.getInstance();

		//Creo un objeto Json de lo recibido, que es un String, pero al estar en formato Json se puede pasar a este
				//JsonObject obj = (JsonObject) JsonParser.parseString(serviciosEnviar()); 
				
				//Creo un Array de tipo Json del campo que quiero, con el getAsElTipoDelCampoQueQuiero
//				JsonArray res= obj.get("servicios_disponibles_nombre").getAsJsonArray();
//				//Creo una estructura del tipo que quiero y en este caso como es una array, la recorro con un for rellenandolo
//				String[] servicios= new String[res.size()];
//				for(int i=0;i<servicios.length;i++) {
//					servicios[i]=res.get(i).getAsString();
//					System.out.println(servicios[i]);
//				}
		//serviciosEnviar();
		
		r();
		
	}
	
	public static String checkinEnviar() throws Exception {
		//HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/"+reservas.getIdReserva(), "GET");
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/1", "GET");
		
		
	}
	//recibir servicios reservados por un cliente
	public static  ModelAndView recibirServiciosReservados() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/hotel/ge", "GET");

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		

		return new ModelAndView("login");
	}
	
	public static  List<String> r() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosReservados", "POST");
		
		JsonObject json = new JsonObject();
		 //coger id_usuario de la sesionBean
		json.addProperty("id_estancia", 27);
		json.addProperty("id_cliente", 1);
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray reservas_hechas= obj.get("nombreServicio").getAsJsonArray();//los nombres me los he inventado

		List<String> reservas= new LinkedList<>();
		for (int i=0;i<reservas_hechas.size();i++) {
			reservas.add(reservas_hechas.get(i).getAsString());
		}
		JsonArray reservas_fechas= obj.get("fecha").getAsJsonArray();//los nombres me los he inventado

		List<String> fechas= new LinkedList<>();
		for (int i=0;i<reservas_fechas.size();i++) {
			fechas.add(reservas_fechas.get(i).getAsString());
		}
		System.out.println(reservas);
		System.out.println(fechas);
        System.out.println((JsonObject) JsonParser.parseString(resp)); //both reservas & fechas
        
		return reservas;
	}
	
	public  static JsonObject reservasEnviar() throws Exception {

		//receivedJSON.put("datosReserva", "Datos de su reserva");


		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservas","POST");
		JsonObject json= new JsonObject();
		json.addProperty("id_cliente","1");

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
	public static  List<String> r() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosReservados", "POST");
		
		JsonObject json = new JsonObject();
		 //coger id_usuario de la sesionBean
		json.addProperty("id_estancia", 27);
		json.addProperty("id_cliente", 1);
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray reservas_hechas= obj.get("nombreServicio").getAsJsonArray();//los nombres me los he inventado

		List<String> reservas= new LinkedList<>();
		for (int i=0;i<reservas_hechas.size();i++) {
			reservas.add(reservas_hechas.get(i).getAsString());
		}
		JsonArray reservas_fechas= obj.get("fecha").getAsJsonArray();//los nombres me los he inventado

		List<String> fechas= new LinkedList<>();
		for (int i=0;i<reservas_fechas.size();i++) {
			fechas.add(reservas_fechas.get(i).getAsString());
		}
	
		return reservas;
	}
	public static int reservarServicios() throws Exception{

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/recibirServicio", "POST");

		JsonObject json = new JsonObject();
		json.addProperty("id_servicio",1 );//se puede mandar el servicio en vez del id??
		json.addProperty("fecha", "2020-03-10");
		json.addProperty("hora", "18:30");
		json.addProperty("cliente_id", 1);
		json.addProperty("lugar", "en mi puta casa");
		json.addProperty("num_personas", 1);
		json.addProperty("id_reserva", 27);
		json.addProperty("tipoServicio", 1);
		json.addProperty("hora_salida", "18:50");
	

		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}


		return respCode;
	}
	
	public static void reservarMesa() throws Exception{
			
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/recibirServicio", "POST");
		JsonObject json = new JsonObject();
		
		json.addProperty("id_servicio",1 );//se puede mandar el servicio en vez del id??
		json.addProperty("fecha", "2020-03-10");
		json.addProperty("hora", "18:30");
		json.addProperty("cliente_id", 1);
		json.addProperty("lugar", "me cago en todo");
		json.addProperty("num_personas", 1);
		json.addProperty("id_reserva", 27);
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
		
		
	}
	
	
}
