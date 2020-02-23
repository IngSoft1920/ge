package ingsoft1920.ge.Controller;

import java.util.ArrayList;
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

import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.HotelesDisponiblesBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class BusquedaController {
	final static Logger logger = LogManager.getLogger(BusquedaController.class.getName());

	@Autowired
	HotelesDisponiblesBean hotelesDisponibles;
	@Autowired 
	BusquedaBean busquedaBean;
	@Autowired
	SesionBean sesionBean;
	
	@GetMapping("/buscador")
	public String buscarGet(Model model) throws Exception {
		
		busquedaBean = new BusquedaBean();
		
		/*
		 * Formato Json recibido:
		 * {
		 * 		"ciudades": ["Guadalajara", "Madrid", "Zaragoza", "Valencia"],
		 * 		"hoteles": ["Rich", "Paquito", "Medici", "Corporate"]
		 * }
		 */

		// Creamos los ejemplos.
		JsonObject obj = new JsonObject();
		JsonArray arr = new JsonArray();
		arr.add("Guadalajara");
		arr.add("Madrid");
		arr.add("Zaragoza");
		arr.add("Valencia");
		obj.add("ciudades",	arr);
		arr = new JsonArray();
		arr.add("Rich");
		arr.add("Paquito");
		arr.add("Medici");
		arr.add("Corporate");
		obj.add("hoteles", arr);
		
		JsonArray ciudades = (JsonArray) obj.get("ciudades");
		JsonArray hoteles = (JsonArray) obj.get("hoteles");
		
		for (int i = 0; i < ciudades.size(); i++) {
			busquedaBean.getCiudades().add(ciudades.get(i).getAsString());
		}
		
		for (int i = 0; i < hoteles.size(); i++) {
			busquedaBean.getHoteles().add(hoteles.get(i).getAsString());
		}
		// El siguiente código debería consultar a CM de forma correcta
		/*
		String response = "";
		
		HttpClient server = new HttpClient(HttpClient.urlCM, "getHoteles");
		if (server.getResponseCode() != 404) {// Si encuentra el servidor
			response = server.getResponseBody();
			obj = new Gson().fromJson(response, JsonObject.class);

			JsonArray ciudades = (JsonArray) obj.get("ciudades");
			JsonArray hoteles = (JsonArray) obj.get("hoteles");
			
			for (int i = 0; i < ciudades.size(); i++) {
				busquedaBean.getCiudades().add(ciudades.get(i).getAsString());
			}
			
			for (int i = 0; i < hoteles.size(); i++) {
				busquedaBean.getHoteles().add(hoteles.get(i).getAsString());
			}
		}
		*/

		model.addAttribute("busquedaBean",busquedaBean);
		
		return "buscador";
	}
	
	@PostMapping("/buscador")
	public String buscarPost(@Valid @ModelAttribute("busquedaBean") BusquedaBean busquedaBean,
			Model model) {
		
		logger.info("Busqueda recibida correctamente");
		
		// Consulta a la base de datos
		
		hotelesDisponibles = new HotelesDisponiblesBean();
		HotelBean hotel = new HotelBean("Ritz", "Zaragoza", 15, 30);
		List<HabitacionBean> listaHabitaciones = new ArrayList<HabitacionBean>();
		listaHabitaciones.add(new HabitacionBean ("Suit", "300.0", 0));
		listaHabitaciones.add(new HabitacionBean ("Turista", "100.0", 1));
		listaHabitaciones.add(new HabitacionBean ("Privilegiada", "200.0", 2));
		hotel.setHabitaciones(listaHabitaciones);
		hotelesDisponibles.getHoteles().add(hotel);
		
		hotel = new HotelBean("Hotel 2", "Madrid", 15, 30);
		listaHabitaciones = new ArrayList<HabitacionBean>();
		listaHabitaciones.add(new HabitacionBean ("Suit", "300.0", 3));
		listaHabitaciones.add(new HabitacionBean ("Turista", "100.0", 4));
		listaHabitaciones.add(new HabitacionBean ("Privilegiada", "200.0", 5));
		hotel.setHabitaciones(listaHabitaciones);
		hotelesDisponibles.getHoteles().add(hotel);
		
		model.addAttribute("hotelesDisponiblesBean", hotelesDisponibles);
		
		return "buscador";
	}
	
	@PostMapping("/reservar")
	public String reservarPost(@Valid @ModelAttribute("habitacionId") int habitacionId,
			@Valid @ModelAttribute("comidas") String comidas,
			Model model) {
		
		if (sesionBean.getUsuarioID() == -1) {
			return "redirect:login";
		}
		
		logger.info("Reserva recibida correctamente." + habitacionId);
		String reserva = "";
		boolean encontrado = false;
		for (HotelBean hotel: hotelesDisponibles.getHoteles()) {
			
			for (HabitacionBean habitacion: hotel.getHabitaciones()) {
				if (habitacion.getId() == habitacionId) {
					encontrado = true;
					reserva += "\nTipo: " + habitacion.getTipo();
					reserva += "\nTarifa: " + habitacion.getTarifa();
					break;
				}
			}
			if (encontrado) {
				reserva += "\nComidas: " + comidas;
				reserva = "\nCiudad: " + hotel.getCiudad() + reserva;
				reserva = "Hotel: " + hotel.getNombre() + reserva;
				break;
			}
		}
		logger.info(reserva);
		
		return "redirect:misReservas";
	}
	
	
	@PostMapping("/reservarTarifa")
	public String reservarTarifaPost(@Valid @ModelAttribute("habitacionId") int habitacionId, @Valid @ModelAttribute("optionComida") String optionComida,
			Model model) {
		System.out.print("nos metemos");
		logger.info("ReservaTarifa recibida correctamente con opcion la opcion de comida:"+optionComida+"y en la habitacion:"+habitacionId);
		
		return "redirect:buscador";
	}
	
}
