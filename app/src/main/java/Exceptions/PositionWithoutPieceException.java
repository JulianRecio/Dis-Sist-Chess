package Exceptions;

public class PositionWithoutPieceException extends Exception{
    public PositionWithoutPieceException() {
        super("The position has no piece!");
    }
}
