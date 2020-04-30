package ingsoft1920.ge.ControllerGE1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.Beans.SesionBean;

@Controller
public class Routing {
	@Autowired
	SesionBean sesion;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("sesionBean", sesion);
		return "index";
	}
	
	
	@GetMapping("/cabecera")
	public String cabecera() {
		return "cabecera";
	}
	
	
	@GetMapping("/reservas")
	public String reservas() {

		return "reservaServicios";
	}
	
	@GetMapping("/servicios")
	public String servicios() {

		return "servicios";
	}
}
