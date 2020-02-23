package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;




import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.FacturaBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class FacturaController {
	
	final static Logger logger = LogManager.getLogger(FacturaController.class.getName());
	
	@Autowired
	SesionBean sesion;
	
	@GetMapping("/factura")
	public static String checkinEnviar(Model model,SesionBean sesion) throws Exception {
		
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "POST");
		
		client.setRequestBody("dadnos las facturas");
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		else {
			resp="ERROR:Formato invalido";
		}
		
		return "facturacion";
		
	}

}
