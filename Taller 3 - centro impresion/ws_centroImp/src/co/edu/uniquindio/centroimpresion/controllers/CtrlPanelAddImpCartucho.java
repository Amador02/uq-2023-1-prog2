package co.edu.uniquindio.centroimpresion.controllers;

import co.edu.uniquindio.centroimpresion.exceptions.CentroImpresionException;
import co.edu.uniquindio.centroimpresion.exceptions.FueraRangoException;
import co.edu.uniquindio.centroimpresion.exceptions.ObjectNotExists;
import co.edu.uniquindio.centroimpresion.exceptions.TextIsEmptyException;
import co.edu.uniquindio.centroimpresion.model.archivos.SerializedData;
import co.edu.uniquindio.centroimpresion.model.centro.EstadoImpresora;
import co.edu.uniquindio.centroimpresion.model.centro.ImpresoraCartucho;
import co.edu.uniquindio.centroimpresion.view.util.Utility;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CtrlPanelAddImpCartucho {

	/**
	 *
	 * @param code
	 * @param marca
	 * @param estadoString
	 * @param esAColor
	 * @param paginasPorMinutoString
	 * @param capacidadCartuchoString
	 * @param desgasteCartuchoString
	 * @throws CentroImpresionException
	 * @throws TextIsEmptyException
	 * @throws ObjectNotExists
	 * @throws NumberFormatException
	 * @throws FueraRangoException
	 */
	public static void agregarImpresoraCartuchoThrows(String code, String marca, String estadoString, boolean esAColor,
			String paginasPorMinutoString, String capacidadCartuchoString, String desgasteCartuchoString)
			throws CentroImpresionException, TextIsEmptyException, ObjectNotExists, NumberFormatException,
			FueraRangoException {
		ImpresoraCartucho impresoraCartucho = obtenerImpresoraCartucho(code, marca, estadoString, esAColor,
				paginasPorMinutoString, capacidadCartuchoString, desgasteCartuchoString);
		SerializedData data = new SerializedData();
		if (impresoraCartucho.exists()) {
			data.getCentroImpresion().agregarImpresoraCartucho(impresoraCartucho.getCode(),
					impresoraCartucho.getMarca(), impresoraCartucho.getEstado(), impresoraCartucho.isEsAColor(),
					impresoraCartucho.getLetrasPorSegundo(), impresoraCartucho.getCapacidadCartucho(),
					impresoraCartucho.getCapacidadCartucho());
			data.updateCentroImpresion();
		}
	}

	public static void agregarImpresoraCartucho(String code, String marca, String estadoString, boolean esAColor,
			String velString, String velDecimalString, String capacidadString, String capacidadDecimalString,
			String desgasteString, String desgasteDecimalString) {
		try {
			CtrlPanelAddImpCartucho.agregarImpresoraCartuchoThrows(code, marca, estadoString, esAColor,
					Utility.juntarCadenasParaDoble(velString, velDecimalString),
					Utility.juntarCadenasParaDoble(capacidadString, capacidadDecimalString),
					Utility.juntarCadenasParaDoble(desgasteString, desgasteDecimalString));
			new Alert(AlertType.CONFIRMATION, "La impresora ha sido agregada con éxito").show();
		} catch (NumberFormatException e) {
			new Alert(AlertType.WARNING, "Solo coloca numeros en la velocidad, capacidad y desgaste").show();
		} catch (CentroImpresionException e) {
			new Alert(AlertType.WARNING, "Ya existe una impresora con ese codigo").show();
		} catch (TextIsEmptyException e) {
			new Alert(AlertType.WARNING, "Rellena todos los campos (" + e.getTipoTexto() + ")").show();
		} catch (ObjectNotExists e) {
			new Alert(AlertType.WARNING, "Rellena todos los campos (" + e.getClase().getSimpleName() + ")").show();
		} catch (FueraRangoException e) {
			new Alert(AlertType.WARNING, e.getMessage()).show();
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
	public static ImpresoraCartucho obtenerImpresoraCartucho(String code, String marca, String estadoString,
			boolean esAColor, String paginasPorMinutoString, String capacidadCartuchoString,
			String desgasteCartuchoString)
			throws TextIsEmptyException, ObjectNotExists, NumberFormatException, FueraRangoException {
		Utility.throwIfEmpty(code, "codigo");
		Utility.throwIfEmpty(marca, "marca");
		Utility.throwIfNull(estadoString, "Elige un estado de impresora");
		Utility.throwIfEmpty(estadoString, "estado");
		Utility.throwIfEmpty(paginasPorMinutoString, "paginas por minuto");
		Utility.throwIfEmpty(capacidadCartuchoString, "capacidad de cartucho");
		Utility.throwIfEmpty(desgasteCartuchoString, "descaste de cartucho");

		EstadoImpresora estadoImpresora = EstadoImpresora.obtenerEstadoThrows(estadoString);
		double paginasPorMinuto = obtenerPagPerMinute(paginasPorMinutoString);
		double capacidadCartucho = obtenerCapacidad(capacidadCartuchoString);
		double desgasteCartucho = obtenerDesgaste(desgasteCartuchoString);

		ImpresoraCartucho impresoraCartucho = new ImpresoraCartucho(code, marca, estadoImpresora, esAColor,
				paginasPorMinuto, capacidadCartucho, desgasteCartucho);
		return impresoraCartucho;
	}

	private static double obtenerDesgaste(String desgasteString) throws FueraRangoException, NumberFormatException {
		double desgasteCartucho = Double.parseDouble(desgasteString);
		if (desgasteCartucho <= 0)
			throw new FueraRangoException("El desgaste tiene que ser mayor que 0");
		return desgasteCartucho;
	}

	private static double obtenerPagPerMinute(String paginasPorMinutoString)
			throws FueraRangoException, NumberFormatException {
		double paginasPorMinuto = Double.parseDouble(paginasPorMinutoString);
		if (paginasPorMinuto <= 0)
			throw new FueraRangoException("Las paginas por minuto tienen que ser mayor a 0");
		return paginasPorMinuto;
	}

	private static double obtenerCapacidad(String capacidadString) throws FueraRangoException, NumberFormatException {
		double capacidadCartucho = Double.parseDouble(capacidadString);
		if (capacidadCartucho <= 0)
			throw new FueraRangoException("Las capacidad tiene que ser mayor a 0");
		return capacidadCartucho;
	}

}
