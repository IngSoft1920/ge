package ingsoft1920.ge.Beans;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class BusquedaBean {
	private String fechaInicio;
	private String fechaFin;
	private String hotel;
	private String ciudad;
	private int hotel_id;
	private List<String> hoteles;
	private Map<String, Integer> ids;
	private List<String> ciudades;
	
	public BusquedaBean() {
		this.hoteles = new ArrayList<String>();
		this.ids = new HashMap<String, Integer>();
		this.ciudades = new ArrayList<String>();
	}
	
	public boolean checkCamposValidos() {
		String now = java.time.LocalDate.now().toString();
		if (now.compareTo(this.fechaInicio) <= 0 && 
				this.fechaInicio.compareTo(this.fechaFin) < 0)
			return true;
		return false;
	}

	public List<String> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<String> ciudades) {
		this.ciudades = ciudades;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public List<String> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<String> hoteles) {
		this.hoteles = hoteles;
	}

	public Map<String, Integer> getIds() {
		return ids;
	}

	public void setIds(Map<String, Integer> ids) {
		this.ids = ids;
	}
	
	public int getNumeroDias () {
		String[] inS = fechaInicio.split("-");
		String[] outS = fechaFin.split("-");
		int[] in = new int[] 
				{Integer.parseInt(inS[0]), Integer.parseInt(inS[1]), Integer.parseInt(inS[2])};
		int[] out = new int[] 
				{Integer.parseInt(outS[0]), Integer.parseInt(outS[1]), Integer.parseInt(outS[2])};
		int dias = 0;
		
		while (in[0] != out[0] || in[1] != out[1]) {

			switch (in[1]) {
			case 1: case 3: case 5: case 7: case 8: case 10:
				dias += 31;
				in[1] += 1;
				break;
			case 4: case 6: case 9: case 11:
				dias += 30;
				in[1] += 1;
				break;
			case 12:
				dias += 31;
				in[0] += 1;
				in[1] = 1;
				break;
			default:
				dias += (in[0] % 4 == 0) ? 29 : 28;
				in[1] += 1;
			}
		}
		return dias + (out[2]-in[2]);
	}
	
}
