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


import ingsoft1920.ge.Beans.MostrarServiciosPostReservaBean;
import ingsoft1920.ge.Beans.ReservaHotel;
import ingsoft1920.ge.Beans.SesionBean;

@Controller
public class ReservaGrupoController {
	final static Logger logger = LogManager.getLogger(ServiciosPostReservaController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	@Autowired 
	ReservaHotel reserva;
	
	@GetMapping("/reservaGrupo")	
	public String reservaGrupoGet(Model model) throws Exception {
		
		return "reservaGrupo";

	}

	@PostMapping("/reservaGrupo")
	public String reservaGrupoPost(@Valid @ModelAttribute("reserva") 
			MostrarServiciosPostReservaBean servicio,
			Model model) throws Exception {
		
		reserva.getServicios().add(servicio);
		
		reserva.setPrecio_total(reserva.getPrecio_total() + servicio.getPrecio());
		
		model.addAttribute("sesionBean", sesionBean);
		return "serviciosExtras";
	}

}
