package ingsoft1920.ge.ControllerGE1;


import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;

import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

public class pruebaConexion {

	@Autowired
	SesionBean sesion;
	VerReservasBean reservas;

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
		
		recibirPlatos();
		
	}
	//recibir servicios
	
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
	

}
/*public void  fechas() throws Exception {

	JsonObject json = new JsonObject();
	  json.addProperty("rest_nom", "Mama Mia");
	  json.addProperty("capacidad", 2);


	HttpPost post = new HttpPost("http://piedrafita.ls.fi.upm.es:7003/checkReservRest");
	  post.addHeader("Content-Type", "application/json");
	  post.addHeader("Accept", "application/json");
	  post.setEntity( new StringEntity(json.toString(),"UTF-8") ); // UTF-8 es importante por tildes y caracteres 'raros'

	HttpClient client = HttpClientBuilder.create().build();
	HttpResponse response = client.execute(post);

	int codigoRespuesta = response.getStatusLine().getStatusCode();

	// Si el código de la respuesta es distinto de 200
	// entonces se ha producido un error
	if( codigoRespuesta != 200 ) {
		System.out.println("ERROR con código:"+codigoRespuesta+"\n");

	}

	// Veamos la respuesta:
	String respuesta = EntityUtils.toString(response.getEntity());
	System.out.println(respuesta);

}*/



