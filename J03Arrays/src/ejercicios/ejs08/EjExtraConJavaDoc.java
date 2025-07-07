package ejercicios.ejs08;

import util.Util;

/**
 * Gestiona los datos de Alumnos.
 * Arma las estructuras necesarias para leer por pantalla los siguientes datos: 
 * Nombre del alumno, nota examen modulo 1, nota examen modulo 2, cantidad de inasistencias.
 * Almacena de cada uno su nota media.
 * 
 * @author Pablo
 * @version 1.0
 * 
 */
public class EjExtraConJavaDoc {
	/**
	 * Almacena los datos de los alumnos
	 */
	static String[] alumnos;
	/**
	 * Almacena las notas del primer examen
	 */
	static double[] nota1;
	/**
	 * Almacena las notas del primer examen
	 */
	static double[] nota2;
	static int[] inasistencias;
	static double[] notaMedia;
	static final int CANT_INICIAL = 10;
	static int cant = 0;
	
	public static void main(String[] args) {
		alumnos = new String[CANT_INICIAL];
		nota1 = new double[CANT_INICIAL];
		nota2 = new double[CANT_INICIAL];
		inasistencias = new int[CANT_INICIAL];
		notaMedia = new double[CANT_INICIAL];
		
		menu();
	}
	
	static void menu() {
		int opcion;
		boolean salir = false;
		
		do {
			titulo("MENU PRINCIPAL");
			System.out.println("1 – Agregar alumnos");
			System.out.println("2 – Buscar un alumno por id");
			System.out.println("3 – Buscar un alumno por nombre");
			System.out.println("4 – Listar todos los alumnos");
			System.out.println("5 – Alumnos con mayor nota media.");
			System.out.println("6 – Alumnos aprobados");
			System.out.println("7 – Alumnos con más de 3 inasistencias.");
			System.out.println("9 – Salir.");
			opcion = Util.leerInt("> ");
			
			switch (opcion) {
			case 1:
				agregarAlumnos();
				break;
			case 2:
				buscarPorId();
				break;
			case 3:
				buscarPorNombre();
				break;
			case 4:
				listarAlumnos();
				break;
			case 5:
				listarMayorNotaMedia();
				break;
			case 6:
				listarAprobados();
				break;
			case 7:
				listarInasistencias(3);
				break;
			case 99:
				simulacion();
				break;
			case 9: 
				salir = true;
			}
			intro();
		} while(!salir);
	}
	
	static void agregarAlumnos() {
		titulo("CARGA DE ALUMNOS");
		if (cant == alumnos.length) {
			redimensionar();
		}
		alumnos[cant] = Util.leerString("Nombre alumno: ");
		nota1[cant] = Util.leerDouble("Nota primer examen: ");
		nota2[cant] = Util.leerDouble("Nota segundo examen: ");
		inasistencias[cant] = Util.leerInt("Cantidad inasistencias: ");
		notaMedia[cant] = (nota1[cant] + nota2[cant]) / 2;
		cant++;
	}
	
	static void buscarPorId() {
		titulo("DATOS ALUMNO POR ID");
		int id = Util.leerInt("Id Alumno: ");
		if (id >= cant) {
			System.out.println("Id inexistente");
			return;
		}
		tituloDatosAlumno();
		listaAlumno(id);
	}
	
	static void buscarPorNombre() {
		titulo("DATOS ALUMNO POR NOMBRE");
		String nombre = Util.leerString("Ingresa nombre del alumno: ");
		tituloDatosAlumno();
		for (int i = 0; i < cant; i++) {
			if (alumnos[i].toLowerCase().contains(nombre.toLowerCase())) {
				listaAlumno(i);
			}
		}
	}
	
	static void listarAlumnos() {
		titulo("LISTADO DE ALUMNOS");
		tituloDatosAlumno();
		for (int i = 0; i < cant; i++) {
			listaAlumno(i);
		}
	}
	
	static void listarMayorNotaMedia() {
		titulo("ALUMNOS CON MAYOR NOTA MEDIA");
		tituloDatosAlumno();
		double notaMayor = calculaNotaMayor();
		for (int i = 0; i < notaMedia.length; i++) {
			if (notaMedia[i] == notaMayor)
				listaAlumno(i);
		}
	}
	
	static double calculaNotaMayor() {
		double mayor = 0;
		for (int i = 0; i < notaMedia.length; i++) {
			if (notaMedia[i] > mayor)
				mayor = notaMedia[i];
		}
		return mayor;
	}
	
	static void listarAprobados() {
		titulo("ALUMNOS APROBADOS");
		tituloDatosAlumno();
		for (int i = 0; i < alumnos.length; i++) {
			if (notaMedia[i] >= 5)
				listaAlumno(i);
		}
	}
	
	static void listarInasistencias(int max) {
		titulo("ALUMNOS CON MAS DE " + max + " INASISTENCIAS");
		tituloDatosAlumno();
		for (int i = 0; i < inasistencias.length; i++) {
			if (inasistencias[i] > max)
				listaAlumno(i);
		}
	}
	
	static void tituloDatosAlumno() {
		System.out.printf("%-30s%6s  %6s  %6s  %13s\n", "ALUMNO", "NOTA 1", "NOTA 2", "MEDIA", "INASISTENCIAS");
	}
	
	static void listaAlumno(int id) {
		System.out.printf("%-30s%6.2f  %6.2f  %6.2f  %13d\n", alumnos[id], nota1[id], nota2[id], notaMedia[id], inasistencias[id]);
	}
	
	
	
	static void titulo(String titulo) {
		System.out.println("\n" + titulo);
		System.out.println("-".repeat(titulo.length()));
	}
	
	static void redimensionar() {
		String[] alumnosAux = new String[alumnos.length * 2];
		for (int i = 0; i < alumnos.length; i++) {
			alumnosAux[i] = alumnos[i];
		}
		alumnos = alumnosAux;
		
		double[] nota1Aux = new double[nota1.length * 2];
		for (int i = 0; i < nota1.length; i++) {
			nota1Aux[i] = nota1[i];
		}
		nota1 = nota1Aux;
		
		double[] nota2Aux = new double[nota2.length * 2];
		for (int i = 0; i < nota2.length; i++) {
			nota2Aux[i] = nota2[i];
		}
		nota2 = nota2Aux;
		
		double[] notaMediaAux = new double[notaMedia.length * 2];
		for (int i = 0; i < notaMedia.length; i++) {
			notaMediaAux[i] = notaMedia[i];
		}
		notaMedia = notaMediaAux;
		
		int[] inasistenciasAux = new int[inasistencias.length * 2];
		for (int i = 0; i < inasistencias.length; i++) {
			inasistenciasAux[i] = inasistencias[i];
		}
		inasistencias = inasistenciasAux;
	}	
	
	static void intro() {
		Util.leerString("Intro para continuar...");
	}
	
	static void simulacion() {
		if (cant > 0) {
			System.out.println("La simulación no se realiza porque tiene datos cargados");
			return;
		}
		alumnos = new String[]{"Maria", "Benjamin", "Alejandra", "Pablo"};
		nota1 = new double[] {10, 9, 9.5, 2};
		nota2 = new double[]{9, 10, 9, 1.5};
		inasistencias = new int[] {3, 1, 1, 7};
		notaMedia = new double[] {19/2.,19/2.,18.5/2.,3.5/2.};
		cant = 4;
		System.out.println("Simulación realizada");
	}
}
