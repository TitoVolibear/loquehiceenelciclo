package pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrenadores")
public class Entrenadores {
	@Id
	private String dni;
	private String nombre;
	private Integer nume_carnet;
	private Date fecha;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "equipos")
	private Equipos equipos_Nombre;
	
	public Entrenadores() {
		
	}
	
	public Entrenadores(String dni, String n, Integer nCarnet, Date f, Equipos nomeq) {
		this.dni = dni;
		this.nombre = n;
		this.nume_carnet = nCarnet;
		this.fecha = f;
		this.equipos_Nombre = nomeq;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNume_carnet() {
		return nume_carnet;
	}

	public void setNume_carnet(Integer nume_carnet) {
		this.nume_carnet = nume_carnet;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Equipos getEquipos_Nombre() {
		return equipos_Nombre;
	}

	public void setEquipos_Nombre(Equipos equipos_Nombre) {
		this.equipos_Nombre = equipos_Nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((nume_carnet == null) ? 0 : nume_carnet.hashCode());
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
		Entrenadores other = (Entrenadores) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (nume_carnet == null) {
			if (other.nume_carnet != null)
				return false;
		} else if (!nume_carnet.equals(other.nume_carnet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entrenadores [dni=" + dni + ", nombre=" + nombre + ", nume_carnet=" + nume_carnet + ", fecha=" + fecha
				+ ", equipos_Nombre=" + equipos_Nombre + "]";
	}
	
}
