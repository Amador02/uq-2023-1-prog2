package co.edu.uniquindio.centroimpresion.model.centro;

public enum TipoEmpleado {
	ADMINISTRADOR("Administrador", true, true, true, true, true, true, true, true),
	SUPERVISOR("Supervisor", false, true, false, true, true, true, false, true),
	TRABAJADOR("Trabajador", false, false, false, false, false, false, false, false);

	private boolean puedeAgregarImpresora;
	private boolean puedeEliminarDocumentos;
	private boolean puedeEliminarImpresoras;
	private boolean puedeVerImpresoras;
	private boolean puedeVerDocs;
	private boolean puedeImprimirDocEsprcifico;
	private String text;
	private boolean puedeSeleccionarImpresora;
	private boolean puedePuedeActualizarDocumento;

	private TipoEmpleado(String text, boolean puedeAgregarImpresora, boolean puedeEliminarDocumentos,
			boolean puedeEliminarImpresoras, boolean puedeVerImpresoras, boolean puedeVerDocs,
			boolean puedeImprimirDocEsprcifico, boolean puedePuedeActualizarDocumento,
			boolean puedeSeleccionarImpresora) {
		this.text = text;
		this.puedeAgregarImpresora = puedeAgregarImpresora;
		this.puedeEliminarDocumentos = puedeEliminarDocumentos;
		this.puedeEliminarImpresoras = puedeEliminarImpresoras;
		this.puedeVerImpresoras = puedeVerImpresoras;
		this.puedeVerDocs = puedeVerDocs;
		this.puedeImprimirDocEsprcifico = puedeImprimirDocEsprcifico;
		this.puedePuedeActualizarDocumento = puedePuedeActualizarDocumento;
		this.puedeSeleccionarImpresora = puedeSeleccionarImpresora;
	}

	public String getText() {
		return text;
	}

	public boolean puedeAgregarImpresora() {
		return puedeAgregarImpresora;
	}

	public boolean puedeEliminarDocumentos() {
		return puedeEliminarDocumentos;
	}

	public boolean puedeEliminarImpresoras() {
		return puedeEliminarImpresoras;
	}

	public boolean puedeVerImpresoras() {
		return puedeVerImpresoras;
	}

	public boolean puedeVerDocs() {
		return puedeVerDocs;
	}

	public boolean puedeImprimirDocEspecifico() {
		return puedeImprimirDocEsprcifico;
	}

	public boolean puedeSeleccionarImpresora() {
		return puedeSeleccionarImpresora;
	}

	public boolean puedePuedeActualizarDocumento() {
		return puedePuedeActualizarDocumento;
	}
}
