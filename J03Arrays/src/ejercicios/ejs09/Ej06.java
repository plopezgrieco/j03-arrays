package ejercicios.ejs09;

import util.ArraysUtil;

//Desarrollar un método que reciba una matriz matemática (dos dimensiones) de double y
//retorne la matriz traspuesta. La matriz traspuesta se genera cambiando filas por columnas
public class Ej06 {

	public static void main(String[] args) {
		double[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] m2 = { { 1, 2, 3 }, { 4, 5, 6 } };
		double[][] m3 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		ArraysUtil.muestra(m1);
		System.out.println("Traspuesta");
		ArraysUtil.muestra(traspuesta(m1));
		System.out.println();

		ArraysUtil.muestra(m2);
		System.out.println("Traspuesta");
		ArraysUtil.muestra(traspuesta(m2));
		System.out.println();

		ArraysUtil.muestra(m3);
		System.out.println("Traspuesta");
		ArraysUtil.muestra(traspuesta(m3));
	}

	public static double[][] traspuesta(double [][] m){
		double[][] trasp = new double[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				trasp[j][i] = m[i][j];
			}
		}
		return trasp;
	}
}
