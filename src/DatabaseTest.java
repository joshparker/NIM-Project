import static org.junit.Assert.*;

import org.junit.Test;


public class DatabaseTest {

	@Test
	public void test() {
		Database db = new Database();
		
//		db.pathGenerate("3-5-7");
//		System.out.println("-----");
//		db.pathGenerate("3-3-3");
		
		System.out.println(db.getPossibleMoves("3-5-7"));
		System.out.println(db.getPossibleMoves("3-5-7").size());
	}

}
