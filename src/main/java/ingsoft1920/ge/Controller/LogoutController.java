package ingsoft1920.ge.Controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ingsoft1920.ge.Beans.SesionBean;

@Controller
public class LogoutController {
	final static Logger logger = LogManager.getLogger(LogoutController.class.getName());

	@Autowired
	SesionBean sesionBean;
	
	@GetMapping("/logout")
	public String logoutPost() throws Exception {

		String resultado = "";
			sesionBean.setUsuarioID(-1);
			sesionBean.setUsuario("");
			resultado = "redirect:";
		return resultado;
	}
}
