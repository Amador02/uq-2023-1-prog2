package view.custom;

import java.util.ArrayList;

public class Utilities {
	private static int idCine = 0;

	public static String format (String format, Object... args) {
		return (String.format(format, args)).replace(',', '.');
	}

	public static String format (Object... args) {
		return (String.format("%.2f", args)).replace(',', '.');
	}

	public static String toString (Object[] a) {
		return toString(a, "");
	}

	public static String toString (Object[] a, String separator) {
		if (a == null) return "null";

		int iMax = a.length - 1;
		if (iMax == -1) return "";

		StringBuilder b = new StringBuilder();
		for (int i = 0;; i++) {
			b.append(String.valueOf(a[i]));
			if (i == iMax) break;
			b.append(separator);
		}

		return b.toString();
	}

	public static String matrizAStringHtml (boolean[][] mb) {
		String ret = "<html>";
		for (int i = 0; i < mb.length; i++) {
			for (int j = 0; j < mb[0].length; j++) {
				ret += "<font color=" + (mb[i][j] ? "#FF0000" : "#0000FF") + ">[]</font>";

			}
			ret += "<br>";
		}
		ret += "</html>";
		return ret;

	}

	public static String[] listArrToStringArr (ArrayList<String> list) {
		String[] ret = new String[list.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public static int getIdCine () {
		return idCine;
	}

	public static void setIdCine (int idCine) {
		Utilities.idCine = idCine;
	}

	public static int conseguirNumeroTabla (int num) {
		int result = 1;
		int diferencia = Integer.MAX_VALUE;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				int diferenciaNum = Math.abs((num / i) - (num / (num / i)));
				if (diferenciaNum < diferencia) {
					result = (num / i);
					diferencia = diferenciaNum;
				}
			}
		}
		if (result < num / result) result = num / result;
		return result;
	}
}