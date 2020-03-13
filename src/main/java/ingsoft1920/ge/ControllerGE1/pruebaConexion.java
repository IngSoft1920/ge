package ingsoft1920.ge.ControllerGE1;

import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.JsonObject;

import ingsoft1920.ge.HttpClient.HttpClient;

public class pruebaConexion {
	
	public static void main(String[]agrs) throws Exception {
		
		
		serviciosEnviar();
	}
	
	//recibir servicios
			@GetMapping("/recibirServicios")
			public static  String serviciosEnviar() throws Exception {
				
				HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "GET");
				
				//enviar nombre del hotel
				JsonObject json = new JsonObject();
				json.addProperty("nombre_hotel", "hotel_prueba");//habria que cogerlo de VerReservasBean, ¿como?
				client.setRequestBody(json.toString());
				
				int respCode = client.getResponseCode();
				
				String resp="";
				if(respCode==200) {
					  resp=client.getResponseBody();
					  }
				return resp;
				
				
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



