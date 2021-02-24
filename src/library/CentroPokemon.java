package library;
import java.util.*;

/**
 * 
 * @author RGILHE 182473
 *Class CentroPokemon, this is the main class that will be used along the project
 */


public class CentroPokemon {
	
	
	//we choose an arrayList because we don't know how many PokeTrainers we want
	private String nurseName, town;
	private ArrayList<PokeTrainer>pokeTrainers;
	
	public CentroPokemon() {
		pokeTrainers=new ArrayList<PokeTrainer>();
	}

	public CentroPokemon(String nurseName, String town) {
		super();
		this.nurseName = nurseName;
		this.town = town;
		pokeTrainers=new ArrayList<PokeTrainer>();
	}
	
	
	//Method to be able to do stuff with the Trainers ArrayList
	
	public ArrayList<PokeTrainer> getTrainersArrayList(){
		return pokeTrainers;
	}

	public String getNurseName() {
		return nurseName;
	}

	public void setNurseName(String nurseName) {
		this.nurseName = nurseName;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public void addTrainer(String name) {
		pokeTrainers.add(new PokeTrainer(name));
	}
	
	public void removeTrainer(String name) {
		PokeTrainer x=new PokeTrainer(name);
		pokeTrainers.remove(x);
	}
	
	//method that creates a new Pokemon and adds it to the PC of the given Trainer in the Given Box
	
	public void addPokemon(String trainer, String name1, String nickname, int level, int box){
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		pokeTrainers.get(k).addPokemon(name1, nickname, level, box);
	}
	
	//method that removes a Pokemon, it has to be a boolean so in case it doesn't find it, 
	//we can tell the user that that Pokemon doesn't exist
	
	
	public boolean PokemonWithdraw(String trainer, String name1, String nickname, int level) {
		boolean r;
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		r=pokeTrainers.get(k).pokemonWithdrawal(name1, nickname, level);
		return r;
	}
	
	
	//Prints out all of the Trainer's Pokemon with their Data 
	
	public String toStringTrainer(String trainer) {
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		return pokeTrainers.get(k).toString();
		
		
	}
	
	//the following 5 methods are the Equivalent to the PokeTrainer's but in this case,
	//we have to additionally give the PokeTrainer name as a String so it can find him and do what
	//the PokeTrainer method should normally do
	
	public ArrayList<Pokemon> pokemonByTypeTrainer(String trainer, String typeC){
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		ArrayList<Pokemon> r =pokeTrainers.get(k).pokemonByType(typeC);
		return r;
		
		
		
	}
	
	public ArrayList<Pokemon> pokemonAboveLevelTrainer(String trainer, int level){
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		ArrayList<Pokemon> r =pokeTrainers.get(k).pokemonHigherLvl(level);
		return r;
		
	}
	
	public ArrayList<Pokemon> pokemonBelowLevelTrainer(String trainer, int level){
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		ArrayList<Pokemon> r =pokeTrainers.get(k).pokemonBelowLvl(level);
		return r;
		
	}
	
	
	
	public int pokemonCountBoxTrainer(String trainer, int box) {
		int n;
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		n=pokeTrainers.get(k).pokemonCounterBox(box);
		return n;
		
		
	}
	
	
	
	
	public Pokemon[] getTrainerPokeBox(String  trainer, int box) {
		int k;
		PokeTrainer x=new PokeTrainer(trainer);
		k=pokeTrainers.indexOf(x);
		
		return pokeTrainers.get(k).getPokeBox(box);
		
		
	}
	
	//tells you if the Trainer is registered already in the PokeCenter, therefore is a boolean type method
	
	public boolean containsTrainer(String x) {
		boolean r=false;
		for(int i=0;i<pokeTrainers.size();i++) {
			if(pokeTrainers.get(i).getName().equals(x)) {
				r=true;
			}
		}
		return r;
	}
	
	//prints out all of the registered trainers there are 
	
	public String toStringCenter() {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<pokeTrainers.size();i++) {
			sb.append(pokeTrainers.get(i).getName()+"\n");
		}
		return sb.toString();
		
		
	}
	
	public ArrayList<Integer> PCInfoTrainer(String trainer){
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		return pokeTrainers.get(k).PCInfo();
	}
	
	public int[] PokemonLocationTrainer(String trainer, Pokemon y) {
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		return pokeTrainers.get(k).PokemonLocation(y);
	}
	
	/**
	 * 
	 * @param trainer
	 * @return the total number of Pokemon within the whole matrix
	 */
	
	public int totalPokemonTrainer(String trainer) {
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		return pokeTrainers.get(k).totalPokemon();
	}
	
	/**
	 * 
	 * @param trainer
	 * @return Trainer's Pokemon Matrix
	 */
	
	public Pokemon[][] getPCtrainer(String trainer){
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		return pokeTrainers.get(k).getPC();
	}
	
	/**
	 * 
	 * @param trainer
	 * @param name
	 * @param nickname
	 * @param level
	 * @param box
	 * @param pos
	 * 
	 * @return void
	 */
	
	public void addPoke(String trainer, String name, String nickname, int level, int box, int pos) {
		PokeTrainer x=new PokeTrainer(trainer);
		int k=pokeTrainers.indexOf(x);
		pokeTrainers.get(k).addPoke(name, nickname, level, box, pos);
	}
	
	
	

}
