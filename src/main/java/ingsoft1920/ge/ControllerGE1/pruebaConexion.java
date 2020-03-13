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
