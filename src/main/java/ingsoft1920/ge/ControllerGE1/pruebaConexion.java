package ingsoft1920.ge.ControllerGE1;


import java.util.Date;
import java.util.Timer;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.google.gson.JsonObject;

import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.HttpClient.HttpClient;





public class pruebaConexion {
	
	public static void main (String[]args) throws Exception {
		
		
		System.out.print(serviciosEnviar());
		
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
//recibir servicios
	public static  String serviciosEnviar() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");
		
		//enviar nombre del hotel
		JsonObject json = new JsonObject();
		json.addProperty("nombre_hotel", "hotel_prueba");
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		return resp;
		
		
	}


}
