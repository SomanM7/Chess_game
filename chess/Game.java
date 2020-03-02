package chess;
import java.io.Console;
import java.util.Scanner;



public class Game {
	private static boolean gameEnd=false;
	public String chessPiece;
	private static PieceColour playerColour = PieceColour.WHITE;
	
	public Game(){
		Board b = new Board();
		b.initialisePieces();
		while (!gameEnd){
			//initialising I/O
			String start, end;
			int i0 = 0;
			int i1 = 0;
			int j0 = 0;
			int j1 = 0;
			Console console = System.console();
			//write the game logic
			b.printBoard();

			System.out.println("--- " + playerColour + " Move ---");
			

			while (true){
				start = console.readLine("> Enter Origin: ");

				
				if (CheckInput.checkCoordinateValidity(start)){
					i0 = Character.getNumericValue(start.charAt(0)) - 1;
					j0 = (start.charAt(1))-97;

					if(b.hasPiece(i0, j0)){
						if(b.getPiece(i0, j0).getColour()!=playerColour){
							System.out.println("Not your piece");
						}
						else{
							break;
						}
					}
					else {
						System.out.println("No piece selected!");
					}
				
			}
				else{
					System.out.println("Invalid Position");
			}

				
			}


			
			//loop and checks for destination coord
			while(true){
				end = console.readLine("Enter destination: ");
				
				
				if (!CheckInput.checkCoordinateValidity(end)){
					System.out.println("Invalid Coordinates");
					
					}
				else{
					i1 = Character.getNumericValue(end.charAt(0))-1;
					j1 = (end.charAt(1))-97;

					Piece p = b.getPiece(i0,j0);
					if (p.isLegitMove(i0, j0, i1, j1)){
						gameEnd = b.movePiece(i0, j0, i1, j1, p);
						break;

					}else{
						System.out.println("Invalid Move");
					}
				}

				}
					
		
			
	


		if (!gameEnd){
			if (playerColour == PieceColour.WHITE){
				playerColour = PieceColour.BLACK;
			}else{
				playerColour = PieceColour.WHITE;
			}
		}



	}

	endGame(false);
	}

	public void endGame(boolean endbyf){
		gameEnd=true;
		PieceColour winner;
		PieceColour loser;

		if (endbyf){
			loser = playerColour;
			if (playerColour == PieceColour.WHITE){
				winner = PieceColour.BLACK;
			}else{
				winner = PieceColour.WHITE;
			}
		}else{
			winner = playerColour;
			if (playerColour == PieceColour.WHITE){
				loser = PieceColour.BLACK;
			}else{
				loser = PieceColour.WHITE;
			}
		}

		System.out.println("Loser: " + loser);
		System.out.println("Winner: " + winner);
		System.exit(0);
	}

	
	
	public static void main (String args[]){
		Game g  = new Game();
	
	}
}
