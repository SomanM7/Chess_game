package chess;

public class King extends Piece{
    public King(PieceColour colour){
        this.colour = colour;
        if (colour == PieceColour.BLACK){
            setSymbol("\u2654");

        }
        else{
            setSymbol("\u265A");
        }
    }
    
    public boolean checkOwn(int i0, int j0, int i1, int j1) {
        Square[][] board = Board.getBoard();
        if (board[i1][j1].hasPiece()) {
          if (board[i0][j0].getPiece().getColour() == board[i1][j1].getPiece().getColour()) {
            return true;
          }
        }
        return false;
      }
    
      public boolean isLegitMove(int i0, int j0, int i1, int j1) {
    
        if (checkOwn(i0,j0,i1,j1)) {
          return false;
        }
            int diffi = Math.abs(i0 -i1);
            int diffj = Math.abs(j0 -j1);
    
            if (diffi <= 1 && diffj <= 1) {
                return true;
            }
        return false;
      }
    
    }

