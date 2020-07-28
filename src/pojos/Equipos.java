package pojos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipos {
	@Id
	private String nombre;
	private String ciudad;
	private String conferencia;
	private String division;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "equipos_Nombre")
	private Entrenadores entrenador;
	
	public Equipos() {
		
	}
	
	public Equipos(String n, String c, String conf, String d) {
		this.nombre = n;
		this.ciudad = c;
		this.conferencia = conf;
		this.division = d;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getConferencia() {
		return conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Entrenadores getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenadores entrenador) {
		this.entrenador = entrenador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ciudad == null) ? 0 : ciudad.hashCode());
		result = prime * result + ((conferencia == null) ? 0 : conferencia.hashCode());
		result = prime * result + ((division == null) ? 0 : division.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipos other = (Equipos) obj;
		if (ciudad == null) {
			if (other.ciudad != null)
				return false;
		} else if (!ciudad.equals(other.ciudad))
			return false;
		if (conferencia == null) {
			if (other.conferencia != null)
				return false;
		} else if (!conferencia.equals(other.conferencia))
			return false;
		if (division == null) {
			if (other.division != null)
				return false;
		} else if (!division.equals(other.division))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipos [nombre=" + nombre + ", ciudad=" + ciudad + ", conferencia=" + conferencia + ", division="
				+ division + ", entrenador=" + entrenador + "]";
	}
	
}
