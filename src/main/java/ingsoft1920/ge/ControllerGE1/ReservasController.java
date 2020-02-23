package ingsoft1920.ge.ControllerGE1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ReservasController {
	
final static Logger logger = LogManager.getLogger(ReservasController.class.getName());
	
	
@Autowired
static SesionBean sesion;

	@GetMapping("/reservas")
	public static String reservasEnviar(Model model) throws Exception {
		
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "POST");
//		
//		client.setRequestBody("dadnos las facturas");
//		
//		int respCode = client.getResponseCode();
//		
//		String resp="";
//		if(respCode==200) {
//			  resp=client.getResponseBody();
//			  }
//		else {
//			resp="ERROR:Formato invalido";
//		}
		
		return "reservaServicios";
		
	}

}
