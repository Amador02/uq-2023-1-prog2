package co.edu.uniquindio.centroimpresion.model;

public enum TipoAccion {
	AGREGAR("Agregar"), IMPRIMIR("Imprimir"), ELIMINAR("Eliminar"), VER("Ver"), ACERCA_DE("Acerca De");

	private String text;

	/**
	 * Es el constructor de la enumeracion {@link TipoAccion}
	 *
	 * @param text
	 */
	TipoAccion(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
