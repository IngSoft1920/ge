package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.HotelesDisponiblesBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class BusquedaController {
	final static Logger logger = LogManager.getLogger(BusquedaController.class.getName());
	
	HotelesDisponiblesBean hotelesDisponibles;

	BusquedaBean busquedaBean = new BusquedaBean();
	@Autowired
	SesionBean sesionBean;

	JsonObject crearReserva;

	@GetMapping("/")
	public String buscarGet(Model model) throws Exception {
		
		
		/*
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
 		 *	}
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
		ejemploCat.addProperty("id", 1);
		ejemploCat.addProperty("nombre", "pet-friendly");
		ejemploArr.add(ejemploCat);
		ejemploCat = new JsonObject();
		ejemploCat.addProperty("id", 2);
		ejemploCat.addProperty("nombre", "adult-only");
		ejemploArr.add(ejemploCat);
		ejemplo.add("categorias", ejemploArr);
		arrayGrande.add(ejemplo);
		
		ejemplo = new JsonObject();
		ejemplo.addProperty("id", 1);
		ejemplo.addProperty("nombre", "Luna Creciente");
		ejemplo.addProperty("descripcion", "Curiosa Experiencia");
		ejemplo.addProperty("estrellas", 3);
		ejemplo.addProperty("continente", "Europa");
		ejemplo.addProperty("pais", "España");
		ejemplo.addProperty("ciudad", "Albacete");
		ejemplo.addProperty("direccion", "Calle Cuenca es mejor, 21");
		ejemploArr = new JsonArray();
		ejemploCat = new JsonObject();
		ejemploCat.addProperty("id", 1);
		ejemploCat.addProperty("nombre", "pet-friendly");
		ejemploArr.add(ejemploCat);
		ejemploCat = new JsonObject();
		ejemploCat.addProperty("id", 3);
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
		hotelesDisponibles.setHoteles(new Gson().fromJson(response, tipo));
		
		model.addAttribute("hoteles", hotelesDisponibles);
		model.addAttribute("busquedaBean",busquedaBean);
		model.addAttribute("sesionBean", sesionBean);

		return "buscador";
	}

	@PostMapping("/")
	public String buscarPost(@Valid @ModelAttribute("busquedaBean") BusquedaBean busquedaBean,
			Model model) throws Exception{

		if (busquedaBean.checkCamposValidos()) {

			logger.info("Busqueda recibida correctamente");

			// Consulta a la base de datos
			/*
			 * El formato de la consulta es el siguiete:
			 * {
			 * 		"fecha_inicio": "2020-08-22",
			 * 		"fecha_fin": "2020-08-29",
			 * 		"hotel_id": 12,            // Los campos ciudad y hotel
			 * 		"ubicacion": "Madrid"          // strings vacíos.
			 * }
			 */
			JsonObject obj = new JsonObject();
			obj.addProperty("fecha_inicio", busquedaBean.getFechaInicio());
			obj.addProperty("fecha_fin", busquedaBean.getFechaFin());
			obj.addProperty("hotel_id", busquedaBean.getHotel_id());
			obj.addProperty("ubicacion", busquedaBean.getCiudad());
			
			/*
	         * [
	         * 		{
	         *  		"nombre":"Uno caro"
	         * 			"ubicacion":"Ayelo"
	         *  		"hotel_id":"1"
	         *  		"tipo":"lujo"
	         *  		"precio":"1000000"
	         * 		},
	         * 		{
	         *  		"nombre":"Otro caro"
	         * 			"ubicacion":"Ayelo"
	         *  		"hotel_id":"2020"
	         *  		"tipo":"lujo"
	         *  		"precio":"1000000"
	         * 		}
	         * ]
	         */
			
			// El siguiente código debería consultar a CM de forma correcta
			//String response = "";
			
			hotelesDisponibles = new HotelesDisponiblesBean();
			/*
			HttpClient server = new HttpClient(HttpClient.urlCM+"precioDisponible", "POST");
			// Añado los datos de la consulta
			server.setRequestBody(obj.toString());
			
			if (server.getResponseCode() != 404) {// Si encuentra el servidor
				response = server.getResponseBody();
			*/
				JsonArray arr = new JsonArray();
				JsonObject json = new JsonObject();
				//arr = new Gson().fromJson(response, JsonArray.class);
				
				json.addProperty("nombre", "Barcelo Playa");
				json.addProperty("id", 3);
				json.addProperty("ubicacion", "Asturias");
				json.addProperty("tipo", "lujo");
				json.addProperty("precio", 99.9);
				arr.add(json);
				json = new JsonObject();
				json.addProperty("nombre", "Barcelo Playa");
				json.addProperty("id", 3);
				json.addProperty("ubicacion", "Asturias");
				json.addProperty("tipo", "económica");
				json.addProperty("precio", 49.9);
				arr.add(json);
				json = new JsonObject();
				json.addProperty("nombre", "El Resplandor");
				json.addProperty("id", 4);
				json.addProperty("ubicacion", "Málaga");
				json.addProperty("tipo", "lujo");
				json.addProperty("precio", 87.9);
				arr.add(json);
				json = new JsonObject();
				json.addProperty("nombre", "El Resplandor");
				json.addProperty("id", 4);
				json.addProperty("ubicacion", "Málaga");
				json.addProperty("tipo", "económica");
				json.addProperty("precio", 35.9);
				arr.add(json);
				
				int numero_dias = busquedaBean.getNumeroDias();
				
				Map<Integer, Integer> hoteles = new HashMap<Integer, Integer>();
				HotelBean hotel; HabitacionBean habitacion;
				//JsonObject json;
				for (int i = 0; i < arr.size(); i++) {
					json = arr.get(i).getAsJsonObject();

					habitacion = new HabitacionBean();
					habitacion.setTipo(json.get("tipo").getAsString());
					habitacion.setTarifa(json.get("precio").getAsDouble() * numero_dias);
					habitacion.setId(i);
					if (!hoteles.containsKey(json.get("id").getAsInt())) {
						hotel = new HotelBean();
						hotel.setNombre(json.get("nombre").getAsString());
						hotel.setCiudad(json.get("ubicacion").getAsString());
						hotel.setId(json.get("id").getAsInt());
						// Añado el hotel a la lista de hoteles si este no había aparecido antes.
						hoteles.put(json.get("id").getAsInt(), hotelesDisponibles.getHoteles().size());
						
						hotelesDisponibles.getHoteles().add(hotel);
						
					} 
					else { // Obtengo el hotel que ya existe para añadirle una habitación
						hotel = hotelesDisponibles.getHoteles()
								.get(hoteles.get(json.get("id").getAsInt()));
					}

					hotel.getHabitaciones().add(habitacion);
				}
			//}

			model.addAttribute("hotelesDisponiblesBean", hotelesDisponibles);
		}		
		
		// Para que siga mostrando las opciones de Ciudades y hoteles
		// después de una búsqueda, necesito hacer esto.
		this.busquedaBean.setCiudad(busquedaBean.getCiudad());
		this.busquedaBean.setFechaFin(busquedaBean.getFechaFin());
		this.busquedaBean.setHotel(busquedaBean.getHotel());
		this.busquedaBean.setHotel_id(busquedaBean.getHotel_id());
		this.busquedaBean.setFechaInicio(busquedaBean.getFechaInicio());
		model.addAttribute("busquedaBean", this.busquedaBean);
		model.addAttribute("sesionBean", sesionBean);
		
		return "buscador";
	}
	
	@PostMapping("/reservar")
	public String reservarPost(@Valid @ModelAttribute("habitacionId") int habitacionId,
			@Valid @ModelAttribute("comidas") String comidas,
			Model model) throws Exception{
		
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
		
		crearReserva = new JsonObject();
		crearReserva.addProperty("fecha_inicio", busquedaBean.getFechaInicio());
		crearReserva.addProperty("fecha_fin", busquedaBean.getFechaFin());
		boolean encontrado = false;
		for (HotelBean hotel: hotelesDisponibles.getHoteles()) {
			for (HabitacionBean habitacion: hotel.getHabitaciones()) {
				if (habitacion.getId() == habitacionId) {
					crearReserva.addProperty("tipo", habitacion.getTipo());
					crearReserva.addProperty("precio", habitacion.getTarifa());
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
	}	
}
