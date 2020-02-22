package ingsoft1920.ge.ControllerGE1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ReservasController {
	
final static Logger logger = LogManager.getLogger(ReservasController.class.getName());
	
	
	@GetMapping("/reservas")
	public static String checkinEnviar(Model model) throws Exception {
		
		HttpClient client= new HttpClient("piedrafita.fi.upm:700*/apiUsuarios", "POST");
		
		client.setRequestBody("dadnos las facturas cabrones");
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		else {
			resp="ERROR:Formato invalido";
		}
		
		return "reservaServicios";
		
	}

}
