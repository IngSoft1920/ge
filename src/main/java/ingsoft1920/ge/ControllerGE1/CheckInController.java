package ingsoft1920.ge.ControllerGE1;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Objetillos.Cliente;
import Objetillos.Reserva;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.Controller.datosController;
//import ingsoft1920.ge.BeansGE1.VerReservasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class CheckInController {
	public int id_cliente;
	public int id_reserva;
	final static Logger logger = LogManager.getLogger(CheckInController.class.getName());

	@Autowired
	SesionBean sesion;

	// enviar check-in
	@PostMapping("/checkin/{id}")
	public ModelAndView checkinEnviar(@PathVariable("id") int id,Model model) throws Exception {
		id_reserva = id;

		/*// HttpClient client= new
		// HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/"+id, "GET");
		HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/getCliente/"+id_reserva, "GET");
	
		int respCode = client.getResponseCode();

		String resp = "";
		System.out.println(respCode + "\n");
		if (respCode == 200) {
			resp = client.getResponseBody();
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

			id_cliente = cliente_id;
			Cliente cliente = new Cliente(cliente_id, nombre, apellidos, DNI, email, password, nacionalidad, telefono);
			System.out.print(cliente.toString());

		} catch (Exception e) {
			return new ModelAndView("checkInAlfonso");
		}*/
		HttpClient clien = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/confirmarCheckin", "POST");

		JsonObject json = new JsonObject();
		json.addProperty("reserva_id", id);

		clien.setRequestBody(json.toString());

		int responseCode = clien.getResponseCode();

		String response = "";
		// System.out.print(responseCode);
		if (responseCode == 200) {
			response = clien.getResponseBody();
		}
		model.addAttribute("sesionBean", sesion);
		return new ModelAndView("index");
	}

	@PostMapping("/confirmarCheckin")
	public String enviarDatosCheckIn(@Valid @ModelAttribute("checkInBean") CheckInBean checkin,Model model) throws Exception {
		System.out.print(checkin.toString());
		HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/enviardatosCambiadosmasCheckIn",
				"POST");
		JsonObject json = new JsonObject();
		try {
			json.addProperty("reserva_id", id_reserva);
			json.addProperty("cliente_id", id_cliente);
			json.addProperty("nombre", checkin.getNombre());
			json.addProperty("apellidos", checkin.getApellidos());
			json.addProperty("DNI", checkin.getDNI());
			json.addProperty("email", checkin.getEmail());
			json.addProperty("password", checkin.getPassword());
			json.addProperty("nacionalidad", checkin.getNacionalidad());
			json.addProperty("telefono", checkin.getTelefono());
		} catch (Exception e) {
			return "checkInAlfonso";

		}
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp = "";
		System.out.println(respCode + "\n");
		if (respCode == 200) {
			resp = client.getResponseBody();
		}
		model.addAttribute("sesionBean", sesion);
		return "index";

	}
	
	@PostMapping("/precheckinge")
	public ModelAndView precheckinEnviar(Model model) throws Exception {
	
		HttpClient client1 = new HttpClient("http://piedrafita.ls.fi.upm.es:7001/precheckin/"+VerReservasController.reservilla.getId_reserva(),
				"POST");
		
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservas","POST");
		JsonObject json= new JsonObject();
		json.addProperty("id_cliente", datosController.ALFONSO);
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}

		JsonObject obj = (JsonObject) JsonParser.parseString(resp);
		//numero de reserva
		JsonArray numeros_reservas= obj.get("id_estancia_lista").getAsJsonArray();

		//numero de habitacion
		JsonArray numeros_habitaciones= obj.get("num_hab_lista").getAsJsonArray();


		//fecha inicio
		JsonArray inicio_fechas= obj.get("fecha_Inicio_Lista").getAsJsonArray();


		//fecha final
		JsonArray final_fechas= obj.get("fecha_Fin_Lista").getAsJsonArray();


		//nombre hotel
		JsonArray nombre_hoteles= obj.get("nombre_hotel_Lista").getAsJsonArray();
		JsonArray estado= obj.get("estado").getAsJsonArray();
		List<Reserva> reservas= new LinkedList<>();
		

		for (int i=0;i<nombre_hoteles.size();i++) {
			reservas.add(new Reserva(numeros_reservas.get(i).getAsInt(),
					numeros_habitaciones.get(i).getAsInt(),inicio_fechas.get(i).getAsString(),
					final_fechas.get(i).getAsString(),nombre_hoteles.get(i).getAsString(),
					estado.get(i).getAsString(),""));
		}

		
		return new ModelAndView("reservaServicios","reservas",reservas);
		
		
	}

}
