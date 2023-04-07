package co.edu.uniquindio.centroimpresion.controllers;

import co.edu.uniquindio.centroimpresion.exceptions.CentroImpresionException;
import co.edu.uniquindio.centroimpresion.exceptions.FueraRangoException;
import co.edu.uniquindio.centroimpresion.exceptions.ObjectNotExists;
import co.edu.uniquindio.centroimpresion.exceptions.TextIsEmptyException;
import co.edu.uniquindio.centroimpresion.model.archivos.SerializedData;
import co.edu.uniquindio.centroimpresion.model.centro.EstadoImpresora;
import co.edu.uniquindio.centroimpresion.model.centro.Impresora;
import co.edu.uniquindio.centroimpresion.model.centro.ImpresoraLaser;

public class CtrlPanelAddImpLaser {

	public static void agregarImpresoraLaser(String code, String marca, String estadoString, boolean esAColor,
			String paginasPorMinutoString, String duracionTonerString) throws CentroImpresionException,
			TextIsEmptyException, ObjectNotExists, NumberFormatException, FueraRangoException {
		ImpresoraLaser impresoraLaser = obtenerImpresoraLaser(code, marca, estadoString, esAColor,
				paginasPorMinutoString, duracionTonerString);
		SerializedData data = new SerializedData();
		if (impresoraLaser.exists()) {
			data.getCentroImpresion().agregarImpresoraLaser(impresoraLaser.getCode(), impresoraLaser.getMarca(),
					impresoraLaser.getEstado(), impresoraLaser.isEsAColor(), impresoraLaser.getPaginasPorMinuto(),
					impresoraLaser.getDuracionToner());
			data.updateCentroImpresion();
		}
	}

	/**
	 *
	 * @param code
	 * @param marca
	 * @param estadoString
	 * @param esAColor
	 * @param paginasPorMinutoString
	 * @param capacidadCartuchoString
	 * @param desgasteCartuchoString
	 * @return
	 * @throws TextIsEmptyException
	 * @throws ObjectNotExists
	 * @throws NumberFormatException
	 * @throws FueraRangoException
	 */
	public static ImpresoraLaser obtenerImpresoraLaser(String code, String marca, String estadoString, boolean esAColor,
			String paginasPorMinutoString, String duracionTonerString)
			throws TextIsEmptyException, ObjectNotExists, NumberFormatException, FueraRangoException {
		throwIfEmpty(code, "codigo");
		throwIfEmpty(marca, "marca");
		throwIfNull(estadoString);
		throwIfEmpty(estadoString, "estado");
		throwIfEmpty(paginasPorMinutoString, "paginas por minuto");

		EstadoImpresora estadoImpresora = EstadoImpresora.obtenerEstadoImpresora(estadoString);
		double paginasPorMinuto = Impresora.obtenerPagPerMinute(paginasPorMinutoString);
		int duracionToner = obtenerDuracionToner(duracionTonerString);

		ImpresoraLaser impresoraCartucho = new ImpresoraLaser(code, marca, estadoImpresora, esAColor, paginasPorMinuto,
				duracionToner);
		return impresoraCartucho;
	}

	private static int obtenerDuracionToner(String duracionTonerString)
			throws FueraRangoException, NumberFormatException {

		int duracionToner = Integer.parseInt(duracionTonerString);
		if (duracionToner <= 0)
			throw new FueraRangoException("La duraci�n tiene que ser mayor o igual a 0");
		return duracionToner;
	}

	private static void throwIfNull(String estadoString) throws TextIsEmptyException {
		if (estadoString == null)
			throw new TextIsEmptyException("Elige un estado de impresora");
	}

	private static void throwIfEmpty(String texto, String tipo) throws TextIsEmptyException {
		if (texto.isEmpty())
			throw new TextIsEmptyException(tipo);
	}

}