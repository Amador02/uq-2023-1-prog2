package co.edu.uniquindio.centroimpresion.exceptions;

public class ObjectNotExists extends Exception {
	private Class<?> clase;

	public ObjectNotExists(Class<?> clase) {
		super("No se ha encontrado el objeto de clase " + clase.getSimpleName());
		this.clase = clase;
	}

	public Class<?> getClase() {
		return clase;
	}
}