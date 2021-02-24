package library;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeTrainerJFrame extends JFrame {

	private JLabel trainerName;
	protected JCheckBox newTrainer;
	protected JButton trainerAccept, trainerBack;
	protected JTextField trainerNameField;

	public ChangeTrainerJFrame(String titulo) {
		super(titulo);
		trainerName = new JLabel("Trainer name: ");
		trainerName.setFont(new Font("Tahoma", 0, 16));
		newTrainer = new JCheckBox("new trainer");
		newTrainer.setFont(new Font("Tahoma", 0, 16));
		trainerBack = new JButton("Back");
		trainerBack.setFont(new Font("Tahoma", 1, 20));
		trainerBack.setBackground(Color.CYAN);
		trainerAccept = new JButton("Accept");
		trainerAccept.setFont(new Font("Tahoma", 1, 20));
		trainerNameField = new JTextField(12);
		trainerAccept.setBackground(Color.RED);

		JPanel p = new JPanel(new GridLayout(4, 1));
		JPanel buttons = new JPanel(new GridLayout(1, 2));

		buttons.add(trainerAccept);
		buttons.add(trainerBack);
		p.add(trainerName);
		p.add(trainerNameField);
		p.add(newTrainer);
		p.add(buttons);

		add(p);

		setBounds(300, 300, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

}
