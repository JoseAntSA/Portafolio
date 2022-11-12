package Programa_Virus;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Frame extends JFrame{
	
	//Atributos
	private JPanel pnl1;
	private JLabel etq1, etqIcono;
	private JButton btn1;
	private ImageIcon imagen;
	private JRadioButton rdbtn1;
	private boolean selec;

	public boolean getSelec(){
		return selec;
	}

	public Frame(){
		selec=false;
		Random r = new Random();
		setTitle("Virus");
		setSize(300,280);
		setResizable(false);
		setLocation((r.nextInt(350)+r.nextInt(350)),(r.nextInt(250)+r.nextInt(250)));
		initComponets();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}//constructor

	public void initComponets(){


		//----------------------------------------- CODIGO PANEL
		pnl1 = new JPanel();
        this.getContentPane().add(pnl1);
		pnl1.setBackground(Color.WHITE);
 		pnl1.setLayout(null);

 		pnl1.setFocusable(true);
 		EventoPanel chismoso2 = new EventoPanel();
		pnl1.addKeyListener( chismoso2 );

 		//----------------------------------------- CODIGO ETIQUETAS

        etq1 = new JLabel("Esto es un virus hehehe :D");
		etq1.setBounds(60,10,240,20);
        etq1.setOpaque(true);
        etq1.setBackground(Color.WHITE);
        etq1.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etq1);

 		imagen = new ImageIcon(this.getClass().getResource("Imagen1.jpg"));
		etqIcono = new JLabel();
		etqIcono.setBounds(80,40,120,120);
		etqIcono.setIcon(new ImageIcon( imagen.getImage().getScaledInstance( etqIcono.getWidth(), etqIcono.getHeight(), Image.SCALE_SMOOTH )));
 		pnl1.add(etqIcono);

		//----------------------------------------- CODIGO RADIO BOTON1 
		rdbtn1 = new JRadioButton("Selecciona para detener",false);
		rdbtn1.setBounds(40,160,230,30);
		rdbtn1.setFont( new Font( "Tw Cen MT", 1, 15 ) );
		rdbtn1.setBackground(Color.WHITE);
		pnl1.add(rdbtn1);

		//----------------------------------------- CODIGO BOTON1
		Color colorBtn = new Color(144,144,144);
		btn1 = new JButton("Detener el virus");
		btn1.setBounds(80,195,110,30);
		btn1.setBackground(colorBtn);
		btn1.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btn1.setForeground(Color.WHITE); 
		btn1.setFocusPainted(false);

		EventoBoton chismoso1 = new EventoBoton();
		btn1.addActionListener( chismoso1 );

		pnl1.add(btn1);

 	}

 	//--------------------------------------------- CODIGO EVENTO BOTON BUSCAR
 	public class EventoBoton implements ActionListener{

		public void actionPerformed(ActionEvent ev){
			JOptionPane.showMessageDialog(null,"Hasta crees que se detendra :v","Te la creiste haha",JOptionPane.INFORMATION_MESSAGE);
		}//evento
	}//clase interna	

	//--------------------------------------------- CODIGO EVENTO TECLADO PARA CTRL+A
	public class EventoPanel implements KeyListener{

		public void keyTyped(KeyEvent e){
        }//Evento Nulo
        public void keyReleased(KeyEvent e){
        }//Evento Nulo
        public void keyPressed(KeyEvent e){
           	if((e.getKeyCode() == KeyEvent.VK_A) && ((e.getModifiers() & KeyEvent.CTRL_MASK) != 0))
           		selec = true;
        }//Evento 
	}//clase interna
}//Frame