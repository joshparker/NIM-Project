import java.util.ArrayList;
import java.util.Hashtable;


public class Database {
	public Hashtable<String, Integer> appearances = new Hashtable<String, Integer>();
	private Hashtable<String, ArrayList<String>> outcomes = new Hashtable<String, ArrayList<String>>();
	private Hashtable<String, Double> values = new Hashtable<String, Double>();

	public Database(){
	}

	public String getNextMove(String current_game_state){

		//take the current state of the board and return the highest rated next move from the Array/Hashtable

		return null;
	}

	public void updateValues(String rows, double value){
		double newVal = ((value)+(values.get(rows)*appearances.get(rows))/((appearances.get(rows))+1));
		values.put(rows, (Double)newVal);
		appearances.put(rows, appearances.get(rows)+1);
	}

	public double getValue(String rows){
		if(!values.containsKey(rows)){
			System.err.println("New Key");
			values.put(rows, 0.0);
			appearances.put(rows, 0);
		}

		return values.get(rows);
	}

	private void pathGenerate(String current){
		int[] bort = new int[3];
		String[] stuff = current.split("-");
		for(int i = 0; i < 3; i++){
			bort[i] = Integer.parseInt(stuff[i]);
		}

		ArrayList<String> outcomez = new ArrayList<String>();

		String stuffs = null;
		for(int a = 0; a < 3; a++){
			for(int b = 0; b < bort[a]; b++){
				switch(a){
				case 0:
					stuffs = b+"-"+bort[1]+"-"+bort[2];
					outcomez.add(stuffs);
					appearances.put(stuffs, 1);
					values.put(stuffs, 0.0);
					break;
				case 1:
					stuffs = bort[0]+"-"+b+"-"+bort[2];
					outcomez.add(stuffs);
					appearances.put(stuffs, 1);
					values.put(stuffs, 0.0);
					break;
				case 2:
					stuffs = bort[0]+"-"+bort[1]+"-"+b;
					outcomez.add(stuffs);
					appearances.put(stuffs, 1);
					values.put(stuffs, 0.0);
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
