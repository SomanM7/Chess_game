package chess;


//This class is partially implemented 
public class Square {
	private int i;
	private int j;
	private boolean hasPiece;
	private Piece p;
	
	public Square(int i, int j){
		this.i=i;
		this.j=j;
		hasPiece = false;
	}
	
	public Piece getPiece(){
		return p;
	}
	
	public boolean hasPiece(){
		return hasPiece;
	}
	
	public void setPiece(Piece piece){
		p = piece;
		hasPiece = true;
		p.updateCoordinates(i, j);

	}

	public void removePiece(){
		p = null;
		hasPiece = false;
	}

	public int getI(){
		return i;
	}

	public int getJ(){
		return j;
	}
}


