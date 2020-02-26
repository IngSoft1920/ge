package ingsoft1920.ge.ControllerGE1;

import org.springframework.web.bind.annotation.GetMapping;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ingsoft1920.ge.HttpClient.HttpClient;

import org.apache.http.HttpResponse;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;



public class pruebaConexion {
	
	public static void main (String[]args) throws Exception {
		
		
		System.out.print(prueba1());
		
	}
	
public static  String prueba1() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/checkReservRest", "GET");
		
		JsonObject json = new JsonObject();
		  json.addProperty("rest_nom", "Mama Mia");
		  json.addProperty("capacidad", 1);
		  
		client.setRequestBody(json.getAsString());
		
		int respCode = client.getResponseCode();
		
		System.out.print(respCode+"\n");
		if(respCode==200) {
			  client.getResponseBody();}
		
		return "";
		}

public static  String recibirInfo() throws Exception {
	
	HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/infoRest", "GET");
	
	
	//client.setRequestBody("");
	
	int respCode = client.getResponseCode();
	
	System.out.print(respCode+"\n");
	if(respCode==200) {
		  client.getResponseBody();}
	
	return "";
	
	
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

}
