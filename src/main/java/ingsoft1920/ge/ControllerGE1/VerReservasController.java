package ingsoft1920.ge.ControllerGE1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Objetillos.Reserva;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.Controller.datosController;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class VerReservasController {
	public static JSONObject receivedJSON = new JSONObject();
	public static Reserva reservilla;
	public static String pathFactura;

	@Autowired
	SesionBean sesion;


	@GetMapping("/recibirReservas")
	public  ModelAndView reservasEnviar() throws Exception {
		
		String idString = String.valueOf(datosController.ALFONSO);
		//idString = "4"; //hardcode para probar factura
		pathFactura = "http://piedrafita.ls.fi.upm.es:7001/download/f/" + idString;

		receivedJSON.put("datosReserva", "Datos de su reserva");

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
					estado.get(i).getAsString()));
		}


		return new ModelAndView("reservaServicios","reservas", reservas);

	}

	@PostMapping("/gestionar/{id}")
	public String enviarComanda(@PathVariable("id") int id) throws Exception {

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
		//estado hotel
		JsonArray estado= obj.get("estado").getAsJsonArray();

		int cont=0;
		boolean salir= false;
		for(int i=0;i<estado.size();i++) {
			if (numeros_reservas.get(i).getAsInt()==id && salir==false) {
				cont=i;salir=true;
			}

		}
		Reserva res= new Reserva(numeros_reservas.get(cont).getAsInt(),numeros_habitaciones.get(cont).getAsInt(),inicio_fechas.get(cont).getAsString(),final_fechas.get(cont).getAsString(),nombre_hoteles.get(cont).getAsString(),estado.get(cont).getAsString());
		reservilla=res;
		System.out.print(res.toString());
		return "index";

	}

	//rellenar datos que faltan y enviar( el envio a falta de que dho pueda recibir nuevos datos)
	@PostMapping("/completarCheckin")
	public String completar() {

		return "completarCheckin";
	}


}
