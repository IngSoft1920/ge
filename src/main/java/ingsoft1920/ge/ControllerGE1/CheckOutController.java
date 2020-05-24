package ingsoft1920.ge.ControllerGE1;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;


import org.apache.logging.log4j.LogManager;



import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Objetillos.Reserva;
import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.CheckOutBean;
import ingsoft1920.ge.Controller.datosController;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller

public class CheckOutController {
	
	final static Logger logger = LogManager.getLogger(CheckOutController.class.getName());
	
	@Autowired
	CheckOutBean checkout;
	
	@Autowired
	 SesionBean sesion;
	
	//enviar check-out
	@PostMapping("/checkout/{id}")
	public  ModelAndView checkoutEnviar(@PathVariable("id") int id ,Model model) throws Exception {
		
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/confirmarCheckout", "POST");
		JsonObject json = new JsonObject();
		json.addProperty("reserva_id",id);
		
		
		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode+"\n");
		if(respCode==200)
		{
			client.getResponseBody();
		}
		
		//////////////////////////////////////
		
		HttpClient client1= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/reservas","POST");
		JsonObject json1= new JsonObject();
		json1.addProperty("id_cliente", datosController.ALFONSO);
		client1.setRequestBody(json1.toString());
		
		int respCode1 = client1.getResponseCode();
		
		String resp1="";
		if(respCode1==200) {
			  resp1=client1.getResponseBody();
			  }
		
		JsonObject obj = (JsonObject) JsonParser.parseString(resp1);
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
			reservas.add(new Reserva(numeros_reservas.get(i).getAsInt(),numeros_habitaciones.get(i).getAsInt(),inicio_fechas.get(i).getAsString(),final_fechas.get(i).getAsString(),nombre_hoteles.get(i).getAsString(),estado.get(i).getAsString(),"",""));
		}
		
		model.addAttribute("sesionBean", sesion);
		return new ModelAndView("reservaServicios","reservas", reservas);
	}
	

}
