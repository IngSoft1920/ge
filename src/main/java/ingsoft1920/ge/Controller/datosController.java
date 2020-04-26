package ingsoft1920.ge.Controller;

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
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.LoginBean;
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
	
	
	@GetMapping("/datos")
	public String opcionesAutentificacion(Model model) throws Exception {
		
		model.addAttribute("reserva", reserva);

		model.addAttribute("sesionBean", sesionBean);

		
		return "datos";
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
				
				if (objetoJson.get("id") == null) {
					model.addAttribute("loginBean", loginBean);
					model.addAttribute("mensajeError", objetoJson.get("error").getAsString());
					return "login";
				}
				
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
					
					resultado = "redirect:metodopago";
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
				
				if (objetoJson.get("id") == null) {
					model.addAttribute("signupBean", signupBean);
					model.addAttribute("mensajeError", objetoJson.get("error").getAsString());
					return "signup";
				}
				
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
					
					reserva.setPrecio_total(reserva.getPrecio_total()*0.95);
					
					resultado = "redirect:metodopago";
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
		
		reserva.setCliente(email);
		return "redirect:metodopago";
	}
	
	@PostMapping("/reservaConfirm")
	public String confirmPost() throws Exception {

		return "redirect:metodopago";
	}
}