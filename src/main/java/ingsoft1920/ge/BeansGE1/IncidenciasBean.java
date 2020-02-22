package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class IncidenciasBean {
	private String Asunto;
	private String mensaje;


	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
	public String getAsunto() {
		return Asunto;
	}
	public void setAsunto(String asunto) {
		Asunto = asunto;
	}
	public boolean checkCamposValidos() {
		if(mensaje.equals("				")) {
			return false;
		}
		else 
			return true; 
		
	}

	public IncidenciasBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IncidenciasBean(String asunto, String mensaje) {
		super();
		Asunto = asunto;
		this.mensaje = mensaje;
	}
	@Override
	public String toString() {
		return "IncidenciasBean [Asunto=" + Asunto + ", mensaje=" + mensaje + "]";
	}



}
