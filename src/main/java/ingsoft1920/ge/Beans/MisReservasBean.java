package ingsoft1920.ge.Beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MisReservasBean {
	private List<ReservaBean> reservas;

	
	public MisReservasBean() {
		reservas = new ArrayList<ReservaBean>();
	}


	public List<ReservaBean> getReservas() {
		return reservas;
	}


	public void setReservas(List<ReservaBean> reservas) {
		this.reservas = reservas;
	}


}