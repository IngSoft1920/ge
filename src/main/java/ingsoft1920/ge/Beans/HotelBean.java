package ingsoft1920.ge.Beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HotelBean {
	
	private String nombre;
	private String ciudad;
	private List<HabitacionBean> habitaciones;
	private int desayuno;
	private int pensionCompleta;
	
	public HotelBean () {}
	
	public HotelBean (String nombre, String ciudad, int desayuno, int pensionCompleta) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.habitaciones = new ArrayList<HabitacionBean>();
		this.desayuno = desayuno;
		this.pensionCompleta = pensionCompleta;
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

	public int getDesayuno() {
		return desayuno;
	}

	public void setDesayuno(int desayuno) {
		this.desayuno = desayuno;
	}

	public int getPensionCompleta() {
		return pensionCompleta;
	}

	public void setPensionCompleta(int pensionCompleta) {
		this.pensionCompleta = pensionCompleta;
	}
	
}
