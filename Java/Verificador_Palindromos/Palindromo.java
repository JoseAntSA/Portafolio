package Verificador_Palindromos;
import java.util.*;

public class Palindromo{
	
	public static void esPalindromo( String n ){
		
		if( n.charAt(0) != n.charAt(n.length()-1) )
			System.out.printf(" NO es una frase o palabra palindroma\n");			
		else{
			if(n.length() <= 2){
				System.out.printf(" es una frase o palabra palindroma\n");
				return;	
			}
			esPalindromo( n.substring( 1, n.length()-1 ) );
		}
	}	
}