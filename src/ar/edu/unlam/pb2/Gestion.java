package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Gestion {

	private String nombre;
	private HashSet<Producto> catolgo;
	private List<Pedido> colaDePedido;
	private Double costoFinal;

	public Gestion(String nombre) {
		this.nombre = nombre;
		this.catolgo = new HashSet<>();
		this.colaDePedido = new LinkedList<Pedido>();
		this.costoFinal = 0.0;
	}

	public String getNombre() {
		return nombre;
	}

	public Boolean agregarProductoAlCatalogo(Producto hamburguesa) {

		return this.catolgo.add(hamburguesa);

	}

	public Producto buscarProductoPorCodigo(Integer i) {

		for (Producto producto : catolgo) {

			if (producto.getCodigo() == i) {
				return producto;
			}

		}

		return null;
	}

	public void agregarPedidoACola(Pedido p) {
		this.colaDePedido.add(p);

	}

	public Double calcularTotalPendiente() {
		Double total = 0.0;
		for (Pedido pedi : colaDePedido) {
			total += pedi.getTotal();
		}
		return total;
	}

	public void procesarProximoPedido() {
		Pedido pendidoPendiente = colaDePedido.remove(0);
		costoFinal = pendidoPendiente.getTotal();
	}

	public int getCantidadPedidosPendientes() {
		// TODO Auto-generated method stub
		return this.colaDePedido.size();
	}

	public Double getTotalFacturado() {
		// TODO Auto-generated method stub
		return this.costoFinal;
	}

}
