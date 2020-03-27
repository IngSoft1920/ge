package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Objetillos.Cliente;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
//import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class CheckInController {
	public int id_cliente;
	public int id_reserva;
	final static Logger logger = LogManager.getLogger(CheckInController.class.getName());
	
	@Autowired
	SesionBean sesion;
	
	
	//enviar check-in
	@PostMapping("/checkin/{id}")
	public ModelAndView checkinEnviar(@PathVariable("id") int id) throws Exception {
		id_reserva=id;
		
		//HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/"+id, "GET");
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/getCliente/1", "GET");
		System.out.print("HOLAAAAA");
		int respCode = client.getResponseCode();
		
		String resp ="";
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			resp=client.getResponseBody();
		}
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		try {
		int cliente_id = obj.get("cliente_id").getAsInt();
		String nombre = obj.get("nombre").toString();
		String apellidos = obj.get("apellidos").toString();
		String DNI = obj.get("DNI").toString();
		String email = obj.get("email").toString();
		String password = obj.get("password").toString();
		String nacionalidad = obj.get("nacionalidad").toString();
		String telefono = obj.get("telefono").toString();
		
		id_cliente=cliente_id;
		Cliente cliente= new Cliente(cliente_id,nombre,apellidos,DNI,email,password,nacionalidad,telefono);
		System.out.print(cliente.toString());
		
		} catch(Exception e) {
			return new ModelAndView("checkInAlfonso");
		}
			HttpClient clien= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/confirmarCheckin", "POST");
			
			JsonObject json= new JsonObject();
			json.addProperty("reserva_id",id);
		
			clien.setRequestBody(json.toString());
			
			int responseCode = clien.getResponseCode();
		
			String response ="";
			//System.out.print(responseCode);
			if(responseCode==200)
			{
				response=clien.getResponseBody();
			}
			return new ModelAndView("index");
		}
	
		
		
	
	@PostMapping("/confirmarCheckin")
	public String enviarDatosCheckIn(@Valid@ModelAttribute("checkInBean") CheckInBean checkin) throws Exception {
		System.out.print(checkin.toString());
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/enviardatosCambiadosmasCheckIn", "POST");
		JsonObject json= new JsonObject();
		try {
		json.addProperty("reserva_id",id_reserva);
		json.addProperty("cliente_id",id_cliente);
		json.addProperty("nombre",checkin.getNombre());
		json.addProperty("apellidos",checkin.getApellidos());
		json.addProperty("DNI",checkin.getDNI());
		json.addProperty("email",checkin.getEmail());
		json.addProperty("password",checkin.getPassword());
		json.addProperty("nacionalidad",checkin.getNacionalidad());
		json.addProperty("telefono",checkin.getTelefono());
		} catch(Exception e) {
			return "checkInAlfonso";
			
		}
		client.setRequestBody(json.toString());
		
		int respCode = client.getResponseCode();
	
		String resp ="";
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			resp=client.getResponseBody();
		}
		return "index";
		
		
		
	}
	
	
	
	

}
