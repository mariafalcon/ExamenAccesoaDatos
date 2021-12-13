package salmantino.es.controlador.entity;

import javax.persistence.*;

@Entity
@Table(name="vpedidos", schema="GESTIONPEDIDOSBDD")
public class vPedidos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPedido")
	private int idPedido;
	
	@Column(name="numpedido")
	private String numpedido;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="importe")
	private double importe;
	
	@Column(name="descuento")
	private double descuento;
	
	@Column(name="idCliente")
	private int idCliente;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	

	@Column(name="email")
	private String email;
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
	 * @return the apellido
	 */

	
	
	public vPedidos() {
		super();
	}
	/**
	 * @param idPedido
	 * @param numpedido
	 * @param fecha
	 * @param importe
	 * @param descuento
	 * @param idCliente
	 */
	
	/**
	 * @param idPedido the idPedido to set
	 */

	
	/*
	 * @return the numpedido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param idPedido
	 * @param numpedido
	 * @param fecha
	 * @param importe
	 * @param descuento
	 * @param idCliente
	 * @param nombre
	 * @param apellido
	 * @param email
	 */
	public vPedidos(int idPedido, String numpedido, String fecha, double importe, double descuento, int idCliente,
			String nombre, String apellido, String email) {
		super();
		this.idPedido = idPedido;
		this.numpedido = numpedido;
		this.fecha = fecha;
		this.importe = importe;
		this.descuento = descuento;
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getNumpedido() {
		return numpedido;
	}
	/**
	 * @param numpedido the numpedido to set
	 */
	public void setNumpedido(String numpedido) {
		this.numpedido = numpedido;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
	}
	/**
	 * @return the descuento
	 */
	public double getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", numpedido=" + numpedido + ", fecha=" + fecha + ", importe="
				+ importe + ", descuento=" + descuento + ", idCliente=" + idCliente + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", email=" + email + "]";
	}

	

	
	
	
	
	
	
	
	

}
