package Programa_Virus;

public class Principal{
	
	public static void main(String[]args){
		while(true){
			Tarea hilo = new Tarea();
			hilo.start();
			try{
				hilo.sleep(1000);
				if(hilo.getVentana().getSelec() == true)
					hilo.join();
			}catch( InterruptedException ex ) {
				System.out.println( ex +  " " + Thread.currentThread().getName() +"\t");
			}
		}
	}


}//class

class Tarea extends Thread{
	Frame vtn3;
	Frame2 vtn2;
	Frame vtn = new Frame();

	public Frame getVentana(){
		return vtn;
	}

	public void run(){
		Thread n = Thread.currentThread();
		try{
			while(true){
				if(vtn.getSelec() == false)
					n.sleep(1000);
				else{
					vtn2 = new Frame2();
					while(!vtn2.getSelec()){
						n.sleep(1000);
					}
					vtn2.dispose();
					for(int i =0 ; i<10 ; i++)
						vtn3 = new Frame();
					break;
				}	
			}
		}catch( InterruptedException ex ) {
			System.out.println( ex +  " " + Thread.currentThread().getName() +"\t");
		}
	}

	
}	
