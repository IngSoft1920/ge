package ingsoft1920.ge.BeansGE1;

public class ServiciosBean {
	private String servicio;
	private String fecha;
	
	
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public ServiciosBean(String servicio, String fecha) {
		super();
		this.servicio = servicio;
		this.fecha = fecha;
	}
	public ServiciosBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
