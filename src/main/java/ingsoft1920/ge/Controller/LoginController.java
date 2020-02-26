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

@Controller
public class LoginController {
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@Autowired
	SesionBean sesionBean;

	@GetMapping("/login")
	public String loginGet(Model model) {

		LoginBean loginBean = new LoginBean();
		model.addAttribute("loginBean", loginBean);
		model.addAttribute("mensajeError", "");

		return "login";
	}

	@PostMapping("/login")
	public String loginPost(@Valid @ModelAttribute("loginBean") LoginBean loginBean, Model model) throws Exception {

		if (loginBean.checkCamposValidos()) {
			logger.info("Peticion de Log In recibida correctamente y con campos validos");

			// Se comprueba que el usuario existe y que la contraseña es correcta.
			JsonObject obj = new JsonObject();
			obj.addProperty("email", loginBean.getUsuario());
			obj.addProperty("password", loginBean.getPassword());
			String response = "";

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
			// Pruebas de SessionScope sin conexión al servidor
			loginBean.setId(1);

			// Guarda el email del usuario en el sesion bean
			// sesionBean = new SesionBean(new UsuarioModel(loginBean));
			sesionBean.setUsuarioID(1);
			sesionBean.setUsuario(loginBean.getUsuario().split("@")[0]);

			return "redirect:home";
		}

		model.addAttribute("loginBean", loginBean);
		model.addAttribute("mensajeError", "Email o password no existe");

		return "login";
	}
}
