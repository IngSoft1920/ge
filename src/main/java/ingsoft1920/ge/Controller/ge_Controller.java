package ingsoft1920.ge.Controller;

import org.apache.logging.log4j.LogManager;



import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.Model.UsuarioModel;


@Controller
public class ge_Controller {
	
	final static Logger logger = LogManager.getLogger(ge_Controller.class.getName());
	
	@Autowired
	SesionBean sesionBean;
	
	
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	@GetMapping("/reservas")
	public String reservas(Model model) {
		return "reservas";
	}
	
	@GetMapping("/servicios")
	public String servicios(Model model) {
		
		UsuarioModel usuario= new UsuarioModel();
		model.addAttribute("Usuario", usuario);
		model.addAttribute("MensajeError", "Usuario invalido?");
		return "servicios";
	}	
	
	@GetMapping("/incidencias")
	public String incidencias() {
		return "incidencias";
	}
}
