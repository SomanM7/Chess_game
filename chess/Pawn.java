package chess;

public class Pawn extends Piece {
    public Pawn(PieceColour colour){
        
        this.colour = colour;
        if(colour == PieceColour.BLACK){
            setSymbol("\u2659");
        }
        else {
            setSymbol("\u265F");
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
    
        public boolean checkSquares(int i0, int j0, int i1, int j1){
            Square[][] board = Board.getBoard();
            int max = 0;
            int min = 0;
    
            if (i0>i1){
                max = i0;
                min = i1;
            }else{
                min = i0;
                max = i1;
            }
    
            for (int x = min + 1; x < max ; x++ ){
                if (board[x][j0].hasPiece()){
                    return false;
                }
            }
            return true;
    
        }
    
        public boolean isLegitMove(int i0, int j0, int i1, int j1){
            Square[][] board = Board.getBoard();
            if(checkOwn(i0, j0, i1, j1)){
                return false;
            }
    
            int diffi = Math.abs(i0-i1);
            int diffj = Math.abs(j0-j1);
    
            if((diffi > 2)||(diffj > 1)){
                return false;
            }
    
            if(colour == PieceColour.WHITE){
                if ((i0 <=i1) ||((diffi == 2 )&&(i0!=6))){
                    return false;
                }
            }else{
                if((i0 >=i1) ||((diffi == 2 )&&(i0!=1))){
                    return false;
                }
            }
    
            if (!(checkSquares(i0, j0, i1, j1)) && (diffi == 2)){
                return false;
            }
    
            if (diffj == 1){
                if(diffi !=1){
                    return false;
                }
                
                if (!board[i1][j1].hasPiece()){
                    return false;
                }
            }
    
            if ((diffj == 0) && (board[i1][j1].hasPiece())){
                return false;
            }
            return true;
            
        }

}
