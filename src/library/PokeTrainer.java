package library;

import java.util.*;

public class PokeTrainer {

	// every PokeTrainer will have an empty Pokemon Matrix of 12x30 at first, then
	// we can add Pokemon and remove them

	private String name;

	private Pokemon[][] PC;

	public PokeTrainer() {
		PC = new Pokemon[12][30];
	}

	public PokeTrainer(String name) {
		super();
		this.name = name;
		PC = new Pokemon[12][30];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	// based on name

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokeTrainer other = (PokeTrainer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	//based on name
	public int compareTo(PokeTrainer otro) {
		int r = 0;
		if (name.compareTo(otro.getName()) < 0) {
			r = -1;
		} else {
			if (name.compareTo(otro.getName()) > 0) {
				r = 1;
			}
		}

		return r;
	}
	
	//when adding a Pokemon, we could add him to the first empty space of all the Matrix,
	//but for this Programm I rather give him what box(array) to put the Pokemon on
	
	public void addPokemon(String name, String nickname, int level, int box) {
		boolean r = false;
		for (int i = 0; i < PC[0].length; i++) {
			if (PC[box][i] == null) {
				PC[box][i] = new Pokemon(name, nickname, level);
				i = PC[0].length;
				r = true;
			}
		}
		if (r == false) {
			System.out.println("the wished box is full, it contains 30 Pokemon already");
		}
	}

	/*
	 * public void addPokemon(String name, String nickname, int level, int box) {
	 * boolean r = false; for (int i = 0; i < PC[0].length; i++) { if (PC[box -
	 * 1][i] == null) { PC[box - 1][i] = new Pokemon(name, nickname, level); i =
	 * PC[0].length; r = true; } } if (r == false) {
	 * System.out.println("the wished box is full, it contains 30 Pokemon already");
	 * } }
	 */
	//we wanna make the Pokemon Remove method (Pokemon Withdrawal) to be a boolean type, so 
	//in case it doesn't find that Pokemon, we can then show a proper message

	public boolean pokemonWithdrawal(String name, String nickname, int level) {
		boolean r = false;
		Pokemon X = new Pokemon(name, nickname, level);
		for (int i = 0; i < PC.length; i++) {
			for (int j = 0; j < PC[0].length; j++) {
				if (PC[i][j] != null) {
					if (PC[i][j].equals(X) == true) {
						PC[i][j] = null;

						r = true;

						j = PC[i].length;
						i = PC.length;
						
						

					}
				}
			}
		}

		if (r == false) {
			System.out.println("the requested Pokemon wasn't found within the PC");
		}
		return r;
	}

	
	//toString, prints information of all Pokemon with Pokedex Data that the Pokemon have
	//also tells you in what box are they
	
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < PC.length; i++) {

			sb.append("BOX #" + (i + 1) + "\n");

			for (int j = 0; j < PC[i].length; j++) {

				if (PC[i][j] != null) {
					sb.append(PC[i][j].toString() + "\n");
				}

			}

			sb.append("\n");
		}
		return sb.toString();
	}

	
	//gives back an ArrayList of Pokemon with all the Pokemon of certain type
	
	
	public ArrayList<Pokemon> pokemonByType(String typeC) {
		ArrayList<Pokemon> r = new ArrayList<Pokemon>();
		for (int i = 0; i < PC.length; i++) {
			for (int j = 0; j < PC[i].length; j++) {
				if (PC[i][j] != null) {
					if ((PC[i][j].getType1().equalsIgnoreCase(typeC) == true)
							|| (PC[i][j].getType2().equalsIgnoreCase(typeC) == true)) {
						r.add(PC[i][j]);
					}

				}
			}
		}
		return r;
	}
	
	//counts how many pokemon are in a given box (this will come in handy later on)

	public int pokemonCounterBox(int k) {
		int n = 0;

		for (int i = 0; i < PC[k].length; i++) {
			if (PC[k][i] != null) {
				n++;
			}
		}

		return n;
	}
	
	//returns Pokemon below a given level K

	public ArrayList<Pokemon> pokemonBelowLvl(int k) {
		ArrayList<Pokemon> r = new ArrayList<Pokemon>();
		for (int i = 0; i < PC.length; i++) {
			for (int j = 0; j < PC[i].length; j++) {
				if (PC[i][j] != null) {
					if (PC[i][j].getLevel() <= k) {
						r.add(PC[i][j]);
					}

				}
			}
		}
		return r;
	}
	
	//returns Pokemon Above a given level K

	public ArrayList<Pokemon> pokemonHigherLvl(int k) {
		ArrayList<Pokemon> r = new ArrayList<Pokemon>();
		for (int i = 0; i < PC.length; i++) {
			for (int j = 0; j < PC[i].length; j++) {
				if (PC[i][j] != null) {
					if (PC[i][j].getLevel() >= k) {
						r.add(PC[i][j]);
					}

				}
			}
		}
		return r;
	}
	
	//returns a pokemon ArrayList, this means, a row out the 12 rows of the PokeMatrix, so we can do stuff with it later on

	public Pokemon[] getPokeBox(int k) {

		return PC[k];
	}
	
	public ArrayList<Integer> PCInfo() {
		
		ArrayList<Integer>r =new ArrayList<Integer>();
		for(int i=0;i<PC.length;i++) {
			if(pokemonCounterBox(i)>0) {
				r.add(i);
			}
		}
		
		return r;
	}
	
	public int[] PokemonLocation(Pokemon x) {
		int[]a=new int[2];
		for(int i=0;i<PC.length;i++) {
			for(int j=0;j<PC[0].length;j++) {
				if(x.equals(PC[i][j])==true) {
					a[0]=i;
					a[1]=j;
				}
			}
		}
		
		return a;
		
	}
	
	public int totalPokemon() {
		int r=0;
		for(int i=0;i<PC.length;i++) {
			for(int j=0;j<PC[0].length;j++) {
				if(PC[i][j]!=null) {
					r++;
				}
			}
		}
		
		return r;
	}
	
	public Pokemon[][] getPC(){
		return PC;
	}
	
	public void addPoke(String name, String nickname, int level, int box, int pos) {
		PC[box][pos] = new Pokemon(name, nickname, level);
				
	}

}
