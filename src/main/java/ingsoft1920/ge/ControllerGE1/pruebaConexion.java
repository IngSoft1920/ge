package ingsoft1920.ge.ControllerGE1;


import java.util.Date;
import java.util.Timer;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.JsonObject;

import ingsoft1920.ge.HttpClient.HttpClient;





public class pruebaConexion {
	
	public static void main (String[]args) throws Exception {
		
		
		System.out.print(prueba1());
		
	}
	
public static  String prueba1() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/checkReservRest", "POST");
		
		JsonObject json = new JsonObject();
		  json.addProperty("rest_nom", "Mamma Mia");
		  json.addProperty("capacidad", 4);
		  json.addProperty("fecha", "2020-02-24");
		  
		  
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		System.out.print(respCode+"\n");
		if(respCode==200) {
			  client.getResponseBody();}
		
		return "";
		}

public static  String recibirInfo() throws Exception {
	
	HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/infoRest", "GET");
	
	
	int respCode = client.getResponseCode();
	
	System.out.print(respCode+"\n");
	if(respCode==200) {
		  client.getResponseBody();}
	
	return "";
	
	
}


}
