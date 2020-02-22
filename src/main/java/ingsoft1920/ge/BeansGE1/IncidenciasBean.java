package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class IncidenciasBean {
	private String habitacion;
	private String restaurante;
	private String servicio;
	private String mensaje;


	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public IncidenciasBean(String habitacion, String restaurante, String servicio, String mensaje) {
		super();
		this.habitacion = habitacion;
		this.restaurante = restaurante;
		this.servicio = servicio;
		this.mensaje = mensaje;
	}
	public String getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}
	@Override
	public String toString() {
		return "IncidenciasBean [habitacion=" + habitacion + ", restaurante=" + restaurante + ", servicio=" + servicio
				+ ", mensaje=" + mensaje + "]";
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public boolean checkCamposValidos() {
		/*if(!mensaje.isEmpty()) {
			return true;
		}
		else 
			return false;*/
		return true;
	}

	public IncidenciasBean() {
		super();
		// TODO Auto-generated constructor stub
	}



}
