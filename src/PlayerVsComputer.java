import java.util.ArrayList;
import java.util.Scanner;

public class PlayerVsComputer {

	private boolean gamewin;
	private boolean p1turn;
	private boolean turntaken;
	private enum winner{ PLAYER, COMPUTER };
	private winner win;
	private Scanner scan = new Scanner(System.in);

	public void pvcGame(){
		gamewin = false;
		p1turn = true;
		int row1 = 3;
		int row2 = 5;
		int row3 = 7;

		ArrayList<String> playerMoves = new ArrayList<String>();
		ArrayList<String> computerMoves = new ArrayList<String>();
		playerMoves.clear();
		computerMoves.clear();
		
		while(!gamewin){
			String rows = "(1) " + row1 + "\n"
					+ "(2) " + row2 + "\n"
					+ "(3) " + row3 + "\n";
			System.out.println(rows);

			if(p1turn){
				System.out.println("Player 1's turn");
				turntaken = false;
				while(p1turn){
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
								p1turn = false;
							}
						}else if(play1in == 2){
							if((play1in == 2) && ((row2 - play1in2) < 0)){
								System.out.println("You can't take more than the number of sticks in the row! Try again!");
							}else{
								row2 = row2 - play1in2;
								p1turn = false;
							}
						}else if(play1in == 3){
							if((play1in == 3) && ((row3 - play1in2) < 0)){
								System.out.println("You can't take more than the number of sticks in the row! Try again!");
							}else{
								row3 = row3 - play1in2;
								p1turn = false;
							}
						}else{
							System.out.println("That is not a valid row");
						}
					}
					computerMoves.add(row1+"-"+row2+"-"+row3);
					if((row1 == 0 && row2 == 0 && row3 == 0)){
						System.out.println("Computer wins!!!");
						win = winner.COMPUTER;
						gamewin = true;
					}
				}
			}////////play1turn end
			else if (!p1turn){
				System.out.println("Computers turn");
				turntaken = false;
				while(!p1turn){
					
					String[] roes = (Main.db.getNextMove(row1+"-"+row2+"-"+row3)).split("-");
					row1 = Integer.parseInt(roes[0]);
					row2 = Integer.parseInt(roes[1]);
					row3 = Integer.parseInt(roes[2]);
					
					System.out.println("The computer has ended its turn.");
					p1turn = true;
					

				}
				playerMoves.add(row1+"-"+row2+"-"+row3);
				if((row1 == 0 && row2 == 0 && row3 == 0)){
					System.out.println("Player 1 wins!!!");
					win = winner.PLAYER;
					gamewin = true;
				}
			}
		}

		System.out.println("Player's moves: "+playerMoves);
		System.out.println("Computer's moves: "+computerMoves);
		
		//calculate values here
		switch(win){
		case COMPUTER:
			System.out.println("Computer 1 wins");
			for(int i = 1; i < playerMoves.size()+1; i++){
				System.out.println("I::"+i+" moves::"+playerMoves.size()+1);
				Menu.data.updateValues(playerMoves.get(i-1), (double)-i/((double)playerMoves.size()+1));
			}
			for(int i = 1; i < computerMoves.size()+1; i++){
				Menu.data.updateValues(computerMoves.get(i-1), (double)i/((double)computerMoves.size()+1));
			}
			break;
		case PLAYER:
			System.out.println("Computer 0 wins");
			for(int i = 1; i < playerMoves.size()+1; i++){
				Menu.data.updateValues(playerMoves.get(i-1), (double)i/((double)playerMoves.size()+1));
			}
			for(int i = 1; i < computerMoves.size()+1; i++){
				Menu.data.updateValues(computerMoves.get(i-1), (double)-i/((double)computerMoves.size()+1));
			}
			break;
		default:
			System.err.println("GAME IS BROKEN, BLAME THE DEVS");
			break;
		}
	}
}
