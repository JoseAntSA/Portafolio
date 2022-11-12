package Metodos_Ordenamiento;
import java.util.*;


public class Burbuja implements Ordenamiento{

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

		int tmp;
		int arrtemp[] = getArr();

		for( int i=0 ; i<arrtemp.length ; i++){

			for( int j=0 ; j<(arrtemp.length)-1 ; j++){

				if( arrtemp[j] > arrtemp[j+1] ){

					tmp = arrtemp[j+1];
					arrtemp[j+1] = arrtemp[j];
					arrtemp[j] = tmp;				
				}//if
			}//for
		}//for
		setArr(arrtemp);
		System.out.printf("\n\n  Arreglo ordenado de menor a mayor...    ");
	}//ordenarMayor
/*	setArr(arrtemp);
	System.out.printf("\n  Iter " + i +": ");
	imprimirArreglo(arrtemp)
	public void imprimirArreglo( int[] arr ){
		System.out.printf("[ ");
		for(int p:arr)
			System.out.printf( p + " " );
		System.out.printf("]");
	}*/

}//class Burbuja
