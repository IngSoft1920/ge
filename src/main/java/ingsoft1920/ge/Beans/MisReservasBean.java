package ingsoft1920.ge.Beans;

import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class MisReservasBean {
	private Date fechaEntrada;
	private Date fechaSalida;
	private String Hotel;
	private String habitacion;
	private String tarifa;

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public String getTarifa() {
		return tarifa;
	}

	public void setTarifa(String tarifa) {
		this.tarifa = tarifa;
	}

	public MisReservasBean() {
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getHotel() {
		return Hotel;
	}

	public void setHotel(String hotel) {
		Hotel = hotel;
	}

	public boolean checkCamposValidos() {
		return true;
	}
}