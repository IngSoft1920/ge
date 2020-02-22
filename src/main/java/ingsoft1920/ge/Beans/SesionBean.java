package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import ingsoft1920.ge.Model.UsuarioModel;



@Component
@SessionScope 
public class SesionBean {
	int usuarioID = -1;
	
	public SesionBean () {}
	
	public SesionBean(UsuarioModel usuarioModel) {
		this.usuarioID=usuarioModel.getUsuarioID();
	}
	
	public int getUsuarioID() {
		return this.usuarioID;
	}
	
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
}
