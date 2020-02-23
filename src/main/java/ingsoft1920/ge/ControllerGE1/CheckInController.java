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
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import com.google.gson.*;

@Controller
public class CheckInController {
	
	final static Logger logger = LogManager.getLogger(CheckInController.class.getName());
	
	@Autowired
	CheckInBean checkin;
	
	@Autowired
	SesionBean sesion;
	
	@PostMapping("/checkinEnviar")
	public String checkinEnviar(@Valid @ModelAttribute("checkInBean") CheckInBean checkInBean,
			Model model) throws Exception {
		System.out.println(checkInBean.toString());
        beanToJson(checkInBean);
//		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/loquesea"+ sesion.getUsuarioID(), "POST");
//		
//		
//		client.setRequestBody(""+beanToJson(checkInBean));
//		
//		int respCode = client.getResponseCode();
//		
//		
//		if(respCode==200) {
//			  client.getResponseBody();}
		
		return "checkin";
		
	}
	@GetMapping("/checkin")
	public static String checkInEnviar() {
		return "checkin";
	}
	
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

	

}
