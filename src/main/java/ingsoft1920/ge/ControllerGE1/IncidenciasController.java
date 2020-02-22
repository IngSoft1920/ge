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

	final static Logger logger = LogManager.getLogger(IncidenciasController.class.getName());


	@Autowired
	IncidenciasBean incidenciasBean;

	@PostMapping("/incidencias")
	public String procesarIncidencias(@Valid @ModelAttribute("incidenciasBean") IncidenciasBean incidenciasBean,
			Model model) throws Exception {
		if(incidenciasBean.checkCamposValidos()) {
			System.out.print(incidenciasBean.toString());
			HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7001/apiUsuarios", "POST");
			
			client.setRequestBody(incidenciasBean.toString());

			int respCode = client.getResponseCode();

			String resp="";
			if(respCode==200) {
				resp=client.getResponseBody();
			}
			
			return "procesarIncidencias";
		}
		else {
			return "incidencias";
		}
	}

	@GetMapping("/incidencias")
	public String Incidencias(Model model) {
		return "incidencias";
	}
}