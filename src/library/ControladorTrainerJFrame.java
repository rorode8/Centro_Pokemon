package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ControladorTrainerJFrame extends TrainerJFrame {
	
	static void PlaySoundd(File sound){
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
			
			
		}catch(Exception e) {
			
		}
		
	}
	
	public ControladorTrainerJFrame(String titulo) {
		super(titulo);
		addPokemon.addActionListener(new EscuchaAddPoke());
		backB.addActionListener(new EscuchaBackB());
		nextB.addActionListener(new EscuchaNextB());
		changeTrainer.addActionListener(new EscuchaChangeTrainer());
		removePokemon.addActionListener(new EscuchaRemovePokemonM());
		inquiryPokemon.addActionListener(new EscuchaInquiryPokemon());
		save.addActionListener(new EscuchaSave());
		load.addActionListener(new EscuchaLoad());

	}
	
	public class EscuchaLoad implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			
			boolean b=PokeMethods.load();
			
			setVisible(false);
			ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
			
			if(b==true) {
				try {
					ImageIcon iconError;
					iconError = new ImageIcon(ImageIO.read(new File("pikaPls.png")));
					JOptionPane.showMessageDialog(null, "your data seems to be loaded the right way ", "Error", 0, iconError);
				} catch (IOException ex) {

				}
				
			}else {
				
				try {
					ImageIcon iconError;
					iconError = new ImageIcon(ImageIO.read(new File("pikaLUL.png")));
					JOptionPane.showMessageDialog(null, "Something went Wrong about loading your Data", "Error", 0, iconError);
				} catch (IOException ex) {

				}
				
				
				
			}
		}
	}
	
	public class EscuchaSave implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			
			boolean r;
			r=PokeMethods.saveToFile();
			if(r==true) {
				try {
					ImageIcon iconError;
					iconError = new ImageIcon(ImageIO.read(new File("pikaPls.png")));
					JOptionPane.showMessageDialog(null, "your data seems to be saved the right way ", "Error", 0, iconError);
				} catch (IOException ex) {

				}
				
			}else {
				try {
					ImageIcon iconError;
					iconError = new ImageIcon(ImageIO.read(new File("pikaLUL.png")));
					JOptionPane.showMessageDialog(null, "Something went Wrong about saving the Data", "Error", 0, iconError);
				} catch (IOException ex) {

				}
				
				
			}
			
		}
	}

	public class EscuchaInquiryPokemon implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			File f=new File("open.wav");
			PlaySoundd(f);
			setVisible(false);
			ControladorInquiryJFrame x1 = new ControladorInquiryJFrame("Pokemon Inquiry");
		}
	}

	public class EscuchaRemovePokemonM implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			File f=new File("open.wav");
			PlaySoundd(f);
			ControladorRemovePokemonJFrame pokeRemove = new ControladorRemovePokemonJFrame("Pokemon Withdrawal");
			setVisible(false);

		}
	}

	public class EscuchaChangeTrainer implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
			File f=new File("open.wav");
			PlaySoundd(f);
			ControladorChangeTrainerJFrame changePokeTrainer = new ControladorChangeTrainerJFrame("Change Trainer");
			setVisible(false);
		}
	}

	public class EscuchaAddPoke implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
			
			File f=new File("open.wav");
			PlaySoundd(f);
			ControladorAddPokemonJFrame Addpoke1 = new ControladorAddPokemonJFrame("PIKA");
			setVisible(false);

		}
	}

	public class EscuchaBackB implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			if (PokeMethods.currentBox > 0) {

				
				PokeMethods.currentBox--;
				File f=new File("button.wav");
				PlaySoundd(f);
				setVisible(false);
				ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Frame");
				
			} else {

				ImageIcon iconError;
				File f = new File("error.wav");
				PlaySoundd(f);
				try {
					iconError = new ImageIcon(ImageIO.read(new File("pikaPls.png")));
					JOptionPane.showMessageDialog(null,
							"you can't go backwards anymore because you're in the first box", "Error", 0, iconError);
				} catch (IOException ex) {

				}
			}
		}
	}

	public class EscuchaNextB implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (PokeMethods.currentBox < 11) {
				PokeMethods.currentBox++;
				File f=new File("button.wav");
				PlaySoundd(f);
				setVisible(false);
				ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Frame");
				
				
			} else {
				ImageIcon iconError;
				File f = new File("error.wav");
				PlaySoundd(f);
				try {
					iconError = new ImageIcon(ImageIO.read(new File("pikachuO.png")));
					JOptionPane.showMessageDialog(null,
							"you can't go forward anymore because you're already in the last box", "Error", 0,
							iconError);
				} catch (IOException ex) {

				}
			}

		}

	}
}
