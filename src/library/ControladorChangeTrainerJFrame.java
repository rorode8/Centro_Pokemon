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

public class ControladorChangeTrainerJFrame extends ChangeTrainerJFrame{
	
	
	static void PlaySoundd(File sound){
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
			
			
		}catch(Exception e) {
			
		}
		
	}
	
	public ControladorChangeTrainerJFrame(String titulo) {
		super(titulo);
		trainerAccept.addActionListener(new EscuchaTrainerAccept());
		trainerBack.addActionListener(new EscuchaTrainerBack());
	}

	public class EscuchaTrainerBack implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			File f=new File("back.wav");
			PlaySoundd(f);
			setVisible(false);
			ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
		}
	}
	
	public class EscuchaTrainerAccept implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			
			boolean T=newTrainer.isSelected();
			String auxTrainerName=trainerNameField.getText();
			
			
			//create two cases, one when it's a new trainer, one when it's not
			//when it's a new trainer
			if(T==true) {
				//we check if the trainer that wants to be added it already in the Pokemon Center(Trainer's ArrayList)
				PokeTrainer auxTrainer=new PokeTrainer("auxTrainerName");
				if(PokeMethods.MainPokeCenter.containsTrainer(auxTrainerName)==true) {
				//if he's already in, we display an error, telling that he's already in 
					File f=new File("error.wav");
					PlaySoundd(f);
					try {
						ImageIcon iconError;
						iconError = new ImageIcon(ImageIO.read(new File("pikaThump.png")));
						JOptionPane.showMessageDialog(null, "That Trainer is already registered, please give another name", "Error", 0, iconError);
					} catch (IOException ex) {

					}
					
				}else {
					//if it's a new Trainer and he isn't registered, we just add him to the Pokemon Center and set him to the currentTrainer
					PokeMethods.MainPokeCenter.addTrainer(auxTrainerName);
					PokeMethods.currentTrainer=auxTrainerName;
					File f=new File("success.wav");
					PlaySoundd(f);
					setVisible(false);
					ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
				}
				
			
			}else {
				//when it's an existing trainer we search for him, which gives us to cases, one that he's not here, so we display an error
				//and the other case in which he is already registered, so we just set him as the current trainer
				PokeTrainer auxTrainer=new PokeTrainer("auxTrainerName");
				System.out.println("in2");
				if(PokeMethods.MainPokeCenter.containsTrainer(auxTrainerName)==true) {
					System.out.println("in1");
					//we set him as the current trainer without adding him to the arrayList of pokeTrainers
					PokeMethods.currentTrainer=auxTrainerName;
					File f=new File("success.wav");
					PlaySoundd(f);
					setVisible(false);
					ControladorTrainerJFrame trai2 = new ControladorTrainerJFrame("Trainer Panel");
					
				}else {
					//we display error message
					
					File f=new File("error.wav");
					PlaySoundd(f);
										
					try {
						ImageIcon iconError;
						iconError = new ImageIcon(ImageIO.read(new File("pikaLUL.png")));
						JOptionPane.showMessageDialog(null, "That trainer isn't registered yet, please add him as a new one", "Error", 0, iconError);
					} catch (IOException ex) {

					}
					
				}
				
				
				
			}
			
			
		}
	}
	
}
