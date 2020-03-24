package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;
import java.util.HashMap;

import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
//import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import com.google.gson.*;

@Controller
public class CheckInController {
	
	final static Logger logger = LogManager.getLogger(CheckInController.class.getName());
	
	@Autowired
	//VerReservasBean reservas;
	SesionBean sesion;
	
	
	//enviar check-in
	@PostMapping("/envioCheckIn")
	public ModelAndView checkinEnviar() throws Exception {
		//HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/"+reservas.getIdReserva(), "GET");
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/7", "GET");
		
		int respCode = client.getResponseCode();
		
		String resp ="";
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			resp=client.getResponseBody();
		}
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);

		String cliente_id = obj.get("cliente_id").toString();
		String nombre = obj.get("nombre").toString();
		String apellidos = obj.get("apellidos").toString();
		String DNI = obj.get("DNI").toString();
		String email = obj.get("email").toString();
		String password = obj.get("password").toString();
		String nacionalidad = obj.get("nacionalidad").toString();
		String telefono = obj.get("telefono").toString();
		
		Map<String,String> map= new HashMap<>();
		map.put("Nombre", nombre);
		map.put("Apellidos", apellidos);
		map.put("DNI", DNI);
		map.put("email", email);
		map.put("Nacionalidad", nacionalidad);
		map.put("Telefono", telefono);
		
		return new ModelAndView("checkin","todo", map );
		
		//Esto seria lo definitivo, pero para las pruebas dejamos de momento lo de arriba
		/*if(cliente_id.isEmpty() || nombre.isEmpty() || DNI.isEmpty() || email.isEmpty() || 
				password.isEmpty() || nacionalidad.isEmpty() || telefono.isEmpty()){
			return new ModelAndView("checkin","todo",map );
		}
		else {
		
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/confirmarCheckin", "POST");
			
			JsonObject json= new JsonObject();
			json.addProperty("reserva_id",reservas.getId_reserva());
		
			client.setRequestBody(json.toString());
			
			int respCode = client.getResponseCode();
		
			String resp ="";
			System.out.println(respCode+"\n");
			if(respCode==200)
			{
				resp=client.getResponseBody();
			}
			return new ModelAndView("recibirServicios");
		}*/
		
		
	}
	
	public String enviarDatosCheckIn(@Valid@ModelAttribute("checkInBean") CheckInBean checkin) throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/enviardatosCambiados", "POST");
		
		JsonObject json= new JsonObject();
		//json.addProperty("reserva_id",reservas.getId_reserva());
		json.addProperty("cliente_id",sesion.getUsuarioID());
		json.addProperty("nombre",checkin.getNombre());
		json.addProperty("apellidos",checkin.getApellidos());
		json.addProperty("DNI",checkin.getDNI());
		json.addProperty("email",checkin.getEmail());
		json.addProperty("nacionalidad",checkin.getNacionalidad());
		json.addProperty("telefono",checkin.getTelefono());
	
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
	
		String resp ="";
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			resp=client.getResponseBody();
		}
		return "reservaServicios";
		
		
		
	}
	
	
	
	

}
