package ChessGame;

import Exceptions.PositionWithoutPieceException;

public class Position {
    private int verticalPosition;
    private int horizontalPosition;
    private Piece piece;
    private boolean hasChanged;

    public Position(int verticalPosition, int horizontalPosition) {
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
        hasChanged = false;
    }

    public int getVerticalPosition() {
        return verticalPosition;
    }

    public int getHorizontalPosition() {
        return horizontalPosition;
    }

    public Piece getPiece() throws PositionWithoutPieceException {
        if (isEmpty()) {
            throw new PositionWithoutPieceException();
        }else{
            return piece;
        }
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isEmpty() {
        return piece == null;
    }

    public boolean hasChanged() {
        return hasChanged;
    }

    public void setHasChanged(boolean hasChanged) {
        this.hasChanged = hasChanged;
    }

    public void clearPiece() {
        setPiece(null);
    }
}
