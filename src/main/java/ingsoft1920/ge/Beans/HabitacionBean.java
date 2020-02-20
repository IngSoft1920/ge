package ingsoft1920.ge.Beans;



import org.springframework.stereotype.Component;

@Component
public class HabitacionBean {
	
	private String tipo;
	private String tarifa;
	private int id;
	
	public HabitacionBean () {}
	
	public HabitacionBean (String tipo, String tarifa, int id) {
		this.tipo = tipo;
		this.tarifa = tarifa;
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
