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

import com.google.gson.Gson;

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
	
	@PostMapping("/checkoutEnviar")
	public  String checkoutEnviar(@Valid @ModelAttribute("checkOutBean") CheckOutBean checkoutBean,
			Model model) throws Exception {
		
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "POST");
//		
//		client.setRequestBody(""+beanToJson(checkoutBean));
//		
//		int respCode = client.getResponseCode();
//		
//		String resp="";
//		if(respCode==200) {
//			  resp=client.getResponseBody();
//			  }
		
        model.addAttribute("sesionBean", sesion);

		return "misReservas";
		
	}
	@GetMapping("/checkout")
	public  String checkInEnviar(Model model) {
        model.addAttribute("sesionBean", sesion);

		return "checkout";
	}
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

}
