package teoria;

import java.util.Arrays;
import java.util.Random;

public class Ordenacion {
	
	//busca el menor y lo intercambia con el primero
	// continua con el segundo, etc.
	// O(n^2)
	public static void seleccion(double[] v) {
		int posMenor;
//		int intercambios = 0;
//		int iteraciones = 0;
		for (int i = 0; i < v.length - 1; i++) {
			posMenor = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[posMenor])
					posMenor = j;
//				iteraciones++;
			}
			if (i != posMenor) {
				intercambia(v, i, posMenor);
//				intercambios++;
			}
		}
//		System.out.println("Intercambios seleccion: " + intercambios);
//		System.out.println("Iteraciones seleccion: " + iteraciones);
	}
	
	// el método de ordenar cartas
	//O(n^2)
	public static void insercion(double[] v) {
		boolean esMenor;
		for (int i = 1; i < v.length; i++) {
			esMenor = true;
			for (int j = i; j > 0 && esMenor; j--) {
				if(v[j] < v[j-1])
					intercambia(v, j, j-1);
				else
					esMenor = false;
			}
		}
	}
	
	//O(n^2)
	public static void burbuja(double[] v) {
		boolean ordenado = false;
		for (int i = 1; i < v.length && !ordenado; i++) {
			ordenado = true;
			for (int j = 0; j < v.length - i; j++) {
				if(v[j] > v[j+1]) {
					intercambia(v, j, j+1);
					ordenado = false;
				}
			}
		}
	}
	
	public static void quickSort(double[] v) {
		quickSort(v, 0, v.length-1);
	}
	
	private static void quickSort(double[] v, int izq, int der) {
		double valPivote = (v[izq] + v[der]) / 2;
		int i = izq;
		int d = der;
		while(i < d) {
			while(v[i] < valPivote) i++;
			while(v[d] > valPivote) d--;
			if (i < d) {
				intercambia(v, i, d);
				i++;
				d--;
			}
		}
		if(izq < d) quickSort(v, izq, d);
		if(i < der) quickSort(v, i, der);
	}
	
	public static double[] generaArray(int cant) {
		double[] nuevo = new double[cant];
		Random r = new Random();
		for (int i = 0; i < nuevo.length; i++) {
			nuevo[i] = r.nextInt(cant * 2);
		}
		return nuevo;
	}
	
	public static void intercambia(double[] v, int a, int b) {
		double aux = v[a];
		v[a] = v[b];
		v[b] = aux;
	}
	
	public static void main(String[] args) {
//		double[] valores = {10, 5.5, 7.3, 1.9, 2, 1};
		double[] valores = generaArray(100_000_000);
		double[] valores2 = valores.clone();
		double[] valores3 = valores.clone();
		double[] valores4 = valores.clone();
		double[] valores5 = valores.clone();
		
		long t0, tf;
		
//		System.out.println(Arrays.toString(valores));
//		t0 = System.currentTimeMillis();
////		seleccion(valores);
//		tf = System.currentTimeMillis();
//		System.out.println("Seleccion: " + (tf-t0));
//		
////		System.out.println(Arrays.toString(valores));
////		seleccion(valores);
//		
//		System.out.println(Arrays.toString(valores2));
//		t0 = System.currentTimeMillis();
////		insercion(valores2);
//		tf = System.currentTimeMillis();
//		System.out.println("Insercion: " + (tf-t0));
//		
////		System.out.println(Arrays.toString(valores2));
////		seleccion(valores);
//
//		System.out.println(Arrays.toString(valores3));
//		t0 = System.currentTimeMillis();
////		burbuja(valores3);
//		tf = System.currentTimeMillis();
//		System.out.println("Burbuja: " + (tf-t0));

//		System.out.println(Arrays.toString(valores4));
		t0 = System.currentTimeMillis();
		quickSort(valores4);
		tf = System.currentTimeMillis();
		System.out.println("QuickSort: " + (tf-t0));
//		System.out.println(Arrays.toString(valores4));
		
//		System.out.println(Arrays.toString(valores5));
		t0 = System.currentTimeMillis();
		Arrays.sort(valores5);
		tf = System.currentTimeMillis();
		System.out.println("QuickSort de libreria: " + (tf-t0));
		
	}
}
