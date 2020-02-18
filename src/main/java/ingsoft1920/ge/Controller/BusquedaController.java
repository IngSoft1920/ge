package ingsoft1920.ge.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.ge.Beans.BusquedaBean;
import ingsoft1920.ge.Beans.HabitacionBean;
import ingsoft1920.ge.Beans.HotelBean;
import ingsoft1920.ge.Beans.HotelesDisponiblesBean;


@Controller
public class BusquedaController {
	final static Logger logger = LogManager.getLogger(BusquedaController.class.getName());

	@GetMapping("/buscar")
	public String buscarGet(Model model) {
		
		BusquedaBean busquedaBean = new BusquedaBean();
		busquedaBean.getCiudades().add("Zaragoza");
		busquedaBean.getHoteles().add("Hotel 1");
		model.addAttribute("busquedaBean",busquedaBean);
		model.addAttribute("mensajeError","");
		
		return "buscador";
	}
	
	@PostMapping("/buscar")
	public String buscarPost(@Valid @ModelAttribute("busquedaBean") BusquedaBean busquedaBean,
			Model model) {
		
		logger.info("Busqueda recibida correctamente");
		
		
		
		// Consulta a la base de datos
		
		HotelesDisponiblesBean hotelesDisponibles = new HotelesDisponiblesBean();
		HotelBean hotel = new HotelBean("Hotel 1", "Zaragoza");
		List<HabitacionBean> listaHabitaciones = new ArrayList<HabitacionBean>();
		listaHabitaciones.add(new HabitacionBean ("Suit", "300.0"));
		listaHabitaciones.add(new HabitacionBean ("Turista", "100.0"));
		listaHabitaciones.add(new HabitacionBean ("Privilegiada", "200.0"));
		hotel.setHabitaciones(listaHabitaciones);
		hotelesDisponibles.getHoteles().add(hotel);
		
		hotel = new HotelBean("Hotel 2", "Madrid");
		listaHabitaciones = new ArrayList<HabitacionBean>();
		listaHabitaciones.add(new HabitacionBean ("Suit", "300.0"));
		listaHabitaciones.add(new HabitacionBean ("Turista", "100.0"));
		listaHabitaciones.add(new HabitacionBean ("Privilegiada", "200.0"));
		hotel.setHabitaciones(listaHabitaciones);
		hotelesDisponibles.getHoteles().add(hotel);
		
		model.addAttribute("hotelesDisponiblesBean", hotelesDisponibles);
		
		return "buscador";
	}
}
