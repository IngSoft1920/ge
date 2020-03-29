package ingsoft1920.ge.Beans;

public class MostarReservasBean {
	private String tipo_hab;
	private String nombre_hotel;
	private String regimen;
	private String ciudad;
	private String fecha_inicio;
	private String fecha_fin;
	private double tarifa;
	public String getTipo_hab() {
		return tipo_hab;
	}
	public void setTipo_hab(String tipo_hab) {
		this.tipo_hab = tipo_hab;
	}
	public String getNombre_hotel() {
		return nombre_hotel;
	}
	public void setNombre_hotel(String nombre_hotel) {
		this.nombre_hotel = nombre_hotel;
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public double getTarifa() {
		return tarifa;
	}
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

}
