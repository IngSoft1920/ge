package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ServiciosBean {
	
	private String idReserva;
	private String tipoServicio;
	private String fecha;
	private int numPersonas;
	
	public ServiciosBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ServiciosBean(String idReserva, String servicio, String fecha, int numPersonas) {
		super();
		this.idReserva = idReserva;
		this.servicio = servicio;
		this.fecha = fecha;
		this.numPersonas = numPersonas;
	}
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	
	

	

}
