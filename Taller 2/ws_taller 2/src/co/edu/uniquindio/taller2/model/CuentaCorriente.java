package co.edu.uniquindio.taller2.model;

public class CuentaCorriente extends Cuenta {

	protected float sobregiro = 0f;

	/**
	 * Es el constructor de la cuenta corriente
	 *
	 * @param saldo
	 * @param tasaAnual
	 */
	public CuentaCorriente(float saldo, float tasaAnual) {
		super(saldo, tasaAnual);
	}

	public float getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(float sobregiro) {
		this.sobregiro = sobregiro;
	}

	@Override
	public void consignarDinero(float saldo) throws CuentaException {
		super.consignarDinero(saldo);
	}

	@Override
	public void retirarDinero(float saldo) throws CuentaException {
		super.retirarDinero(saldo);
	}

	public boolean haySobregiro() {
		return getSobregiro() > 0;
	}

	public String imprimir() {
		return toString();
	}

}
