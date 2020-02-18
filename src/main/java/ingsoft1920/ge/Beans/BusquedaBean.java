package ingsoft1920.ge.Beans;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BusquedaBean {
	private String fechaInicio;
	private String fechaFin;
	private String hotel;
	private String ciudad;
	private List<String> hoteles;
	private List<String> ciudades;
	
	public BusquedaBean() {
		this.hoteles = new ArrayList<String>();
		this.ciudades = new ArrayList<String>();
	}
	
	public List<String> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<String> hoteles) {
		this.hoteles = hoteles;
	}

	public List<String> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<String> ciudades) {
		this.ciudades = ciudades;
	}

	public boolean checkCamposValidos() {
		return true;
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
