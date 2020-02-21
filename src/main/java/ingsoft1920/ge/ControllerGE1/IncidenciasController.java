package ingsoft1920.ge.ControllerGE1;

import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.ge.BeansGE1.CheckInBean;
import ingsoft1920.ge.BeansGE1.IncidenciasBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class IncidenciasController {

	final static Logger logger = LogManager.getLogger(ge_Controller.class.getName());


	@Autowired
	IncidenciasBean incidenciasBean;

	@GetMapping("/incidencias")
	public String Incidencias(Model model) {
		return "incidencias";
	}

	
	@GetMapping("/procesarIncidencias")
	public String procesarIncidencias(Model model) {
		return "procesarIncidencias";
	}
	
/*
	@PostMapping("/procesarIncidencias")
	public String procesarIncidencias(@Valid @ModelAttribute("incidenciasBean") IncidenciasBean IncidenciasBean,
			Model model) throws Exception {

		//Si los campos no estan vacios
		if(IncidenciasBean.checkCamposValidos()) {
			logger.info("Peticion de enviar incidencia recibida correctamente y con campos validos");

			HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/...", "POST");
			client.setRequestBody("");
			int respCode = client.getResponseCode();
			if(respCode==200) {
				client.getResponseBody();
			}
			return "procesarIncidencias";

		}

		else
			return "incidencias";

	}  */
}