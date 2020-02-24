package ingsoft1920.ge.Controller;

import java.util.ArrayList;
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

import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.HotelesDisponiblesBean;
import ingsoft1920.ge.Beans.LoginBean;
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
	
	JsonObject crearReserva;

	@GetMapping("/buscador")
	public String buscarGet(Model model) throws Exception {

		if (busquedaBean.getCiudades().size() == 0) {
			/*
			 * Formato Json recibido:
			 * {
			 * 		"ciudades": ["Guadalajara", "Madrid", "Zaragoza", "Valencia"]
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
			
			JsonArray ciudades = (JsonArray) obj.get("ciudades");

			for (int i = 0; i < ciudades.size(); i++) {
				busquedaBean.getCiudades().add(ciudades.get(i).getAsString());
			}
			/*
			 * Formato Json recibido:
			 * [
			 * 		{
			 * 			"nombre": "Rich",
			 * 			"ubicacion": "Madrid",
			 * 			"hotel_id": "1"
			 * 		},
			 * 		{
			 * 			"nombre": "Paquito",
			 * 			"ubicacion": "Zaragoza",
			 * 			"hotel_id": "2"
			 * 		},
			 * 		{
			 * 			"nombre": "Medici",
			 * 			"ubicacion": "Valencia",
			 * 			"hotel_id": "3"
			 * 		},
			 * 		{
			 * 			"nombre": "Corporate",
			 * 			"ubicacion": "Guadalajara",
			 * 			"hotel_id": "4"
			 * 		},
			 * 		
			 * ]
			 */
			
			// Creamos los ejemplos.
			arr = new JsonArray();
			obj = new JsonObject();
			obj.addProperty("nombre", "Rich");
			obj.addProperty("ubicacion", "Madrid");
			obj.addProperty("hotel_id", "1");
			arr.add(obj);
			obj = new JsonObject();
			obj.addProperty("nombre", "Paquito");
			obj.addProperty("ubicacion", "Zaragoza");
			obj.addProperty("hotel_id", "2");
			arr.add(obj);
			obj = new JsonObject();
			obj.addProperty("nombre", "Medici");
			obj.addProperty("ubicacion", "Valencia");
			obj.addProperty("hotel_id", "3");
			arr.add(obj);
			obj = new JsonObject();
			obj.addProperty("nombre", "Corporate");
			obj.addProperty("ubicacion", "Guadalajara");
			obj.addProperty("hotel_id", "4");
			arr.add(obj);
			obj = new JsonObject();
			
			JsonArray hoteles = arr.getAsJsonArray();

			for (int i = 0; i < hoteles.size(); i++) {
				JsonObject hotel = hoteles.get(i).getAsJsonObject();
				busquedaBean.getHoteles().add(hotel.get("nombre").getAsString());
				busquedaBean.getIds().put(hotel.get("nombre").getAsString(), hotel.get("hotel_id").getAsInt());
			}
			
			// El siguiente código debería consultar a CM de forma correcta
			/*
			String response = "";
			JsonObject obj;
			HttpClient serverCiudades = new HttpClient(HttpClient.urlCM+"ciudades", "GET");
			if (serverCiudades.getResponseCode() != 404) {// Si encuentra el servidor
				response = serverCiudades.getResponseBody();
				obj = new Gson().fromJson(response, JsonObject.class);

				JsonArray ciudades = (JsonArray) obj.get("ciudades");

				for (int i = 0; i < ciudades.size(); i++) {
					busquedaBean.getCiudades().add(ciudades.get(i).getAsString());
				}
			}
			
			JsonArray hoteles;
			HttpClient serverHoteles = new HttpClient(HttpClient.urlCM+"hoteles", "GET");
			if (serverHoteles.getResponseCode() != 404) {// Si encuentra el servidor
				response = serverHoteles.getResponseBody();
				
				hoteles = new Gson().fromJson(response, JsonArray.class);

				for (int i = 0; i < hoteles.size(); i++) {
					JsonObject hotel = hoteles.get(i).getAsJsonObject();
					busquedaBean.getHoteles().add(hotel.get("nombre").getAsString());
					busquedaBean.getIds().put(hotel.get("nombre").getAsString(), hotel.get("hotel_id").getAsInt());
				}
			}
			*/

		}
		model.addAttribute("busquedaBean",busquedaBean);

		return "buscador";
	}

	@PostMapping("/buscador")
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
			String response = "";
			
			hotelesDisponibles = new HotelesDisponiblesBean();
			/*
			HttpClient server = new HttpClient(HttpClient.urlCM+"precioDisponible", "GET");
			// Añado los datos de la consulta
			server.setRequestBody(obj.toString());
			
			if (server.getResponseCode() != 404) {// Si encuentra el servidor
				response = server.getResponseBody();
			*/ 
				JsonArray arr = new JsonArray();
				JsonObject json = new JsonObject();
				
				json.addProperty("nombre", "Rich");
				json.addProperty("hotel_id", "1");
				json.addProperty("ubicacion", "Madrid");
				json.addProperty("tipo", "lujo");
				json.addProperty("precio", 1000000);
				arr.add(json);
				json = new JsonObject();
				json.addProperty("nombre", "Medici");
				json.addProperty("hotel_id", "3");
				json.addProperty("ubicacion", "Valencia");
				json.addProperty("tipo", "lujo");
				json.addProperty("precio", 1000000);
				arr.add(json);
				
				int numero_dias = busquedaBean.getNumeroDias();
				
				Map<String, Integer> hoteles = new HashMap<String, Integer>();
				HotelBean hotel; HabitacionBean habitacion;
				//JsonObject json;
				for (int i = 0; i < arr.size(); i++) {
					json = arr.get(i).getAsJsonObject();

					if (!hoteles.containsKey(json.get("nombre").getAsString())) {
						hotel = new HotelBean();
						hotel.setNombre(json.get("nombre").getAsString());
						hotel.setCiudad(json.get("ubicacion").getAsString());
						hotel.setHotel_id(json.get("hotel_id").getAsInt());
						// Añado el hotel a la lista de hoteles si este no había aparecido antes.
						hoteles.put(json.get("nombre").getAsString(), hotelesDisponibles.getHoteles().size()-1);
					} 
					else { // Obtengo el hotel que ya existe para añadirle una habitación
						hotel = hotelesDisponibles.getHoteles()
								.get(hoteles.get(json.get("nombre").getAsString()));
					}
					
					habitacion = new HabitacionBean();
					habitacion.setTipo(json.get("tipo").getAsString());
					habitacion.setTarifa(json.get("precio").getAsDouble() * numero_dias);
					habitacion.setId(i);
					hotel.getHabitaciones().add(habitacion);
					
					hotelesDisponibles.getHoteles().add(hotel);
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
					crearReserva.addProperty("hotel_id", hotel.getHotel_id());
					encontrado = true;
					break;
				}
			}
			if (encontrado) break;
		}
		
		if (sesionBean.getUsuarioID() == -1) {
			LoginBean login = new LoginBean();
			login.setMethod("loginReservar");
			model.addAttribute(login);
			return "login";
		}

		crearReserva.addProperty("cliente_id", sesionBean.getUsuarioID());
		/*
		HttpClient server = new HttpClient(HttpClient.urlCM+"crearReserva", "GET");
		// Añado los datos de la consulta
		server.setRequestBody(crearReserva.toString());
		
		if (server.getResponseCode() == 404) {// Si encuentra el servidor
			model.addAttribute("mensajeError", "La reserva no se ha podido realizar correctamente");
			return "buscador";
		}*/
		
		return "redirect:misReservas";
	}
	
	@PostMapping("/loginReservar")
	public String loginPost(@Valid @ModelAttribute("loginBean") LoginBean loginBean,
			Model model) throws Exception{

		if(loginBean.checkCamposValidos()) {
			logger.info("Peticion de Log In recibida correctamente y con campos validos");
			
			// Se comprueba que el usuario existe y que la contraseña es correcta.
			JsonObject obj = new JsonObject();
			obj.addProperty("email", loginBean.getUsuario());
			obj.addProperty("password", loginBean.getPassword());
			String response = "";
			
			/*
			HttpClient server = new HttpClient(HttpClient.urlCM+"login", "GET");
			server.setRequestBody(obj.getAsString());
			if (server.getResponseCode() != 404) {// Si encuentra el servidor
				response = server.getResponseBody();
				obj = new Gson().fromJson(response, JsonObject.class);
				int id = obj.get("id_cliente").getAsInt();
				
				if (id == -1) {
					
					model.addAttribute("loginBean", loginBean);
					model.addAttribute("mensajeError","El usuario no existe");
					
					return "login";
				}
				else {
					loginBean.setId(id);
					
					// Guarda el email del usuario en el sesion bean
					sesionBean = new SesionBean(new UsuarioModel(loginBean));
					
					return "redirect:buscador";
				}
			}
			*/
			// Pruebas de SessionScope sin conexión al servidor
			loginBean.setId(1);

			// Guarda el email del usuario en el sesion bean
			sesionBean.setUsuarioID(1);

			crearReserva.addProperty("cliente_id", sesionBean.getUsuarioID());
			/*
			HttpClient server = new HttpClient(HttpClient.urlCM+"crearReserva", "GET");
			// Añado los datos de la consulta
			server.setRequestBody(crearReserva.toString());
			
			if (server.getResponseCode() == 404) {// Si encuentra el servidor
				model.addAttribute("mensajeError", "La reserva no se ha podido realizar correctamente");
				return "buscador";
			}
			*/
			return "redirect:misReservas";
		}
		
		model.addAttribute("loginBean", loginBean);
		model.addAttribute("mensajeError","Email o password no existe");
		
		return "login";
	}
	
}
