package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.List;

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
import com.google.gson.reflect.TypeToken;

import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.MostarReservasBean;
import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.ServiciosPostReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MisReservasController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@Autowired
	MisReservasBean misReservasBean;
	
	@Autowired
	SesionBean sesionBean;

	List<ReservaBean> reservas;
	
	MostarReservasBean mostarReservasBean = new MostarReservasBean();

	@GetMapping("/misReservas")
	public String mostrarReservasGet(Model model) throws Exception {

		/*
		 * [ { reserva_id : 21, hotel_id : 1 , tipo_hab : “normal”, regimen :
		 * “no_aplica”, importe : “300”, fecha_entrada : “2020-02-10”, fecha_salida :
		 * “2020-02-15”, }, { reserva_id : 10, hotel_id : 14 , tipo_hab : “premium”,
		 * regimen : “media_pension”, importe : “750”, fecha_entrada : “2020-07-10”,
		 * fecha_salida : “2020-07-15”, } ]
		 */

		JsonArray arrayGrande = new JsonArray();

		JsonObject ejemplo = new JsonObject();
		ejemplo.addProperty("reserva_id", 21);
		ejemplo.addProperty("hotel_id", 1);
		ejemplo.addProperty("tipo_hab", "normal");
		ejemplo.addProperty("regimen", "no aplica");
		ejemplo.addProperty("importe", 300);
		ejemplo.addProperty("fecha_entrada", "2020-02-10");
		ejemplo.addProperty("fecha_salida", "2020-02-15");
		arrayGrande.add(ejemplo);

		ejemplo = new JsonObject();
		ejemplo.addProperty("reserva_id", 10);
		ejemplo.addProperty("hotel_id", 14);
		ejemplo.addProperty("tipo_hab", "premium");
		ejemplo.addProperty("regimen", "media_pension");
		ejemplo.addProperty("importe", 750);
		ejemplo.addProperty("fecha_entrada", "2020-07-10");
		ejemplo.addProperty("fecha_salida", "2020-07-15");
		arrayGrande.add(ejemplo);

		String response = arrayGrande.toString();

		/*
		 * HttpClient serverReservas = new HttpClient( HttpClient.urlCM +
		 * "reserva/cliente/ " + sesionBean.getUsuarioID(), "GET");
		 */

		/*
		 * JsonObject json = new JsonObject();
		json.addProperty("id_usuario", sesionBean.getUsuarioID()); // coger id_usuario de SesionBean 
		*/

		/*
		 * if (serverReservas.getResponseCode() == 200) {// Si encuentra el servidor
		 * response = serverReservas.getResponseBody(); }
		 */

		Type tipo = new TypeToken<List<ReservaBean>>() {
		}.getType();
		reservas = new Gson().fromJson(response, tipo);
		
		model.addAttribute("reservas", reservas);
		model.addAttribute("mostrarReservasBean", mostarReservasBean);
		model.addAttribute("sesionBean", sesionBean);

		for (int i = 0; i < reservas.size(); i++) {
			System.out.println(reservas.get(i));
		}

		return "misReservas";

	}
	
	@PostMapping("/misReservas")
	public String mostarReservasPost(

			@Valid @ModelAttribute("mostarReservasBean") MostarReservasBean mostarReservasBean,
			Model model) throws Exception {
		
		System.out.println("Bien");
		

		model.addAttribute("reservas", reservas);
		model.addAttribute("mostarReservasBean", mostarReservasBean);
		model.addAttribute("sesionBean", sesionBean);
		
		return "misReservas";
	}
	@PostMapping("/valorar")
	public String valorarPost(@Valid @ModelAttribute("valoracionId") String valoracionId, Model model) {

		logger.info("Valoración recibida correctamente." + valoracionId);
		return "redirect:misReservas";
	}


}
