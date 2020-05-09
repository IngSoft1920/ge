package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Objetillos.HotelGE2;
import Objetillos.Reserva;
import Objetillos.ReservaGE2;
import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.MostarReservasBean;
import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.ServiciosPostReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ReservaGrupoController {
	final static Logger logger = LogManager.getLogger(ServiciosPostReservaController.class.getName());

	@Autowired
	SesionBean sesionBean;

	
	List<ReservaBean> hoteles;

	
	@GetMapping("/reservaGrupo")	
	public ModelAndView reservaGrupoGet(Model model) throws Exception {
		String response ="";
		HttpClient server = new HttpClient(
				HttpClient.urlCM+"hotel/ge", "GET");
		if (server.getResponseCode() == 200) {// Si encuentra el servidor 
			  response = server.getResponseBody(); } 
			  
			JsonArray obj = (JsonArray) JsonParser.parseString(response);	 
			 
			List<HotelGE2> hoteles= new LinkedList<>(); 
			for (int i=0;i<obj.size();i++) {
				hoteles.add(new HotelGE2(obj.get(i).getAsJsonObject().get("id").getAsInt(),  
						obj.get(i).getAsJsonObject().get("nombre").getAsString(), 
						obj.get(i).getAsJsonObject().get("ciudad").getAsString()));
			} 
			return new ModelAndView("reservaGrupo","ListaHotel", hoteles); 
	}

	/*@PostMapping("/reservaGrupo")
	public String reservaGrupoPost(@Valid @ModelAttribute("reserva") 
			MostrarServiciosPostReservaBean servicio,
			Model model) throws Exception {
		
		reserva.getServicios().add(servicio);
		
		reserva.setPrecio_total(reserva.getPrecio_total() + servicio.getPrecio());
		
		model.addAttribute("sesionBean", sesionBean);
		return "serviciosExtras";
	}*/

}
