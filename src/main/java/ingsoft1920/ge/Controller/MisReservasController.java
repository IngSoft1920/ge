package ingsoft1920.ge.Controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;

import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;

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
	
	@PostMapping("/cancelarReserva")
	public void borrarReserva(@Valid @ModelAttribute("ReservaBean") ReservaBean reservaBean,
			Model model) throws Exception {
		HttpClient client= new HttpClient("piedrafita.ls.fi.upm.es:7000/cancelarReserva", "POST");
		client.setRequestBody(beanToJson(reservaBean).toString());
		String response = null;
		if(client.getResponseCode()==200) {
			response = client.getResponseBody();
		}
		
	}
	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);	
		return JSON;
	}
	
}
