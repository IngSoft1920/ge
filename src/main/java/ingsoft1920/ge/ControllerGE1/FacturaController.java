package ingsoft1920.ge.ControllerGE1;
import org.json.*;
import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class FacturaController {
	public static JSONObject receivedJSON = new JSONObject();

	final static Logger logger = LogManager.getLogger(FacturaController.class.getName());

	@Autowired
	 SesionBean sesion;
	
	@GetMapping("/facturacion")
	public  String facturaGet(Model model) throws Exception {
		fillJson("hola");
//	
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
        model.addAttribute("sesionBean", sesion);

		return "facturacion";

	}

	public static void fillJson(String value) {
		receivedJSON.put("facturaPdf", value);
	}


}
