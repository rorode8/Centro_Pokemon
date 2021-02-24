package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPokemonJFrame extends JFrame {
	
	private JLabel pokeName, nickName, pokeLevel, Box;
	protected JTextField nameFieldA, nicknameFieldA, levelFieldA, boxFieldA;
	protected JButton addPokemonI, BackA;
	
	public AddPokemonJFrame(String titulo) {
		super(titulo);
		pokeName=new JLabel("Pokemon :");
		pokeName.setFont(new Font("Tahoma",0,16));
		nickName=new JLabel("Nickname: ");
		nickName.setFont(new Font("Tahoma",0,16));
		pokeLevel=new JLabel("Level: ");
		pokeLevel.setFont(new Font("Tahoma",0,16));
		nameFieldA=new JTextField(12);
		nicknameFieldA=new JTextField(12);
		levelFieldA=new JTextField(12);
		addPokemonI=new JButton("add Pokemon");
		addPokemonI.setBackground(Color.RED);
		addPokemonI.setFont(new Font("Tahoma",1,20));
		BackA=new JButton("Back");
		BackA.setBackground(Color.CYAN);
		BackA.setFont(new Font("Tahoma",1,20));
		
		JPanel p =new JPanel(new GridLayout(7,1));
		JPanel buttons=new JPanel(new GridLayout(1,2));
		
		buttons.add(addPokemonI);
		buttons.add(BackA);
		p.add(pokeName);
		p.add(nameFieldA);
		p.add(nickName);
		p.add(nicknameFieldA);
		p.add(pokeLevel);
		p.add(levelFieldA);
		p.add(buttons);
		
		add(p);
		
		this.setBounds(350,350,400,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	

	

}
