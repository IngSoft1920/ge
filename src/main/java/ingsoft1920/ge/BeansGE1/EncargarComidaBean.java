package ingsoft1920.ge.BeansGE1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class EncargarComidaBean {
	
	private static String tipoServicio= "encargarComida";
	private String[] platos;
	private String[] items;
	
	
	public static String getTipoServicio() {
		return tipoServicio;
	}
	public static void setTipoServicio(String tipoServicio) {
		EncargarComidaBean.tipoServicio = tipoServicio;
	}
	public String[] getPlatos() {
		return platos;
	}
	public void setPlatos(String[] platos) {
		this.platos = platos;
	}
	public String[] getItems() {
		return items;
	}
	public void setItems(String[] items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "EncargarComidaBean [platos=" + Arrays.toString(platos) + ", items=" + Arrays.toString(items) + "]";
	}
	public EncargarComidaBean(String[] platos, String[] items) {
		super();
		this.platos = platos;
		this.items = items;
		
	}
	public EncargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
