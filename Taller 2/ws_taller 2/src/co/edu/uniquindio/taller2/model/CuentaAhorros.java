package co.edu.uniquindio.taller2.model;

public class CuentaAhorros extends Cuenta {

	/**
	 * Es el constructor de la cuenta de ahorros
	 *
	 * @param saldo
	 * @param tasaAnual
	 */
	public CuentaAhorros(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
	}

	/**
	 * Determina si la cuenta de ahorros est� activa o no
	 *
	 * @return true si el saldo es mayor o igual a 10000
	 */
	public boolean estaActiva() {
		return getSaldo() >= 10000f;
	}

	@Override
	public void consignarDinero(float saldo) throws CuentaException {
		if (!estaActiva()) {
			throw new CuentaException("No se pudo consignar el dinero");
		}
		super.consignarDinero(saldo);
	}

	@Override
	public void retirarDinero(float saldo) throws CuentaException {
		super.retirarDinero(saldo);
	}

	@Override
	public void extractoMensual() throws CuentaException {
		super.extractoMensual();
	}

	public String imprimir() {
		return toString();
	}

	@Override
	public String toString() {
		return "CuentaAhorros[saldo:" + darFormatoDinero(saldo) + ", comision: " + darFormatoDinero(comisionMensual)
				+ ", numero de transacciones: " + getNumTransacciones() + "]";
	}

}