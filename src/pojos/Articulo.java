package pojos;

import java.util.Date;

public class Articulo {
	
	private int idArticulo;
	private String numserie;
	private String estado;
	private Date fechaalta;
	private Date fechabaja;
	private int usuarioalta;
	private int usuariobaja;
	private int modelo;
	private int departamento;
	private int espacio;
	private int dentrode;
	private String observaciones;
	
	public Articulo() {}
	
	public Articulo(int idArticulo, String numserie, String estado,
			Date fechaalta, Date fechabaja, int usuarioalta, int usuariobaja,
			int modelo, int departamento, int espacio, int dentrode,
			String observaciones) {
		super();
		this.idArticulo = idArticulo;
		this.numserie = numserie;
		this.estado = estado;
		this.fechaalta = fechaalta;
		this.fechabaja = fechabaja;
		this.usuarioalta = usuarioalta;
		this.usuariobaja = usuariobaja;
		this.modelo = modelo;
		this.departamento = departamento;
		this.espacio = espacio;
		this.dentrode = dentrode;
		this.observaciones = observaciones;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public String getNumserie() {
		return numserie;
	}

	public void setNumserie(String numserie) {
		this.numserie = numserie;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Date fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Date getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Date fechabaja) {
		this.fechabaja = fechabaja;
	}

	public int getUsuarioalta() {
		return usuarioalta;
	}

	public void setUsuarioalta(int usuarioalta) {
		this.usuarioalta = usuarioalta;
	}

	public int getUsuariobaja() {
		return usuariobaja;
	}

	public void setUsuariobaja(int usuariobaja) {
		this.usuariobaja = usuariobaja;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getEspacio() {
		return espacio;
	}

	public void setEspacio(int espacio) {
		this.espacio = espacio;
	}

	public int getDentrode() {
		return dentrode;
	}

	public void setDentrode(int dentrode) {
		this.dentrode = dentrode;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Articulo [idArticulo=" + idArticulo + ", numserie=" + numserie
				+ ", estado=" + estado + ", fechaalta=" + fechaalta
				+ ", fechabaja=" + fechabaja + ", usuarioalta=" + usuarioalta
				+ ", usuariobaja=" + usuariobaja + ", modelo=" + modelo
				+ ", departamento=" + departamento + ", espacio=" + espacio
				+ ", dentrode=" + dentrode + ", observaciones=" + observaciones
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dentrode;
		result = prime * result + departamento;
		result = prime * result + espacio;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((fechaalta == null) ? 0 : fechaalta.hashCode());
		result = prime * result
				+ ((fechabaja == null) ? 0 : fechabaja.hashCode());
		result = prime * result + idArticulo;
		result = prime * result + modelo;
		result = prime * result
				+ ((numserie == null) ? 0 : numserie.hashCode());
		result = prime * result
				+ ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + usuarioalta;
		result = prime * result + usuariobaja;
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
		Articulo other = (Articulo) obj;
		if (dentrode != other.dentrode)
			return false;
		if (departamento != other.departamento)
			return false;
		if (espacio != other.espacio)
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (fechaalta == null) {
			if (other.fechaalta != null)
				return false;
		} else if (!fechaalta.equals(other.fechaalta))
			return false;
		if (fechabaja == null) {
			if (other.fechabaja != null)
				return false;
		} else if (!fechabaja.equals(other.fechabaja))
			return false;
		if (idArticulo != other.idArticulo)
			return false;
		if (modelo != other.modelo)
			return false;
		if (numserie == null) {
			if (other.numserie != null)
				return false;
		} else if (!numserie.equals(other.numserie))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (usuarioalta != other.usuarioalta)
			return false;
		if (usuariobaja != other.usuariobaja)
			return false;
		return true;
	}
	
	

}
