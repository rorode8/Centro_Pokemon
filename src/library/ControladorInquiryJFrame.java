package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ControladorInquiryJFrame extends InquiryJFrame {

	static void PlaySoundd(File sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength() / 1000);

		} catch (Exception e) {

		}

	}

	public ControladorInquiryJFrame(String titulo) {
		super(titulo);
		givePokemon.addActionListener(new EscuchaGivePokemon());
		backInq.addActionListener(new EscuchaBackInq());
		giveTrainers.addActionListener(new EscuchaGiveTrainers());

	}

	public class EscuchaGiveTrainers implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			File f = new File("button.wav");
			PlaySoundd(f);
			bigField.setText(PokeMethods.MainPokeCenter.toStringCenter());

		}
	}

	public class EscuchaGivePokemon implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			File f = new File("button.wav");
			PlaySoundd(f);
			bigField.setText(PokeMethods.MainPokeCenter.toStringTrainer(PokeMethods.currentTrainer));

		}
	}

	public class EscuchaBackInq implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			File f = new File("back.wav");
			PlaySoundd(f);
			setVisible(false);
			ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
		}
	}

}
