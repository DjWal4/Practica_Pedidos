package ar.edu.unlam.pb2;

import java.util.Objects;

public class Producto {

	private Integer codigo;
	private String nombre;
	private Double precio;
	
	public Producto(Integer codigo, String nombre, Double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	public Integer getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
}
