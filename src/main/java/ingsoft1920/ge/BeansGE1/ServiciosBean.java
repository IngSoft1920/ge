package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ServiciosBean {
	
	private String idReserva;
	
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	private String servicio;
	private String fecha;
	
	
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
	
	public ServiciosBean(String idReserva, String servicio, String fecha) {
		super();
		this.idReserva = idReserva;
		this.servicio = servicio;
		this.fecha = fecha;
	}
	public ServiciosBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
