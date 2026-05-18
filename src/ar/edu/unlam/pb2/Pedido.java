package ar.edu.unlam.pb2;

import java.util.ArrayList;

public abstract class Pedido {

	private String cliente;
	private Integer codigoDePedido;
    protected ArrayList<Producto> items;

	public Pedido(Integer codigoDePedido, String cliente) {
		this.cliente = cliente;
		this.codigoDePedido = codigoDePedido;
		this.items = new ArrayList<>();
	}

	public String getCliente() {
		return cliente;
	}

	public Integer getCodigoDePedido() {
		return codigoDePedido;
	}

	public Boolean agregarProducto(Producto producto) {
		return this.items.add(producto);
	}

	public abstract Double getTotal();

	public ArrayList<Producto> getItems(){
		return items;
	}
}
