package ingsoft1920.ge.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.ReservaBean;


@Controller
public class MisReservasController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@GetMapping("/reservas")
	public String buscarGet(Model model) {
		
		// Consulta a la base de datos
		MisReservasBean misReservasPendientes = new MisReservasBean();
		misReservasPendientes.getReservas().add(new ReservaBean("Hotel 1", "Zaragoza", "28/4/2020", "30/4/2020", "Suit", "300.0", ""));
		
		MisReservasBean misReservasPasadas = new MisReservasBean();
		misReservasPasadas.getReservas().add(new ReservaBean("Hotel 2", "Madrid", "12/1/2020", "14/1/2020", "Suit", "300.0", ""));
		
		
		model.addAttribute("misReservasPendientes", misReservasPendientes);
		model.addAttribute("misReservasPasadas", misReservasPasadas);
		model.addAttribute("mensajeError","");
		
		return "reserva";
	}
	
	@PostMapping("/reservar")
	public String buscarPost(@Valid @ModelAttribute("misReservasBean") MisReservasBean misReservasBean,
			Model model) {
		
		return "reserva";
	}
}
