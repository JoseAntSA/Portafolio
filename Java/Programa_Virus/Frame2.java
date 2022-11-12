package Programa_Virus;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Frame2 extends JFrame{
	
	//Atributos
	private JPanel pnl1;
	private JLabel etq1, etq2, etq3;
	private JTextField txt1;
	private JButton btn1;
	private boolean selec=false;
	Frame vtn4;
	public boolean getSelec(){
		return selec;
	}

	public Frame2(){
		setTitle("Oportunidad para detener esta cosa");
		setSize(300,200);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponets();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(
            new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    JOptionPane.showMessageDialog(null,"No debiste presionar ese boton...", "Hiciste mal",JOptionPane.INFORMATION_MESSAGE);
                    selec= true;
                }
            }
	    );
		setVisible(true);
	}//constructor

	public void initComponets(){


		//----------------------------------------- CODIGO PANEL
		pnl1 = new JPanel();
        this.getContentPane().add(pnl1);
		pnl1.setBackground(Color.WHITE);
 		pnl1.setLayout(null);

 		//----------------------------------------- CODIGO ETIQUETAS

        etq1 = new JLabel("Wow supiste la clave,");
		etq1.setBounds(40,10,200,20);
        etq1.setOpaque(true);
        etq1.setBackground(Color.WHITE);
        etq1.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etq1);

        etq2 = new JLabel("bien te dare una oportunidad");
		etq2.setBounds(40,30,230,20);
        etq2.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etq2);

        etq3 = new JLabel("__________________________");
		etq3.setBounds(40,60,215,20);
        etq3.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etq3);

 		
 		//----------------------------------------- CODIGO CAJA TEXTO
 		txt1 = new JTextField();
		txt1.setBounds(40,55,200,20);
		txt1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txt1.setForeground(Color.BLACK);
		pnl1.add(txt1);

		//----------------------------------------- CODIGO BOTON BUSCAR
		Color colorBtn = new Color(144,144,144);
		btn1 = new JButton("Detener");
		btn1.setBounds(107,105,80,30);
		btn1.setBackground(colorBtn);
		btn1.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btn1.setForeground(Color.WHITE); 
		btn1.setFocusPainted(false);

		EventoBoton chismoso1 = new EventoBoton();
		btn1.addActionListener( chismoso1 );

		pnl1.add(btn1);

		//----------------------------------------- CODIGO EVENTO TECLADO PARA ENTER EN ETQ1
		txt1.setFocusable(true);
		txt1.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                //Nada
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
 						btn1.doClick();
	        }
            public void keyReleased(KeyEvent e){
                //Nada
            }
        });

 	}

 	//--------------------------------------------- CODIGO EVENTO BOTON BUSCAR
 	public class EventoBoton implements ActionListener{

		public void actionPerformed(ActionEvent ev){
			if(txt1.getText().trim().equals("Programacion"))
				System.exit(0);
			else{
				
				int resp = JOptionPane.showConfirmDialog(null, "Error de equivocaste :(... mereces un castigo, Que dices?","", JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
				String mensaje = "";
		        switch (resp) {
		        case 0:
		            mensaje = "Vale pues ahi te va";
		            break;
		        case 1:
		            mensaje = "No es Si asi que no importa :v";
		            break;
		        }
		        JOptionPane.showMessageDialog(null, mensaje,"",JOptionPane.INFORMATION_MESSAGE);
		        selec= true;
			}
		}//evento
	}//clase interna
}//Frame2
