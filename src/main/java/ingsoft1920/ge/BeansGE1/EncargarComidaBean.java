package ingsoft1920.ge.BeansGE1;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope

public class EncargarComidaBean {
	
	private static String tipoServicio= "encargarComida";
	private String[] platos;
	private String[] items;
	private int[] num_platos;
	private int[] num_items;
	
	
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
	public int[] getNum_platos() {
		return num_platos;
	}
	public void setNum_platos(int[] num_platos) {
		this.num_platos = num_platos;
	}
	public int[] getNum_items() {
		return num_items;
	}
	public void setNum_items(int[] num_items) {
		this.num_items = num_items;
	}
	public EncargarComidaBean(String[] platos, String[] items, int[] num_platos, int[] num_items) {
		super();
		this.platos = platos;
		this.items = items;
		this.num_platos = num_platos;
		this.num_items = num_items;
	}
	public EncargarComidaBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
