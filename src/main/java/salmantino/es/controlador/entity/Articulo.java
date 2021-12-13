package salmantino.es.controlador.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="articulos", schema="GESTIONPEDIDOSBDD")

public class Articulo {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="idArticulo")
		private int idArticulo;
		
		@Column(name="nombre")
		private String nombre;
		

		@Column(name="descripcion")
		private String descripcion;
		
		@Column(name="stock")
		private int stock;
		
		@Column(name="precio")
		private double precio;
		

		/**
		 * 
		 */
		public Articulo() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param idArticulo
		 * @param nombrePedido
		 * @param descripcion
		 * @param stock
		 * @param precio
		 */
		public Articulo(int idArticulo, String nombre, String descripcion, int stock, double precio) {
			this.idArticulo = idArticulo;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.stock = stock;
			this.precio = precio;
		}

		/**
		 * @return the idArticulo
		 */
		public int getIdArticulo() {
			return idArticulo;
		}

		/**
		 * @param idArticulo the idArticulo to set
		 */
		public void setIdArticulo(int idArticulo) {
			this.idArticulo = idArticulo;
		}

		/**
		 * @return the nombre
		 */
		public String getNombre() {
			return nombre;
		}

		/**
		 * @param nombrePedido the nombre to set
		 */
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		/**
		 * @return the descripcion
		 */
		public String getDescripcion() {
			return descripcion;
		}

		/**
		 * @param descripcion the descripcion to set
		 */
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		/**
		 * @return the stock
		 */
		public int getStock() {
			return stock;
		}

		/**
		 * @param stock the stock to set
		 */
		public void setStock(int stock) {
			this.stock = stock;
		}

		/**
		 * @return the precio
		 */
		public double getPrecio() {
			return precio;
		}

		/**
		 * @param precio the precio to set
		 */
		public void setPrecio(double precio) {
			this.precio = precio;
		}

		@Override
		public String toString() {
			return "Pedidos [idArticulo=" + idArticulo + ", nombrePedido=" + nombre + ", descripcion="
					+ descripcion + ", stock=" + stock + ", precio=" + precio + "]";
		}
		
		
		
		
}
