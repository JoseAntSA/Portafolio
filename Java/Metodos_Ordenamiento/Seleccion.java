package Metodos_Ordenamiento;
import java.util.*;


public class Seleccion implements Ordenamiento{


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
		int tmp, j, pos;
		int arrtemp[] = getArr();

		for( int i=0 ; i<arrtemp.length ; i++ ){
			pos = buscaMenor( arrtemp, arrtemp.length, i);
			tmp = arrtemp[i];
			arrtemp[i] = arrtemp[pos];
			arrtemp[pos] = tmp;
		}//for
		setArr(arrtemp);
		System.out.printf("\n\n  Arreglo ordenado de menor a mayor...    ");
	}//ordenarMayor
	public int buscaMenor( int[] arr, int tam, int inicio){
		int menor, pos;

		menor = arr[inicio];
		pos = inicio;
		for( int i=inicio+1 ; i<tam ; i++){
				if(arr[i]<menor){
					menor = arr[i];
					pos = i;
				}
			}
		return pos;
	}
}//class Seleccion
