package ingsoft1920.ge.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.Beans.SesionBean;


@Controller
public class datosController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	@GetMapping("/datos")
	public String buscarGet(Model model) {

		return "datos";

	}
}