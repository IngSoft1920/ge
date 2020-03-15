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
import com.google.gson.JsonObject;

import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.BeansGE1.ServiciosBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class MisReservasController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@Autowired
	SesionBean sesionBean;

	@GetMapping("/misReservas")
	public String buscarGet(Model model) {

		MisReservasBean misReservasBean = new MisReservasBean();

		ReservaBean reservaBean = new ReservaBean("Rich", "Guadalajara", "10/12/2020", "15/12/2020", "Suit", "300.0",
				"");
		misReservasBean.getReservas().add(reservaBean);

		model.addAttribute("misReservasBean", misReservasBean);
		model.addAttribute("sesionBean", sesionBean);
		model.addAttribute("mensajeError", "");

		return "misReservas";

	}

	@GetMapping("/recibirReservas")
	public String recibirReservas(@Valid @ModelAttribute("misReservasBean") MisReservasBean reservas, Model model)
			throws Exception {

		HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/{cliente_id}", "GET");

		JsonObject json = new JsonObject();
		json.addProperty("id_cliente", sesionBean.getUsuarioID()); // coger id_usuario de la sesionBean
		client.setRequestBody(json.toString());

		int respCode = client.getResponseCode();

		String resp = "";
		if (respCode == 200) {
			resp = client.getResponseBody();
		}
		return resp;
	}

	@PostMapping("/valorar")
	public String misReservasPost(@Valid @ModelAttribute("valoracionId") String valoracionId, Model model) {

		logger.info("Valoración recibida correctamente." + valoracionId);
		return "redirect:misReservas";
	}

	@PostMapping("/cancelarReserva")
	public void borrarReserva(@Valid @ModelAttribute("ReservaBean") ReservaBean reservaBean, Model model)
			throws Exception {

		JsonObject json = new JsonObject();
		HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/eliminar/{reserva_id}", "POST");
		json.addProperty("id_reserva", reservaBean.getReservaID()); // coger id_reserva de la reservaBean
		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		System.out.println(respCode + "\n");
		if (respCode == 200) {
			client.getResponseBody();
		}

		logger.info("Cancelación de reserva realizada correctamente." + reservaBean);

	}
	
	@GetMapping("/recibirReservas")
    public  String recibirReservas(@Valid @ModelAttribute("misReservasBean") MisReservasBean reservas,
			Model model) throws Exception {
		HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/cliente/{cliente_id}", "GET");
		JsonObject json = new JsonObject();
		json.addProperty("id_cliente", sesionBean.getUsuarioID()); //coger id_usuario de la sesionBean
		client.setRequestBody(json.toString());
		int respCode = client.getResponseCode();
		String resp="";
		if(respCode==200) {
			resp=client.getResponseBody();
		}
		return resp;
	}
	

	public static Object beanToJson(Object bean) {
		Gson gson = new Gson();
		String JSON = gson.toJson(bean);
		return JSON;
	}

}
