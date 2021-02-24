package library;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class InquiryJFrame extends JFrame {

	protected JTextArea bigField;
	protected JLabel Pokemon;
	protected JButton givePokemon, giveTrainers, backInq;

	public InquiryJFrame(String titulo) {
		super(titulo);

		bigField = new JTextArea(50, 1);
		GridBagConstraints c = new GridBagConstraints();
		givePokemon = new JButton("Print All Pokemon for Trainer :" + "\n" + PokeMethods.currentTrainer);
		giveTrainers = new JButton("Print all Trainers for this PokeCenter");
		backInq = new JButton("Back");
		bigField.setText("                                  ");
		bigField.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(bigField, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		JPanel pmain = new JPanel(new GridBagLayout());
		// JPanel text=new JPanel();
		// text.setBorder(new EmptyBorder(5,5,5,5));
		// text.setLayout(new BorderLayout(0,0));
		// text.add(bigField);
		// text.add(scrollPane);
		c.gridx = 0;
		c.gridy = 0;
		c.fill = GridBagConstraints.BOTH;
		c.weighty = 1;
		pmain.add(givePokemon, c);
		c.gridy++;
		pmain.add(giveTrainers, c);
		c.gridy++;
		pmain.add(backInq, c);
		c.gridx = 1;
		c.gridy = 0;
		scrollPane.setMinimumSize(new Dimension(450, 650));
		c.gridheight = 3;
		c.gridwidth = 2;
		c.weighty = 1;
		// pmain.add(text,c);
		pmain.add(scrollPane, c);
		Border gap = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		// pmain.add(scrollPane);
		pmain.setBorder(gap);

		add(pmain);
		setSize(700, 750);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
	}

}
