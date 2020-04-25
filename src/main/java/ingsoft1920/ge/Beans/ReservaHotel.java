package ingsoft1920.ge.Beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class ReservaHotel {

	private int hotel_id;
	private int habitacion_id;
	private String nombre_hotel;
	private String nombre_habitacion;
	private String fecha_inicio;
	private String fecha_fin;
	private int tarifa;
	private int regimen_comidas;
	
	private List<MostrarServiciosPostReservaBean> servicios;
	
	/*
	 * Este método se utiliza para eliminar los datos de reservas 
	 * anteriores
	 */
	public void resetReserva () {
		hotel_id = 0;
		habitacion_id = 0;
		fecha_inicio = "";
		fecha_fin = "";
		tarifa = 0;
		servicios.clear();
		regimen_comidas = 0;
	}
	
	/*
	 * Función que devuelve la información del régimen de comidas
	 * para CM
	 */
	public String regimen () {
		switch (regimen_comidas) {
		case 1:
			return "no_aplica";
		case 2:
			return "media_pensión";
		case 3:
			return "pensión_completa";
		case 4: 
			return "todo_incluido";
		default:
			return "no_aplica";
		}
	}
	
	
	
	public ReservaHotel() {
		servicios = new ArrayList<MostrarServiciosPostReservaBean>();
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getHabitacion_id() {
		return habitacion_id;
	}

	public void setHabitacion_id(int habitacion_id) {
		this.habitacion_id = habitacion_id;
	}

	public String getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public List<MostrarServiciosPostReservaBean> getServicios() {
		return servicios;
	}

	public void setServicios(List<MostrarServiciosPostReservaBean> servicios) {
		this.servicios = servicios;
	}

	public int getRegimen_comidas() {
		return regimen_comidas;
	}

	public void setRegimen_comidas(int regimen_comidas) {
		this.regimen_comidas = regimen_comidas;
	}

	public String getNombre_hotel() {
		return nombre_hotel;
	}

	public void setNombre_hotel(String nombre_hotel) {
		this.nombre_hotel = nombre_hotel;
	}

	public String getNombre_habitacion() {
		return nombre_habitacion;
	}

	public void setNombre_habitacion(String nombre_habitacion) {
		this.nombre_habitacion = nombre_habitacion;
	}
}
