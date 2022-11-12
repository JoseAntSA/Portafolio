package Metodos_Ordenamiento;
import java.util.*;


public class Mergesort implements Ordenamiento{

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
		dividir( arrtemp, 0, arrtemp.length-1);
		setArr(arrtemp);
		System.out.printf("\n\n  Arreglo ordenado de menor a mayor...    ");

	}
	public void dividir(int[] arr, int inicio, int ultimo){
		if( inicio < ultimo ){
			int mitad = (inicio+ultimo) / 2;
			//Mitad izquierda
			dividir(arr, inicio, mitad);
			//Mitad derecha
			dividir(arr, mitad+1, ultimo);
			//Mezclar
			merge(arr, inicio, mitad, ultimo);
		}
	}
	public void merge(int[] arr, int inicio, int mitad, int ultimo){
		int tamIzq, tamDer;

		//Creacion de los arreglos que surgen al dividir el array inicial;
		tamIzq = mitad - inicio + 1;
		tamDer = ultimo - mitad;

		int[] arrIzq = new int[tamIzq];
		int[] arrDer = new int[tamDer];

		//LLenar los arreglos
		for(int i=0 ; i<tamIzq ; i++)
			arrIzq[i] = arr[inicio+i];
		for(int i=0 ; i<tamDer ; i++)
			arrDer[i] = arr[mitad+i+1];

		int i=0 ,j=0, k=inicio;

		//Comezamos a mezclar los arreglos ordenados 
		while( i<tamIzq && j < tamDer){
			if( arrIzq[i]<=arrDer[j] ){
				arr[k] = arrIzq[i];
				i++;
			}else{
				arr[k] = arrDer[j];
				j++;
			}
			k++;
		}

		//Copia los elementos restantes de arrIzq[] si los hay
		while ( i<tamIzq ) { 
            arr[k] = arrIzq[i]; 
            i++; 
            k++; 
        }
        //Copia los elementos restantes de arrDer[] si los hay
        while ( i<tamDer ) { 
            arr[k] = arrDer[j]; 
            j++; 
            k++; 
        } 
        
	}
	
}//class Mergesort
