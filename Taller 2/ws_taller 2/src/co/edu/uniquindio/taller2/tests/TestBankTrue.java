package co.edu.uniquindio.taller2.tests;

import org.junit.Test;

import co.edu.uniquindio.taller2.model.Banco;
import co.edu.uniquindio.taller2.model.CuentaException;

public class TestBankTrue {
	public Banco bank = new Banco("Bancolombia", "Cra 9 # 23 - 01", "AB-001");

	@Test
	public void TestBancoAgregarCuenta1() throws CuentaException {

		// Agrega una cuenta de ahorros
		bank.agregarCuentaAhorros("A001", 0, 0);
		// Agrega una cuenta de ahorros con diferente c�digo
		bank.agregarCuentaAhorros("A002", 0, 0);
	}
}
