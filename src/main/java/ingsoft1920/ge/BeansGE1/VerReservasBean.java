package ingsoft1920.ge.BeansGE1;
import org.springframework.stereotype.Component;


@Component
public class VerReservasBean {

	private int id_reserva;
	private int num_hab;
	private String fecha_inicio;
	private String fecha_fin;
	private String nombre_hotel;
	
	private int tarjeta_credito;
	
	@Override
	public String toString() {
		return "VerReservasBean [id_reserva=" + id_reserva + ", num_hab=" + num_hab + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", nombre_hotel=" + nombre_hotel + "]";
	}
	public VerReservasBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VerReservasBean(int id_reserva, int num_hab, String fecha_inicio, String fecha_fin, String nombre_hotel) {
		super();
		this.id_reserva = id_reserva;
		this.num_hab = num_hab;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.nombre_hotel = nombre_hotel;
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public int getNum_hab() {
		return num_hab;
	}
	public void setNum_hab(int num_hab) {
		this.num_hab = num_hab;
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
	public String getNombre_hotel() {
		return nombre_hotel;
	}
	public void setNombre_hotel(String nombre_hotel) {
		this.nombre_hotel = nombre_hotel;
	}
	
	
	

}
