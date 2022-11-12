package Verificador_Palindromos;
import java.util.*;
import java.lang.*;
import java.nio.file.*;
import java.io.*;

public class ManejoArchivos{

	private static Formatter salida;//envia texto a un archivo
	private static Scanner lectura;

	//----------------------------------------- ESCRITURA DE ARCHIVO
	//Abre el archivo
	public static void abrirArchivoEscritura(){
		try{
			salida = new Formatter("Verificador_Palindromos\\B5.txt");// Abre el archivo
		}
		catch(SecurityException securtityException){
			System.err.println("  Permiso de escritura denengado. Temrminado.");
			System.exit(1); //Termina el programa
		}
		catch(FileNotFoundException fileNotFoundException){
			System.err.println("  Error al abrir el archivo. Temrminado.");
			System.exit(1); //Termina el programa
		}
	}

	//Agrega registros al archivo
	public static void agregarRegistros(){
		Scanner entrada = new Scanner(System.in);
		System.out.printf("  %s%n  %s%n%n? ", "Escriba la frase", "Para terminar la entrada presione ctrl+z.");

		while (entrada.hasNext()){//Itera hasta encontrar el indicador de fin de archivo
			try{
				//Escribe el nuevo registro en el archivo; asume una entrada valida
				salida.format("%s", entrada.nextLine()+"\n");
			}
			catch (FormatterClosedException formatterClosedException){
				System.err.println("  Error al escribir en el archivo. Terminando.");
				break;
			}
			catch(NoSuchElementException elementException){
				System.err.println("  Entrada invalida. Intente de nuevo.");
				entrada.nextLine(); //descarta la entrada para que el usuario intente de nuevo
			}

			System.out.print("? ");
		} //While
	}//agregarRegistros

	//Cierra el archivo
	public static void cerrarArchivoEscritura(){
		if(salida != null)
			salida.close();
	}

	//----------------------------------------- LECTURA DE ARCHIVO
	//Abre Archivo
	public static void abrirArchivoLectura(){
		try{
			lectura = new Scanner(Paths.get("Verificador_Palindromos\\B5.txt"));// Abre el archivo
		}
		catch(IOException ioException){
			System.err.println("  Error al abrir el archivo. Terminado.");
			System.exit(1); //Termina el programa
		}
	}
	//Leer registros al archivo
	public static void leerRegistros(){
		Palindromo p = new Palindromo();
		System.out.printf("%n%n  %s%n","Registros");
		try{
			while(lectura.hasNext()){
				String s = lectura.nextLine();
				s = s.replace("\n","");
				System.out.printf("  '%s'", s);
				s = s.replace(" ","");
				p.esPalindromo(s);
			}
		}
		catch(NoSuchElementException elementException){
			System.err.println("El archivo no esta bien formado. Terminado");
		}
		catch(IllegalStateException stateException){
			System.err.println("Error al leer del archivo. Terminado");	
		}
	}
	//Cierra el archivo
	public static void cerrarArchivoLectura(){
		if(lectura != null)
			lectura.close();
	}
}//Clase ManejoArchivos