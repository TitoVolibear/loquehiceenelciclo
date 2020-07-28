package pojos;

public class FicheroUsuario {
	private Integer idFicheroUsuario;
	private Integer usuario;
	private String nombre;
	private String tipo;
	public FicheroUsuario(){
		
	}
	public FicheroUsuario(Integer idFicheroUsuario, Integer usuario,
			String nombre, String tipo) {
		super();
		this.idFicheroUsuario = idFicheroUsuario;
		this.usuario = usuario;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	public Integer getIdFicheroUsuario() {
		return idFicheroUsuario;
	}
	public void setIdFicheroUsuario(Integer idFicheroUsuario) {
		this.idFicheroUsuario = idFicheroUsuario;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario= usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idFicheroUsuario == null) ? 0 : idFicheroUsuario.hashCode());
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
		FicheroUsuario other = (FicheroUsuario) obj;
		if (idFicheroUsuario == null) {
			if (other.idFicheroUsuario!= null)
				return false;
		} else if (!idFicheroUsuario.equals(other.idFicheroUsuario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FicheroUsuario [idFicheroUsuario=" + idFicheroUsuario
				+ ", usuario=" + usuario + ", nombre=" + nombre + ", tipo="
				+ tipo + "]";
	}

}
