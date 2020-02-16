package ingsoft1920.ge.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.catalina.mbeans.ServiceMBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.ReservaBean;

public class ReservaController {

	@Autowired
	ReservaBean reservaBean;

	@GetMapping("/reservar")
	public String buscarGet(Model model) {

		ReservaBean reservaBean = new ReservaBean();
		model.addAttribute("reservaBean", reservaBean);
		model.addAttribute("mensajeError", "");

		return "reserva";
	}


}
