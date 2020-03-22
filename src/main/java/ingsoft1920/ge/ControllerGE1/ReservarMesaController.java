package ingsoft1920.ge.ControllerGE1;


import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ReservarMesaBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ReservarMesaController {
	public static JsonObject restaurantes;
	
	@Autowired
	 SesionBean sesion;
	ReservarMesaBean mesa;
	VerReservasBean reservas;
	
	//recibimos los posibles restaurantes¿no nos hace falta mandar el hotel?
	@GetMapping("/recibirRestaurantes")
	public static  String recibirRestaurantes() throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/infoRest", "GET");
		
		
		int respCode = client.getResponseCode();
		
		System.out.print(respCode+"\n");
		String resp="";
		if(respCode==200) {
			 resp= client.getResponseBody();}
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp); 
		restaurantes=obj;
		return "servicios";
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
		return obj;
		}

	//reservar servicios a DHO
			
		public String serviciosReservados(@Valid @ModelAttribute("reservarMesaBean") ReservarMesaBean mesa) throws Exception{
				
			HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/reservar_servicio", "POST");
			JsonObject json = new JsonObject();
			json.addProperty("tipoServicio",mesa.getTipoServicio());//se puede mandar el servicio en vez del id??
			json.addProperty("fecha",mesa.getFecha() );
			json.addProperty("hora", mesa.getHora());
			json.addProperty("cliente_id", sesion.getUsuarioID());
			//falta el lugar,¿como?
			
			//cosas que faltan
			json.addProperty("numPersonas", mesa.getNumPersonas());
			json.addProperty("idReserva", reservas.getId_reserva());
			json.addProperty("platos", (String)null);
			json.addProperty("items", (String)null);
			
			
			client.setRequestBody(json.toString());
			int respCode = client.getResponseCode();
			System.out.println(respCode+"\n");
			if(respCode==200)
			{
				client.getResponseBody();
			}
			
			
			return "";
		}
}
