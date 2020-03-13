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

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class ServiciosController {
	
	final static Logger logger = LogManager.getLogger(ServiciosController.class.getName());
	

	@Autowired
	ServiciosBean servicios;
	SesionBean sesion;
	VerReservasBean reservas;
	
	
	@GetMapping("/servicios")
	public String checkInEnviar(Model model, SesionBean sesion) throws Exception {
        model.addAttribute("sesionBean", sesion);
		return "servicios";
 	}
	
	

	//recibir servicios
		@GetMapping("/recibirServicios")
		public static  String serviciosEnviar() throws Exception {
			
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/serviciosDisponibles", "POST");
			
			//enviar nombre del hotel
			JsonObject json = new JsonObject();
			json.addProperty("nombre_hotel", "hotel_prueba");//habria que cogerlo de VerReservasBean, ¿como?
			client.setRequestBody(json.toString());
			
			int respCode = client.getResponseCode();
			
			String resp="";
			if(respCode==200) {
				  resp=client.getResponseBody();
				  }
			return resp;
			
			
		}
		
		
		//falta api que nos de las horas disponibles y mandamos fecha e id de servicio
		
		
		
	//reservar servicios
	@PostMapping("/reservarServicio")	
	public String serviciosReservados(@Valid @ModelAttribute("serviciosBean") ServiciosBean servicos) throws Exception{
			
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
