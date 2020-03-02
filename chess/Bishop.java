package chess;

public class Bishop extends Piece {
    public Bishop(PieceColour colour){
        this.colour = colour;
        if (colour == PieceColour.BLACK){
            setSymbol("\u2657");

        }
        else{
            setSymbol("\u265D");
        }
    }

    public boolean checkOwn(int i0, int j0, int i1, int j1){
        Square[][] board = Board.getBoard();
        if (board[i1][j1].hasPiece()) {
            if (board[i0][j0].getPiece().getColour() == board[i1][j1].getPiece().getColour()) {
              return true;
            }
          }
          return false;
        }
    
      public boolean checkSquares(int i0, int j0, int i1, int j1){
        Square[][] board = Board.getBoard();
        int dist = Math.abs(i0 - i1);
        int x = 0;
        int y = 0;
    
        while (Math.abs(x) < dist - 1){
          if (i0<i1){
            x = x + 1;
          } else {
            x = x - 1;
          }
    
          if (j0<j1){
            y = y + 1;
          }else{
            y = y - 1;
          }
    
          if (board[x + i0][y + j0].hasPiece()){
            return false;
          }
    
        }
        return true;
      }
    
      public boolean isLegitMove(int i0, int j0, int i1, int j1){
        if(checkOwn(i0,j0,i1,j1)){
          return false;
        }
        int diffi = Math.abs(i0-i1);
        int diffj = Math.abs(j0-j1);
    
        if (diffi == diffj){
          if (checkSquares(i0,i1,j0,j1)){
            return true;
          }
        }
        return false;
      }
    }
    
