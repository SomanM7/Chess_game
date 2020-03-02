package chess;

public class Rook extends Piece{
    public Rook(PieceColour colour){
        this.colour = colour;
        if (colour == PieceColour.BLACK){
            setSymbol("\u2656");

        }
        else{
            setSymbol("\u265C");
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
    
    
      public boolean checkSquares(int i0, int j0, int i1, int j1) {
        Square[][] board = Board.getBoard();
    
        int minj = 0;
        int mini = 0;
        int maxj = 0;
        int maxi = 0;
    
        if(i0>i1){
          maxi = i0;
          mini = i1;
        }else{
          maxi = i1;
          mini = i0;
        }
    
        if (j0>j1){
          maxj = j0;
          minj = j1;
        }else{
          maxj = j1;
          minj = j0;
        }
    
        if ((i0 - i1) == 0) {
          for (int x = minj + 1; x < maxj  ;x++ ) {
            if (board[i0][x].hasPiece()) {
              return false;
            }
          }
    
        } else {
          for (int x = mini + 1; x < maxi ;x++ ) {
            if (board[x][j0].hasPiece()) {
              return false;
            }
          }
        }
        return true;
      }
      public boolean isLegitMove(int i0, int j0, int i1, int j1) {
    
        if (checkOwn(i0,j0,i1,j1)) {
          return false;
        }
    
        if ((i0 == i1 ^ j0 == j1)) {
          if (checkSquares(i0,j0,i1,j1)) {
            return true;
          }
        }
        return false;
      }
    }
    
