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

import com.google.gson.Gson;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {
	
	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());
	

	@Autowired
	ServiciosBean servicios;
	
	@Autowired
	 SesionBean sesion;
	
	@PostMapping("/serviciosEnviar")
	public  String serviciosEnviar(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicios,
			Model model) throws Exception {
		
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "POST");
//		
//		client.setRequestBody(""+ beanToJson(servicios));
//		
//		int respCode = client.getResponseCode();
//		
//		String resp="";
//		if(respCode==200) {
//			  resp=client.getResponseBody();}
        model.addAttribute("sesionBean", sesion);

		return "";
		
	}
	
	
	
	@GetMapping("/servicios")
	public  String checkInEnviar(Model model, SesionBean sesion) throws Exception {
		
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:700*/apiUsuarios/"+sesion.getUsuarioID(), "POST");
//		
//		client.setRequestBody("dadnos el menu");
//		
//		int respCode = client.getResponseCode();
//		
//		String resp="";
//		if(respCode==200) {
//			  resp=client.getResponseBody();
//			  }
        model.addAttribute("sesionBean", sesion);

		return "servicios";
	}
	
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

}
