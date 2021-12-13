package Modelo;
/**
 * 
 */

/**
 * @author Alumno
 *
 */
public class Usuario {
	
	
	public int idusuario;
	public String nombre;
	public String apellido1;
	public String apellido2;
	public String dni;
	public String borrado;
	public String correo;
	
	/**
	 * @return the correo
	 */
	

	/**
	 * @param idusuario
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param dni
	 * @param correo
	 * @param borrado
	 */
	public Usuario(int idusuario, String nombre, String apellido1,
			String apellido2, String dni,String borrado, String correo) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.borrado = borrado;
		this.correo = correo;
	}
	
	/**
	 * 
	 */
	public Usuario() {
		super();
	}
	
	/**
	 * @return the idusuario
	 */
	public int getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String getBorrado() {
		return borrado;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setBorrado(String borrado) {
		this.borrado = borrado;
	}
	
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre=" + nombre
				+ ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", dni=" + dni + ", borrado=" + borrado + ", correo= " + correo+"]";
	}
	
	
	

}
