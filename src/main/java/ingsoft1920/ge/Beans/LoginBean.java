package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

//Con la etiqueta component especificamos que esta clase es un Bean 
@Component
public class LoginBean {
	String usuario;
	String password;
	int id;
	
	//En un bean siempre es necesario el constructor vacio
	public LoginBean() {}
	
	public boolean checkCamposValidos() {
		boolean resultado = true;
		if (usuario.isEmpty()) {
			resultado = false;
		} else if (password.isEmpty()) {
			resultado = false;
		}
		return resultado;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
