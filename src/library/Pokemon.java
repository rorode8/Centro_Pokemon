package library;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Pokemon {

	// The Pokemon should have the following attributes
	// we use the reference number so the program doesnt crash when filling the
	// PoKedex
	private String name, type1, type2, nickname, description;
	private int ID = 0;
	private int level;
	private BufferedImage img = null;
	private static int ReferenceNumber = 0;

	public Pokemon() {

	}

	public Pokemon(String name1, String nickname, int level) {
		super();
		this.name = name1;
		this.nickname = nickname;
		this.level = level;

		ReferenceNumber++;
		// once the the refence number is bigger than the pokedex(once the pokedex is
		// full
		// then we get the Data for our Pokemon outta de Pokedex data).
		if (ReferenceNumber > PokeMethods.Pokedex.length) {

			for (int i = 0; i < PokeMethods.Pokedex.length; i++) {
				if (name.equalsIgnoreCase(PokeMethods.Pokedex[i].getName())) {
					setType1(PokeMethods.Pokedex[i].getType1());
					setType2(PokeMethods.Pokedex[i].getType2());
					setDescription(PokeMethods.Pokedex[i].getDescription());
					setID(PokeMethods.Pokedex[i].getID());
					i = PokeMethods.Pokedex.length;
					try {
						String auxName1 = name1;
						auxName1 = auxName1.substring(0, 1).toLowerCase();
						auxName1 = auxName1.concat(name1.substring(1, name1.length()));

						// System.out.println(auxName1);
						// String
						// auxFile="H:\\Rodrigo_Gil182473\\Centro_Pokemon\\pokePNGs\\".concat(auxName1).concat(".png");
						// System.out.println(auxFile);
						auxName1 = auxName1.concat(".png");
						auxName1 = "pokePNGs/".concat(auxName1);
						img = (ImageIO.read(new File(auxName1)));
						// PokeMethods.Pokedex[i].setImg(AuxIm);
					} catch (IOException e) {
						e.printStackTrace();

						System.out.println(name1);

					}

				}
			}
		}

	}

	// get's and set's of all attributes
	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {

		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + level;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		return result;
	}

	// 2 Pokemon are considered to be the same based on level, nickname and
	// name(what Pokemon)

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		if (level != other.level)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}

	// we compare them based on the ID in case we wanna arrange them in this orther
	// later
	public int compareTo(Pokemon otro) {
		int r = 0;
		if (ID < otro.getID()) {
			r = -1;
		} else {
			if (ID > otro.getID()) {
				r = 1;
			}
		}
		return r;
	}

	// toString method
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("Pokemon: " + name + "  #" + ID + " nickname: " + nickname + "\n");
		sb.append("types " + type1 + " " + type2 + "  level :" + level + "\n");
		// sb.append("\n");
		sb.append(description + "\n");
		return sb.toString();

	}

}
