import java.util.Scanner;


public class Menu {


	private UserInterface ui = new UserInterface();
	private PlayerVsPlayer pvp = new PlayerVsPlayer();
	private Scanner scan = new Scanner(System.in);

	public void mainMenu(){


		boolean menuLoop = true;

		try{
			while(menuLoop){
				ui.displayMain();
				int userIn = Integer.parseInt(scan.nextLine());

				if (userIn == 1){
					pvp.pvpGame();
					menuLoop = playAgain();
				}

				else if (userIn == 2){

					//Runs compuer vs player
					menuLoop = playAgain();
				}

				else if (userIn == 3){

					//Runs computer vs computer
					menuLoop = playAgain();

				}

				else if (userIn == 4){

					//Exit
					System.out.println("Goodbye!");
					System.exit(1);

				}


				else {

					System.out.println("That is not a valid number, please imput a valid number...\n");


				}

/************************Use for Refactoring***************************/
//				switch(userIn){
//				case 1:
//					pvp.pvpGame();
//					menuLoop = playAgain();
//					break;
//				case 2:
//					menuLoop = playAgain();
//					break;
//				case 3:
//					menuLoop = playAgain();
//					break;
//				case 4:
//					System.out.println("Goodbye!");
//					System.exit(1);
//					break;
//				default:
//					break;
//				}

			}
		}
		catch(NumberFormatException e){

			System.out.println("That is not a number, please try a number..");
			mainMenu();

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
