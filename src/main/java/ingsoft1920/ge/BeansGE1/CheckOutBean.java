package ingsoft1920.ge.BeansGE1;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CheckOutBean {

	private String horaSalida;

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public CheckOutBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckOutBean(String horaSalida) {
		super();
		this.horaSalida = horaSalida;
	}
	
	
}
