package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;



import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller

public class CheckOutController {
	
	final static Logger logger = LogManager.getLogger(CheckOutController.class.getName());
	
	@Autowired
	CheckOutBean checkout;
	
	@PostMapping("/checkoutEnviar")
	public static String checkinEnviar(@Valid @ModelAttribute("checkOutBean") CheckOutBean checkoutBean,
			Model model) throws Exception {
		
		HttpClient client= new HttpClient("localhost:7004/apiUsuarios", "POST");
		
		client.setRequestBody("");
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();}
		
		return resp;
		
	}
	@GetMapping("/checkOutEnviar")
	public static String checkInEnviar(Model model) {
		return "";
	}

}
