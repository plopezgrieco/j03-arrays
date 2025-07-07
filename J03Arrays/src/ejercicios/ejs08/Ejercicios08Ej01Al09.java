package ejercicios.ejs08;

public class Ejercicios08Ej01Al09 {
	
	//Ej01
//	Desarrollar un método que muestre por pantalla un array de enteros de la siguiente forma: [25, 32, -1567, 8]
	public static void muestra(int[] m) {
		System.out.print("[");
		for (int i = 0; i < m.length - 1; i++) {
			System.out.print(m[i] + ", ");
		}
		System.out.println(m.length > 0 ? m[m.length - 1] + "]" : "]");
	}
	
	public static void muestra(double[] m) {
		System.out.print("[");
		for (int i = 0; i < m.length - 1; i++) {
			System.out.print(m[i] + ", ");
		}
		System.out.println(m.length > 0 ? m[m.length - 1] + "]" : "]");
	}
	
	//Ej02
//	Desarrollar un método que reciba un array de enteros y retorne otro con los valores originales elevados al cuadrado.
	public static int[] cuadrado(int[] m) {
		int[] cuad = new int[m.length];
		for (int i = 0; i < cuad.length; i++) {
			cuad[i] = m[i] * m[i];
		}
		return cuad;
	}
	
	//Ej03
//	Desarrollar un método que reciba un array de enteros y retorne otro con los elementos ordenados 
//		exactamente al revés que el original.
	public static int[] invierte(int[] m) {
		int[] inv = new int[m.length];
		for (int i = 0; i < inv.length; i++) {
			inv[i] = m[m.length - 1 -i];
		}
		return inv;
	}
	
	//Ej04
//	Desarrollar un método que reciba un array de enteros y retorne otro con el doble de tamaño y con los valores 
//		originales almacenados en las mismas posiciones que en el original.
	public static int[] duplica(int[] m) {
		int[] dup = new int[m.length * 2];
		for (int i = 0; i < m.length; i++) {
			dup[i] = m[i];
		}
		return dup;
	}
	
	//Ej05
//	Desarrollar un método que reciba, dos arrays de doubles del mismo tamaño y retorne un nuevo array con la suma
//		de los elementos que están en la misma posición.
	public static double[] sumaIguales(double[] a1, double[] a2) {
		double[] resu = new double[a1.length];
		for (int i = 0; i < resu.length; i++) {
			resu[i] = a1[i] + a2[i];
		}
		return resu;
	}

	//Ej05a
//		Repetir el método, pero para arrays de diferentes tamaños.
	public static double[] suma(double[] a1, double[] a2) {
		double[] corto, largo;
		if (a1.length > a2.length) {
			largo = a1;
			corto = a2;
		} else {
			largo = a2;
			corto = a1;
		}
		double[] resu = new double[largo.length];
		for (int i = 0; i < corto.length; i++) {
			resu[i] = a1[i] + a2[i];
		}
		for (int i = corto.length; i < largo.length; i++) {
			resu[i] = largo[i];
		}
		return resu;
	}

	//Ej05a V2
	public static double[] sumaV2(double[] a1, double[] a2) {
		int largo = Math.max(a1.length, a2.length);
		double[] resu = new double[largo];
		for (int i = 0; i < largo; i++) {
			resu[i] += i < a1.length ? a1[i] : 0;
			resu[i] += i < a2.length ? a2[i] : 0;
		}
		return resu;
	}
	
