package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class VerReservasController {
public static JSONObject receivedJSON = new JSONObject();
	
@Autowired
 SesionBean sesion;


	
	public  JsonObject reservasEnviar() throws Exception {
		
		receivedJSON.put("datosReserva", "Datos de su reserva");

		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservas","POST");
		JsonObject json= new JsonObject();
		json.addProperty("id_cliente", sesion.getUsuarioID());
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp); 
		return obj;
		
	}
	
	//recibimos los datos de un cliente
	public JsonObject datosCliente(@Valid @ModelAttribute("verReservasBean") VerReservasBean reservas) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/datosCliente","POST");
		JsonObject json= new JsonObject();
		json.addProperty("reserva_id",reservas.getId_reserva());
		
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
