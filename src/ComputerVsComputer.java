import java.util.ArrayList;


public class ComputerVsComputer {

	private boolean gamewin;
	private boolean p1turn;
	private boolean turntaken;
	private enum winner{ PLAYER, COMPUTER };
	private winner win = null;

	public void cvcGame(boolean useAI){
		gamewin = false;
		p1turn = new java.util.Random().nextBoolean();
		int row1 = 3;
		int row2 = 5;
		int row3 = 7;

		ArrayList<String> playerMoves = new ArrayList<String>();
		ArrayList<String> computerMoves = new ArrayList<String>();
		playerMoves.clear();
		computerMoves.clear();
		
		System.out.println("3-5-7");
		
		while(!gamewin){
			if(p1turn){
//				System.out.println("C1's turn");
				turntaken = false;
				while(p1turn){
					
					String[] roes = (Menu.data.getNextMove(row1+"-"+row2+"-"+row3)).split("-");
					row1 = Integer.parseInt(roes[0]);
					row2 = Integer.parseInt(roes[1]);
					row3 = Integer.parseInt(roes[2]);
					p1turn = false;
				}
				playerMoves.add(row1+"-"+row2+"-"+row3);
				if((row1 == 0 && row2 == 0 && row3 == 0)){
					win = winner.COMPUTER;
					gamewin = true;
				}
			}////////play1turn end
			else if (!p1turn){
//				System.out.println("C2's turn");
				turntaken = false;
				while(!p1turn){
					String[] roes;
					if(useAI){
						roes = (Menu.data.getNextMove(row1+"-"+row2+"-"+row3)).split("-");
					}else{
						roes = (Menu.data.getRandMove(row1+"-"+row2+"-"+row3)).split("-");
					}
					row1 = Integer.parseInt(roes[0]);
					row2 = Integer.parseInt(roes[1]);
					row3 = Integer.parseInt(roes[2]);
					p1turn = true;
				}
				computerMoves.add(row1+"-"+row2+"-"+row3);
				if((row1 == 0 && row2 == 0 && row3 == 0)){
					win = winner.PLAYER;
					gamewin = true;
				}
			}
			
			
		}
		
		//calculate values here
		switch(win){
		case COMPUTER:
			System.out.println("Computer 2 wins");
			for(int i = 1; i <= (playerMoves.size()); i++){
//				System.out.println("I::"+i+" moves::"+(playerMoves.size()));
				Menu.data.updateValues(playerMoves.get(i-1), (double)-i/((double)(playerMoves.size())));
			}
			for(int i = 1; i <= computerMoves.size(); i++){
//				System.out.println("I::"+i+" moves::"+(computerMoves.size()));
				Menu.data.updateValues(computerMoves.get(i-1), (double)i/((double)(computerMoves.size())));
			}
			break;
		case PLAYER:
			System.out.println("Computer 1 wins");
			for(int i = 1; i <= (playerMoves.size()); i++){
//				System.out.println("I::"+i+" moves::"+(playerMoves.size()));
				Menu.data.updateValues(playerMoves.get(i-1), (double)i/((double)(playerMoves.size())));
			}
			for(int i = 1; i <= (computerMoves.size()); i++){
//				System.out.println("I::"+i+" moves::"+(computerMoves.size()));
				Menu.data.updateValues(computerMoves.get(i-1), (double)-i/((double)(computerMoves.size())));
			}
			break;
		default:
			System.err.println("GAME IS BROKEN, BLAME THE DEVS");
			break;
		}
		
		System.out.println("C1's moves: "+playerMoves);
		System.out.println("C2's moves: "+computerMoves);
//		for(int i = 0; i < playerMoves.size(); i++){
//			System.out.println(playerMoves.get(i)+"::"+Menu.data.getValue(playerMoves.get(i)));
//		}
//		for(int i = 0; i < computerMoves.size(); i++){
//			System.out.println(computerMoves.get(i)+"::"+Menu.data.getValue(computerMoves.get(i)));
//		}
		System.out.println("Game Over");
	}
}