package ingsoft1920.ge.ControllerGE1;

import java.util.HashMap;
import java.util.LinkedList;


import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ReservarMesaBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.Controller.datosController;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {
	public static List<String> servicios_nombre;
	public static int[] servicios_id;
	public static List<String> servicios_reservados;
	public static List<String> fechas_reservadas;
	public static String palabra_restaurante;

	
	public static List<String> renewServicios;
	public static List<String> renewRestaurantes;
	public static List<String> renewServiciosReservados;
	public static List<String> renewFechasReservadas;
	public static List<String> renewHorasRestaurantes;
	public static List<String> renewHorasServicios;

	@Autowired
	SesionBean sesion;
	
	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());
	//recibir servicios
  
	@GetMapping("/recibirServicios")
	public  ModelAndView recibirServicios(Model model) throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");

		//enviar nombre del hotel
		JsonObject json = new JsonObject();
		json.addProperty("nombre_Hotel", VerReservasController.reservilla.getNombre_hotel());//habria que cogerlo de VerReservasBean, ¿como?
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();
		
		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
	
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		
		JsonArray nombres= obj.get("servicios_disponibles_nombre").getAsJsonArray();
		
		List<String> serviciosList= new LinkedList<>();
		
		for(int i=0;i<nombres.size();i++) {
			serviciosList.add(nombres.get(i).getAsString());
		}
		servicios_nombre=serviciosList;
		
		//igual pero con los identificadores de los servicios
		JsonArray ids= obj.get("servicios_disponibles_id").getAsJsonArray();
		int[] ides= new int[ids.size()];
		for(int i=0;i<ides.length;i++) {
			ides[i]=ids.get(i).getAsInt();	
		}
		servicios_id=ides;
		ReservarMesaController.horasDisponibles();
		servicios_reservados=this.recibirServiciosReservados().get("reservas");
		fechas_reservadas=this.recibirServiciosReservados().get("fechas");
		
		Map<String,List<String>> map= new HashMap<>();
		map.put("servicios", serviciosList);
		map.put("restaurantes", ReservarMesaController.recibirRestaurantes());
		map.put("servicos_reservados", servicios_reservados);
		map.put("fechas_reservadas", fechas_reservadas);
		map.put("horasRestaurantes", ReservarMesaController.horasDisponibles);

		
		////////////////////HARDCODED mientras no nos llegan datos///////////////////////
		List<String> hardcode = new LinkedList<String>();
		hardcode.add("14:00");
		hardcode.add("15:00");
		hardcode.add("16:00");
		hardcode.add("17:00");
		map.put("horasServicios",hardcode);
		///////////////////////////////////////////
		

		///////To reload servicios page and still get data 
		renewServicios = map.get("servicios");
		renewRestaurantes = map.get("restaurantes");
		renewServiciosReservados = map.get("servicos_reservados");
		renewFechasReservadas= map.get("fechas_reservadas");
		renewHorasRestaurantes= map.get("horasRestaurantes");
		renewHorasServicios= map.get("horasServicios");
		//////
		model.addAttribute("sesionBean", sesion);
		return new ModelAndView("servicios","muchas_cosas", map);
	}


	//recibir horas disponibles de cada servicio
	public JsonObject recibirHorasServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicios) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosHoras", "POST");
		
		int id_servicio=0;
		for (int i=0;i<servicios_nombre.size();i++) {
			
			if(servicios.getTipoServicio().equals(servicios_nombre.get(i))) {
				id_servicio=servicios_id[i];
				
		}}
		System.out.print(servicios.getTipoServicio());
		JsonObject json = new JsonObject();
		
		json.addProperty("servicio_id",id_servicio);
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		

		return obj;
	}


	//recibir servicios reservados por un cliente
	public static  Map<String,List<String>> recibirServiciosReservados() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosReservados", "POST");
		
		JsonObject json = new JsonObject();
		 //coger id_usuario de la sesionBean
		json.addProperty("id_estancia", VerReservasController.reservilla.getId_reserva());
		json.addProperty("id_cliente", datosController.ALFONSO);
		
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		JsonArray reservas_hechas= obj.get("nombreServicio").getAsJsonArray();//los nombres me los he inventado

		List<String> reservas= new LinkedList<>();
		for (int i=0;i<reservas_hechas.size();i++) {
			reservas.add(reservas_hechas.get(i).getAsString());
		}
		JsonArray reservas_fechas= obj.get("fecha").getAsJsonArray();//los nombres me los he inventado

		List<String> fechas= new LinkedList<>();
		for (int i=0;i<reservas_fechas.size();i++) {
			fechas.add(reservas_fechas.get(i).getAsString());
		}
		
		
		Map<String,List<String>> map= new HashMap<>();
		map.put("reservas", reservas);
		map.put("fechas", fechas);
		//System.out.println(reservas);
		//System.out.println(fechas);
        //System.out.println((JsonObject) JsonParser.parseString(resp)); //both reservas & fechas
        
		return map;
	}


	//reservar servicios
	@GetMapping("/enviarServicios")
	public ModelAndView reservarServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicos,Model model) throws Exception{

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/recibirServicio", "POST");

		//Para averiguar el identificador del servicio liamos todo esto
		int nombre_id=0;
		int id_servicio_dho=0;
		for (int i=0;i<servicios_id.length;i++) {
			if(servicios_nombre.get(i).equals(servicos.getTipoServicio())) {
				id_servicio_dho=servicios_id[i];
				nombre_id=i;
			}
		}
		System.out.print("------------------>"+"\n"+servicos.getTipoServicio()+"\n"+id_servicio_dho+"\n"+servicos.getFecha()+"\n"+servicos.getHoras());
		JsonObject json = new JsonObject();
		json.addProperty("id_servicio", id_servicio_dho);//se puede mandar el servicio en vez del id??
		json.addProperty("fecha", servicos.getFecha());
		json.addProperty("hora", servicos.getHoras());
		json.addProperty("cliente_id", datosController.ALFONSO);
		json.addProperty("lugar", servicios_nombre.get(nombre_id));
		json.addProperty("num_personas", servicos.getNumPersonas());
		json.addProperty("id_reserva", VerReservasController.reservilla.getId_reserva());
		json.addProperty("tipoServicio", 1);
		json.addProperty("hora_salida", (String)null);
		//IMPORTANTE:falta el nombre del restaurante al reservar una mesa

		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}
		
		Map<String,List<String>> map= new HashMap<>();

		map.put("servicios", renewServicios);
		map.put("restaurantes", renewRestaurantes);
		map.put("servicos_reservados", recibirServiciosReservados().get("reservas"));
		map.put("horasRestaurantes", renewHorasRestaurantes);
		map.put("horasServicios",renewHorasServicios);
		map.put("fechas_reservadas",recibirServiciosReservados().get("fechas"));

		model.addAttribute("sesionBean", sesion);
		return new ModelAndView("servicios","muchas_cosas",map);
	}
	
	
	public ModelAndView pruebaReservaBean(@Valid@ModelAttribute("ServiciosBean") ServiciosBean reserva_servicios,Model model) throws Exception{
		Map<String,List<String>> map= new HashMap<>();

		map.put("servicios", renewServicios);
		map.put("restaurantes", renewRestaurantes);
		map.put("servicos_reservados", recibirServiciosReservados().get("reservas"));
		map.put("horasRestaurantes", renewHorasRestaurantes);
		map.put("horasServicios",renewHorasServicios);
		map.put("fechas_reservadas",recibirServiciosReservados().get("fechas"));

		model.addAttribute("sesionBean", sesion);
		System.out.print(reserva_servicios.toString()); //reservar servicios bean
		return new ModelAndView("servicios","muchas_cosas", map);

	}
	


}
