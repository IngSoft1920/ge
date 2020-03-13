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
import com.google.gson.JsonObject;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {

	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());


	@Autowired
	ServiciosBean servicios;
	@Autowired
	SesionBean sesion;
	VerReservasBean reservas;

	@GetMapping("/servicios")
	public String checkInEnviar(Model model, SesionBean sesion) throws Exception {
		model.addAttribute("sesionBean", sesion);
		return "servicios";
	}



	//recibir servicios
	@GetMapping("/recibirServicios")
	public static  String recibirServiciosr(@ModelAttribute("reserva") VerReservasBean reserva) throws Exception {

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");

		//enviar nombre del hotel
		JsonObject json = new JsonObject();
		json.addProperty("nombre_hotel", "hotel_prueba");//habria que cogerlo de VerReservasBean, ¿como?
		//ASI?? json.addProperty("id_estancia", reserva.getNombre_hotel());   ASI¿?¿?
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		return resp;
	}
	//falta api que nos de las horas disponibles y mandamos fecha e id de servicio

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
	@PostMapping("/reservarServicios1")	
	public String reservarServicios(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicos) throws Exception{

		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservar_servicio", "POST");
		JsonObject json = new JsonObject();
		json.addProperty("tipoServicio", servicios.getTipoServicio());//se puede mandar el servicio en vez del id??
		json.addProperty("fecha", servicios.getFecha());
		json.addProperty("hora", servicios.getHoras());
		json.addProperty("cliente_id", sesion.getUsuarioID());
		//falta el lugar,¿como?

		//cosas que faltan
		json.addProperty("numPersonas", servicios.getNumPersonas());
		json.addProperty("idReserva", reservas.getId_reserva());
		json.addProperty("platos", (String)null);
		json.addProperty("items", (String)null);
		//falta el nombre del restaurante al reservar una mesa

		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}


		return "";
	}



	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}

}
