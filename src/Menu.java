import java.util.Scanner;


public class Menu {


	private UserInterface ui = new UserInterface();
	private PlayerVsPlayer pvp = new PlayerVsPlayer();
	private PlayerVsComputer pvc = new PlayerVsComputer();
	private ComputerVsComputer cvc = new ComputerVsComputer();
	private Scanner scan;
	public static Database data = new Database();

	public void mainMenu(){
		scan = new Scanner(System.in);
		while(true){

			String menu = "Nim Game:\n" 
					+ "(1) Play a Player vs Player game\n"
					+ "(2) Play a Player vs Computer game\n"
					+ "(3) Start a Computer vs Computer game\n"
					+ "(4) Exit";

			System.out.println(menu);
			String stuff = scan.nextLine();
			int userIn = 0;
			if(stuff.equals("1") || stuff.equals("2") || stuff.equals("3") || stuff.equals("4")){
				userIn = Integer.parseInt(stuff);
			}

			switch(userIn){
			case 1:
				pvp.pvpGame();
				break;
			case 2:

				pvc = new PlayerVsComputer();
				pvc.pvcGame();
				break;
			case 3:
				System.out.println("How many times should the computer play against itself?");
				int runtime = scan.nextInt();
				for(int i = 0; i < runtime; i++){
					System.out.println("Game "+i);
					cvc = new ComputerVsComputer();
					cvc.cvcGame(i > (3*runtime/4));
//					cvc.cvcGame(true);
					
					
//					 try {
//					 	Thread.sleep(10000);
//					 } catch (InterruptedException e) {
//					 	e.printStackTrace();
//					 }

				}
				break;
			case 4:
				System.out.println("Goodbye!");
				System.exit(1);
				break;
			default:
				System.out.println("Please choose a number from the menu.\n\n");
				break;
			}
			/************************Use for Refactoring***************************/
			/*
			 *				if (userIn == 1){
			 *					pvp.pvpGame();
			 *					menuLoop = playAgain();
			 *				}
			 *
			 *				else if (userIn == 2){
			 *
			 *					//Runs compuer vs player
			 *					pvc = new PlayerVsComputer();
			 *					pvc.pvcGame();
			 *
			 *					menuLoop = playAgain();
			 *				}
			 *
			 *				else if (userIn == 3){
			 *
			 *					//Runs computer vs computer
			 *					System.out.println("How many times should the computer play against itself?");
			 *					int runtime = scan.nextInt();
			 *					for(int i = 0; i < runtime; i++){
			 *						System.out.println("Game "+i);
			 *						cvc = new ComputerVsComputer();
			 *						cvc.cvcGame();
			 *
			 *						//						try {
			 *						//							Thread.sleep(5000);
			 *						//						} catch (InterruptedException e) {
			 *						//							// TODO Auto-generated catch block
			 *						//							e.printStackTrace();
			 *						//						}
			 *					}
			 *					menuLoop = playAgain();
			 *
			 *				}
			 *
			 *				else if (userIn == 4){
			 *
			 *					//Exit
			 *					System.out.println("Goodbye!");
			 *					System.exit(1);
			 *
			 *				}
			 *
			 *
			 *				else {
			 *
			 *					System.out.println("That is not a valid number, please imput a valid number...\n");
			 *
			 *
			 *				}
			 **/

		}
	}

	public boolean playAgain(){

		ui.promptToPlayAgain();
		boolean playAgainLoop = true;
		boolean promptAwnser = false;

		try{
			while(playAgainLoop){
				int response = Integer.parseInt(scan.nextLine());

				if (response == 1){

					promptAwnser = true;
					playAgainLoop = false;

				}

				else if (response == 2){

					promptAwnser = false;
					playAgainLoop = false;
				}

				else {

					System.out.println("That is not a valid number, please imput a valid number...\n");
					ui.promptToPlayAgain();

				}

			}
		}
		catch(NumberFormatException e){

			System.out.println("You need to imput a value...");
			playAgain();

		}

		return promptAwnser;

	}

}


//Dont forget to put in user imputs as well
