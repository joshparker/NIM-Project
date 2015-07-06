import java.util.ArrayList;
import java.util.Hashtable;


public class Database {

	private Hashtable<String, ArrayList<String>> outcomes = new Hashtable<String, ArrayList<String>>();
	private Hashtable<String, Double> values = new Hashtable<String, Double>();

	public Database(){
	}

	public String getNextMove(String current_game_state){

		//take the current state of the board and return the highest rated next move from the Array/Hashtable

		return null;
	}

	public void updateValues(String rows, double value){
		values.put(rows, (Double)value);
	}

	private void pathGenerate(String current){
		int[] bort = new int[3];
		String[] stuff = current.split("-");
		for(int i = 0; i < 3; i++){
			bort[i] = Integer.parseInt(stuff[i]);
		}
		
		ArrayList<String> outcomez = new ArrayList<String>();
		
		//Fix this so it only takes from one.
		
		for(int a = 0; a < 3; a++){
			for(int b = 0; b < bort[a]; b++){
				switch(a){
				case 0:
					outcomez.add(b+"-"+bort[1]+"-"+bort[2]);
					this.updateValues(b+"-"+bort[1]+"-"+bort[2], 0.0);
					break;
				case 1:
					outcomez.add(bort[0]+"-"+b+"-"+bort[2]);
					this.updateValues(bort[0]+"-"+b+"-"+bort[2], 0.0);
					break;
				case 2:
					outcomez.add(bort[0]+"-"+bort[1]+"-"+b);
					this.updateValues(bort[0]+"-"+bort[1]+"-"+b,0.0);
					break;
				}
			}
		}
		
		outcomes.put(current, outcomez);
		
	}

	public ArrayList getPossibleMoves(String current){
		
		if(outcomes.get(current) == null){
			this.pathGenerate(current);
		}
		
		
		return outcomes.get(current);
	}
}
