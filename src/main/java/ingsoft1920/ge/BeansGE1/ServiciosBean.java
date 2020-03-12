package ingsoft1920.ge.BeansGE1;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ServiciosBean {
	
	private String idReserva;
	private String tipoServicio;
	private String fecha;
	private int numPersonas;
	
	
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public ServiciosBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ServiciosBean(String idReserva, String tipoServicio, String fecha, int numPersonas) {
		super();
		this.idReserva = idReserva;
		this.tipoServicio = tipoServicio;
		this.fecha = fecha;
		this.numPersonas = numPersonas;
	}
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

	

}
