package Carrera_Caballos;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

class Principal extends JFrame{
	
	public static void main(String[]args){
		Principal vtn = new Principal();
	}

	private JPanel pnl;
	private JLabel etq;
	private JTextField txt;
	private JButton btn;


	public Principal(){
		setTitle("Inicio");
		setSize(280,160);
		setResizable(false);
		setLocationRelativeTo(null);
		initComponets();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public void initComponets(){
		//----------------------------------------- CODIGO PANEL
		JPanel pnl = new JPanel();
        this.getContentPane().add(pnl);
		pnl.setBackground(Color.WHITE);
 		pnl.setLayout(null);

 		//----------------------------------------- CODIGO ETIQUETAS
        JLabel etq = new JLabel("Caballos que correran:");
		etq.setBounds(30,20,180,20);
        etq.setOpaque(true);
        etq.setBackground(Color.WHITE);
        etq.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl.add(etq);

        etq = new JLabel("____");
		etq.setBounds(200,25,35,20);
        etq.setFont( new Font( "Tw Cen MT", 1, 15 ) );
        pnl.add(etq);

        //----------------------------------------- CODIGO CAJA DE TEXTO
        JTextField txt = new JTextField();
		txt.setBounds(200,20,35,20);
		txt.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		txt.setForeground(Color.BLACK);
		txt.setHorizontalAlignment(SwingConstants.CENTER);
		pnl.add(txt);

		//----------------------------------------- CODIGO BOTONES
		Color colorBtn = new Color(144,144,144);
		JButton btn = new JButton("Crear Carrera");
		btn.setBounds(75,65,100,30);
		btn.setBackground(colorBtn);
		btn.setBorder(BorderFactory.createLineBorder(colorBtn)); 
		btn.setForeground(Color.WHITE); 
		btn.setFocusPainted(false);
		//----------------------------------------- CODIGO EVENTO BOTON CREAR
		btn.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ev){
        		Frame2 vtn;
        		if(Integer.parseInt(txt.getText()) < 2 || Integer.parseInt(txt.getText()) > 75)
        			JOptionPane.showMessageDialog(null,"Ingresa un numero mayor a 1 y menor a 76", "Numero incorrecto",JOptionPane.ERROR_MESSAGE);
        		else{
					vtn = new Frame2( Integer.parseInt(txt.getText()) );
					dispose();
        		}
			}//evento
        });
		pnl.add(btn);

	}

	
}


