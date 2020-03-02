package chess;


//This class is partially implemented. Some methods need to have their body written, some other are fine as they are and other may need to be extended. 

public class Board {
	private static Square [][] board = new Square[8][8];

	public Board(){
		for (int i=0; i<board[0].length; i++){
			for (int j=0; j<board[1].length; j++)
					board[i][j]=new Square(i,j);
		}		

	}	

	public static Square[][] getBoard(){
		return board;
	}
	
	public void initialisePieces(){

		Piece bPawn = new Pawn(PieceColour.BLACK);

		Piece bRook1 = new Rook(PieceColour.BLACK);
		Piece bKnight1 = new Knight(PieceColour.BLACK);
		Piece bBishop1 = new Bishop(PieceColour.BLACK);
		Piece bQueen = new Queen(PieceColour.BLACK);
		Piece bKing = new King(PieceColour.BLACK);
		Piece bBishop2 = new Bishop(PieceColour.BLACK);
		Piece bKnight2 = new Knight(PieceColour.BLACK);
		Piece bRook2 = new Rook(PieceColour.BLACK);
		
		board[0][0].setPiece(bRook1);
		board[0][1].setPiece(bKnight1);
		board[0][2].setPiece(bBishop1);
		board[0][4].setPiece(bKing);
		board[0][3].setPiece(bQueen);
		board[0][5].setPiece(bBishop2);
		board[0][6].setPiece(bKnight2);
		board[0][7].setPiece(bRook2);

		for (int j=0; j<board[1].length; j++){
			board[1][j].setPiece(bPawn);
			
		}

		Piece wPawn = new Pawn(PieceColour.WHITE);

		Piece wRook1 = new Rook(PieceColour.WHITE);
		Piece wKnight1 = new Knight(PieceColour.WHITE);
		Piece wBishop1 = new Bishop(PieceColour.WHITE);
		Piece wQueen = new Queen(PieceColour.WHITE);
		Piece wKing = new King(PieceColour.WHITE);
		Piece wBishop2 = new Bishop(PieceColour.WHITE);
		Piece wKnight2 = new Knight(PieceColour.WHITE);
		Piece wRook2 = new Rook(PieceColour.WHITE);

		board[7][0].setPiece(wRook1);
		board[7][1].setPiece(wKnight1);
		board[7][2].setPiece(wBishop1);
		board[7][4].setPiece(wKing);
		board[7][3].setPiece(wQueen);
		board[7][5].setPiece(wBishop2);
		board[7][6].setPiece(wKnight2);
		board[7][7].setPiece(wRook2);

		for (int j=0; j<board[1].length; j++){
			board[6][j ].setPiece(wPawn);
			


		}


	}
	
	public void printBoard(){
		System.out.print("\n  a b c d e f g h \n");
		System.out.print("  -----------------\n");
		String wsp=" ";String bar="|";
		
		for (int i=0; i<board[0].length; i++){
			int row=i+1;
				for (int j=0; j<board[1].length; j++){
					if ((j==0) && board[i][j].hasPiece())
						System.out.print(row+" "+ board[i][j].getPiece().getSymbol());	
					else if ((j==0) && !board[i][j].hasPiece())
						System.out.print(row+"  " );
					else if (board[i][j].hasPiece())					
						System.out.print("|"+ board[i][j].getPiece().getSymbol());				
					else					
						System.out.print("| ");		
				}				
				System.out.print("  "+row+"\n");
		}
		System.out.print(" - -----------------");
		System.out.print("\n  a b c d e f g h \n");
	}


	public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
		boolean kingDead = false;

		Square[][] board = Board.getBoard();

		if (board[i1][j1].getPiece() instanceof King){  // if position destination on board has King piece
			kingDead = true;
		}
		

		board[i0][j0].removePiece();
		if (board[i1][j1].hasPiece()){
			board[i1][j1].removePiece();
		}

		board[i1][j1].setPiece(p);

		return kingDead;


	}



	public void setPiece(int iIn, int jIn, Piece p){
		board[iIn][jIn].setPiece(p);
	}

	public Piece getPiece(int iIn, int jIn){
		return board[iIn][jIn].getPiece();
	}

	public boolean hasPiece(int iIn, int jIn){
		return board[iIn][jIn].hasPiece();
	}

}
