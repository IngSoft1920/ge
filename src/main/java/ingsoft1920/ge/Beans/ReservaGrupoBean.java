package ingsoft1920.ge.Beans;

import org.springframework.stereotype.Component;

//Con la etiqueta component especificamos que esta clase es un Bean 
@Component
public class ReservaGrupoBean {
	String nombreGrupo;
	String tipoGrupo;
	String email;
	String method = "reservaGrupo";
	int numeroHabitaciones;
	
	
	//En un bean siempre es necesario el constructor vacio
	public ReservaGrupoBean() {
		
	}
	

	public String getNombreGrupo() {
		return nombreGrupo;
	}



	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}



	public String getTipoGrupo() {
		return tipoGrupo;
	}



	public void setTipoGrupo(String tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getNumeroHabitaciones() {
		return numeroHabitaciones;
	}



	public void setNumeroHabitaciones(int numeroHabitaciones) {
		this.numeroHabitaciones = numeroHabitaciones;
	}



	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
}