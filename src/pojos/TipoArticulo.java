package pojos;

public class TipoArticulo {
	
	private int idtipoarticulo;
	private String nombre;
	private int padre;
	
	public TipoArticulo() {}

	public TipoArticulo(int idtipoarticulo, String nombre, int padre) {
		super();
		this.idtipoarticulo = idtipoarticulo;
		this.nombre = nombre;
		this.padre = padre;
	}

	public int getIdtipoarticulo() {
		return idtipoarticulo;
	}

	public void setIdtipoarticulo(int idtipoarticulo) {
		this.idtipoarticulo = idtipoarticulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPadre() {
		return padre;
	}

	public void setPadre(int padre) {
		this.padre = padre;
	}

	@Override
	public String toString() {
		return getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idtipoarticulo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + padre;
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
		TipoArticulo other = (TipoArticulo) obj;
		if (idtipoarticulo != other.idtipoarticulo)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (padre != other.padre)
			return false;
		return true;
	}
	
	

}
