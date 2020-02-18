package ingsoft1920.ge.Beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HotelBean {
	
	private String nombre;
	private String ciudad;
	private List<HabitacionBean> habitaciones;
	
	public HotelBean () {}
	
	public HotelBean (String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.habitaciones = new ArrayList<HabitacionBean>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public List<HabitacionBean> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<HabitacionBean> habitaciones) {
		this.habitaciones = habitaciones;
	}

	
	
}
