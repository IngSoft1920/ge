package ingsoft1920.ge.Beans;


import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HotelesDisponiblesBean {
	
	private List<HotelBean> hoteles;
	
	public HotelesDisponiblesBean () {}

	public List<HotelBean> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<HotelBean> hoteles) {
		this.hoteles = hoteles;
	}	
	
}
