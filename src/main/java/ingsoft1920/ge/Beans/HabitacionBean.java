package ingsoft1920.ge.Beans;



import org.springframework.stereotype.Component;

@Component
public class HabitacionBean {
	
	private String nombre;
	private int precio_total;
	private int tipo_hab_id;
	
	public HabitacionBean () {}
	
	public HabitacionBean (String tipo, int tarifa, int id) {
		this.nombre = tipo;
		this.precio_total = tarifa;
		this.tipo_hab_id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(int precio_total) {
		this.precio_total = precio_total;
	}

	public int getTipo_hab_id() {
		return tipo_hab_id;
	}

	public void setTipo_hab_id(int tipo_hab_id) {
		this.tipo_hab_id = tipo_hab_id;
	}


}
