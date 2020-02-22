package ingsoft1920.ge.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.SesionBean;

@Controller
public class MisReservasController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());
	
	@Autowired
	SesionBean sesionBean;

	@GetMapping("/misReservas")
	public String buscarGet(Model model) {

		MisReservasBean misReservasBean = new MisReservasBean();
		
		ReservaBean reservaBean = new ReservaBean ("Rich", "Guadalajara", "10/12/2020", "15/12/2020", "Suit", "300.0", "");
		misReservasBean.getReservas().add(reservaBean);
		
		model.addAttribute("misReservasBean", misReservasBean);
		model.addAttribute("mensajeError", "");

		return "misReservas";

	}
}
