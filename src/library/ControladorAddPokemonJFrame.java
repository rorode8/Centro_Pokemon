package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorAddPokemonJFrame extends AddPokemonJFrame {

	static void PlaySoundd(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {

		}

	}

	public ControladorAddPokemonJFrame(String titulo) {
		super(titulo);
		addPokemonI.addActionListener(new EscuchaAddPokemon());
		BackA.addActionListener(new EscuchaBackA());

	}

	public class EscuchaBackA implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			File f = new File("back.wav");
			PlaySoundd(f);
			setVisible(false);
			ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
		}
	}

	public class EscuchaAddPokemon implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			boolean real = false;

			String auxName = nameFieldA.getText();
			String auxNickName = nicknameFieldA.getText();
			int auxLevel = Integer.parseInt(levelFieldA.getText());

			for (int i = 0; i < PokeMethods.Pokedex.length; i++) {
				if (auxName.equalsIgnoreCase(PokeMethods.Pokedex[i].getName())) {
					real = true;
				}
			}

			if (real == true) {

				if (PokeMethods.MainPokeCenter.pokemonCountBoxTrainer(PokeMethods.currentTrainer,
						PokeMethods.currentBox) == 30) {

					File f = new File("error.wav");
					PlaySoundd(f);
					try {
						ImageIcon iconError;
						iconError = new ImageIcon(ImageIO.read(new File("alakazam.png")));
						JOptionPane.showMessageDialog(null,
								"the current box: " + (PokeMethods.currentBox + 1) + "# is full", "Error", 0,
								iconError);
					} catch (IOException ex) {

					}

				} else {
					PokeMethods.MainPokeCenter.addPokemon(PokeMethods.currentTrainer, auxName, auxNickName, auxLevel,
							PokeMethods.currentBox);
					File f = new File("success.wav");
					PlaySoundd(f);
					ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
					setVisible(false);
				}

			} else {
				ImageIcon iconError;
				File f = new File("error.wav");
				PlaySoundd(f);
				try {
					iconError = new ImageIcon(ImageIO.read(new File("unown.png")));
					JOptionPane.showMessageDialog(null, "that Pokemon doesn't exist, dummy", "Error", 0, iconError);
				} catch (IOException ex) {

				}

			}

		}
	}

}
