package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class EncargarComidaBean {
	private  int numHabitacion;
	private String pedido;
	private int numPersonas;
	private String fecha;
	
	
	
	public int getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getNumHabitacion() {
		return numHabitacion;
	}
	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public EncargarComidaBean(int numHabitacion, String pedido, int numPersonas, String fecha) {
		super();
		this.numHabitacion = numHabitacion;
		this.pedido = pedido;
		this.numPersonas = numPersonas;
		this.fecha = fecha;
	}
	public EncargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
