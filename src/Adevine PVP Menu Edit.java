import java.util.Scanner;


public class Menu {
	private boolean gamewin;
	private boolean play1turn;
	private boolean turntaken;


	private UserInterface ui = new UserInterface();
	private Scanner scan = new Scanner(System.in);
	
	public void mainMenu(){
		
		ui.displayMain();
		int userIn = Integer.parseInt(scan.nextLine());
		
		if (userIn == 1){
			gamewin = false;
			play1turn = true;
			int row1 = 3;
			int row2 = 5;
			int row3 = 7;
			while (!gamewin){
				String rows = "(1) " + row1 + "\n"
						+ "(2) " + row2 + "\n"
						+ "(3) " + row3 + "\n";
				System.out.println(rows);
				if(play1turn){
					System.out.println("Player 1's turn");
					turntaken = false;
					while(play1turn){
						System.out.println("Choose a row");
						int play1in = Integer.parseInt(scan.nextLine());
						if( (play1in == 1) && (row1 == 0) ||
							(play1in == 2) && (row2 == 0) ||
							(play1in == 3) && (row3 == 0) ){
							System.out.println("That row is already empty! Try again!");
						}else{
							System.out.println("Enter the amount you would like to take from the row");
							int play1in2 = Integer.parseInt(scan.nextLine());
							if(play1in == 1){
								if((play1in == 1) && ((row1 - play1in2) < 0)){
								System.out.println("You can't take more than the number of sticks in the row! Try again!");
								}else{
								row1 = row1 - play1in2;
								play1turn = false;
								}
							}else if(play1in == 2){
								if((play1in == 2) && ((row2 - play1in2) < 0)){
									System.out.println("You can't take more than the number of sticks in the row! Try again!");
									}else{
									row2 = row2 - play1in2;
									play1turn = false;
									}
							}else if(play1in == 3){
								if((play1in == 3) && ((row3 - play1in2) < 0)){
									System.out.println("You can't take more than the number of sticks in the row! Try again!");
									}else{
									row3 = row3 - play1in2;
									play1turn = false;
							}
								}else{
								System.out.println("That is not a valid row");
							}
						}
						if((row1 == 0 && row2 == 0 && row3 == 0)){
							System.out.println("Player 2 wins!!!");
							gamewin = true;
						}
					}
				}////////play1turn end
				else if (!play1turn){
					System.out.println("Player 2's turn");
					turntaken = false;
					while(!play1turn){
						System.out.println("Choose a row");
						int play1in = Integer.parseInt(scan.nextLine());
						if( (play1in == 1) && (row1 == 0) ||
							(play1in == 2) && (row2 == 0) ||
							(play1in == 3) && (row3 == 0) ){
							System.out.println("That row is already empty! Try again!");
						}else{
							System.out.println("Enter the amount you would like to take from the row");
							int play1in2 = Integer.parseInt(scan.nextLine());
							if(play1in == 1){
								if((play1in == 1) && ((row1 - play1in2) < 0)){
								System.out.println("You can't take more than the number of sticks in the row! Try again!");
								}else{
								row1 = row1 - play1in2;
								play1turn = true;
								}
							}else if(play1in == 2){
								if((play1in == 2) && ((row2 - play1in2) < 0)){
									System.out.println("You can't take more than the number of sticks in the row! Try again!");
									}else{
									row2 = row2 - play1in2;
									play1turn = true;
									}
							}else if(play1in == 3){
								if((play1in == 3) && ((row3 - play1in2) < 0)){
									System.out.println("You can't take more than the number of sticks in the row! Try again!");
									}else{
									row3 = row3 - play1in2;
									play1turn = true;
							}
								}else{
								System.out.println("That is not a valid row");
							}
						}
						if((row1 == 0 && row2 == 0 && row3 == 0)){
							System.out.println("Player 1 wins!!!");
							gamewin = true;
						}
					}
				}/////play2turn end
			}/////Game end
		}
	}
}

	
	//Dont forget to put in user imputs as well
	
