package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;

@Component

public class EcargarComidaBean {
	private  int numHabitacion;
	private String pedido;
	
	
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
	public EcargarComidaBean(int numHabitacion, String pedido) {
		super();
		this.numHabitacion = numHabitacion;
		this.pedido = pedido;
	}
	public EcargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
