
package ingsoft1920.ge.Controller;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.ge.Beans.SesionBean;


@Controller
public class CambiarReservasController {

	final static Logger logger = LogManager.getLogger(CambiarReservasController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	
	@GetMapping("/cambiarReservas")
	public String cambiarReservasGet(Model model) throws Exception {
		return "cambiarReservas";
	}

	@PostMapping("/cambiarReservas")
	public String cambiarReservasPost( Model model) throws Exception{
		return null;
		
	}	
	
}

