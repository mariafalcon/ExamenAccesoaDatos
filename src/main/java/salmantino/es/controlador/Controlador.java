package salmantino.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import salmantino.es.controlador.entity.Articulo;
import salmantino.es.controlador.entity.Cliente;
import salmantino.es.controlador.entity.vPedidos;
import salmantino.es.controlador.entity.Pedidos;
import salmantino.es.controlador.entity.VArticulo;
import salmantino.es.dao.ArticuloDAO;
import salmantino.es.dao.ClienteDAO;
import salmantino.es.dao.vPedidoDAO;
import salmantino.es.dao.PedidoDAO;
import salmantino.es.dao.VArticuloDAO;

@Controller
@RequestMapping("/cliente")
public class Controlador {

	@RequestMapping("/lista")
	public String listaClientes(Model modelo) {
		List<Cliente> losClientes = clienteDAO.getClientes();
		modelo.addAttribute("clientes",losClientes);
		return "lista-clientes";
	}
	
	
	
	@RequestMapping("/muestraFormularioAgregar")
	public String muestraFormularioAgregar(Model modelo) {
		Cliente elCliente = new Cliente();
		modelo.addAttribute("cliente", elCliente);
		
		return "formularioCliente";
	}
	
	@PostMapping("/insertar")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		clienteDAO.insertarCliente(elCliente);
		return "redirect:/cliente/lista";
	}
	
	@GetMapping("/muestraFormularioActualizar")
	public String muestraformularioActualizar(@RequestParam("clienteId") int Id, Model elModelo) {
		
		Cliente elCliente= clienteDAO.getCliente(Id);
		
		elModelo.addAttribute("cliente",elCliente);
		
		System.out.println(Id);
		
		return "formularioCliente";
		
	}
	
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("clienteId") int Id) {
		clienteDAO.eliminarCliente(Id);
		
		
		return "redirect:/cliente/lista";
	}
	
   // A PARTIR DE AQUÍ ESTÁN LOS MÉTODOS DEL CONTROLADOR DE PEDIDOS
	
	
	@GetMapping("/lista2")
	public String MostrarLista(Model modelo) {
		
		List<vPedidos> losPedidos = vpedidoDAO.getPedidos();
		modelo.addAttribute("pedidos",losPedidos);
		return "lista-pedidos";
		
	}
	
	@RequestMapping("/muestraFormularioAgregarP")
	public String muestraFormularioAgregarP(Model modelo) {
		Pedidos pedido = new Pedidos();
		modelo.addAttribute("pedido", pedido);
		
		return "Formulariopedido";
	}
	
	

	@PostMapping("/insertarPedido")
	public String insertarPedido(@ModelAttribute("pedido") Pedidos elpedido) {
		pedidoDAO.insertarPedido(elpedido);
		return "redirect:/cliente/lista2";
	}
	
	@GetMapping("/eliminarPedido")
	public String eliminarpedido(@RequestParam("idPedido") int Id) {
		
		pedidoDAO.eliminarPedido(Id);
		
		return "redirect:/cliente/lista2";
	}
	
	@GetMapping("/muestraFormularioActualizarPedidos")
	public String muestraformularioActualizarP(@RequestParam("idPedido") int Id, Model elModelo) {
		
		Pedidos Elpedido= pedidoDAO.getPedido(Id);
		
		elModelo.addAttribute("pedido", Elpedido);
		
		System.out.println(Id);
		
		return "Formulariopedido";
		
	}
	
	
	
	//A PARTIR DE AQUÍ ESTARÁN LOS MÉTODOS DE CONTROLADOR DE ARTÍCULOS
	
	@GetMapping("/lista3")
	public String MostrarListaArt(Model modelo) {
		
		List<VArticulo> losArticulos = varticuloDAO.getArticulos();
		modelo.addAttribute("articulos",losArticulos);
		return "lista-articulos";
		
	}
	
	@RequestMapping("/muestraFormularioAgregarA")
	public String muestraFormularioAgregarA(Model modelo) {
		Articulo articulo = new Articulo();
		modelo.addAttribute("articulo", articulo);
		
		return "formularioArticulo";
	}
	
	

	@PostMapping("/insertarArticulo")
	public String insertarArticulo(@ModelAttribute("articulo") Articulo elArticulo) {
		articuloDAO.insertarArticulo(elArticulo);
		return "redirect:/cliente/lista3";
	}
	
	@GetMapping("/eliminarArticulo")
	public String eliminarArticulo(@RequestParam("idArticulo") int Id) {
		System.out.println("ENTRO");
		articuloDAO.eliminarArticulo(Id);
		
		return "redirect:/cliente/lista3";
	}
	
	@GetMapping("/muestraFormularioActualizarArticulos")
	public String muestraformularioActualizarA(@RequestParam("idArticulo") int Id, Model elModelo) {
		
		Articulo elarticulo = articuloDAO.getArticulo(Id);
		
		elModelo.addAttribute("articulo", elarticulo);
		
		System.out.println(Id);
		
		return "formularioArticulo";
		
	}
	
	
	
	
	
	
	
	

	@Autowired
	private PedidoDAO pedidoDAO;
	
	@Autowired
	private vPedidoDAO vpedidoDAO;
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private VArticuloDAO varticuloDAO;
	
	@Autowired
	private ArticuloDAO articuloDAO;
	
	

}
