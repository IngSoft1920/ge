package Objetillos;

public class ReservaGE2 {
	
	private int reserva_id;
	private int hotel_id;
	private int tipo_hab_id;
	private int importe;
	private String regimen;
	private String fecha_entrada;
	private String fecha_salida;
	
	public ReservaGE2(int reserva_id, int hotel_id, int tipo_hab_id, int importe, String regimen,
			String fecha_entrada, String fecha_salida) {
		super();
		this.reserva_id = reserva_id;
		this.hotel_id = hotel_id;
		this.tipo_hab_id = tipo_hab_id;
		this.importe = importe;
		this.regimen = regimen;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
	}
	
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
	public int getTipo_hab_id() {
		return tipo_hab_id;
	}
	public void setTipo_hab_id(int tipo_hab_id) {
		this.tipo_hab_id = tipo_hab_id;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
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
	
}