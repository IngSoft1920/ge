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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.EncargarComidaBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.Controller.datosController;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class EncargarComidaController {
	
	final static Logger logger = LogManager.getLogger(EncargarComidaController.class.getName());
	

	@Autowired
	EncargarComidaBean encargarComida;
	VerReservasBean reservas;
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
		return new ModelAndView("encargarComidaAlfonso","todo", map);
	}
	/*@GetMapping("/enviarComanda")
	public static String enviarComanda(@Valid@ModelAttribute("encargarComidaBean") EncargarComidaBean comanda) {
		System.out.print(comanda.toString());
	
		return "index";
	}*/
	
	@PostMapping("/enviarComanda")
	public String enviarPedidoFNB(@Valid@ModelAttribute("encargarComidaBean") EncargarComidaBean comanda) throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7003/nuevoServicio", "POST");
		JsonObject json= new JsonObject();
		json.addProperty("servicio_id",datosController.ALFONSO);
		json.addProperty("reserva_id",VerReservasController.reservilla.getId_reserva());
		json.addProperty("fecha_hora","2020-03-15T20:15:00");
		json.addProperty("num_clientes",0);
		json.addProperty("tipoUbicacion",2);
		json.addProperty("ubicacion","Mamma Mia");
		
		int[] habitaciones_id= new int[4]; 
		habitaciones_id[0]=VerReservasController.reservilla.getNum_hab();
		int p=0;
		int tamanoI=0;
		for(int i=0;i<comanda.getNum_items().length;i++)
		{
			tamanoI=tamanoI+comanda.getNum_items()[i];
		}
		String[]pedidoitems=new String[tamanoI];
		for(int i=0;i<comanda.getNum_items().length;i++)
		{
			
			for(int j=comanda.getNum_items()[i];j!=0;j--)
			{
				pedidoitems[p]=comanda.getItems()[i];
				p++;
			}
		}
		int p2=0;
		int tamanoP=0;
		for(int i=0;i<comanda.getNum_platos().length;i++)
		{
			tamanoP=tamanoP+comanda.getNum_platos()[i];
		}
		String[]pedidoplatos=new String[tamanoP];
		for(int i=0;i<comanda.getNum_platos().length;i++)
		{
			for(int j=comanda.getNum_platos()[i];j!=0;j--)
			{
				pedidoplatos[p2]=comanda.getPlatos()[i];
				p2++;
			}
		}
		
		
		json.addProperty("habitaciones_id",habitaciones_id.toString());
		json.addProperty("platos", pedidoplatos.toString());
		json.addProperty("items",pedidoitems.toString());
		
		
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			  resp=client.getResponseBody();
			  }
		System.out.println("CODIGO RESP " + respCode);
		return"index";
	}
	
	

}
