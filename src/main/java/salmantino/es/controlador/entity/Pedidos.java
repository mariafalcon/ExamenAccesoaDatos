package salmantino.es.controlador.entity;

import javax.persistence.*;

@Entity
@Table(name="pedidos", schema="GESTIONPEDIDOSBDD")
public class Pedidos {
	
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
	
	
	

	
	public Pedidos() {
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
	public Pedidos(int idPedido, String numpedido, String fecha, double importe, double descuento, int idCliente) {
		super();
		this.idPedido = idPedido;
		this.numpedido = numpedido;
		this.fecha = fecha;
		this.importe = importe;
		this.descuento = descuento;
		this.idCliente = idCliente;
		
	}

	/**
	 * @return the idPedido
	 */
	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * @param idPedido the idPedido to set
	 */
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * @return the numpedido
	 */
	public String getNumpedido() {
		return numpedido;
	}
	
	
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

	@Override
	public String toString() {
		return "Pedidos2 [idPedido=" + idPedido + ", numpedido=" + numpedido + ", fecha=" + fecha + ", importe="
				+ importe + ", descuento=" + descuento + ", idCliente=" + idCliente + "]";
	}
	   
	


	
	
	

}
