package ingsoft1920.ge.ControllerGE1;




import java.util.List;

import java.util.LinkedList;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.ControllerGE1.VerReservasController;
import ingsoft1920.ge.ControllerGE1.EncargarComidaController;
import ingsoft1920.ge.HttpClient.HttpClient;




@Controller
public class Routing {
	
	@GetMapping("/index")
	public String index() {

		return "index";
	}
	
	
	@GetMapping("/cabecera")
	public String cabecera() {
		return "cabecera";
	}
	
	
	@GetMapping("/reservas")
	public String reservas() {

		return "reservaServicios";
	}
	
	@GetMapping("/servicios")
	public String servicios() {

		return "servicios";
	}
	
//	@GetMapping("/incidencias")
//	public String incidencias() {
//
//		return "incidencias";
//	}
//	@GetMapping("/recibirPlatos")
//	public String onload() throws Exception {
//		EncargarComidaController.recibirPlatos();
//		EncargarComidaController.recibirItems();
//		return "encargarComidaAlfonso";
//		
	}
//	@GetMapping("/serviciosAlfonso")
//	public ModelAndView serviciosAlfonso() throws Exception {
//		List<String> prueba= new LinkedList<>();
//		prueba.add("hola");
//		prueba.add("ya");
//		prueba.add("funciono");
//
//		
//		//String[] prueba= {"hola","ya","funciono"};
//		 
//		return new ModelAndView("encargarComidaAlfonso","nombreServicios",prueba);
//	}
	
//
//	@GetMapping("/checkin")
//	public String checkin() {
//		
//		
//		
//
//		return "incidencias";
//	}
//	

/*HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");

		//enviar nombre del hotel
		JsonObject json = new JsonObject();
		json.addProperty("nombre_hotel", "hotel_prueba");//habria que cogerlo de VerReservasBean, ¿como?
		//ASI json.addProperty("id_estancia", reserva.getNombre_hotel());
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();
		System.out.print(respCode+"<---------");

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		System.out.print(resp+"<---------");
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		//Creo un Array de tipo Json del campo que quiero, con el getAsElTipoDelCampoQueQuiero
		JsonArray nombres= obj.get("servicios_disponibles_nombre").getAsJsonArray();
		//Creo una estructura del tipo que quiero y en este caso como es una array, la recorro con un for rellenandolo
		String[] servicios= new String[nombres.size()];
		for(int i=0;i<servicios.length;i++) {
			servicios[i]=nombres.get(i).getAsString();	
		}*/
