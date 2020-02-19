package ingsoft1920.ge.BeansGE1;

public class CheckInBean {
	private String idReserva;
	private String horaLlegada;
	private String comentario;
	
	
	
	public CheckInBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CheckInBean(String idReserva, String horaLlegada, String comentario) {
		super();
		this.idReserva = idReserva;
		this.horaLlegada = horaLlegada;
		this.comentario = comentario;
	}
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	

}
