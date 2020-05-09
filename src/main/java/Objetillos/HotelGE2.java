package Objetillos;

public class HotelGE2 {
	
	private int id;
	private String nombre;
	private String descripcion;
	private int estrellas;
	private String continente;
	private String pais;
	private String ciudad;
	

	
	
	public HotelGE2(int  id, String nombre, String descripcion, int estrellas, 
			String continente, String pais, String ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estrellas = estrellas;
		this.continente = continente;
		this.pais = pais;
		this.ciudad = ciudad;	
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



	public String getCiudad() {
		return ciudad;
	}



	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	
	
	
	
}