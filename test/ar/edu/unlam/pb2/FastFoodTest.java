package ar.edu.unlam.pb2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FastFoodTest {

	private Gestion gestion;

	@Before
	public void setUp() {
		this.gestion = new Gestion("FastFood");

		Producto hamburguesa = new Producto(1, "Hamburguesa", 500.0);

		gestion.agregarProductoAlCatalogo(hamburguesa);

		Producto coca = new Producto(2, "Coca", 100.0);
		gestion.agregarProductoAlCatalogo(coca);

		Producto papas = new Producto(3, "Papas", 200.0);
		gestion.agregarProductoAlCatalogo(papas);
	}

	@Test
	public void queSePuedaBuscarUnProductoEnElCatalogo() {
		Producto encontrado = gestion.buscarProductoPorCodigo(1);
		assertNotNull(encontrado);
		assertEquals("Hamburguesa", encontrado.getNombre());
	}

	@Test
	public void queSePuedaAgregarUnProductoAlCatalogo() {
		Producto nuevo = new Producto(4, "Agua", 50.0);
		assertTrue(gestion.agregarProductoAlCatalogo(nuevo));
	}

	@Test
	public void queNoSePuedanRepetirProductosEnCatalogo() {
		// El código 1 ya fue agregado en el setUp
		Producto repetido = new Producto(1, "Hamburguesa Doble", 800.0);
		assertFalse(gestion.agregarProductoAlCatalogo(repetido));
	}

	@Test
	public void queUnPedidoPuedaTenerProductosRepetidosYCalculeElTotal() {
		// Usamos PedidoLocal para probar la lógica de productos repetidos
		Pedido pedido = new PedidoLocal(1, "Juan");

		// Recuperamos el producto del sistema
		Producto bebida = gestion.buscarProductoPorCodigo(2);

		pedido.agregarProducto(bebida);
		pedido.agregarProducto(bebida);

		assertEquals(200.0, pedido.getTotal(), 0.01);
		assertEquals(2, pedido.getItems().size());

	}

	@Test
	public void queSePuedaCalcularElTotalPendienteDeLosPedidosEnCola() {
		Producto burger = gestion.buscarProductoPorCodigo(1); // 500
		Producto soda = gestion.buscarProductoPorCodigo(2); // 100

		Pedido p1 = new PedidoLocal(1, "Juan");
		p1.agregarProducto(burger);

		Pedido p2 = new PedidoDelivery(2, "Ana", 150.0);
		p2.agregarProducto(soda); // 250

		gestion.agregarPedidoACola(p1);
		gestion.agregarPedidoACola(p2);

		// El total pendiente debe ser 750 (500 + 250)
		assertEquals(750.0, gestion.calcularTotalPendiente(), 0.01);
	}

	@Test
	public void queAlProcesarUnPedidoSeActualiceElTotalFacturado() {
		
		Producto burger = gestion.buscarProductoPorCodigo(1); // 500
		Producto soda = gestion.buscarProductoPorCodigo(2); // 100

		Pedido p1 = new PedidoLocal(1, "Juan");
		p1.agregarProducto(burger);

		Pedido p2 = new PedidoDelivery(2, "Ana", 150.0);
		p2.agregarProducto(soda); // 250

		Producto p = new Producto(50, "asd", 0d);
		p1.agregarProducto(p);

		gestion.agregarPedidoACola(p1);
		gestion.agregarPedidoACola(p2);

		gestion.procesarProximoPedido();
		// ver que haya 1 pedido pendiente
		assertEquals(1, gestion.getCantidadPedidosPendientes());
		// verificar el total
		assertEquals(Double.valueOf(500d), gestion.getTotalFacturado());

	}

}
