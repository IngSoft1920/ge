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
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {
	
	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());
	

	@Autowired
	ServiciosBean servicios;
	SesionBean sesion;
	ReservaBean reserva;
	
	
	@GetMapping("/servicios")
	public String checkInEnviar(Model model, SesionBean sesion) throws Exception {
        model.addAttribute("sesionBean", sesion);
		return "servicios";
 	}
	
	

	//recibir servicios
	public  String serviciosEnviar(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicios,
			Model model) throws Exception {
		
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");
		
		//enviar nombre del hotel
		client.setRequestBody(reserva.getHotel());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
 		return resp;
		
		
	}
	
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

}
