package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CheckInBean {
	private String nombre;
	private String apellidos;
	private String DNI;
	private String email;
	//private String password; la contraseña no se pide
	private String nacionalidad;
	private String telefono ;
	@Override
	public String toString() {
		return "CheckInBean [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", email=" + email
				+ ", nacionalidad=" + nacionalidad + ", telefono=" + telefono + "]";
	}
	public CheckInBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckInBean(String nombre, String apellidos, String dNI, String email, String nacionalidad,
			String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.email = email;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
	
	

}
