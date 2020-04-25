package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Objetillos.ReservaGE2;
import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ReservaHotel;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.Beans.SignupBean;
import ingsoft1920.ge.HttpClient.HttpClient;


@Controller
public class datosController {
	public static int ALFONSO;
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	@Autowired 
	ReservaHotel reserva;
	MostrarServiciosPostReservaBean servicios;
	HotelBean hotel;
	HabitacionBean habitacion;
	
	
	@GetMapping("/datos")
	public String opcionesAutentificacion(Model model) throws Exception {
		
		JsonArray arrayGrande = new JsonArray();

		String response = arrayGrande.toString();

		HttpClient serverCiudades = new HttpClient(HttpClient.urlCM+"hotel/ge", "GET");
		if (serverCiudades.getResponseCode() == 200) {// Si encuentra el servidor
			response = serverCiudades.getResponseBody();
		}

		
/**
 * 
 * 		Type tipo = new TypeToken<List<HotelBean>>(){}.getType();
		hoteles = new Gson().fromJson(response, tipo);

		ciudades = new ArrayList<String>();
		for (HotelBean h: hoteles) {
			if (!ciudades.contains(h.getCiudad()))
				ciudades.add(h.getCiudad());
		}
		
		System.out.println(ciudades.get(0));
		
		JsonObject json = new JsonObject();
		json.addProperty("id_usuario", sesionBean.getUsuarioID()); // coger id_usuario de SesionBean 

		
		JsonArray obj = (JsonArray) JsonParser.parseString(response);
		
		JsonArray jarr = new JsonArray();
		JsonObject jobj = new JsonObject();
		jobj.addProperty("hotel_id", reserva.getHotel_id());
		jobj.addProperty("tipo_hab_id", reserva.getHabitacion_id());
		jobj.addProperty("fecha_inicio", reserva.getFecha_inicio());
		jobj.addProperty("fecha_fin", reserva.getFecha_fin());
		jobj.addProperty("tarifa", reserva.getTarifa());
		jobj.addProperty("regimen_comidas", reserva.getRegimen_comidas());
		jarr.add(jobj);
		
		System.out.print(reserva.getHotel_id());
		System.out.print(reserva.getTarifa());
		System.out.print(reserva.getFecha_fin());
		**/
		/**
		JsonArray obj = (JsonArray) JsonParser.parseString(response);	
		
		List<ReservaGE2> reserva= new LinkedList<>();
		for (int i=0;i<obj.size();i++) {
			reserva.add(new ReservaGE2(obj.get(i).getAsJsonObject().get("reserva_id").getAsInt(), 
					obj.get(i).getAsJsonObject().get("hotel_id").getAsInt(),
					obj.get(i).getAsJsonObject().get("tipo_hab_id").getAsInt(),
					obj.get(i).getAsJsonObject().get("importe").getAsInt(),
					obj.get(i).getAsJsonObject().get("regimen").getAsString(),
					obj.get(i).getAsJsonObject().get("fecha_entrada").getAsString(),
					obj.get(i).getAsJsonObject().get("fecha_salida").getAsString()));
		}


		model.addAttribute("servicios", servicios);
		
		
		model.addAttribute("ciudades", ciudades);
		model.addAttribute("hoteles", hoteles);
		model.addAttribute("busquedaBean",busquedaBean);
		
**/
		
		System.out.print(habitacion.getNombre());
		System.out.print(hotel.getNombre());
		System.out.print(reserva.getFecha_fin());
		
		
	
		model.addAttribute("habitacion", habitacion);
		
		model.addAttribute("hotel", hotel);
		
		model.addAttribute("servicios", servicios);
		
		model.addAttribute("reservas", reserva);

		model.addAttribute("sesionBean", sesionBean);

		
		return "datos";
		
		

	}
	
	public void reservaHabitacion () throws Exception {
		/*
		 * Se envía la reserva 
		 * 
		 * {
 		 *		"fecha_entrada" : “2020-02-10”,
 		 *		"fecha_salida" : “2020-02-15”,
 		 *		"importe" : 400,
 		 *		"regimen" : “no_aplica”, // Valores posibles:"no_aplica","media_pension","pension_completa","todo_incluido"
 		 *		"cliente_id" : 14,
 		 *		"hotel_id" : 11,
 		 *		"tipo_hab_id" : 9,
 		 *		"numero_acompanantes" : 21
		 * }
		 */
		
		JsonObject json_reserva = new JsonObject();
		json_reserva.addProperty("cliente_id", sesionBean.getUsuarioID());
		json_reserva.addProperty("hotel_id", reserva.getHotel_id());
		json_reserva.addProperty("tipo_hab_id", reserva.getHabitacion_id());
		json_reserva.addProperty("fecha_entrada", reserva.getFecha_inicio());
		json_reserva.addProperty("fecha_salida", reserva.getFecha_fin());
		json_reserva.addProperty("importe", reserva.getTarifa());
		json_reserva.addProperty("regimen", "no_aplica");
		json_reserva.addProperty("numero_acompanantes", 1);
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		JsonObject reserva_id = new Gson().fromJson(response, JsonObject.class);
		
		reserva.resetReserva();
	}
	
