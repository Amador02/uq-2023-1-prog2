package co.edu.uniquindio.taller2.model;

import java.util.ArrayList;
import java.util.List;

public class Banco {

	protected String nombre;
	protected String direccion;
	protected String codigo;
	protected List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

	public Banco(String nombre, String direccion, String codigo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	public Banco() {
	}

	public Cuenta buscarCuenta(String codigo) {
		return getListaCuentas().stream().filter(cadaCuenta -> cadaCuenta.getCodigo().equals(codigo)).findFirst()
				.orElse(null);
	}

	public void agregarCuentaAhorros(String codigo, float saldo, float tasaAnual) throws CuentaException {
		if (validarCuenta(codigo)) {
			throw new CuentaException("La cuenta ya existe (" + codigo + ")");
		}
		getListaCuentas().add(new CuentaAhorros(codigo, saldo, tasaAnual));
	}

	public void agregarCuentaCorriente(String codigo, float saldo, float tasaAnual) throws CuentaException {
		if (validarCuenta(codigo)) {
			throw new CuentaException("La cuenta ya existe (" + codigo + ")");
		}
		getListaCuentas().add(new CuentaCorriente(codigo, saldo, tasaAnual));
	}

	public void eliminarCuenta(String codigo) throws CuentaException {
		if (!validarCuenta(codigo)) {
			throw new CuentaException("La cuenta no existe (" + codigo + ")");
		}
	}

	public List<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	public boolean validarCuenta(String codigo) {
		return buscarCuenta(codigo) != null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
