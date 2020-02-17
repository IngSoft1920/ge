package ingsoft1920.ge.Beans;



import org.springframework.stereotype.Component;

@Component
public class HabitacionBean {
	
	private String tipo;
	private String tarifa;
	
	public HabitacionBean () {}
	
	public HabitacionBean (String tipo, String tarifa) {
		this.tipo = tipo;
		this.tarifa = tarifa;
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
	
	
}
