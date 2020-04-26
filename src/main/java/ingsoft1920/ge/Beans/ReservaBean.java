package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

@Component
public class ReservaBean {

	private int reserva_id;
	private int hotel_id;
	private String hotel_nombre;
	private int tipo_hab_id;
	private String tipo_hab_nombre;
	private int importe;
	private String regimen;
	private String fecha_entrada;
	private String fecha_salida;
	private double valoracion;

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
	
	public String getHotel_nombre() {
		return hotel_nombre;
	}

	public void setHotel_nombre(String hotel_nombre) {
		this.hotel_nombre = hotel_nombre;
	}

	public int getTipo_hab_id() {
		return tipo_hab_id;
	}

	public void setTipo_hab_id(int tipo_hab_id) {
		this.tipo_hab_id = tipo_hab_id;
	}

	public String getTipo_hab_nombre() {
		return tipo_hab_nombre;
	}

	public void setTipo_hab_nombre(String tipo_hab_nombre) {
		this.tipo_hab_nombre = tipo_hab_nombre;
	}

	public double getValoracion() {
		return valoracion;
	}

	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "ReservaBean [reserva_id=" + reserva_id + ", hotel_id=" + hotel_id + ", tipo_hab_id=" + tipo_hab_id
				+ ", regimen=" + regimen + ", importe=" + importe + ", fecha_entrada=" + fecha_entrada
				+ ", fecha_salida=" + fecha_salida + "]";
	}


}