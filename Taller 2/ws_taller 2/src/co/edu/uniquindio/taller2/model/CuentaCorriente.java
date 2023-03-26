package co.edu.uniquindio.taller2.model;

public class CuentaCorriente extends Cuenta {

	protected float sobregiro = 0f;

	/**
	 * Es el constructor de la cuenta corriente
	 *
	 * @param codigo
	 * @param saldo
	 * @param tasaAnual
	 */
	public CuentaCorriente(String codigo, float saldo, float tasaAnual) {
		super(codigo, saldo, tasaAnual);
	}

	public float getSobregiro() {
		return sobregiro;
	}

	public void setSobregiro(float sobregiro) {
		this.sobregiro = sobregiro;
	}

	@Override
	public void consignarDinero(float saldo) throws CuentaException {
		if (haySobregiro()) {
			if (getSobregiro() >= saldo) {
				setSobregiro(getSobregiro() - saldo);
			} else {
				setSaldo(saldo - getSobregiro());
				setSobregiro(0f);
			}
		} else {
			super.consignarDinero(saldo);
		}
	}

	@Override
	public void retirarDinero(float saldo) throws CuentaException {
		if (haySobregiro()) {
			setSobregiro(getSobregiro() + saldo);
		} else {
			if (saldo > getSaldo()) {
				setSobregiro(saldo - getSaldo());
				setSaldo(0f);
			}
		}
	}

	public boolean haySobregiro() {
		return getSobregiro() > 0;
	}

	@Override
	public String imprimir() {
		return toString();
	}

}