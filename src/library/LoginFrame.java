package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginFrame extends JFrame{
	
	//private static final long serialVersionUID= 1L;
		protected JTextField cityField;
		protected JTextField nurseField, fTrainerField;
		protected JButton accept;
		private JLabel us, pa, FirstTrainer;
		
		public LoginFrame(String titulo) {
			super(titulo);
		//creacion de los componentes
			us=new JLabel("City: ");
			us.setFont(new Font("Tahoma",0,16));
			cityField= new JTextField(12);
			//cityField.setText(" ");
			pa=new JLabel("Nurse: ");
			pa.setFont(new Font("Tahoma",0,16));
			nurseField=new JTextField(12);
			//nurseField.setText(" ");
			accept=new JButton("accept");
			accept.setBackground(Color.PINK);
			FirstTrainer=new JLabel("FirstTrainer: ");
			FirstTrainer.setFont(new Font("Tahoma",0,16));
			fTrainerField=new JTextField(12);
			
			//llenamos la Pokedex desde el momento de crear este JFrame
			PokeMethods.fill("Pokedex.txt");
			
			//adicion al contenedor 
			JPanel p =new JPanel();
			
			p.setLayout(new GridLayout(7,1));
			Border gap=BorderFactory.createEmptyBorder(10,10,10,10);
			p.setBorder(gap);
			
			p.add(us);
			p.add(cityField);
			p.add(pa);
			p.add(nurseField);
			p.add(FirstTrainer);
			p.add(fTrainerField);
			p.add(accept);
			
			add(p);
			
			//visualizar
			
			this.setBounds(100,100,400,350);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
		
			
			
		
			
		}
		
		
				
	
	}
