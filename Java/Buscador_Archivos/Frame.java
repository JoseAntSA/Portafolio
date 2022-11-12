package Buscador_Archivos;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class Frame extends JFrame{
	
	//Atributos
	private JPanel pnl1;
	private JLabel etqDir, etqArc, etqRes, etqIcono, etqDiv, etqDiv2;
	private JTextField txtDir, txtArc;
	private JButton btnBuscar;
	private JTextArea area;
	private ImageIcon imagen;
	private JRadioButton rdIter, rdRecu;
	private ButtonGroup grupo; 
	private TextPrompt txtTempDir, txtTempArc;

	public Frame(){
		setTitle("Buscador de archivos");
		setSize(660,250);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponets();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}//constructor

	public void initComponets(){


		//----------------------------------------- CODIGO PANEL
		pnl1 = new JPanel();
        this.getContentPane().add(pnl1);
		pnl1.setBackground(Color.WHITE);
 		pnl1.setLayout(null);

 		//----------------------------------------- CODIGO ETIQUETAS
 	    etqArc = new JLabel("Archivo:");
		etqArc.setBounds(200,25,100,20);
        etqArc.setOpaque(true);
        etqArc.setBackground(Color.WHITE);
        etqArc.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqArc);

        etqDir = new JLabel("Direccion:");
		etqDir.setBounds(200,80,100,20);
        etqDir.setOpaque(true);
        etqDir.setBackground(Color.WHITE);
        etqDir.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqDir);

        etqDir = new JLabel("__________________________________________________");
		etqDir.setBounds(200,50,400,20);
        etqDir.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqDir);

        etqDir = new JLabel("__________________________________________________");
		etqDir.setBounds(200,105,400,20);
        etqDir.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl1.add(etqDir);

 		imagen = new ImageIcon(this.getClass().getResource("Imagen1.png"));
		etqIcono = new JLabel(/*"Hola",imagen,SwingConstants.CENTER*/);
		etqIcono.setBounds(40,40,120,120);
		//etqIcono.setOpaque(true);
		//etqIcono.setBackground(Color.WHITE);
		etqIcono.setIcon(new ImageIcon( imagen.getImage().getScaledInstance( etqIcono.getWidth(), etqIcono.getHeight(), Image.SCALE_SMOOTH )));
 		pnl1.add(etqIcono);

 		//----------------------------------------- CODIGO CAJAS TEXTO
		txtArc = new JTextField();
		txtArc.setBounds(200,45,400,20);
		txtArc.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtArc.setForeground(Color.BLACK);
		txtTempArc = new TextPrompt("Ejemplo: Summer2018.pdf", txtArc);
    	txtTempArc.changeStyle(Font.ITALIC);
    	txtTempArc.setForeground(Color.GRAY);
		pnl1.add(txtArc);

		txtDir = new JTextField();
		txtDir.setBounds(200,100,400,20);
		txtDir.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txtDir.setForeground(Color.BLACK);
		txtTempDir = new TextPrompt("Ejemplo: C:/Documents/Newsletters", txtDir);
    	
    	txtTempDir.changeStyle(Font.ITALIC);
    	txtTempDir.setForeground(Color.GRAY);
		pnl1.add(txtDir);

		//----------------------------------------- CODIGO RADIO BOTON 
		rdIter = new JRadioButton("Iterando",true);
		rdIter.setBounds(198,140,150,20);
		rdIter.setFont( new Font( "Tw Cen MT", 1, 15 ) );
		rdIter.setBackground(Color.WHITE);
		pnl1.add(rdIter);

		rdRecu = new JRadioButton("Recursivamente",false);
		rdRecu.setBounds(198,160,150,20);
		rdRecu.setFont( new Font( "Tw Cen MT", 1, 15 ) );
		rdRecu.setBackground(Color.WHITE);
		pnl1.add(rdRecu);

		grupo = new ButtonGroup();
		grupo.add(rdIter);
		grupo.add(rdRecu);
		

		//----------------------------------------- CODIGO BOTON BUSCAR
		Color colorBtn = new Color(144,144,144);
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(520,145,80,30);
		btnBuscar.setBackground(colorBtn);
		btnBuscar.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btnBuscar.setForeground(Color.WHITE); 
		btnBuscar.setFocusPainted(false);

		EventoBotonBuscar chismoso1 = new EventoBotonBuscar();
		btnBuscar.addActionListener( chismoso1 );

		pnl1.add(btnBuscar);
 	}	

 	//--------------------------------------------- CODIGO EVENTO BOTON BUSCAR
 	public class EventoBotonBuscar implements ActionListener{

		public void actionPerformed(ActionEvent ev){
			//Comprobar directorio
			if(txtDir.getText().trim().equals("") || txtArc.getText().trim().equals(""))
				JOptionPane.showMessageDialog(null,"Alguno de los campos se encuentra vacio","Campo vacio",JOptionPane.INFORMATION_MESSAGE);
			else{
				File direc = new File(txtDir.getText());
				if ( direc.isDirectory() ){
					//Definir resultados de la busqueda
					BuscarArchivo buscador = new BuscarArchivo();
					String resul = "";

					if(rdIter.isSelected())
						resul = buscador.buscarIterando(txtDir.getText(), txtArc.getText(), "");
					else
						resul = buscador.buscarRecursivo(txtDir.getText(), txtArc.getText(), "");

					//Irse a la Ventana de resultados
					if(resul.trim().equals("")){
						Frame2 vtn2 = new Frame2("Imagen3.jpg");
						vtn2.getArea().setText("No se encontraron coincidencias dentro del directorio...");
					}
					else{
						Frame2 vtn2 = new Frame2("Imagen2.png");
						vtn2.getArea().setText(resul);
					}
				}
				else
					JOptionPane.showMessageDialog(null,"El directorio introducido no existe","Directorio invalido",JOptionPane.INFORMATION_MESSAGE);
			}
		}//evento
	}//clase interna

}//main
