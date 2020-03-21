package ingsoft1920.ge.ControllerGE1;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.ControllerGE1.VerReservasController;




@Controller
public class Routing {
	
	@GetMapping("/index")
	public String index() {

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
	
	@GetMapping("/incidencias")
	public String incidencias() {

		return "incidencias";
	}

	@GetMapping("/checkin")
	public String checkin() {
		
		
		

		return "incidencias";
	}
	
}
