package Metodos_Ordenamiento;
import java.util.*;


public class Quicksort implements Ordenamiento{

	//Atributos
	private int[] arr;

	//Metodos sets y gets
	public void setArr( int arr[] ){
		this.arr = arr;
	}
	public int[] getArr(){
		return arr;
	}

	//Metodos
	public String toString(){
		String c = "[ ";

		for(int p: getArr())
			c += p + " ";
		c += "]";

		return c;
	}
	public void ordenarAMayor(){
		int arrtemp[] = getArr();
		sort( arrtemp, 0, arrtemp.length-1);
		setArr(arrtemp);
		System.out.printf("\n\n  Arreglo ordenado de menor a mayor...    ");

	}
	public void sort(int[] arr, int inicio, int ultimo){
		if( inicio < ultimo ){
			int pivote;

			pivote = calcPivote( arr, inicio, ultimo);
			// Ordena los elementos antes  y despues del pivote
			sort(arr, inicio, pivote-1);
			sort(arr, pivote+1, ultimo);
		}


	}
	public int calcPivote(int[] arr, int inicio, int ultimo){
		int pivote, i;

		pivote = arr[ultimo];
		i = (inicio-1);
		for(int j=inicio ; j<ultimo ; j++){
			// Si el elemento actual es más pequeño que el pivote
			if( arr[j]<pivote ){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// Se intercambia el pivote de lugar despues del ultimo elemento menor que el en el array 
		int temp = arr[i+1];
		arr[i+1] = arr[ultimo];
		arr[ultimo] = temp;
		return i+1;

	}		
}//class Quiksort
