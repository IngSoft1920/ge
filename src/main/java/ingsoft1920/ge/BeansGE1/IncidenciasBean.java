package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;

import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class IncidenciasBean {
	
	
	private String asunto;
	private String mensaje;
	
	public String getAsunto() {
		return asunto;
	}
	@Override
	public String toString() {
		return "IncidenciasBean [asunto=" + asunto + ", mensaje=" + mensaje + "]";
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public IncidenciasBean(String asunto, String mensaje) {
		super();
		this.asunto = asunto;
		this.mensaje = mensaje;
	}
	public IncidenciasBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



}
