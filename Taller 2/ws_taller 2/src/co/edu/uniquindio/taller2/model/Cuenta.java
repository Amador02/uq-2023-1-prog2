package co.edu.uniquindio.taller2.model;

public abstract class Cuenta {
	protected float saldo = 0f;
	protected int numConsignaciones = 0;
	protected int numRetiros = 0;
	protected float tasaAnual = 0f;
	protected float comisionMensual = 0f;

	/**
	 * Es el constructor de la cuenta
	 *
	 * @param saldo
	 * @param tasaAnual
	 */
	public Cuenta(float saldo, float tasaAnual) {
		this.saldo = saldo;
		this.tasaAnual = tasaAnual;
	}

	/**
	 *
	 * @param saldo
	 * @return
	 */
	public String consignarDinero(float saldo) {
		setSaldo(getSaldo() + saldo);
		return "Se consign� " + saldo + ", ahora tienes: " + this.saldo;
	}

	/**
	 *
	 * @param saldo
	 * @return
	 * @throws CuentaException
	 */
	public String retirarDinero(float saldo) throws CuentaException {
		if (getSaldo() < saldo) {
			throw new CuentaException("El saldo a retirar no puede sobrepasar el saldo actual");
		}
		return "Se consign� " + saldo + ", ahora tienes: " + this.saldo;
	}

	/**
	 *
	 * @return
	 */
	public abstract float calcularIntereses();

	/**
	 *
	 */
	public void extractoMensual() {

	}

	/**
	 *
	 * @return
	 */
	public String imprimir() {
		return toString();
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumConsignaciones() {
		return numConsignaciones;
	}

	public void setNumConsignaciones(int numConsignaciones) {
		this.numConsignaciones = numConsignaciones;
	}

	public int getNumRetiros() {
		return numRetiros;
	}

	public void setNumRetiros(int numRetiros) {
		this.numRetiros = numRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}

	public static String darFormato(String format, Object... args) {
		return String.format(format, args).replace(',', '.');
	}

	public static String darFormatoDinero(Object... args) {
		return "$" + darFormato("%.2f", args);
	}

	public int getNumTransacciones() {
		return getNumConsignaciones() + getNumRetiros();
	}

	@Override
	public String toString() {
		return "Cuenta [saldo=" + saldo + ", numConsignaciones=" + numConsignaciones + ", numRetiros=" + numRetiros
				+ ", tasaAnual=" + tasaAnual + ", comisionMensual=" + comisionMensual + "]";
	}
}
