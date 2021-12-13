package salmantino.es.controlador.entity;
import javax.persistence.*;
@Entity
@Table(name="cliente", schema="GESTIONPEDIDOSBDD")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	/**
	 * 
	 */
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="email")
	private String email;
	
	/**
	 * @return the apellido
	 */
	

	@Column(name="apellido")
	private String apellido;
	

	public Cliente() {
	
		
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + ", apellido=" + apellido + "]";
	}

	
	

}
