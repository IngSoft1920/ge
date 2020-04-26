package ingsoft1920.ge.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MetodoPagoController {

	final static Logger logger = LogManager.getLogger(MetodoPagoController.class.getName());
	
	
	
	@GetMapping("/reservar/metodopago")
	public String metodopago(Model model) {
		
		
		return "metodopago";
	}

}
