package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class EncargarComidaBean {
	
	private String pedido;
	private String nombreRestaurante;
	private int numPersonas;
	
	private String idReserva;

	public String getPedido() {
		return pedido;
	}

	public void setPedido(String pedido) {
		this.pedido = pedido;
	}

	public String getNombreRestaurante() {
		return nombreRestaurante;
	}

	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public EncargarComidaBean(String pedido, String nombreRestaurante, int numPersonas, String idReserva) {
		super();
		this.pedido = pedido;
		this.nombreRestaurante = nombreRestaurante;
		this.numPersonas = numPersonas;
		this.idReserva = idReserva;
	}

	public EncargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
