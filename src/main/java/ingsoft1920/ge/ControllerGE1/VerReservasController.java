package ingsoft1920.ge.ControllerGE1;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.google.gson.JsonObject;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class VerReservasController {
//public static JSONObject receivedJSON = new JSONObject();
	
@Autowired
 SesionBean sesion;

	@GetMapping("/reservas")
	public  String reservasEnviar() throws Exception {
		//receivedJSON.put("datosReserva", "Datos de su reserva");

		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservas ","POST");
		JsonObject json= new JsonObject();
		json.addProperty("id_cliente", sesion.getUsuarioID());
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		return resp;
		
	}

}
