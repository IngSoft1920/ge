package ingsoft1920.ge.ControllerGE1;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
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
		checkinEnviar();
		
	}
	
	public static String checkinEnviar() throws Exception {
		//HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/"+reservas.getIdReserva(), "GET");
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/1", "GET");
		
		int respCode = client.getResponseCode();
		
		String resp ="";
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			resp=client.getResponseBody();
		}
		System.out.println(resp.toString());
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		String cliente_id = obj.get("cliente_id").toString();
		String nombre = obj.get("nombre").toString();
		String apellidos = obj.get("apellidos").toString();
		String DNI = obj.get("DNI").toString();
		String email = obj.get("email").toString();
		String password = obj.get("password").toString();
		String nacionalidad = obj.get("nacionalidad").toString();
		String telefono = obj.get("telefono").toString();
		
		Map<String,String> map= new HashMap<>();
		map.put("Nombre", nombre);
		map.put("Apellidos", apellidos);
		map.put("DNI", DNI);
		map.put("email", email);
		map.put("Nacionalidad", nacionalidad);
		map.put("Telefono", telefono);
		
		return map.toString();
		
		//Esto seria lo definitivo, pero para las pruebas dejamos de momento lo de arriba
		/*if(cliente_id.isEmpty() || nombre.isEmpty() || DNI.isEmpty() || email.isEmpty() || 
				password.isEmpty() || nacionalidad.isEmpty() || telefono.isEmpty()){
			return new ModelAndView("checkin","todo",map );
		}
		else {
			return new ModelAndView("recibirServicios");
		}*/
		
		
	}
	//ENVIAR INCIDENCIA
	public static  JsonObject serviciosEnviar() throws Exception {

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
		System.out.println(resp);
		JsonObject objeto = (JsonObject) JsonParser.parseString(resp);
		System.out.print(objeto.toString());

		return objeto;


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
	public static JsonObject recibirServicios() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosReservados", "POST");

		//enviar id_cliente e id_reserva
		JsonObject json = new JsonObject();
		json.addProperty("id_cliente", 1); //coger id_usuario de la sesionBean
		json.addProperty("id_estancia",13); //coger id_reserva de VerReservasBean
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		//		JsonArray fechas= obj.get("fecha").getAsJsonArray();
		//		String[] fecha= new String[fechas.size()];
		//		for(int i=0;i<fecha.length;i++) {
		//			fecha[i]=fechas.get(i).getAsString();	
		//		}

		return obj;
	}

	public static JsonObject recibirPlatos() throws Exception {
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/platosRest", "POST");
		JsonObject json= new JsonObject();
		json.addProperty("rest_nom","Mamma Mia" );
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp); 
		return obj;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////
	public static int enviarIncidencias() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/informarIncidencia", "POST");

		JsonObject json = new JsonObject();
		json.addProperty("asunto","Limpieza");
		json.addProperty("descripcion", "prueba");
		json.addProperty("nombre_hotel", "hotel_prueba");
		json.addProperty("fecha",formatoFecha.format(fechaActual));
		json.addProperty("hora", calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE));
		json.addProperty("lugar", "H43");//habitacion de prueba, de momento solo se pueden enviar habitaciones


		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		if(respCode==200) {
			client.getResponseBody();
		}

		return respCode;
	}
	

}