	public void reservaServicios (int cliente_id) throws Exception {
		
		/*
		 * Formato de servicios
		 * 
		 * { 
  		 *		"lugar":String 
  		 *		"id_servicioHotel":int
  		 *		"fecha": Date
  		 *		"hora": Time
  		 *		"cliente_id":int
		 * }
		 */
		
		HttpClient server = new HttpClient(HttpClient.urlDHO + "recibirServicio", "POST");
		
		for(MostrarServiciosPostReservaBean s: reserva.getServicios()) {
			
			JsonObject json_reserva = new JsonObject();
			json_reserva.addProperty("lugar", s.getTipoServicio());
			json_reserva.addProperty("id_servicioHotel", s.getId());
			json_reserva.addProperty("fecha", s.getFecha());
			json_reserva.addProperty("hora", s.getHora());
			json_reserva.addProperty("cliente_id", cliente_id);

			server.setRequestBody(json_reserva.toString());
			server.getResponseCode();
		}


	}	



	@GetMapping("/reservaLogin")
	public String loginGet(Model model) throws Exception{

		LoginBean loginBean = new LoginBean(); 
		loginBean.setMethod("reservaLogin");
		model.addAttribute("loginBean", loginBean);
		model.addAttribute("mensajeError", "");

		return "login"; 
	}
	
	@PostMapping("/reservaLogin")
	public String loginPost(@Valid @ModelAttribute("loginBean") LoginBean loginBean, Model model) throws Exception {

		String resultado = "";
		if (loginBean.checkCamposValidos()) {
			logger.info("Peticion de Log In recibida correctamente y con campos validos");

			JsonObject objetoJson = new JsonObject();
			objetoJson.addProperty("email", loginBean.getEmail());
			objetoJson.addProperty("password", loginBean.getPassword());
			String response = "";
			
			//Mandar usuario registrado correctamente a la base de datos
			HttpClient server = new HttpClient(HttpClient.urlCM + "cliente/login", "POST");
			server.setRequestBody(objetoJson.toString());
			if (server.getResponseCode() == 200) {//Conectado con el servidor
				response = server.getResponseBody();
				objetoJson = new Gson().fromJson(response, JsonObject.class);
				System.out.print("AQUIIIIIIIIIIII"+objetoJson.toString());
				int id = objetoJson.get("id").getAsInt();
				
				ALFONSO=id;
				if (id == -1) { //Usuario no registrado. Mandamos de vuelta a la página de login
					model.addAttribute("loginBean", loginBean);
					model.addAttribute("mensajeError","El usuario no existe");
					resultado = "login";
				} else { //Usuario existente y login exitoso
					loginBean.setId(id);
					
					sesionBean.setUsuarioID(id);
					sesionBean.setUsuario(loginBean.getEmail().split("@")[0]);
					
					
					reservaHabitacion();
					reservaServicios(sesionBean.getUsuarioID());
					reserva.resetReserva();
					resultado = "redirect:misReservas";
				}
			} else { //Conexión con el servidor fallida
				model.addAttribute("login", loginBean);
				model.addAttribute("mensajeError","Conexión con el servidor fallida");
				resultado = "login";
			} 
		} else { //Datos mal introducidos al hacer el login 
			model.addAttribute("loginBean", loginBean);
			model.addAttribute("mensajeError", "Datos incorrectos");

			resultado = "login";
		}
		return resultado;
	}
	
	public static int getALFONSO() {
		return ALFONSO;
	}

	public static void setALFONSO(int aLFONSO) {
		ALFONSO = aLFONSO;
	}

	@GetMapping("/reservaSignup")
	public String signupGet(Model model) {

		SignupBean signupBean = new SignupBean(); // Creamos una bean de signup con sus respectivos atributos.
		signupBean.setMethod("reservaSignup");
		model.addAttribute("signupBean", signupBean); // Añadimos el bean creado al modelo
		model.addAttribute("mensajeError", "");
		return "signup"; // Vista que debemos ver signup.jsp
	}

