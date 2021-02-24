package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemovePokemonJFrame extends JFrame	{
	
	private JLabel nameLabelR, nickNameLabelR, levelLabelR;
	protected JTextField nameFieldR, nickNameFieldR, levelFieldR;
	protected JButton removeAccept, backR;
	
	public RemovePokemonJFrame(String titulo) {
		super(titulo);
		
		nameLabelR=new JLabel("Name: ");
		nameLabelR.setFont(new Font("Tahoma",0,16));
		nickNameLabelR=new JLabel("Nickname: ");
		nameLabelR.setFont(new Font("Tahoma",0,16));
		levelLabelR=new JLabel("level :");
		levelLabelR.setFont(new Font("Tahoma",0,16));
		
		nameFieldR=new JTextField(12);
		nickNameFieldR=new JTextField(12);
		levelFieldR=new JTextField(12);
		
		removeAccept=new JButton("Accept");
		removeAccept.setFont(new Font("Tahoma",1,20));
		removeAccept.setBackground(Color.red);
		
		backR=new JButton("Back");
		backR.setFont(new Font("Tahoma",1,20));
		backR.setBackground(Color.CYAN);
		
		 JPanel pmain=new JPanel(new GridLayout(7,1));
		 JPanel buttons=new JPanel(new GridLayout(1,2));
		 buttons.add(removeAccept);
		 buttons.add(backR);
		 pmain.add(nameLabelR);
		 pmain.add(nameFieldR);
		 pmain.add(nickNameLabelR);
		 pmain.add(nickNameFieldR);
		 pmain.add(levelLabelR);
		 pmain.add(levelFieldR);
		 pmain.add(buttons);
		 add(pmain);
			
		this.setBounds(350,350,400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
		
		
		
		
	}
	
	
	
	

	
}
