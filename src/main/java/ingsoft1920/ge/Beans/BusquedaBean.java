package ingsoft1920.ge.Beans;



import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BusquedaBean {
	private Date fechaInicio;
	private Date fechaFin;
	private String hotel;
	private String ciudad;
	
	public BusquedaBean() {}
	
	public boolean checkCamposValidos() {
		return true;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	
}
