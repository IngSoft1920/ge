package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ServiciosDisponiblesPostReservaBean;
import ingsoft1920.ge.Beans.ServiciosPostReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;

public class ServiciosPostReservaController {
	final static Logger logger = LogManager.getLogger(ServiciosPostReservaController.class.getName());

	@Autowired

	ServiciosDisponiblesPostReservaBean serviciosDisponibles;

	SesionBean sesionBean;

	List<ServiciosPostReservaBean> servicios;

	MostrarServiciosPostReservaBean mostrarServiciosPostReservaBean = new MostrarServiciosPostReservaBean();

	@GetMapping("/serviciosExtras")
	public String mostarServiciosGet(Model model) throws Exception {

		/*
		 * [ { “id” : 1 , “nombre” : “piscina” , “precio”: 10 , “unidad” : “por_dia” },
		 * { “id” : 2 , “nombre” : “restaurante” , “precio” : null , “unidad” : null } ]
		 */

		JsonArray arrayGrande = new JsonArray();

		JsonObject ejemplo = new JsonObject();
		ejemplo.addProperty("id", 1);
		ejemplo.addProperty("nombre", "piscina");
		ejemplo.addProperty("precio", 10);
		ejemplo.addProperty("unidad", "por_dia");
		arrayGrande.add(ejemplo);

		ejemplo.addProperty("id", 2);
		ejemplo.addProperty("nombre", "spa");
		ejemplo.addProperty("precio", 30);
		ejemplo.addProperty("unidad", "por_sesión");
		arrayGrande.add(ejemplo);

		String response = arrayGrande.toString();

		HttpClient serverServicios = new HttpClient(
				HttpClient.urlCM + "hotel/servicios/" + mostrarServiciosPostReservaBean.getHotel_id(), "GET");

		JsonObject json = new JsonObject();
		json.addProperty("id_hotel", mostrarServiciosPostReservaBean.getHotel_id()); // coger id_hotel de
																						// mostarServiciosPostReservaBean

		if (serverServicios.getResponseCode() == 200) {// Si encuentra el servidor
			response = serverServicios.getResponseBody();
		}

		Type tipo = new TypeToken<List<ServiciosPostReservaBean>>() {
		}.getType();
		servicios = new Gson().fromJson(response, tipo);

		model.addAttribute("servicios", servicios);
		model.addAttribute("mostarServiciosPostReservaBean", mostrarServiciosPostReservaBean);
		model.addAttribute("sesionBean", sesionBean);

		return "serviciosExtras";

	}

	@PostMapping("/serviciosExtras")
	public String mostarServiciosPost(

			@Valid @ModelAttribute("mostrarServiciosPostReservaBean") MostrarServiciosPostReservaBean mostrarServiciosPostReservaBean,
			Model model) throws Exception {
		return "";
	}

}
