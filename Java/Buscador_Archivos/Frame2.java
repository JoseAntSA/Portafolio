package Buscador_Archivos;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Frame2 extends JFrame{
	
	//Atributos
	private JPanel pnl1;
	private JLabel etqRes, etqIcono, etqDiv;
	private JButton btnReg;
	private JTextArea area;
	private ImageIcon imagen;
	private JScrollPane barraNav;
	private String nombreImagen;

	public JTextArea getArea(){
		return area;
	}

	public Frame2( String n ){
		nombreImagen = n;
		setTitle("Buscador de archivos");
		setSize(850,350);
		setResizable(false);
		setLocationRelativeTo(null);
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

 		//----------------------------------------- CODIGO ETIQUETAS
 	    etqRes = new JLabel("Archivos encontrados:");
		etqRes.setBounds(200,25,180,20);
        etqRes.setOpaque(true);
        etqRes.setBackground(Color.WHITE);
        etqRes.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqRes);

        etqDiv = new JLabel("_________________________________________________________________________");
		etqDiv.setBounds(200,35,590,20);
        etqDiv.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqDiv);

 		imagen = new ImageIcon(this.getClass().getResource(nombreImagen));
		etqIcono = new JLabel();
		etqIcono.setBounds(19,40,160,160);
		etqIcono.setIcon(new ImageIcon( imagen.getImage().getScaledInstance( etqIcono.getWidth(), etqIcono.getHeight(), Image.SCALE_SMOOTH )));
 		pnl1.add(etqIcono);

 		//----------------------------------------- CODIGO CAJA AREATEXTO
		area = new JTextArea ();
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		Color colorArea = new Color(231,235,218);
		area.setBackground(colorArea);
		area.setBorder(BorderFactory.createLineBorder(colorArea));
		area.setEditable(false);
		barraNav = new JScrollPane(area);
		barraNav.setBounds(200,65,590,200);	
		pnl1.add(barraNav);

		//----------------------------------------- CODIGO BOTON REGRESAR
		Color colorBtn = new Color(144,144,144);
		btnReg = new JButton("Regresar");
		btnReg.setBounds(55,220,90,30);
		btnReg.setBackground(colorBtn);
		btnReg.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btnReg.setForeground(Color.WHITE); 
		btnReg.setFocusPainted(false);

		EventoBotonReg chismoso1 = new EventoBotonReg();
		btnReg.addActionListener( chismoso1 );

		pnl1.add(btnReg);
 	}	

 	//--------------------------------------------- CODIGO EVENTO BOTON REGRESAR
 	public class EventoBotonReg implements ActionListener{

		public void actionPerformed(ActionEvent ev){

			//Regresar a la Ventana principal			
			dispose();

		}//evento
	}//clase interna
}//main
