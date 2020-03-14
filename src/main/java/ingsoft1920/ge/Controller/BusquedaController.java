package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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

	List<HotelBean> hoteles;
	
	BusquedaBean busquedaBean = new BusquedaBean();
	@Autowired
	SesionBean sesionBean;

	JsonObject crearReserva;

	@GetMapping("/")
	public String buscarGet(Model model) throws Exception {
		
		
		/*[
		 * {
  		 *		"id" : 1,
  		 *		"nombre" : "Sol Creciente",
  		 *		"descripcion" : "Calurosa experiencia",
  		 *		"estrellas" : 4,
  		 *		"continente" : "Europa",
  		 *		"pais" : "España",
  		 *		"ciudad" : "Madrid",
  		 *		"direccion" : "Calle Gran Vía,21",
  		 *		“categorias” : [
     	 *			{“categoria_id” : 1 , “nombre” : “pet-friendly” },
     	 *			{“categoria_id” : 2 , “nombre” : “adult-only”}
    	 *		]
 		 *	},
 		 *  {
  		 *		"id" : 1,
  		 *		"nombre" : "Luna Creciente",
  		 *		"descripcion" : "Curiosa experiencia",
  		 *		"estrellas" : 3,
  		 *		"continente" : "Europa",
  		 *		"pais" : "España",
  		 *		"ciudad" : "Albacete",
  		 *		"direccion" : "Calle Cuenca es mejor,21",
  		 *		“categorias” : [
     	 *			{“categoria_id” : 1 , “nombre” : “pet-friendly” },
     	 *			{“categoria_id” : 2 , “nombre” : “caga-y-vete”}
    	 *		]
 		 *	 }
 		 * ]
		 */
		JsonArray arrayGrande = new JsonArray();
		
		JsonObject ejemplo = new JsonObject();
		ejemplo.addProperty("id", 1);
		ejemplo.addProperty("nombre", "Sol Creciente");
		ejemplo.addProperty("descripcion", "Calurosa Experiencia");
		ejemplo.addProperty("estrellas", 4);
		ejemplo.addProperty("continente", "Europa");
		ejemplo.addProperty("pais", "España");
		ejemplo.addProperty("ciudad", "Madrid");
		ejemplo.addProperty("direccion", "Calle Gran Vía, 21");
		JsonArray ejemploArr = new JsonArray();
		JsonObject ejemploCat = new JsonObject();
		ejemploCat.addProperty("categoria_id", 1);
		ejemploCat.addProperty("nombre", "pet-friendly");
		ejemploArr.add(ejemploCat);
		ejemploCat = new JsonObject();
		ejemploCat.addProperty("categoria_id", 2);
		ejemploCat.addProperty("nombre", "adult-only");
		ejemploArr.add(ejemploCat);
		ejemplo.add("categorias", ejemploArr);
		arrayGrande.add(ejemplo);
		
		ejemplo = new JsonObject();
		ejemplo.addProperty("id", 2);
		ejemplo.addProperty("nombre", "Luna Creciente");
		ejemplo.addProperty("descripcion", "Curiosa Experiencia");
		ejemplo.addProperty("estrellas", 3);
		ejemplo.addProperty("continente", "Europa");
		ejemplo.addProperty("pais", "España");
		ejemplo.addProperty("ciudad", "Albacete");
		ejemplo.addProperty("direccion", "Calle Cuenca es mejor, 21");
		ejemploArr = new JsonArray();
		ejemploCat = new JsonObject();
		ejemploCat.addProperty("categoria_id", 1);
		ejemploCat.addProperty("nombre", "pet-friendly");
		ejemploArr.add(ejemploCat);
		ejemploCat = new JsonObject();
		ejemploCat.addProperty("categoria_id", 3);
		ejemploCat.addProperty("nombre", "caga-y-vete");
		ejemploArr.add(ejemploCat);
		ejemplo.add("categorias", ejemploArr);
		arrayGrande.add(ejemplo);
		
		String response = arrayGrande.toString();
		/*
		HttpClient serverCiudades = new HttpClient(HttpClient.urlCM+"hotel/ge", "GET");
		if (serverCiudades.getResponseCode() != 404) {// Si encuentra el servidor
			response = serverCiudades.getResponseBody();
		}*/

		Type tipo = new TypeToken<List<HotelBean>>(){}.getType();
		hoteles = new Gson().fromJson(response, tipo);

		model.addAttribute("hoteles", hoteles);
		model.addAttribute("busquedaBean",busquedaBean);
		model.addAttribute("sesionBean", sesionBean);

		return "buscador";
	}

	@PostMapping("/")
	public String buscarPost(@Valid @ModelAttribute("busquedaBean") BusquedaBean busquedaBean,
			Model model) throws Exception{

		if (busquedaBean.checkCamposValidos()) {

			/* Será interesante para el futuro
			List<HotelBean> list = hotelesDisponibles.getHoteles().stream()
					.filter(hotel -> !hotel.getHabitaciones().isEmpty())
					.collect(Collectors.toList());
			 */
			logger.info("Busqueda recibida correctamente");

			/*
			 * En este caso los datos para la búsqueda 
			 * de disponibilidad los paso en la url
			 * 
			 *  /hotel/disponibles?fecha_inicio=2020-10-03&fecha_fin=2020-10-05
			 */
			
			/*
			 * Formato de la respuesta:
			 * [
 			 *	{
 			 *  	"hotel_id" : 1,
			 *  	“habitaciones” : [
 			 *     		{"tipo_hab_id" : 1, "nombre": “normal”, "precio_total" : 300},
 			 *     		{"tipo_hab_id" : 2, "nombre" : “premium”, "precio_total" : 400}
 			 *  	]
 			 *  },
 			 *  {
 			 *  	"hotel_id" : 2,
 			 *  	"habitaciones" : [
 			 *     		{"tipo_hab_id" : 1, "nombre": “normal”, "precio_total" : 100},
 			 *     		{"tipo_hab_id":3, "nombre" : "presidencial" , "precio_total" : 600}
 			 *   	]
 			 *  }
 			 * ]
			 */

			JsonArray jarr = new JsonArray();
			JsonObject jobj = new JsonObject();
			jobj.addProperty("hotel_id", 1);
			JsonArray arrhab = new JsonArray();
			JsonObject objhab = new JsonObject();
			objhab.addProperty("tipo_hab_id", 1);
			objhab.addProperty("nombre", "normal");
			objhab.addProperty("precio_total", 300);
			arrhab.add(objhab);
			objhab = new JsonObject();
			objhab.addProperty("tipo_hab_id", 2);
			objhab.addProperty("nombre", "premium");
			objhab.addProperty("precio_total", 400);
			arrhab.add(objhab);
			jobj.add("habitaciones", arrhab);
			jarr.add(jobj);

			jobj = new JsonObject();
			jobj.addProperty("hotel_id", 2);
			arrhab = new JsonArray();
			objhab = new JsonObject();
			objhab.addProperty("tipo_hab_id", 1);
			objhab.addProperty("nombre", "normal");
			objhab.addProperty("precio_total", 100);
			arrhab.add(objhab);
			objhab = new JsonObject();
			objhab.addProperty("tipo_hab_id", 3);
			objhab.addProperty("nombre", "presidencial");
			objhab.addProperty("precio_total", 600);
			arrhab.add(objhab);
			jobj.add("habitaciones", arrhab);
			jarr.add(jobj);

			String response = jarr.toString();
			/*
			HttpClient server = new HttpClient(
					HttpClient.urlCM+"hotel/disponibles?" + 
					"fecha_inicio=" + busquedaBean.getFechaInicio() +
					"&fecha_fin=" + busquedaBean.getFechaFin(), "GET");

			if (server.getResponseCode() == 200) {
				response = server.getResponseBody();
			}*/

			List<HotelBean> disponibles = hoteles;

			if (busquedaBean.getCiudad() != "") {
				disponibles = disponibles.stream()
						.filter(hotel -> 
						hotel.getCiudad().compareTo(busquedaBean.getCiudad()) == 0)
						.collect(Collectors.toList());
			}

			if (busquedaBean.getHotel() != "") {
				disponibles = disponibles.stream()
						.filter(hotel -> 
						hotel.getNombre().compareTo(busquedaBean.getHotel()) == 0)
						.collect(Collectors.toList());
			}

			JsonArray habitaciones = new Gson().fromJson(response, JsonArray.class);
			for (JsonElement je: habitaciones) {
				JsonObject jo = je.getAsJsonObject();
				int hotel_id = jo.get("hotel_id").getAsInt();
				HotelBean h = disponibles.stream().filter(hotel -> hotel.getId() == hotel_id).findFirst().get();
				h.setHabitaciones(new Gson().fromJson(jo.get("habitaciones"), new TypeToken<List<HabitacionBean>>(){}.getType()));
			}
			
			hotelesDisponibles.setHoteles(
					disponibles.stream()
					.filter(hotel -> hotel.getHabitaciones().size() > 0)
					.collect(Collectors.toList()));
			
			model.addAttribute("hotelesDisponibles", hotelesDisponibles);
			model.addAttribute("hoteles", hoteles);
		}


		model.addAttribute("busquedaBean", busquedaBean);
		model.addAttribute("sesionBean", sesionBean);
		return "buscador";
	}

	@PostMapping("/reservar")
	public String reservarPost(@Valid @ModelAttribute("habitacionId") int habitacionId,
			@Valid @ModelAttribute("comidas") String comidas, @Valid @ModelAttribute("hotelId") int hotelId,
			Model model) throws Exception{
		
		System.out.println("habitacionId: " + habitacionId + "; hotelId: " + hotelId);
		
		/*
         * {
         *
         *  "fecha_inicio":"yyyy-MM-dd"
         *  "fecha_fin":"yyyy-MM-dd"
         *  "precio":"1023124"
         *  "hotel_id":"12"
         *  "tipo":"lujo"
         *  "cliente_id":"123456789"
         *
         * }
         */
		
		/*
		
		crearReserva = new JsonObject();
		crearReserva.addProperty("fecha_inicio", busquedaBean.getFechaInicio());
		crearReserva.addProperty("fecha_fin", busquedaBean.getFechaFin());
		boolean encontrado = false;
		for (HotelBean hotel: hotelesDisponibles.getHoteles()) {
			for (HabitacionBean habitacion: hotel.getHabitaciones()) {
				if (habitacion.getTipo_hab_id() == habitacionId) {
					crearReserva.addProperty("tipo", habitacion.getNombre());
					crearReserva.addProperty("precio", habitacion.getPrecio_total());
					crearReserva.addProperty("hotel_id", hotel.getId());
					encontrado = true;
					break;
				}
			}
			if (encontrado) break;
		}

		crearReserva.addProperty("cliente_id", sesionBean.getUsuarioID());
		
		HttpClient server = new HttpClient(HttpClient.urlCM+"crearReserva", "POST");
		// Añado los datos de la consulta
		server.setRequestBody(crearReserva.toString());
		
		if (server.getResponseCode() == 404) {// Si encuentra el servidor
			model.addAttribute("mensajeError", "La reserva no se ha podido realizar correctamente");
			return "buscador";
		}
		
		return "redirect:misReservas";
		*/
		model.addAttribute("busquedaBean", busquedaBean);
		model.addAttribute("sesionBean", sesionBean);
		
		return "buscador";
	}	
}
