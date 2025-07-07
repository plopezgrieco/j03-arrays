package util;

import java.awt.Font;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Util {

	private final static Scanner teclado = new Scanner(System.in);
	public final static int CONSOLA = 0;
	public final static int VENTANA = 1;
	
	 
	public static char leerChar(String mensaje, int dispositivo) {
		String leido = leerString(mensaje, dispositivo);
		char caracter;
		if (leido == null || leido.length() == 0) {
			caracter = ' ';
		} else {
			caracter = leido.charAt(0);
		}
		return caracter;
	}
	
	public static char leerChar(String mensaje) {
		return leerChar(mensaje, CONSOLA);
	}
	
	public static char leerChar(int dispositivo) {
		return leerChar("Ingrese caracter", dispositivo);
	}
	
	public static char leerChar() {
		return leerChar("Ingrese caracter");
	}
	
	public static int leerInt(String mensaje, int dispositivo) {
		boolean salir = false, corregido = false;
		int num = -1;
		while(!salir) {
			String leido = leerString(mensaje, dispositivo);
			try {
				num = Integer.parseInt(leido);
				salir = true;
			} catch (Exception e) {
				if (!corregido) {
					mensaje += " (ENTERO)";
					corregido = true;
				}
			}
		}
		return num;
	}
	
	public static int leerInt(String mensaje) {
		return leerInt(mensaje, CONSOLA);
	}
	
	public static int leerInt(int dispositivo) {
		return leerInt("Ingrese nro", dispositivo);
	}
	
	public static int leerInt() {
		return leerInt("Ingrese nro");
	}
	
	public static double leerDouble(String mensaje, int dispositivo) {
		boolean salir = false, corregido = false;
		double num = -1;
		while(!salir) {
			String leido = leerString(mensaje, dispositivo);
			try {
				num = Double.parseDouble(leido);
				salir = true;
			} catch (Exception e) {
				if (!corregido) {
					mensaje += " (REAL)";
					corregido = true;
				}
			}
		}
		return num;
	}
	
	public static double leerDouble(String mensaje) {
		return leerDouble(mensaje, CONSOLA);
	}

	public static double leerDouble(int dispositivo) {
		return leerDouble("Ingrese nro", dispositivo);
	}
	
	public static double leerDouble() {
		return leerDouble("Ingrese nro");
	}
	
	public static String leerString(String mensaje) {
		return leerString(mensaje, CONSOLA);
	}
	
	public static String leerString(String mensaje, int dispositivo) {
		if (dispositivo == VENTANA) {
			return JOptionPane.showInputDialog(mensaje);
		} else {
			System.out.print(mensaje + ": ");
			return teclado.nextLine();
		}
	}
	
	public static void mostrarSinSalto(Object dato) {
		System.out.print(dato);
	}
	
	public static void mostrar(Object dato, String titulo, int dispositivo, char tipo) {
		if (dispositivo == CONSOLA) {
			System.out.println((titulo == null ? "" : (titulo + ": ")) + dato);
		} else {
			int tipoMje = switch(tipo) {
				case '?': 
					yield JOptionPane.QUESTION_MESSAGE;
				case 'X':
				case 'x':
					yield JOptionPane.ERROR_MESSAGE;
				default: 
					yield JOptionPane.INFORMATION_MESSAGE;
			};
			JOptionPane.showMessageDialog(null, dato, titulo, tipoMje);			
		}
	}
	
//	public static void mostrar(Object dato, String titulo, int dispositivo, char tipo) {
//		if (dispositivo == CONSOLA) {
//			System.out.println((titulo == null ? "" : (titulo + ": ")) + dato);
//		} else if (tipo == '?') {
//			JOptionPane.showMessageDialog(null, dato, titulo, JOptionPane.QUESTION_MESSAGE);
//		}  else if (tipo == '?') {
//			JOptionPane.showMessageDialog(null, dato, titulo, JOptionPane.ERROR_MESSAGE);
//		} else {
//			JOptionPane.showMessageDialog(null, dato, titulo, JOptionPane.INFORMATION_MESSAGE);
//		}
//	}
//	
	public static void mostrar(Object dato, String titulo, int dispositivo) {
		mostrar(dato, titulo, dispositivo, '!');
	}
	
	public static void mostrar(Object dato, String titulo) {
		mostrar(dato, titulo, CONSOLA);
	}
	
	public static void mostrar(Object dato) {
		mostrar(dato, null, CONSOLA);
	}
	
	public static void mostrarPasta(String mensaje, double valor) {
		System.out.printf(mensaje + "%,.2f\n", valor);
	}
	
	public static void mostrarPasta(double valor) {
		System.out.printf("%,.2\n", valor);
	}
	
	public static void mostrarGrande(Object dato, String titulo, int tamanyo, char tipo) {
		JLabel mensaje = new JLabel(dato.toString());
		mensaje.setText(dato.toString());
		mensaje.setFont(new Font("Arial", Font.BOLD, tamanyo));
		mostrar(mensaje, titulo, VENTANA, tipo);
	}
	
	public static void mostrarGrande(Object dato, String titulo, int tamanyo) {
		mostrarGrande(dato, titulo, tamanyo, '!');
	}
	
	/**
	 * Genera un nro aleatorio entre 0 y hasta inclusives
	 * @param hasta valor máximo generado
	 * @return Un número seudoaleatorio
	 */
	public static int random(int hasta) {
		return new Random().nextInt(hasta + 1);
	}

	/**
	 * Genera un nro aleatorio entre desde y hasta inclusives
	 * @param desde valor mínimo generado
	 * @param hasta valor máximo generado
	 * @return Un número seudoaleatorio
	 */
	public static int random(int desde, int hasta) {
		return random(hasta-desde) + desde;
	}
	
	public static String enmarcar(String texto) {
		String enmarcado = "";
		enmarcado += "\u250C";
		for (int k = 1; k <= texto.length() + 2; k++) {
			enmarcado += "\u2500";
		}
		enmarcado += "\u2510\n";
		
		enmarcado += "\u2502";
		enmarcado += " " + texto + " ";
		enmarcado += "\u2502\n";
		
		enmarcado += "\u2514";
		for (int k = 1; k <= texto.length() + 2; k++) {
			enmarcado += "\u2500";
		}
		enmarcado += "\u2518";
		return enmarcado;
	}

	public static void mostrarVector(int[] vector) {
		System.out.print("[");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ", ");
		}
		System.out.println(vector[vector.length - 1] + "]");
	}
	
	public static void mostrarVector(double[] vector) {
		System.out.print("[");
		for (int i = 0; i < vector.length - 1; i++) {
			System.out.print(vector[i] + ", ");
		}
		System.out.println(vector[vector.length - 1] + "]");
	}
}
