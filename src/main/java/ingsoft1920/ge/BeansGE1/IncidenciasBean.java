package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class IncidenciasBean {
	
	private String idReserva;
	private String Asunto;
	private String mensaje;
	
	
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getAsunto() {
		return Asunto;
	}
	public void setAsunto(String asunto) {
		Asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public IncidenciasBean(String idReserva, String asunto, String mensaje) {
		super();
		this.idReserva = idReserva;
		Asunto = asunto;
		this.mensaje = mensaje;
	}
	public IncidenciasBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IncidenciasBean [idReserva=" + idReserva + ", Asunto=" + Asunto + ", mensaje=" + mensaje + "]";
	}


	
	



}