	//Ej06
//	Desarrollar un método que reciba dos arrays de enteros y retorne un tercero con todos los elementos del primero 
//		y luego los del segundo.
//	Ej: recibe [1, 2, 3] y [4, 5]; retorna [1, 2, 3, 4, 5].
	public static int[] concatena(int[] a1, int[] a2) {
		int[] resu = new int[a1.length + a2.length];
		for (int i = 0; i < a1.length; i++) {
			resu[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			resu[a1.length + i] = a2[i];
		}
		return resu;
	}
	
	//Ej07
//	Similar al anterior pero que intercale los elementos. 
//		Ej: recibe [1, 2, 3, 4, 5] y [6, 7]; retorna [1, 6, 2, 7, 3, 4, 5].
	public static int[] intercala(int[] a1, int[] a2) {
		int[] resu = new int[a1.length + a2.length];
		int[] corto, largo;
		if (a1.length > a2.length) {
			largo = a1;
			corto = a2;
		} else {
			largo = a2;
			corto = a1;
		}
		for (int i = 0; i < corto.length; i++) {
			resu[2 * i] = a1[i];
			resu[2 * i + 1] = a2[i];
		}
		
		for (int i = corto.length; i < largo.length; i++) {
			resu[corto.length + i] = largo[i];
		}
		return resu;
	}
	
	//Ej08
//	Desarrollar un método que reciba un array de doubles y, en el mismo array, intercambie los elementos en espejo, es decir, el primero por el último, el segundo por el penúltimo y así sucesivamente. No se puede utilizar otro array. 
//		Ej: recibe [1, 2, 3, 4, 5]; el array queda como [5, 4, 3, 2, 1].
	public static void invierte(double[] v) {
		double aux;
		for (int i = 0; i < v.length / 2; i++) {
			aux = v[i];
			v[i] = v[v.length - 1 - i];
			v[v.length - 1 - i] = aux;
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] nums0 = {};
		int[] nums1 = {6};
		int[] nums2 = {1, -9};
		int[] nums3 = {0, 8, 4};
		int[] nums4 = {-8, 7, 15, 9};
		//Test01
//		muestra(nums0);
//		muestra(nums1);
//		muestra(nums2);
//		muestra(nums3);
//		muestra(nums4);
		
		//Test02
//		muestra(nums0);
//		muestra(cuadrado(nums0));
//		muestra(nums1);
//		muestra(cuadrado(nums1));
//		muestra(nums2);
//		muestra(cuadrado(nums2));
//		muestra(nums3);
//		muestra(cuadrado(nums3));
//		muestra(nums4);
//		muestra(cuadrado(nums4));

		//Test03
//		muestra(nums0);
//		muestra(invierte(nums0));
//		muestra(nums1);
//		muestra(invierte(nums1));
//		muestra(nums2);
//		muestra(invierte(nums2));
//		muestra(nums3);
//		muestra(invierte(nums3));
//		muestra(nums4);
//		muestra(invierte(nums4));
		
		//Test04
//		muestra(nums0);
//		muestra(duplica(nums0));
//		muestra(nums1);
//		muestra(duplica(nums1));
//		muestra(nums2);
//		muestra(duplica(nums2));
//		muestra(nums3);
//		muestra(duplica(nums3));
//		muestra(nums4);
//		muestra(duplica(nums4));
		
		//Test05
		double[] d1 = {9};
		double[] d3 = {9, 8.37, 7};
		double[] otro1 = {5};
		double[] otro3 = {5, -1, 3.2};
//		muestra(d1);
//		muestra(otro1);
//		muestra(sumaIguales(d1, otro1));
//		muestra(d3);
//		muestra(otro3);
//		muestra(sumaIguales(d3, otro3));

		//Test05a
//		muestra(d1);
//		muestra(d3);
//		muestra(suma(d1, d3));
//		muestra(suma(d3, d1));
//		//Test05a V2
//		muestra(d1);
//		muestra(d3);
//		muestra(sumaV2(d1, d3));
//		muestra(sumaV2(d3, d1));
		
		//Test06
//		muestra(nums2);
//		muestra(nums4);
//		muestra(concatena(nums2, nums4));
//		muestra(concatena(nums4, nums2));

		//Test07
//		muestra(nums2);
//		muestra(nums4);
//		muestra(intercala(nums2, nums4));
//		muestra(intercala(nums4, nums2));
		
		//Test08
		muestra(d1);
		invierte(d1);
		muestra(d1);
		muestra(d3);
		invierte(d3);
		muestra(d3);
		
	}
}
