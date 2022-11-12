package Metodos_Ordenamiento;
import java.util.*;

public class Principal{

	public static void main(String arg[]){

		Scanner lee = new Scanner(System.in);
		int tam;

		Burbuja burbuja = new Burbuja();
		Insercion insercion = new Insercion();
		Seleccion seleccion = new Seleccion();
		Mergesort mergersort = new Mergesort();
		Quicksort quicksort = new Quicksort();

		System.out.println("\n\n  Programa para ordenar arreglos de numeros reales.");
		System.out.printf("\n  Cantidad de elementos en el arreglo: ");
		tam = lee.nextInt();
		lee.nextLine();
		int arr[] = new int[tam];
		llenarArreglo( arr );
		

		System.out.printf("\n\n  Arreglo sin ordenar: ");
		imprimirArreglo(arr);

		System.out.printf("\n\n\n  Metodo Burbuja: ");
		burbuja.setArr( arr );
		burbuja.ordenarAMayor();	
		System.out.printf("\n  Arreglo ordenado:    " + burbuja);
		
		System.out.printf("\n\n\n  Metodo Insercion: ");
		insercion.setArr( arr );
		insercion.ordenarAMayor();	
		System.out.printf("\n  Arreglo ordenado:    " + insercion);

		System.out.printf("\n\n\n  Metodo Seleccion: ");
		seleccion.setArr( arr );
		seleccion.ordenarAMayor();	
		System.out.printf("\n  Arreglo ordenado:    " + seleccion);		
		
		System.out.printf("\n\n\n  Metodo MergeSort: ");
		mergersort.setArr( arr );
		mergersort.ordenarAMayor();
		System.out.printf("\n  Arreglo ordenado:    " + mergersort);	

		System.out.printf("\n\n\n  Metodo QuickSort: ");
		quicksort.setArr( arr );
		quicksort.ordenarAMayor();
		System.out.printf("\n  Arreglo ordenado:    " + quicksort + "\n\n");

	}//main

	public static void imprimirArreglo( int[] arr ){
		System.out.printf("[ ");
		for(int p:arr)
			System.out.printf( p + " " );
		System.out.printf("]");
	}
	public static void llenarArreglo( int[] arr ){
		Scanner lee = new Scanner(System.in);
		for(int i=0 ; i<arr.length ; i++){
			System.out.printf("  Dato en indice " + i + ": ");
			arr[i] = lee.nextInt();
		}//for
	}

}//class Principal