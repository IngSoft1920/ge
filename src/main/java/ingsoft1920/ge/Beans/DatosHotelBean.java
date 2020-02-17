package ingsoft1920.ge.Beans;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class DatosHotelBean {
	private String nombre;
	private String ciudad;
	private List<HabitacionBean> tipoHabitacion;
	
	public DatosHotelBean () {
		this.tipoHabitacion = new ArrayList();
	}
	
	public DatosHotelBean (String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.tipoHabitacion = new ArrayList();
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

	public List<HabitacionBean> getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(List<HabitacionBean> tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	
	
	
	
}
