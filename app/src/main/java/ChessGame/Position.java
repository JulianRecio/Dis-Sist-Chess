package ChessGame;

import java.util.NoSuchElementException;

public class Position {
    private String verticalPosition;
    private Integer horizontalPosition;
    private Piece piece;

    public Position(String verticalPosition, Integer horizontalPosition) {
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
    }

    public String getVerticalPosition() {
        return verticalPosition;
    }

    public Integer getHorizontalPosition() {
        return horizontalPosition;
    }

    public Piece getPiece() {
        if (isEmpty()) {
            throw new NoSuchElementException() ;
        }else{
            return piece;
        }
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        if (piece != null){
            return false;
        }else{
            return true;
        }
    }
}
