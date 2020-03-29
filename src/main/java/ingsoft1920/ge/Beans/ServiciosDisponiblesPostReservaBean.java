package ingsoft1920.ge.Beans;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ServiciosDisponiblesPostReservaBean {
	
	private List<ServiciosPostReservaBean> servicios;
	
	public ServiciosDisponiblesPostReservaBean () {}

	public List<ServiciosPostReservaBean> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServiciosPostReservaBean> servicios) {
		this.servicios = servicios;
	}

}
