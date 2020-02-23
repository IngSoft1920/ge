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
	
	public boolean checkCamposValidos() {
		String now = java.time.LocalDate.now().toString();
		String[] fecha = now.split("-"); // fecha = {"<año>", "<mes>", "<dia>"}
		String[] fechaInicio = this.fechaInicio.split("-");
		String[] fechaFin = this.fechaFin.split("-");
		if (fechaInicio.length != 3 || fechaFin.length != 3 ||
			fechaInicio[0].compareTo(fecha[0]) < 0 || 
			fechaFin[0].compareTo(fechaInicio[0]) < 0 ||
			fechaInicio[1].compareTo(fecha[1]) < 0 ||
			fechaFin[1].compareTo(fechaInicio[1]) < 0 ||
			fechaInicio[2].compareTo(fecha[2]) < 0 ||
			fechaFin[2].compareTo(fechaInicio[2]) <= 0) {
			
			return false;
		}
		return true;
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
