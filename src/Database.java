import java.util.Hashtable;


public class Database {
	
	private Hashtable<String, Double> values = new Hashtable<String, Double>();
	
	public Database(){
		
	}
	
	public String getNextMove(String current_game_state){
		
		//take the current state of the board and return the highest rated next move from the Array/Hashtable
		
		return null;
	}
	
	public void updateValues(String rows, double value){
		values.put(rows, (Double)value);
		//loop this later on?
	}
}
