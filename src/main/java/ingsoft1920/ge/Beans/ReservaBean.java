package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

@Component
public class ReservaBean {
	private String hotel;
	private String tarifa;
	private String ciudad;
	private String fechaInicio;
	private String fechaFin;
	private String habitacion;
	private String valoracion;
	
	public ReservaBean () {}

	public ReservaBean (String hotel, String ciudad, String fechaInicio, String fechaFin, String habitacion, String tarifa, String valoracion) {
		this.hotel = hotel;
		this.tarifa = tarifa;
		this.ciudad = ciudad;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.habitacion = habitacion;	
		this.valoracion = valoracion;
	}
	
	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	
}

