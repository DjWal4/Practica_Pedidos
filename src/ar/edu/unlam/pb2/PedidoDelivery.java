package ar.edu.unlam.pb2;

public class PedidoDelivery extends Pedido {
	
	private Double precioDeEnvio;

	public PedidoDelivery(Integer codigoDePedido, String cliente,Double precioDeEnvio) {
		super(codigoDePedido, cliente);
		this.precioDeEnvio = precioDeEnvio;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getTotal() {
		Double total = 0.0;
		for (Producto pro : items) {
			total += pro.getPrecio();
		}
		return total + this.precioDeEnvio;
	}

}
