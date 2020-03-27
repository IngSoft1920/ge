package ingsoft1920.ge.BeansGE1;

import java.util.Arrays;

public class ReservarMesaBean {
	
	
	private String nombreRestaurante;
	private String fecha;
	private String hora;
	private int numPersonas;
	private static String tipoServicio= "reservarMesa";
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public static String getTipoServicio() {
		return tipoServicio;
	}
	public static void setTipoServicio(String tipoServicio) {
		ReservarMesaBean.tipoServicio = tipoServicio;
	}
	
	
	public String getNombreRestaurante() {
		return nombreRestaurante;
	}
	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	@Override
	public String toString() {
		return "ReservarMesaBean [nombreRestaurante=" + nombreRestaurante + ",fecha=" + fecha + ",numPersonas=" + numPersonas + ",hora=" + hora + "]";
	}
	public ReservarMesaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
