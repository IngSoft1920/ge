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

import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.Beans.SignupBean;

/*
 *Con esta anotacion establecemos que esta clase es un controlador. 
 *El controlador de la vista signup
 */
@Controller
public class SignupController {
	
	final static Logger logger = LogManager.getLogger(SignupController.class.getName());

	@Autowired
	SesionBean sesionBean;

	/*
	 * El GetMapping se encarga de pedir los recursos al servidor al buscar 
	 * localhost:port/signup
	 * MVC (Modelo-Vista-Controlador)
	 * El Modelo representa un objeto Java que transporta datos.
	 * La Vista visualiza los datos que contiene el Modelo (página signup.jsp escrita en html, ...)
	 * El Controlador gestiona el flujo de datos en el objeto Modelo y activa la Vista cada vez que cambian los datos.
	 * Recibe como parámetro un Model (encargado de agregar atributos)
	 */
	@GetMapping("/signup")
	public String signupGet(Model model) {

		SignupBean signupBean = new SignupBean(); //Creamos una bean de signup con sus respectivos atributos.
		model.addAttribute("signupBean", signupBean); //Añadimos el bean creado al modelo
		model.addAttribute("mensajeError", "");
		return "signup"; //Vista que debemos ver signup.jsp
	}

	/*
	 * La clase UsuarioModel representa el modelo de datos que vamos a manejar en la aplicacion. 
	 * UsuarioModel usuarioModel = new UsuarioModel(signupBean);
	 */
	
	
	/*
	 * La clase UsuarioDAO es el "punto de conexion" entre nuestro modelo de datos
	 * (UsuarioModel) y la base de datos con sus tablas correspondientes.
	 *  Será la encargada de "traducir" peticiones en forma de metodos Java en SELECT,
	 * INSERT, UPDATE, DELETE... de la base de datos. Por lo tanto, en las clases
	 * DAO reside TODA la logica de base de datos, y no puede haber ninguna consulta
	 * SQL fuera de dichas clases.
	 * UsuarioModel respuesta = UsuarioDAO.signup(usuarioModel); 
	 * if(respuesta != null) { Puedo publicar un objeto, y dentro del jsp acceder a sus propiedades.
	 * 			SesionBean sesionBean = new SesionBean(respuesta); 
	 * 			model.addAttribute(sesionBean);
	 */
	
	
	/*
	 * Tambien puedo publicar listas, e iterar por ellas en el jsp 
	 * List<String> listaStrings = new ArrayList<String>(); 
	 * listaStrings.add("string1");
	 * listaStrings.add("string2"); 
	 * listaStrings.add("string3");
	 * model.addAttribute("listaStrings",listaStrings);
	 */
	
	
	/*
	 * Devolvemos el nombre de la vista que corresponde (welcome.jsp)
	 * 
	 * return "buscador"; 
	 * 
	 * }else { 
	 * 
	 * 		model.addAttribute("signupBean",signupBean);
	 * 
	 * Esta linea publica el String "Usuario ya existe!" con el nombre mensajeError en el model respuesta
	 * 
	 * 		model.addAttribute("mensajeError","Usuario ya existe!"); 
	 * 
	 * return "signup"; }
	 */
	
	@PostMapping("/signup")
	public String signupPost(@Valid @ModelAttribute("signupBean") SignupBean signupBean, Model model) {

		String resultado;
		if (signupBean.checkCamposValidos()) {

			logger.info("Peticion de Signup recibida correctamente y con campos validos");

			JsonObject obj = new JsonObject();
			obj.addProperty("email", signupBean.getEmail());
			obj.addProperty("password", signupBean.getPassword());
			obj.addProperty("dni", signupBean.getDni());
			obj.addProperty("nombre", signupBean.getNombre());
			obj.addProperty("apellidos", signupBean.getApellidos());
			String response = "";

			signupBean.setId(1);

			sesionBean.setUsuarioID(1);
			sesionBean.setUsuario(signupBean.getUsuario().split("@")[0]);
			

			resultado = "redirect:home";
		} else {
			model.addAttribute("signupBean", signupBean);
			model.addAttribute("mensajeError", "Datos incorrectos");

			resultado = "signup";
		}

		return resultado;

	}
}
