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
import ingsoft1920.ge.HttpClient.HttpClient;
@Controller
public class EncargarComidaController {
	
	final static Logger logger = LogManager.getLogger(EncargarComidaController.class.getName());
	

	@Autowired
	EncargarComidaBean encargarComida;
	
	@Autowired
	 SesionBean sesion;
	
	//pedimos los restaurantes disponibles y mas cosas que de monento no usamos
	@GetMapping("/recibirInfo")
	public  String recibirInfo() throws Exception {
		
		Gson prueba= new Gson();
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/infoRest", "GET");
		
		client.setRequestBody(""+prueba);
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();}
		
		return resp;
		
	}
	//damos el restaurante que queremos con el numero de gente que queremos y nos devulven las horas OCUPADAS
	@GetMapping("/pedirFechas")
	public String  fechas(@Valid @ModelAttribute("encargarComidaBean") EncargarComidaBean encargarComida,
			Model model) throws Exception {

		EncargarComidaBean cuerpoPet= new EncargarComidaBean();
		cuerpoPet.setNombreRestaurante(encargarComida.getNombreRestaurante());
		cuerpoPet.setNumPersonas(encargarComida.getNumPersonas());
		
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7003/checkReservRest", "GET");
		
		client.setRequestBody(""+cuerpoPet);
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();}
		model.addAttribute("sesionBean", sesion);

		
		return resp;
		
	}
	
	
	
	
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}
	


}
