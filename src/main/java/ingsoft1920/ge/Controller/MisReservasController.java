package ingsoft1920.ge.Controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import ingsoft1920.ge.Beans.MisReservasBean;
import ingsoft1920.ge.Beans.MostarReservasBean;
import ingsoft1920.ge.Beans.ReservaBean;
import ingsoft1920.ge.Beans.SesionBean;
import ingsoft1920.ge.HttpClient.HttpClient;

@Controller
public class MisReservasController {
	final static Logger logger = LogManager.getLogger(MisReservasController.class.getName());

	@Autowired
	MisReservasBean misReservasBean;
	
	@Autowired
	SesionBean sesionBean;
	
	@Autowired
	ReservaBean reserva;

	List<ReservaBean> reservas;
	
	//List<ReservaGE2> reservas = new LinkedList<>();
	
	MostarReservasBean mostarReservasBean = new MostarReservasBean();

	@GetMapping("/misReservas")
	public String mostrarReservasGet(Model model) throws Exception {

		/*
		 * [ { reserva_id : 21, hotel_id : 1 , tipo_hab : “normal”, regimen :
		 * “no_aplica”, importe : “300”, fecha_entrada : “2020-02-10”, fecha_salida :
		 * “2020-02-15”, }, { reserva_id : 10, hotel_id : 14 , tipo_hab : “premium”,
		 * regimen : “media_pension”, importe : “750”, fecha_entrada : “2020-07-10”,
		 * fecha_salida : “2020-07-15”, } ]
		 */
		/*
		[
		 {
		  reserva_id : 21,
		  hotel_id : 1,
		  hotel_nombre: "New Japón",
		  tipo_hab_id: 1,
		  tipo_hab_nombre : “normal”,
		  regimen : “no_aplica”,
		  importe : “300”,
		  fecha_entrada : “2020-02-10”,
		  fecha_salida : “2020-02-15”,
		  valoracion: 4.2
		 },
		 {
		  reserva_id : 10,
		  hotel_id : 14 ,
		  hotel_nombre: "Viejo Japan",
		  tipo_hab_id: 2
		  tipo_hab_nombre : “premium”,
		  regimen : “media_pension”,
		  importe : “750”,
		  fecha_entrada : “2020-07-10”,
		  fecha_salida : “2020-07-15”,
		  valoracion: -1.0
		 }
		]*/

		/*JsonArray arrayGrande = new JsonArray();

		JsonObject ejemplo = new JsonObject();
		ejemplo.addProperty("reserva_id", 21);
		ejemplo.addProperty("hotel_id", 1);
		ejemplo.addProperty("tipo_hab", "normal");
		ejemplo.addProperty("regimen", "no aplica");
		ejemplo.addProperty("importe", 300);
		ejemplo.addProperty("fecha_entrada", "2020-02-10");
		ejemplo.addProperty("fecha_salida", "2020-02-15");
		arrayGrande.add(ejemplo);

		ejemplo = new JsonObject();
		ejemplo.addProperty("reserva_id", 10);
		ejemplo.addProperty("hotel_id", 14);
		ejemplo.addProperty("tipo_hab", "premium");
		ejemplo.addProperty("regimen", "media_pension");
		ejemplo.addProperty("importe", 750);
		ejemplo.addProperty("fecha_entrada", "2020-07-10");
		ejemplo.addProperty("fecha_salida", "2020-07-15");
		arrayGrande.add(ejemplo);

		String response = arrayGrande.toString();*/


		HttpClient serverReservas = new HttpClient( HttpClient.urlCM +"reserva/cliente/" + sesionBean.getUsuarioID(), "GET");

		String response = "";
		if (serverReservas.getResponseCode() == 200) {// Si encuentra el servidor
			response = serverReservas.getResponseBody(); 
		}
		
		Type tipo = new TypeToken<List<ReservaBean>>(){}.getType();
		reservas = new Gson().fromJson(response, tipo);
		
		String now = java.time.LocalDate.now().toString();
		List<ReservaBean> reservas_pendientes = 
				reservas.stream().filter
				(reserva -> reserva.getFecha_salida().compareTo(now) >= 0)
				.collect(Collectors.toList());
		
		List<ReservaBean> reservas_finalizadas = 
				reservas.stream().filter
				(reserva -> reserva.getFecha_salida().compareTo(now) < 0)
				.collect(Collectors.toList());
		
		model.addAttribute("reservas_pendientes", reservas_pendientes);
		model.addAttribute("reservas_finalizadas", reservas_finalizadas);
		
		model.addAttribute("sesionBean", sesionBean);

		return "misReservas";
	}
	
	@PostMapping("/misReservas")
	public String mostarReservasPost(
			@Valid @ModelAttribute("mostarReservasBean") MostarReservasBean mostarReservasBean,
			Model model) throws Exception {
		
		System.out.println("Bien");
		

		model.addAttribute("reservas", reservas);
		model.addAttribute("mostarReservasBean", mostarReservasBean);
		model.addAttribute("sesionBean", sesionBean);
		
		return "misReservas";
	}
	
	@PostMapping("/valorar")
	public String valorarPost(@Valid @ModelAttribute("nota") int nota,
			@Valid @ModelAttribute("hotel_id") int hotel_id,
			@Valid @ModelAttribute("cabecera") String cabecera,
			@Valid @ModelAttribute("comentario") String comentario,
			Model model) throws Exception{
		/*
		{
			  "cliente_id" :1,
			  "hotel_id" : 2,
			  "cabecera" : “Muy bueno”,
			  "cuerpo" : “Maravilloso…”,
			  "nota" : 5
		}
		*/
		
		JsonObject valoracion = new JsonObject();
		valoracion.addProperty("cliente_id", sesionBean.getUsuarioID());
		valoracion.addProperty("hotel_Id", hotel_id);
		valoracion.addProperty("cabecera", cabecera);
		valoracion.addProperty("comentario", comentario);
		valoracion.addProperty("nota", nota);
		
		logger.info("Valoración recibida correctamente." + nota);
		
		String response = "";
		HttpClient server = new HttpClient(HttpClient.urlCM+"valoracion", "POST");
		server.setRequestBody(valoracion.toString());
		if (server.getResponseCode() == 200) {
			response = server.getResponseBody();
		}
		
		
		return "redirect:misReservas";
	}
	
	
	@PostMapping("/funciona")
	public String funciona(@Valid @ModelAttribute("hotel_id") int hotel_id, 
			@Valid @ModelAttribute("cabecera") String cabecera,
			@Valid @ModelAttribute("comentario") String comentario, 
			@Valid @ModelAttribute("nota") String nota,
			Model model) throws Exception {
		System.out.println(hotel_id);
		System.out.println(cabecera);
		System.out.println(comentario);
		System.out.println(nota);
		
		return "redirect:misReservas";
	}
	
	@PostMapping("/estrellas")
	public String funciona(@Valid @ModelAttribute("estrellas") int estrellas, 
			Model model) throws Exception {
		System.out.print(estrellas);
		
		return "redirect:misReservas";
	}
	
	@PostMapping("/cancelar/{id}")
	public String cancelarReserva(@PathVariable("id") int id) throws Exception {
		
	HttpClient serverReservas = new HttpClient( HttpClient.urlCM + "reserva/eliminar/" + id, "POST");
	int codigoRespuesta = serverReservas.getResponseCode();
	if(codigoRespuesta==200)	
	{
		serverReservas.getResponseBody();
	}
	logger.info("Valoración recibida correctamente." + id);



	return "redirect:/misReservas";
	}


}
