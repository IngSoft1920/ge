package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

//Con la etiqueta component especificamos que esta clase es un Bean 
@Component
public class SignupBean {
	// Atributos que necesitamos
	String nombre;
	String apellidos;
	String DNI;
	String email;
	String telefono;
	String nacionalidad;
	String password;
	String verificacionPassword;
	int id;
	String method = "signup";
	

	// En un bean siempre es necesario el constructor vacio
	public SignupBean() {
	}

	public boolean checkCamposValidos() {
		boolean resultado = true;
		if (nombre.isEmpty()) {
			resultado = false;
		} else if (apellidos.isEmpty()) {
			resultado = false;
		} else if (DNI.isEmpty()) {
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
						if (temporal.charAt(j) == temporal.charAt(j + 1)) {
							resultado = false;
						}
					}
				}

			}
		} else if (telefono.isEmpty()) {
			resultado = false;
		} else if (nacionalidad.isEmpty()) {
			resultado = false;
		} else if (password.isEmpty() || password.compareTo(verificacionPassword) != 0) {
			resultado = false;
		}
		return resultado;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerificacionPassword() {
		return verificacionPassword;
	}

	public void setVerficicacionPassword(String verificacionPassword) {
		this.verificacionPassword = verificacionPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setVerificacionPassword(String verificacionPassword) {
		this.verificacionPassword = verificacionPassword;
	}

}
