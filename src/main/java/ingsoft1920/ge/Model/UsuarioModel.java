package ingsoft1920.ge.Model;

import ingsoft1920.ge.Beans.LoginBean;
import ingsoft1920.ge.Beans.SignupBean;

public class UsuarioModel {
	
	int usuarioID;

	public UsuarioModel() {}
	
	public UsuarioModel(SignupBean signupBean) {
		usuarioID = signupBean.getId();
	}
	
	public UsuarioModel(LoginBean loginBean) {
		usuarioID = loginBean.getId();
	}
	
	public int getUsuarioID() {
		return 0;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	
}
