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

	@GetMapping("/misReservas")
	public String buscarGet(Model model) {

		MisReservasBean misReservasBean = new MisReservasBean();

		ReservaBean reservaBean = new ReservaBean("Rich", "Guadalajara", "10/12/2020", "15/12/2020", "Suit", "300.0",
				"");
		misReservasBean.getReservas().add(reservaBean);

		model.addAttribute("misReservasBean", misReservasBean);
		model.addAttribute("mensajeError", "");

		return "misReservas";

	}

	@PostMapping("/valorar")
	public String misReservasPost(@Valid @ModelAttribute("valoracionId") String valoracionId, Model model) {

		logger.info("Valoración recibida correctamente." + valoracionId);
		return "redirect:misReservas";
	}
}
