package ingsoft1920.ge.Beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class HotelBean {

	private int id;
	private String nombre;
	private String descripcion;
	private int estrellas;
	private String continente;
	private String pais;
	private String ciudad;
	private String direccion;
	private List<CategoriaBean> categorias;
	
	private List<HabitacionBean> habitaciones;
	
	public HotelBean () {
		habitaciones = new ArrayList<HabitacionBean>();
	}
	
	@Override
	public String toString () {
		String result = "hotel_id: " + id +
				",\nnombre: " + nombre +
				",\ndescripcion: " + descripcion +
				",\nestrellas: " + estrellas +
				",\ncontinente: " + continente +
				",\npais: " + pais +
				",\nciudad: " + ciudad +
				",\ndireccion: " + direccion +
				",\ncategorias: [";
		
		for (CategoriaBean c: categorias) {
			result += "\n\t{ " + c.toString() + " },";
		}
		result += "\n]";
		
		return result;
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getEstrellas() {
		return estrellas;
	}


	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}


	public String getContinente() {
		return continente;
	}


	public void setContinente(String continente) {
		this.continente = continente;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<CategoriaBean> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<CategoriaBean> categorias) {
		this.categorias = categorias;
	}


	public List<HabitacionBean> getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(List<HabitacionBean> habitaciones) {
		this.habitaciones = habitaciones;
	}


	@Component
	public class CategoriaBean {
		
		private int categoria_id;
		private String nombre;
		
		public String toString () {
			return "categoria_id: " + categoria_id + ", nombre: " + nombre;
		}

		public int getCategoria_id() {
			return categoria_id;
		}

		public void setCategoria_id(int categoria_id) {
			this.categoria_id = categoria_id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
	}
	
}