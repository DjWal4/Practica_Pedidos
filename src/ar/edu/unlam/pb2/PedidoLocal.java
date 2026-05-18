package ar.edu.unlam.pb2;

public class PedidoLocal extends Pedido {

	public PedidoLocal( Integer codigoDePedido, String cliente) {
		super(codigoDePedido, cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double getTotal() {
		
		Double total=0.0;
    	for (Producto producto : items) {
			total += producto.getPrecio();
			
		}
    	return total;
	}


	
	

}
