import java.util.Scanner;


public class Menu {

	private UserInterface ui = new UserInterface();
	private Scanner scan = new Scanner(System.in);
	
	public void mainMenu(){
		
		ui.displayMain();
		int userIn = Integer.parseInt(scan.nextLine());
		
	}
	
	//Dont forget to put in user imputs as well
	
}
