package pojos;

public class ModeloArticulo {

	private int idmodeloarticulo;
	private String nombre;
	private String descripcion;
	private String marca;
	private String modelo;
	private int tipo;
	
	public ModeloArticulo() {}

	public ModeloArticulo(int idmodeloarticulo, String nombre,
			String descripcion, String marca, String modelo, int tipo) {
		super();
		this.idmodeloarticulo = idmodeloarticulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
	}

	public int getIdmodeloarticulo() {
		return idmodeloarticulo;
	}

	public void setIdmodeloarticulo(int idmodeloarticulo) {
		this.idmodeloarticulo = idmodeloarticulo;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idmodeloarticulo;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + tipo;
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
		ModeloArticulo other = (ModeloArticulo) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idmodeloarticulo != other.idmodeloarticulo)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	
}
