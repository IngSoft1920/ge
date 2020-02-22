package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

//Con la etiqueta component especificamos que esta clase es un Bean 
@Component
public class LoginBean {
	String usuario;
	String password;
	String email;
	
	//En un bean siempre es necesario el constructor vacio
	public LoginBean() {}
	
	public boolean checkCamposValidos() {
		boolean resultado = true;
		if (usuario.isEmpty()) {
			resultado = false;
		} else if (password.isEmpty()) {
			resultado = false;
		} else if (email.isEmpty()) {
			resultado = false;
		} else if (!email.isEmpty()) {
			int contador = 0; 
			for (int i = 0; i < email.length(); i++) {
				if (email.charAt(i) == '@') {
					contador++;
				}
			}
			if (contador == 0 || contador > 1) {
				resultado = false;
			} else if (!email.contains(".")) {
				resultado = false;
			}
			String temporal = email.substring(email.indexOf('@') + 1, email.length());
			if (!temporal.contains(".") || email.charAt(email.indexOf('@') + 1) == '.') {
				resultado = false;
			} else {
				for (int j = 0; j < temporal.length(); j++) {
					if (temporal.charAt(j) == '.') {
						if (temporal.charAt(j) == temporal.charAt(j+1)) {
							resultado = false;
						}
					}
				}
				
			}
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
}
