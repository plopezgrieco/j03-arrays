package ejercicios.ejs09;

import java.util.Random;

//Desarrollar un método que reciba dos enteros, el primero (f) la cantidad de filas y el
//segundo (c) la cantidad de columnas. Deberá generar y retornar una matriz de dos
//dimensiones de f+1 filas y c+1 columnas, con números aleatorios entre 0 y 99 en todas las
//celdas, excepto en la última fila y en la última columna, que deberán contener los
//sumatorios de las filas o columnas correspondientes, similar a una hoja Excel.

public class Ej09 {

	
	public static void main(String[] args) {
		util.ArraysUtil.muestra(generaTabla(4, 6));
	}
	
	public static int[][] generaTabla(int f, int c){
		int[][] t = new int[f+1][c+1];
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				t[i][j] = random();
				t[i][c] += t[i][j];
				t[f][j] += t[i][j];
				t[f][c] += t[i][j];
			}
		}
		return t;
	}
	
	private static int random() {
		return new Random().nextInt(0, 100);
	}
}
