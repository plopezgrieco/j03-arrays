package ejercicios.ejs09;


import util.ArraysUtil;

//7. Desarrollar un método que reciba un array de dos dimensiones de double y un número de
//	fila y retorne la fila indicada.
//8. Desarrollar un método que reciba un array de dos dimensiones de double y un número de
//	columna y retorne la columna indicada.
public class Ej07y08 {
	public static void main(String[] args) {
		double[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		double[][] m2 = { { 10, 20, 30 }, { 4, 5, 6 } };
		double[][] m3 = { { 1, 2 }, { 30, 40 }, { 5, 6 } };

		ArraysUtil.muestra(m1);
		System.out.print("Fila 2: ");
		ArraysUtil.muestra(fila(m1, 2));
		System.out.print("Columna 2: ");
		ArraysUtil.muestra(columna(m1,2));
		System.out.println();

		ArraysUtil.muestra(m2);
		System.out.print("Fila 0: ");
		ArraysUtil.muestra(fila(m2, 0));
		System.out.print("Columna 0: ");
		ArraysUtil.muestra(columna(m2,0));
		System.out.println();
		
		ArraysUtil.muestra(m3);
		System.out.print("Fila 1: ");
		ArraysUtil.muestra(fila(m3, 1));
		System.out.print("Columna 1: ");
		ArraysUtil.muestra(columna(m3,1));
		System.out.println();
		
		
	}

	public static double[] fila(double[][] m, int fila) {
		if(fila < 0 || fila >= m.length)
			return null;
		return m[fila].clone();
	}
	
	public static double[] columna(double[][] m, int col) {
		if(col < 0 || col >= m[0].length)
			return null;
		double[] columna = new double[m.length];
		for (int i = 0; i < m.length; i++) {
			columna[i] = m[i][col];
		}
		return columna;
	}
	
}
