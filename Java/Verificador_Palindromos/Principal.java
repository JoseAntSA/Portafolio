package Verificador_Palindromos;
import java.util.*;
import java.lang.*;
import java.nio.file.*;
import java.io.*;

public class Principal{

	private static Formatter salida;//envia texto a un archivo
	private static Scanner lectura;

	public static void main(String[ ] args) {

		ManejoArchivos archivo = new ManejoArchivos();
		archivo.abrirArchivoEscritura();
		archivo.agregarRegistros();
		archivo.cerrarArchivoEscritura();
		archivo.abrirArchivoLectura();
		archivo.leerRegistros();
		archivo.cerrarArchivoLectura();
		

	}
}