	@PostMapping("/reservaSignup")
	public String signupPost(@Valid @ModelAttribute("signupBean") SignupBean signupBean, Model model) throws Exception {

		String resultado = "";
		if (signupBean.checkCamposValidos()) {

			logger.info("Peticion de Signup recibida correctamente y con campos validos");

			JsonObject objetoJson = new JsonObject();
			objetoJson.addProperty("nombre", signupBean.getNombre());
			objetoJson.addProperty("apellidos", signupBean.getApellidos());
			objetoJson.addProperty("DNI", signupBean.getDNI());
			objetoJson.addProperty("email", signupBean.getEmail());
			objetoJson.addProperty("telefono", signupBean.getTelefono());
			objetoJson.addProperty("nacionalidad", signupBean.getNacionalidad());
			objetoJson.addProperty("password", signupBean.getPassword());
			String response = "";

			// Mandar usuario registrado correctamente a la base de datos

			HttpClient server = new HttpClient(HttpClient.urlCM + "cliente", "POST");
			server.setRequestBody(objetoJson.toString());
			if (server.getResponseCode() == 200) { //Conexión con el servidor exitosa
				response = server.getResponseBody();
				objetoJson = new Gson().fromJson(response, JsonObject.class);
				int id = objetoJson.get("id").getAsInt();

				if (id == -1) {
					/*
					 * Usuario ya existe y no queremos volver a registar. Mandamos de vuelta a la
					 * página registrar No sabemos cual es el id de usuario erroneo por tanto
					 * hacemos código temporal.
					 */
					model.addAttribute("signup", signupBean);
					model.addAttribute("mensajeError", "Usuario existente");
					resultado = "signup";
				} else { //Usuario registrado correctamente
					signupBean.setId(id);
					sesionBean.setUsuarioID(id);
					sesionBean.setUsuario(signupBean.getEmail().split("@")[0]);
					
					reservaHabitacion();
					reservaServicios(sesionBean.getUsuarioID());
					reserva.resetReserva();
					resultado = "redirect:misReservas";
				}
			} else { //Conexión con el servidor fallida
				model.addAttribute("signup", signupBean);
				model.addAttribute("mensajeError", "Conexión con el servidor fallida");
				resultado = "signup";
			}

		} else { //Datos introducidos por el cliente incorrectos
			System.out.print(signupBean.checkCamposValidos());
			model.addAttribute("signupBean", signupBean);
			model.addAttribute("mensajeError", "Datos incorrectos");

			resultado = "signup";
		}
		return resultado;
	}
	
	@PostMapping("/reservaAnonima")
	public String reservaAnonima(Model model, 
			@Valid @ModelAttribute("email") String email) throws Exception {
		
		/*
		 * Se envía la resrva anónima
		 * 
		 * {
 		 *		"fecha_entrada" : “2020-02-10”,
 		 *		"fecha_salida" : “2020-02-15”,
 		 *		"importe" : 400,
 		 *		"regimen" : “no_aplica”, // Valores posibles:"no_aplica","media_pension","pension_completa","todo_incluido"
 		 *		"email_cliente" : "juan@gmail.com",
 		 *		"hotel_id" : 11,
 		 *		"tipo_hab_id" : 9,
 		 *		"numero_acompanantes" : 21
		 * }
		 */
		
		JsonObject json_reserva = new JsonObject();
		json_reserva.addProperty("email_cliente", email);
		json_reserva.addProperty("hotel_id", reserva.getHotel_id());
		json_reserva.addProperty("tipo_hab_id", reserva.getHabitacion_id());
		json_reserva.addProperty("fecha_entrada", reserva.getFecha_inicio());
		json_reserva.addProperty("fecha_salida", reserva.getFecha_fin());
		json_reserva.addProperty("importe", reserva.getTarifa());
		json_reserva.addProperty("regimen", reserva.regimen());
		json_reserva.addProperty("numero_acompanantes", 1);
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM + "reserva/anonima", "POST");
		server.setRequestBody(json_reserva.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		JsonObject reserva_cliente = new Gson().fromJson(response, JsonObject.class);
		
		reservaServicios(reserva_cliente.get("cliente_id").getAsInt());
		int alfonso = reserva_cliente.get("cliente_id").getAsInt();
		System.out.println(alfonso);
		ALFONSO=alfonso;
		reserva.resetReserva();
		
		return "redirect:";
	}
}