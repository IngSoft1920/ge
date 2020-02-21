package ingsoft1920.ge.ControllerGE1;

import org.apache.logging.log4j.LogManager;



import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;




@Controller
public class ge_Controller {
	
	final static Logger logger = LogManager.getLogger(ge_Controller.class.getName());
	
	
	
	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	@GetMapping("/reservaServicios")
	public String reservaServicios() {
		return "reservaServicios";
	}
	
	@GetMapping("/servicios")
	public String servicios() {
		
		return "servicios";
	}	
	@GetMapping("/incidencias")
	public String incidencias() {
		
		return "incidencias";
	}
	

	@GetMapping("/procesarIncidencias")
	public String ProcesarIncidencias() {
		return "procesarIncidencias";
	}
	
	@GetMapping("/checkinfalso")
	public String checkin() {
		return "checkin";
	}
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	@GetMapping("/facturacion")
	public String facturacion() {
		return "facturacion";
	}
	
	@GetMapping("/cabecera")
	public String cabecera() {
		return "cabecera";
	}
}
