package ingsoft1920.ge.ControllerGE1;

import java.util.ArrayList;
import java.util.List;
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
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class IncidenciasController {

	final static Logger logger = LogManager.getLogger(ge_Controller.class.getName());}
/*
	@GetMapping("/signup")
	public String signupGet(Model model) {
		IncidenciasBean incidenciasBean = new IncidenciasBean();
		//model.addAttribute("signupBean", incidenciasBean);
		//model.addAttribute("mensajeError","");
		return "incidencias";
	}

	@PostMapping("/signup")
	public String signupPost(@Valid @ModelAttribute("incidenciasBean") IncidenciasBean bean,
			Model model) {
		if(bean.checkCamposValidos()) {
			logger.info("Peticion de enviar incidencia recibida correctamente y con campos validos");

		}
		
		return "prueba";
	}
}
*/