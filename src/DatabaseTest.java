import static org.junit.Assert.*;
import org.junit.Test;


public class DatabaseTest {

	@Test
	public void test() {
		Database db = new Database();
		
		String rows = "3-5-7";
		
		String row2 = "0-3-3";
		
		System.out.println(db.getPossibleMoves(rows));
		System.out.println(db.getValue(row2));
		System.out.println(db.appearances.get(row2));
		db.updateValues(row2, 1);
		System.out.println(db.getValue(row2));
		System.out.println(db.appearances.get(row2));
		
		db.getNextMove("0-3-4");
		
		for(int i = 0; i < 50; i++){

			db.updateValues(row2, .5);
			System.out.println(db.getValue(row2));
			System.out.println(db.appearances.get(row2));
		}
		
		db.getNextMove(rows);
		System.out.println("____________________________");
		db.getNextMove("0-3-4");
	}

}