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

public class ControladorLoginFrame extends LoginFrame {

	static void PlaySoundd(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {

		}

	}

	public ControladorLoginFrame(String titulo) {
		super(titulo);
		accept.addActionListener(new EscuchaBotton());
	}

	public class EscuchaBotton implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String city, nurse, firstTrainer;
			city = cityField.getText();
			nurse = nurseField.getText();
			firstTrainer = fTrainerField.getText();

			if (city.equals("") || nurse.equals("") || firstTrainer.equals("")) {
				ImageIcon iconError;
				File f = new File("error.wav");
				PlaySoundd(f);
				try {
					iconError = new ImageIcon(ImageIO.read(new File("abra.png")));
					JOptionPane.showMessageDialog(null, "YOU MUST FILL ALL THE FIELDS!!!!, dummy", "Error", 0,
							iconError);
				} catch (IOException ex) {

				}

			} else {
				File f = new File("success.wav");
				PlaySoundd(f);
				PokeMethods.MainPokeCenter = new CentroPokemon(city, nurse);
				PokeMethods.MainPokeCenter.addTrainer(firstTrainer);
				PokeMethods.currentTrainer = firstTrainer;

				// PokeMethods.fill("Pokedex.txt");

				setVisible(false);
				ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Display");

			}

		}

	}

}
