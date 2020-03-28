package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ServiciosBean {
	
	private String tipoServicio;
	private String fecha;
	private String hora;
	private int numPersonas;
	
	
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoras() {
		return hora;
	}
	public void setHoras(String hora) {
		this.hora = hora;
	}
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public ServiciosBean(String tipoServicio, String fecha, String horas, int numPersonas) {
		super();
		this.tipoServicio = tipoServicio;
		this.fecha = fecha;
		this.hora = hora;
		this.numPersonas = numPersonas;
	}
	
	
	@Override
	public String toString() {
		return "ServiciosBean [tipoServicio=" + tipoServicio + ",fecha=" + fecha + ",numPersonas=" + numPersonas + ",hora=" + hora + "]";
	}
	
	
	
	

}
