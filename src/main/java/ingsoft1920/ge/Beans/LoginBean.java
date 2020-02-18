package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

//Con la etiqueta component especificamos que esta clase es un Bean 
@Component
public class LoginBean {
	String usuario;
	String password;
	
	//En un bean siempre es necesario el constructor vacio
	public LoginBean() {}
	
	public boolean checkCamposValidos() {
		return true;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
