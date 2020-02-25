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
import ingsoft1920.ge.BeansGE1.EncargarComidaBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.HttpClient.HttpClient;
@Controller
public class RecibirServicios {

	final static Logger logger = LogManager.getLogger(EncargarComidaController.class.getName());


	@Autowired
	ServiciosBean servicios;

	@Autowired
	SesionBean sesion;

	//Pedir los servicios disponibles (y horarios)
	@GetMapping("/recibirServicios")
	public String pedirServicios(Model model, SesionBean sesion) throws Exception {

		//conexion para recibir servicios disponibles
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/getServiciosHotel", "GET");		
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();			 
			  }
        model.addAttribute("sesionBean", sesion);

		return resp;
	}

	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}



}
