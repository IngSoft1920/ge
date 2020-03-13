package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.EncargarComidaBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class EncargarComidaController {
	
	final static Logger logger = LogManager.getLogger(EncargarComidaController.class.getName());
	

	@Autowired
	EncargarComidaBean encargarComida;
	
	@Autowired
	 SesionBean sesion;
	
	@GetMapping("/recibirPlatos")
	public String recibirPlatos() throws Exception {
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/platosRest", "POST");
		JsonObject json= new JsonObject();
		json.addProperty("rest_nom","Mamma Mia" );
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		
		return null;
	}
	

	@GetMapping("/recibirItems")
	public String recibirItems() throws Exception {
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/itemsRest", "POST");
		JsonObject json= new JsonObject();
		json.addProperty("rest_nom","Mamma Mia" );
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		
		return null;
	}
	
	
	

}
