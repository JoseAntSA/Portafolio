package Metodos_Ordenamiento;
import java.util.*;


public class Insercion implements Ordenamiento{

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

		int tmp, j;
		int arrtemp[] = getArr();

		for( int i=1; i<arrtemp.length ; i++){		
			tmp = arrtemp[i];
			j = i-1;
			while( j>=0  && arrtemp[j]>tmp ){
				arrtemp[j+1] = arrtemp[j];
				j--;
			}
			arrtemp[j+1] = tmp;
		}//for
		setArr(arrtemp);
		System.out.printf("\n\n  Arreglo ordenado de menor a mayor...    ");
	}//ordenarMayor
}//class Insercion
