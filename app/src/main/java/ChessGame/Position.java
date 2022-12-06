package ChessGame;

import Exceptions.PositionWithoutPieceException;

public class Position {
    private final int verticalPosition;
    private final int horizontalPosition;
    private Piece piece;
    private boolean hasChanged;

    public Position(int horizontalPosition, int verticalPosition) {
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
        if (piece != null) {
            return piece;
        }else{
            throw new PositionWithoutPieceException();
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
