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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {
	public static String[] servicios_nombre;
	public static int[] servicios_id;

	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());


	@Autowired
	ServiciosBean servicios;
	@Autowired
	SesionBean sesion;
	VerReservasBean reservas;


	//recibir servicios
	
	public static  JsonObject recibirServiciosr() throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");

		//enviar nombre del hotel
		JsonObject json = new JsonObject();
		json.addProperty("nombre_hotel", "hotel_prueba");//habria que cogerlo de VerReservasBean, ¿como?
		//ASI json.addProperty("id_estancia", reserva.getNombre_hotel());
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		
		//Creo un objeto Json de lo recibido, que es un String, pero al estar en formato Json se puede pasar a este
		JsonObject obj = (JsonObject) JsonParser.parseString(resp); 
		
		//Creo un Array de tipo Json del campo que quiero, con el getAsElTipoDelCampoQueQuiero
		JsonArray nombres= obj.get("servicios_disponibles_nombre").getAsJsonArray();
		//Creo una estructura del tipo que quiero y en este caso como es una array, la recorro con un for rellenandolo
		String[] servicios= new String[nombres.size()];
		for(int i=0;i<servicios.length;i++) {
			servicios[i]=nombres.get(i).getAsString();	
		}
		//Me he declarado un atributo de la clase para guardar el array cuando nos lo manden para luego sacar 
		//el id del sericio con otro for
		servicios_nombre= servicios;
		
		//igual pero con los identificadores de los servicios
		JsonArray ids= obj.get("servicios_disponibles_id").getAsJsonArray();
		int[] ides= new int[ids.size()];
		for(int i=0;i<ides.length;i++) {
			ides[i]=ids.get(i).getAsInt();	
		}
		servicios_id=ides;
		
		return obj;
	}
	
	
	//IMPORTANTE:falta api que nos de las horas disponibles y mandamos fecha e id de servicio

	//recibir servicios reservados por un cliente
	public  String recibirServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicios,
			Model model) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosReservados", "POST");

		//enviar id_cliente e id_reserva
		JsonObject json = new JsonObject();
		json.addProperty("id_cliente", sesion.getUsuarioID()); //coger id_usuario de la sesionBean
		json.addProperty("id_estancia", reservas.getId_reserva()); //coger id_reserva de VerReservasBean
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		return resp;
	}


	//reservar servicios

	public int reservarServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicos) throws Exception{

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservar_servicio", "POST");
		
		//Para averiguar el identificador del servicio liamos todo esto
		int id_servicio_dho=0;
		for (int i=0;i<servicios_id.length;i++) {
			if(servicios_nombre[i].equals(servicios.getTipoServicio())) {
				id_servicio_dho=servicios_id[i];
			}
		}
		
		JsonObject json = new JsonObject();
		json.addProperty("id_servicio", id_servicio_dho);//se puede mandar el servicio en vez del id??
		json.addProperty("fecha", servicios.getFecha());
		json.addProperty("hora", servicios.getHoras());
		json.addProperty("cliente_id", sesion.getUsuarioID());
		json.addProperty("lugar", (String)null);

		//cosas que faltan
		json.addProperty("numPersonas", servicios.getNumPersonas());
		json.addProperty("idReserva", reservas.getId_reserva());
		json.addProperty("platos", (String)null);
		json.addProperty("items", (String)null);
		//IMPORTANTE:falta el nombre del restaurante al reservar una mesa

		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}


		return respCode;
	}



	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

}
