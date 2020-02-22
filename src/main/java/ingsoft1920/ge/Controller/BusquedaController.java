package ingsoft1920.ge.Controller;

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

import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.HotelesDisponiblesBean;
import ingsoft1920.ge.Beans.SesionBean;


@Controller
public class BusquedaController {
	final static Logger logger = LogManager.getLogger(BusquedaController.class.getName());

	@Autowired
	HotelesDisponiblesBean hotelesDisponibles;
	@Autowired 
	BusquedaBean busquedaBean;
	@Autowired
	SesionBean sesionBean;
	
	@GetMapping("/buscador")
	public String buscarGet(Model model) {
		
		busquedaBean = new BusquedaBean();
		busquedaBean.getCiudades().add("Zaragoza");
		busquedaBean.getCiudades().add("Barcelona");
		busquedaBean.getHoteles().add("Ritz");
		
		try {
			//HttpClient servidor = new HttpClient(HttpClient.urlCM, "getHoteles");
			//servidor.getResposeBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("busquedaBean",busquedaBean);
		
		return "buscador";
	}
	
	@PostMapping("/buscador")
	public String buscarPost(@Valid @ModelAttribute("busquedaBean") BusquedaBean busquedaBean,
			Model model) {
		
		logger.info("Busqueda recibida correctamente");
		
		logger.info(busquedaBean.getFechaInicio());
		
		// Consulta a la base de datos
		
		hotelesDisponibles = new HotelesDisponiblesBean();
		HotelBean hotel = new HotelBean("Ritz", "Zaragoza", 15, 30);
		List<HabitacionBean> listaHabitaciones = new ArrayList<HabitacionBean>();
		listaHabitaciones.add(new HabitacionBean ("Suit", "300.0", 0));
		listaHabitaciones.add(new HabitacionBean ("Turista", "100.0", 1));
		listaHabitaciones.add(new HabitacionBean ("Privilegiada", "200.0", 2));
		hotel.setHabitaciones(listaHabitaciones);
		hotelesDisponibles.getHoteles().add(hotel);
		
		hotel = new HotelBean("Hotel 2", "Madrid", 15, 30);
		listaHabitaciones = new ArrayList<HabitacionBean>();
		listaHabitaciones.add(new HabitacionBean ("Suit", "300.0", 3));
		listaHabitaciones.add(new HabitacionBean ("Turista", "100.0", 4));
		listaHabitaciones.add(new HabitacionBean ("Privilegiada", "200.0", 5));
		hotel.setHabitaciones(listaHabitaciones);
		hotelesDisponibles.getHoteles().add(hotel);
		
		model.addAttribute("hotelesDisponiblesBean", hotelesDisponibles);
		
		return "buscador";
	}
	
	@PostMapping("/reservar")
	public String reservarPost(@Valid @ModelAttribute("habitacionId") int habitacionId,
			Model model) {
		
		if (sesionBean.getUsuarioID() == 0) {
			return "redirect:login";
		}
		
		logger.info("Reserva recibida correctamente." + habitacionId);
		String reserva = "";
		boolean encontrado = false;
		for (HotelBean hotel: hotelesDisponibles.getHoteles()) {
			
			for (HabitacionBean habitacion: hotel.getHabitaciones()) {
				if (habitacion.getId() == habitacionId) {
					encontrado = true;
					reserva += "\nTipo: " + habitacion.getTipo();
					reserva += "\nTarifa: " + habitacion.getTarifa();
					break;
				}
			}
			if (encontrado) {
				reserva = "\nCiudad: " + hotel.getCiudad() + reserva;
				reserva = "Hotel: " + hotel.getNombre() + reserva;
				break;
			}
		}
		logger.info(reserva);
		
		return "redirect:buscador";
	}
	
	
	@PostMapping("/reservarTarifa")
	public String reservarTarifaPost(@Valid @ModelAttribute("habitacionId") int habitacionId, @Valid @ModelAttribute("optionComida") String optionComida,
			Model model) {
		System.out.print("nos metemos");
		logger.info("ReservaTarifa recibida correctamente con opcion la opcion de comida:"+optionComida+"y en la habitacion:"+habitacionId);
		
		return "buscador";
	}
	
}
