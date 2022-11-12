package Carrera_Caballos;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.lang.Math;

public class Frame2 extends JFrame{
	
	//Atributos
	static JPanel pnl;
	static JLabel etq;
	static JButton btn1, btn2, btn3;
	static JProgressBar barra;
	static int num, num2;
	
	ArrayList<Hilo2> lista = new ArrayList<Hilo2>();

	public Frame2( int n ){
		num = n;
		setTitle("Carreras de caballos");
		if(n>1 && n<=25){
			setSize(380,165+(num*20));
			num2 = num;
		}
		else if(n>25 && n<=50){
			setSize(760,665);
			num2 = 25;
		}
		else if(n>50 && n<=75){
			setSize(1140,665);
			num2 = 25;
		}
		setResizable(false);
		setLocationRelativeTo(null);
		initComponets();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//constructor

	public void initComponets(){

		//----------------------------------------- CODIGO PANEL
		pnl = new JPanel();
        this.getContentPane().add(pnl);
		pnl.setBackground(Color.WHITE);
 		pnl.setLayout(null);

 		int disV, disH;
 		for( int i=0 ; i<num ; i++){
 			disV = 30+(i*20);
 			disH = 30;
			if(i>24 && i<=49){
				disV = 30+(i*20)-500;
				disH = 410;
			}
			if(i>49 && i<=74){
				disV = 30+(i*20)-1000;
				disH = 790;
			}
			
 			//----------------------------------------- CODIGO ETIQUETAS
	        etq = new JLabel("Caballo " + (i+1));
			etq.setBounds(disH,disV,100,20);
	        etq.setOpaque(true);
	        etq.setBackground(Color.WHITE);
	        etq.setFont( new Font( "Tw Cen MT", 1, 15 ) );
	        pnl.add(etq);

	        //----------------------------------------- CODIGO BARRAS DE PROGRESO
	        barra = new JProgressBar();
			barra.setValue(0);
			barra.setStringPainted(true);
			barra.setBounds(disH+100,disV,200,19); 
			Hilo2 c1 = new Hilo2( barra );
			c1.setName("Caballo " + (i+1));
			lista.add(c1);
			pnl.add(barra);
			
 		}
		disH = 30;
		if(num>25)
			disH = 250;
		if(num>50)
			disH = 410;
		
		//----------------------------------------- CODIGO BOTONES
		Color colorBtn = new Color(144,144,144);
		btn1 = new JButton("Iniciar");
		btn1.setBounds(disH,50+(num2*20),60,30);
		btn1.setBackground(colorBtn);
		btn1.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btn1.setForeground(Color.WHITE); 
		btn1.setFocusPainted(false);
		//----------------------------------------- CODIGO EVENTO BOTON INICIAR
		btn1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ev){
				btn1.setEnabled(false);
				for(int i=0 ;i<num ;i++)
					lista.get(i).start();
			}//evento
        });
		pnl.add(btn1);

		btn2 = new JButton("Repetir");
		btn2.setBounds(disH+85,50+(num2*20),60,30);
		btn2.setBackground(colorBtn);
		btn2.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btn2.setForeground(Color.WHITE); 
		btn2.setFocusPainted(false);
		//----------------------------------------- CODIGO EVENTO BOTON REPETIR CARRERA
		btn2.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ev){
				Frame2 vtnNew = new Frame2( num );
				dispose();	
			}//evento
        });
		pnl.add(btn2);

		btn3 = new JButton("Iniciar otra carrera");
		btn3.setBounds(disH+170,50+(num2*20),130,30);
		btn3.setBackground(colorBtn);
		btn3.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btn3.setForeground(Color.WHITE); 
		btn3.setFocusPainted(false);
		//----------------------------------------- CODIGO EVENTO BOTON CREAR OTRA CARRERA
		btn3.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ev){
        		Principal vtnNew1 = new Principal();
				dispose();	
			}//evento
        });
		pnl.add(btn3);
 	}

}//Frame

class Hilo2 extends Thread{

	JProgressBar barra;
	int i=0;

	Hilo2(JProgressBar b){
		barra = b;
	}
	
	public void run(){	
		System.out.println( Thread.currentThread().getName() + " ha iniciado la carrera");	
		try {
			
			while (i <= 100) {  
				Random r = new Random();
                barra.setValue(i + 2);
                sleep((int) (Math.random() * 2000));
                i += 2; 
            } 
            System.out.println( Thread.currentThread().getName() + " ha finalizado la carrera");				
		} catch (InterruptedException e) {
			System.out.println(e);				
		}

		
	}	
	
}

