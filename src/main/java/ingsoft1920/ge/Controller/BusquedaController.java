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

import ingsoft1920.ge.Beans.BusquedaBean;


@Controller
public class BusquedaController {
	final static Logger logger = LogManager.getLogger(BusquedaController.class.getName());

	@GetMapping("/buscar")
	public String buscarGet(Model model) {
		
		BusquedaBean busquedaBean = new BusquedaBean();
		model.addAttribute("busquedaBean",busquedaBean);
		model.addAttribute("mensajeError","");
		
		return "buscador";
	}
	
	@PostMapping("/buscar2")
	public String buscarPost(@Valid @ModelAttribute("busquedaBean") BusquedaBean busquedaBean,
			Model model) {
		
		if(busquedaBean.checkCamposValidos()) {
			logger.info("Busqueda recibida correctamente");
			
			/*
			//La clase UsuarioModel representa el modelo de datos que vamos a manejar en la aplicacion
			UsuarioModel usuarioModel = new UsuarioModel(signupBean);
			
			//La clase UsuarioDAO es el "punto de conexion" entre nuestro modelo de datos (UsuarioModel) y la base de datos
			//con sus tablas correspondientes. Sera la encargada de "traducir" peticiones en forma de metodos Java en
			//SELECT, INSERT, UPDATE, DELETE... de la base de datos. Por lo tanto, en las clases DAO reside TODA la logica 
			//de base de datos, y no puede haber ninguna consulta SQL fuera de dichas clases
			UsuarioModel respuesta = UsuarioDAO.signup(usuarioModel);
			if(respuesta!=null) {
				//Puedo publicar un objeto, y dentro del jsp acceder a sus propiedades
				SesionBean sesionBean = new SesionBean(respuesta);
				model.addAttribute(sesionBean);
				
				//Tambien puedo publicar listas, e iterar por ellas en el jsp
				List<String> listaStrings = new ArrayList<String>();
				listaStrings.add("string1");
				listaStrings.add("string2");
				listaStrings.add("string3");
				model.addAttribute("listaStrings",listaStrings);
				
				//Devolvemos el nombre de la vista que corresponde (welcome.jsp)
				return "welcome";
			}else {
				model.addAttribute("signupBean",signupBean);
				
				//Esta linea publica el String "Usuario ya existe!" con el nombre mensajeError
				//en el model respuesta
				model.addAttribute("mensajeError","Usuario ya existe!");
				return "signup";
			}
			*/
			
		}
		
		
		
		return "buscar";
	}
}
