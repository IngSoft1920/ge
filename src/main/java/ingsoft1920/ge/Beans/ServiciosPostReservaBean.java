package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

@Component
public class ServiciosPostReservaBean {

	private int id;
	private String nombre;
	private double precio;
	private String unidad;

	@Override
	public String toString() {
		return "ServiciosPostReservaBean [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", unidad=" + unidad
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
