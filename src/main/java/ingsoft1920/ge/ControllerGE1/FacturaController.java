package ingsoft1920.ge.ControllerGE1;
import org.json.*;
import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;




import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.gson.Gson;

import ingsoft1920.ge.Beans.SignupBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.FacturaBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class FacturaController {
	public static JSONObject receivedJSON = new JSONObject();
	
	final static Logger logger = LogManager.getLogger(FacturaController.class.getName());
	
	@Autowired
	SesionBean sesion;
	
	public static String facturaGet(Model model) throws Exception {
		fillJson("hola");
	@GetMapping("/facturacion")
		
		client.setRequestBody("dadnos las facturas");
		
		//int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		else {
			resp="ERROR:Formato invalido";
		}
		
		return "facturacion";
		
	}

	public static void fillJson(String value) {
		receivedJSON.put("facturaPdf", value);
	}
	

}
