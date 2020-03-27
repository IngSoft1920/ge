package Objetillos;

public class Cliente {
	
	@Override
	public String toString() {
		return "Cliente [cliente_id=" + cliente_id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI
				+ ", email=" + email + ", password=" + password + ", nacionalidad=" + nacionalidad + ", telefono="
				+ telefono + "]";
	}

	private int cliente_id ;
	private String nombre;
	private String apellidos ;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(int cliente_id, String nombre, String apellidos, String dNI, String email, String password,
			String nacionalidad, String telefono) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.email = email;
		this.password = password;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}

	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	private String DNI;
	private String email;
	private String password;
	private String nacionalidad;
	private String telefono ;

}
