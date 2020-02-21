package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class EncargarComidaBean {
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
	public EncargarComidaBean(int numHabitacion, String pedido) {
		super();
		this.numHabitacion = numHabitacion;
		this.pedido = pedido;
	}
	public EncargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
