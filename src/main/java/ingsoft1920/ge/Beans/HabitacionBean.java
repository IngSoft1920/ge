package ingsoft1920.ge.Beans;



import org.springframework.stereotype.Component;

@Component
public class HabitacionBean {
	
	private String tipo;
	private double tarifa;
	private int id;
	
	public HabitacionBean () {}
	
	public HabitacionBean (String tipo, double tarifa, int id) {
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

	public double getTarifa() {
		return tarifa;
	}

	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
