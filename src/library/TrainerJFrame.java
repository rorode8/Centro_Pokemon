package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class TrainerJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel j2, j3, j4;

	private ImageIcon iconNulo;

	private JLabel ho1;
	protected JButton addPokemon, removePokemon, inquiryPokemon, changeTrainer, backB, nextB, load, save;
	protected JLabel currentTrainer;
	protected JLabel currentBox;
	private Font Fx;

	public TrainerJFrame(String titulo) {
		super(titulo);

		// we load our place holder image that we're gonna used later on in case we
		// don't have any
		// pokemon to display

		try {
			iconNulo = new ImageIcon(ImageIO.read(new File("pokePNGs/placeHolder1.png")));
		} catch (IOException ex) {

		}

		// we initiate and create all the components that we're gonna add to our JPanels

		ho1 = new JLabel();

		ho1.setIcon(iconNulo);

		load = new JButton("Load");
		save = new JButton("Save");

		addPokemon = new JButton("add a Pokemon");
		backB = new JButton("Back");
		nextB = new JButton("Next");
		removePokemon = new JButton("remove a Pokemon");
		inquiryPokemon = new JButton("make a Pokemon Inquiry");
		changeTrainer = new JButton("change Trainer");
		currentTrainer = new JLabel("Trainer: " + PokeMethods.currentTrainer);

		currentBox = new JLabel("BOX #" + (PokeMethods.currentBox + 1));

		// we load our fancy Font because it's not by default on windows
		try {

			Font Caviar = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("CaviarDreams_BOLD.ttf")))
					.deriveFont(Font.PLAIN, 20);
			currentBox.setFont(Caviar);
			currentTrainer.setFont(Caviar);
		} catch (IOException | FontFormatException e) {
			// Handle exception
		}

		// we want it to be fairly big, so we se the size
		// we want it to spawn always right in the midddle of the screen so we set
		// Location relative to null
		// also we don't want our JFrame to be resizable since it would probably be a
		// mess
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);

		// we initiate our main JPanel
		JPanel panelMain = new JPanel(new GridBagLayout());
		// and of course our Constraints for it
		GridBagConstraints cMain = new GridBagConstraints();

		JPanel p = new JPanel(new GridBagLayout());
		// the Pokematrix is where all of our pokemons are gonna be display so therefore
		// we want it be 3x10, also give a bit of spaces
		// in between among the Pokemon cells

		JPanel pokeMatrix = new JPanel(new GridLayout(3, 10, 5, 5));
		// we create our 30 place holders as a JPanel array
		JPanel[] placeHolder = new JPanel[30];
		// this are fairly simple just 2 JPanels to contain our buttons
		JPanel bottomGrid = new JPanel(new GridBagLayout());
		JPanel bottomLeftGrid = new JPanel(new GridBagLayout());

		// this makes the Panel's transparent
		bottomLeftGrid.setOpaque(true);
		bottomLeftGrid.setBackground(new Color(0, 0, 0, 0));

		bottomGrid.setOpaque(true);
		bottomGrid.setBackground(new Color(0, 0, 0, 0));

		// we set a different color for the PokeMatrix
		pokeMatrix.setOpaque(true);
		pokeMatrix.setBackground(new Color(255, 142, 159));

		p.setOpaque(true);
		p.setBackground(new Color(0, 0, 0, 0));

		panelMain.setBackground(new Color(249, 74, 74));

		// we make all of our placeHolder JPanels transparent as well
		for (int i = 0; i < placeHolder.length; i++) {
			placeHolder[i] = new JPanel();
			placeHolder[i].setOpaque(true);
			placeHolder[i].setBackground(new Color(0, 0, 0, 0));
			pokeMatrix.add(placeHolder[i]);

			
		}
		
		//in case we don't have any Pokemon, we should use our place holder image so our PokeMatrix doesn't change sizes

		if (PokeMethods.MainPokeCenter.pokemonCountBoxTrainer(PokeMethods.currentTrainer,
				PokeMethods.currentBox) <= 0) {
			placeHolder[14].add(ho1);
		} else {
			//if we have at least one Pokemon, we don't need the place holder, since a single Pokemon icon can 
			//keep the shape and the size of the pokeMatrix 
			for (int i = 0; i < PokeMethods.MainPokeCenter.getTrainerPokeBox(PokeMethods.currentTrainer,
					PokeMethods.currentBox).length; i++) {
				if (PokeMethods.MainPokeCenter.getTrainerPokeBox(PokeMethods.currentTrainer,
						PokeMethods.currentBox)[i] != null) {
					JLabel auxJ = new JLabel();
					auxJ.setIcon(new ImageIcon(PokeMethods.MainPokeCenter.getTrainerPokeBox(PokeMethods.currentTrainer,
							PokeMethods.currentBox)[i].getImg()));
					placeHolder[i].add(auxJ);
				}
			}
		}

		cMain.insets = new Insets(5, 5, 50, 5);
		cMain.anchor = GridBagConstraints.LINE_START;
		//coordinates 0,0 for our JPanel main
		cMain.gridx = 0;
		cMain.gridy = 0;
		panelMain.add(changeTrainer, cMain);
		cMain.anchor = GridBagConstraints.CENTER;
		//coordinates 1,0 for our JPanel main
		cMain.gridx++;
		panelMain.add(currentTrainer, cMain);

		cMain.anchor = GridBagConstraints.LINE_START;
		//coordinates 0,1 for our JPanel main
		cMain.gridx = 0;
		cMain.gridy = 1;
		panelMain.add(p, cMain);
		cMain.anchor = GridBagConstraints.LINE_END;
		//coordinates 1,1 for our JPanel main
		cMain.gridx = 1;
		panelMain.add(pokeMatrix, cMain);
		//coordinates 1,2 for our JPanel main
		cMain.gridy = 2;
		cMain.gridx = 1;
		cMain.anchor = GridBagConstraints.CENTER;
		panelMain.add(bottomGrid, cMain);
		//coordinates 0,2 for our JPanel main
		cMain.gridy = 2;
		cMain.gridx = 0;
		panelMain.add(bottomLeftGrid, cMain);
		GridBagConstraints bottomGridC = new GridBagConstraints();
		bottomGridC.gridx = 0;
		bottomGridC.gridy = 0;
		bottomGridC.insets = new Insets(5, 5, 10, 5);
		bottomGridC.anchor = GridBagConstraints.LINE_END;

		bottomGrid.add(backB, bottomGridC);
		bottomGridC.gridx++;
		bottomGridC.anchor = GridBagConstraints.LINE_START;
		bottomGrid.add(nextB, bottomGridC);
		bottomGridC.gridx++;
		bottomGridC.anchor = GridBagConstraints.LINE_END;
		bottomGrid.add(currentBox, bottomGridC);

		GridBagConstraints bottomLeftC = new GridBagConstraints();
		bottomLeftC.gridx = 0;
		bottomLeftC.gridy = 0;
		bottomLeftC.insets = new Insets(5, 5, 10, 5);
		bottomLeftC.anchor = GridBagConstraints.LINE_START;
		bottomLeftGrid.add(load, bottomLeftC);
		bottomLeftC.gridx++;
		bottomLeftC.anchor = GridBagConstraints.LINE_END;
		bottomLeftGrid.add(save, bottomLeftC);

		/*
		 * panelMain.add(backB, cMain); cMain.gridx=1;
		 * cMain.anchor=GridBagConstraints.LINE_START; panelMain.add(nextB, cMain);
		 */

		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(5, 5, 15, 5);
		c.anchor = GridBagConstraints.LINE_START;
		c.gridx = 0;
		c.gridy = 0;
		p.add(addPokemon, c);
		c.gridy++;
		p.add(removePokemon, c);
		c.gridy++;
		p.add(inquiryPokemon, c);

		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_END;
		JPanel hold1 = new JPanel(), hold2 = new JPanel(), hold3 = new JPanel();
		hold1.setOpaque(true);
		hold1.setBackground(new Color(0, 0, 0, 0));

		hold2.setOpaque(true);
		hold2.setBackground(new Color(0, 0, 0, 0));

		hold3.setOpaque(true);
		hold3.setBackground(new Color(0, 0, 0, 0));

		p.add(hold1, c);
		c.gridy++;
		p.add(hold2, c);
		c.gridy++;
		p.add(hold3, c);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setVisible(true);
		add(panelMain);
	}

}
