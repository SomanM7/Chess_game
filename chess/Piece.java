package chess;

public abstract class Piece{

    private int row;
    private int column;
    private String symbol;
    protected PieceColour colour;


    public Piece(){
        
        
    }


    public String getSymbol(){
        return symbol;
    }

    public void setSymbol(String newSymbol){
        symbol = newSymbol;
    }

    public PieceColour getColour(){
        return colour;

    }

    public void updateCoordinates(int newR, int newC){
        row = newR;
        column = newC;

    }
   public abstract boolean isLegitMove(int i0, int j0, int i1, int j1);
   

}
