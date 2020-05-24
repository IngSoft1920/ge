package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

@Component
public class ReservaGrupoBean {

	private String nombre;
	private String tipo;
	private String email;
	private int hotel_id;
	private int numero_habitaciones;
	private int numero_personas;
	private String fecha_entrada;
	private String fecha_salida;
	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumero_habitaciones() {
		return numero_habitaciones;
	}

	public void setNumero_habitaciones(int numero_habitaciones) {
		this.numero_habitaciones = numero_habitaciones;
	}

	public int getNumero_personas() {
		return numero_personas;
	}

	public void setNumero_personas(int numero_personas) {
		this.numero_personas = numero_personas;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}