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
		} else if (!usuario.isEmpty()) {
			int contador = 0; 
			for (int i = 0; i < usuario.length(); i++) {
				if (usuario.charAt(i) == '@') {
					contador++;
				}
			}
			if (contador == 0 || contador > 1) {
				resultado = false;
			} else if (!usuario.contains(".")) {
				resultado = false;
			}
			String temporal = usuario.substring(usuario.indexOf('@') + 1, usuario.length());
			if (!temporal.contains(".") || usuario.charAt(usuario.indexOf('@') + 1) == '.') {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
