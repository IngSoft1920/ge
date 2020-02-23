package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class EncargarComidaBean {
	
	private String pedido;
	private String idReserva;
	
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	
	public EncargarComidaBean(String pedido, String idReserva) {
		super();
		this.pedido = pedido;
		this.idReserva = idReserva;
	}
	public EncargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
