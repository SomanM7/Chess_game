package chess;

public class Knight extends Piece {
    public Knight(PieceColour colour){
        this.colour = colour;
        if (colour == PieceColour.BLACK){
            setSymbol("\u2658");

        }
        else{
            setSymbol("\u265E");
        }
    }

    @Override
    public boolean isLegitMove(int iIn, int jIn, int iOut, int jOut){
        if ((iOut==iIn+2) && (jOut==jIn+1)){
            return true;
        }
        else if ((iOut==iIn+1) && (jOut==jIn+2)){
            return true;
        }
        else if ((iOut==iIn-1) && (jOut==jIn+2)){
            return true;
        }
        else if ((iOut==iIn-2) && (jOut==jIn+1)){
            return true;
        }
        else if ((iOut==iIn-2) && (jOut==jIn-1)){
            return true;
        }
        else if ((iOut==iIn-1) && (jOut==jIn-2)){
            return true;
        }
        else if ((iOut==iIn+1) && (jOut==jIn-2)){
            return true;
        }
        else if ((iOut==iIn+2) && (jOut==jIn-1)){
            return true;
        }
        else{
            return false;
        }
    }
}
