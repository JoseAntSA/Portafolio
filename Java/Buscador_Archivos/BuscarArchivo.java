package Buscador_Archivos;
import java.io.*;
import java.util.*;

public class BuscarArchivo{

    public static String buscarRecursivo(String dir, String arc, String c ) {
        File ruta = new File(dir);

        File[] dirContenido = ruta.listFiles();
        
        if (dirContenido == null || dirContenido.length == 0)
           return c;
        
        else{
           	for (File file : dirContenido){
                if ( file.isDirectory() )
                    c = c + buscarRecursivo(file.getAbsolutePath() , arc, "");
            	if( file.isFile() && arc.equals( file.getName() ) )
                	c = c + file.getAbsolutePath() + "\n";        
            }//for
            return c;
        }//else
        
    }//Metodo

    public static String buscarIterando(String dir, String arc, String c ) {

        List<String> lista = new ArrayList<String>();
        lista.add(dir);

        do{

            File ruta = new File(lista.get(0));
            File[] dirContenido = ruta.listFiles();
            
            if (dirContenido == null || dirContenido.length == 0)
                c = c + "";
            else{
                for (File file : dirContenido){
                    if ( file.isDirectory() )
                        lista.add( file.getAbsolutePath() );
                    if( file.isFile() && arc.equals( file.getName() ) )
                        c = c + file.getAbsolutePath() + "\n";        
                }//for
            }//else

            lista.remove(0);


        }while( lista.isEmpty() == false );

    return c;

        
        
    }//Metodo


}