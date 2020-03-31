package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

@Component
public class ServiciosPostReservaBean {

	private int id;
	private String nombre;
	private double precio;
	private String unidad_medida;

	@Override
	public String toString() {
		return "ServiciosPostReservaBean [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", unidad=" + unidad_medida
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
		return unidad_medida;
	}

	public void setUnidad(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

}
