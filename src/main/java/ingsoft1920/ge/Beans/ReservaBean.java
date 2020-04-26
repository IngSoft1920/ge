package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

@Component
public class ReservaBean {

	private int reserva_id;
	private int hotel_id;
	private String tipo_hab;
	private int importe;
	private String regimen;
	private String fecha_entrada;
	private String fecha_salida;

	public int getReserva_id() {
		return reserva_id;
	}

	public void setReserva_id(int reserva_id) {
		this.reserva_id = reserva_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public int getImporte() {
		return importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	
	@Override
	public String toString() {
		return "ReservaBean [reserva_id=" + reserva_id + ", hotel_id=" + hotel_id + ", tipo_hab_id=" + tipo_hab
				+ ", regimen=" + regimen + ", importe=" + importe + ", fecha_entrada=" + fecha_entrada
				+ ", fecha_salida=" + fecha_salida + "]";
	}

	public String getTipo_hab() {
		return tipo_hab;
	}

	public void setTipo_hab(String tipo_hab) {
		this.tipo_hab = tipo_hab;
	}

}