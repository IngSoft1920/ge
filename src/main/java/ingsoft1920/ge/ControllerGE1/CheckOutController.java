package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;



import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller

public class CheckOutController {
	
	final static Logger logger = LogManager.getLogger(CheckOutController.class.getName());
	
	@Autowired
	CheckOutBean checkout;
	
	@Autowired
	 SesionBean sesion;
	
	//enviar check-out
	@PostMapping("/checkout/{id}")
	public  String checkoutEnviar(@PathVariable("id") int id ) throws Exception {
		
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/envioCheckOut", "POST");
		JsonObject json = new JsonObject();
		json.addProperty("idReserva",id);
		
		
		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}
		
		
		return "login";
	}
	

}
