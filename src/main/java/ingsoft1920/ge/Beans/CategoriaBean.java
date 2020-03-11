package ingsoft1920.ge.Beans;

public class CategoriaBean {
	
	private int categoria_id;
	private String nombre;
	
	@Override
	public String toString () {
		return "categoria_id: " + categoria_id +
				", categoria: " + nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}
	
}
