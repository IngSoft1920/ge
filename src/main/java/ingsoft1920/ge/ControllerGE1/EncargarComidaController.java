package ingsoft1920.ge.ControllerGE1;


import java.util.HashMap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	
	
	public static List<String> recibirPlatos() throws Exception {
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/platosRest", "POST");
		JsonObject json= new JsonObject();
		json.addProperty("rest_nom","Mamma Mia" );
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray platos= obj.get("nombre_plato").getAsJsonArray();
		List<String> prueba= new LinkedList<>();
		for (int i=0;i<platos.size();i++) {
			prueba.add(platos.get(i).getAsString());
		}
		return prueba;
	}
	

	@GetMapping("/recibirPlatos")
	public static ModelAndView recibirItems() throws Exception {
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/itemsRest", "POST");
		JsonObject json= new JsonObject();
		json.addProperty("rest_nom","Mamma Mia");
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray items= obj.get("nombre_item").getAsJsonArray();
		List<String> item= new LinkedList<>();
		for (int i=0;i<items.size();i++) {
			item.add(items.get(i).getAsString());
		}
		
		List<String> platos= recibirPlatos();
		
		Map<String, List<String>> map= new HashMap<>();
		map.put("item", item);
		map.put("platos", platos);
		
		//return m;
		return new ModelAndView("encargarComidaAlfonso","todo",map);
	}
	@GetMapping("/enviarComanda")
	public static String enviarComanda(@Valid@ModelAttribute("encargarComidaBean") EncargarComidaBean comanda) {
		System.out.print(comanda.toString());
		return "encargarComidaAlfonso";
		
		
	}
	
	
	

}
