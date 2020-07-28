package pojos;

public class Espacio {
	private Integer idespacio;
	private String nombre;
	private String descripcion;
	private Integer padre;
	
	public Espacio() {
		
	}
	
	public Espacio(Integer idespacio, String nombre, String descripcion, Integer padre) {
		this.idespacio = idespacio;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.padre = padre;
	}

	public Integer getIdespacio() {
		return idespacio;
	}

	public void setIdespacio(Integer idespacio) {
		this.idespacio = idespacio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPadre() {
		return padre;
	}

	public void setPadre(Integer padre) {
		this.padre = padre;
	}
	
	public String toString() {
		return "Espacio [idespacio=" + idespacio + ", nombre=" + nombre + ", descripcion=" + descripcion + ", padre=" + padre + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idespacio == null) ? 0 : idespacio.hashCode());
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
		Espacio other = (Espacio) obj;
		if (idespacio == null) {
			if (other.idespacio != null)
				return false;
		} else if (!idespacio.equals(other.idespacio))
			return false;
		return true;
	}
	
}
