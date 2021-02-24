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

public class ControladorRemovePokemonJFrame extends RemovePokemonJFrame {

	static void PlaySoundd(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {

		}

	}

	public ControladorRemovePokemonJFrame(String titulo) {
		super(titulo);
		removeAccept.addActionListener(new EscuchaRemoveAccept());
		backR.addActionListener(new EscuchaBackR());

	}

	public class EscuchaBackR implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			File f = new File("back.wav");
			PlaySoundd(f);
			setVisible(false);
			ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
		}
	}

	public class EscuchaRemoveAccept implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			boolean r;
			String auxName = nameFieldR.getText();
			String auxNickname = nickNameFieldR.getText();
			int auxLevel = Integer.parseInt(levelFieldR.getText());

			r = PokeMethods.MainPokeCenter.PokemonWithdraw(PokeMethods.currentTrainer, auxName, auxNickname, auxLevel);

			if (r == true) {
				File f = new File("success.wav");
				PlaySoundd(f);
				setVisible(false);
				ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");

			} else {
				File f = new File("error.wav");
				PlaySoundd(f);
				try {
					ImageIcon iconError;
					iconError = new ImageIcon(ImageIO.read(new File("alakazam.png")));
					JOptionPane.showMessageDialog(null,
							"That Pokemon doesn't exist or is not within this trainer's account", "Error", 0,
							iconError);
				} catch (IOException ex) {

				}
				
			}

		}

	}

}
