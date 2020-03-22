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
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;
import ingsoft1920.ge.Model.UsuarioModel;

/*
 *Con esta anotacion establecemos que esta clase es un controlador. 
 *El controlador de la vista login
 */
@Controller
public class LoginController {
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	/*
	 * El GetMapping se encarga de pedir los recursos al servidor al buscar 
	 * localhost:port/login
	 * MVC (Modelo-Vista-Controlador)
	 * El Modelo representa un objeto Java que transporta datos.
	 * La Vista visualiza los datos que contiene el Modelo (página signup.jsp escrita en html, ...)
	 * El Controlador gestiona el flujo de datos en el objeto Modelo y activa la Vista cada vez que cambian los datos.
	 * Recibe como parámetro un Model (encargado de agregar atributos)
	 */

	@GetMapping("/login")
	public String loginGet(Model model) {

		LoginBean loginBean = new LoginBean(); //Creamos una bean de login con sus respectivos atributos.
		model.addAttribute("loginBean", loginBean); //Añadimos el bean creado al modelo
		model.addAttribute("mensajeError", "");

		return "login"; //Vista que debemos ver login.jsp
	}
	
	/*
	 * HttpClient server = new HttpClient(HttpClient.urlCM+"login", "GET");
	 * server.setRequestBody(obj.getAsString()); if (server.getResponseCode() !=
	 * 404) {// Si encuentra el servidor response = server.getResponseBody(); obj =
	 * new Gson().fromJson(response, JsonObject.class); int id =
	 * obj.get("id_cliente").getAsInt();
	 * 
	 * if (id == -1) {
	 * 
	 * model.addAttribute("loginBean", loginBean);
	 * model.addAttribute("mensajeError","El usuario no existe");
	 * 
	 * return "login"; } else { loginBean.setId(id);
	 * 
	 * // Guarda el email del usuario en el sesion bean sesionBean = new
	 * SesionBean(new UsuarioModel(loginBean));
	 * 
	 * return "redirect:buscador"; } }
	 */

	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute("loginBean") LoginBean loginBean, Model model) throws Exception {

		if (loginBean.checkCamposValidos()) {
			logger.info("Peticion de Log In recibida correctamente y con campos validos");

			JsonObject obj = new JsonObject();
			obj.addProperty("email", loginBean.getUsuario());
			obj.addProperty("password", loginBean.getPassword());
			String response = "";

			// Pruebas de SessionScope sin conexión al servidor
			loginBean.setId(1);

			/*
			 * Guarda el email del usuario en el sesion bean sesionBean = new SesionBean(new
			 * UsuarioModel(loginBean));
			 */
			sesionBean.setUsuarioID(1);
			sesionBean.setUsuario(loginBean.getUsuario().split("@")[0]);

			return "redirect:";
		} else {
		
			model.addAttribute("loginBean", loginBean);
			model.addAttribute("mensajeError", "Email o password no existe");
		}

		return "login";
	}
}
