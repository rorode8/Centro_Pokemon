package library;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PokeMethods {

	// the purpose of this class is to create a Pokemon database "pokedex" out of a
	// .txt
	// so we can get all of the Information for a Pokemon when we create them, and
	// we don't have to ask the user
	// for much information about the pokemon
	// We also have the variables that will be changing throughout the program, they
	// are public and static so we can
	// modify them from any other class, besides, since they are static we don't
	// need to create a "PokeMethods" Object
	// we can just modify them freely

	public static File entry1;
	public static Scanner read1;
	public static CentroPokemon MainPokeCenter;
	public static String currentTrainer;
	public static int currentBox = 0;

	public static Pokemon[] Pokedex;

	// method that fills the Pokedex Pokemon information

	public static void fill(String name) {

		
		String preFile="data/";
		preFile=preFile.concat(name);
		entry1 = new File(preFile);

		try {
			read1 = new Scanner(entry1);

			Pokedex = new Pokemon[Integer.parseInt(read1.nextLine())];
			// System.out.println(Pokedex.length);
			for (int i = 0; i < Pokedex.length; i++) {

				String name1 = read1.nextLine();

				// this whole thing is to read the images
				// since it's case sensitive, we have to change the fisrt character to a
				// lowerCase character
				try {
					String auxName1 = name1;
					auxName1 = auxName1.substring(0, 1).toLowerCase();
					auxName1 = auxName1.concat(name1.substring(1, name1.length()));

					// System.out.println(auxName1);
					// String
					// auxFile="H:\\Rodrigo_Gil182473\\Centro_Pokemon\\pokePNGs\\".concat(auxName1).concat(".png");
					// System.out.println(auxFile);
					auxName1 = auxName1.concat(".png");
					auxName1="pokePNGs/".concat(auxName1);
					BufferedImage AuxIm = (ImageIO.read(new File(auxName1)));
					// PokeMethods.Pokedex[i].setImg(AuxIm);
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println(i);
					System.out.println(name1);

				}

				String typeOne = read1.nextLine();
				String typeTwo = read1.nextLine();
				int ID1 = Integer.parseInt(read1.nextLine());
				String description1 = read1.nextLine();

				Pokedex[i] = new Pokemon(name1, name1, 0);
				Pokedex[i].setDescription(description1);
				Pokedex[i].setID(ID1);
				Pokedex[i].setType1(typeOne);
				Pokedex[i].setType2(typeTwo);

			}

		} catch (Exception e) {
			System.out.println("h2");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	// return boolean
	public static boolean saveToFile() {

		String trainerD;
		int sT, tP;
		Pokemon[][] auxPC;

		boolean r = true;
		File saveFile = new File("data/saveFile.txt");

		try {
			saveFile.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
			r = false;
		}

		try {
			FileWriter writer = new FileWriter(saveFile);
			BufferedWriter buffW = new BufferedWriter(writer);

			buffW.write(PokeMethods.currentTrainer);
			buffW.newLine();
			buffW.write(PokeMethods.MainPokeCenter.getNurseName());
			buffW.newLine();
			buffW.write(PokeMethods.MainPokeCenter.getTown());
			buffW.newLine();
			sT = PokeMethods.MainPokeCenter.getTrainersArrayList().size();
			String.valueOf(sT);
			buffW.write(String.valueOf(sT));
			buffW.newLine();
			for (int i = 0; i < sT; i++) {
				trainerD = PokeMethods.MainPokeCenter.getTrainersArrayList().get(i).getName();
				buffW.write(trainerD);
				buffW.newLine();
				tP = PokeMethods.MainPokeCenter.totalPokemonTrainer(trainerD);
				buffW.write(String.valueOf(tP));
				buffW.newLine();
				
					auxPC = PokeMethods.MainPokeCenter.getPCtrainer(trainerD);
					for (int k = 0; k < auxPC.length; k++) {
						for (int l = 0; l < auxPC[0].length; l++) {
							if (auxPC[k][l] != null) {
								buffW.write(auxPC[k][l].getName());
								buffW.newLine();
								buffW.write(auxPC[k][l].getNickname());
								buffW.newLine();
								buffW.write(String.valueOf(auxPC[k][l].getLevel()));
								buffW.newLine();
								buffW.write(String.valueOf(k));
								buffW.newLine();
								buffW.write(String.valueOf(l));
								buffW.newLine();
							}
						}
					}

				

			}

			buffW.close();
			System.out.println("success!");
		} catch (Exception e) {
			r = false;
			e.printStackTrace();
		}

		return r;
	}
	
	public static boolean load() {
		boolean r=true;
		File loadFile=new File("data/saveFile.txt");
		Scanner readP;
		int tT, tP;
		String trainerD, p1,p2;
		try {
		
		readP=new Scanner(loadFile);
		PokeMethods.currentTrainer=readP.nextLine();
		p1=readP.nextLine();
		p2=readP.nextLine(); //nurse
		PokeMethods.MainPokeCenter=null;
		PokeMethods.MainPokeCenter=new CentroPokemon(p2, p1);
		tT=Integer.parseInt(readP.nextLine());
		
		for(int i=0;i<tT;i++) {
			trainerD=readP.nextLine();
			PokeMethods.MainPokeCenter.addTrainer(trainerD);
			tP=Integer.parseInt(readP.nextLine());
			for(int j=0;j<tP;j++) {
				PokeMethods.MainPokeCenter.addPoke(trainerD, readP.nextLine(), readP.nextLine(), Integer.parseInt(readP.nextLine()), Integer.parseInt(readP.nextLine()), Integer.parseInt(readP.nextLine()));
			}
		}
		
		
		
		readP.close();
		}catch(Exception e) {
			e.printStackTrace();
			r=false;
		}
		
		return r;
	}
	
	public static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
			Thread.sleep(clip.getMicrosecondLength()/1000);
			
			
		}catch(Exception e) {
			
		}
	}

}
