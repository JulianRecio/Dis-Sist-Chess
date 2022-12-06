package Validation;

import ChessGame.Position;
import Interfaces.Board;

public class AvailablePathValidator {
    public boolean validate(Board board, Position startPosition, Position finalPosition) {
        int xVector = finalPosition.getHorizontalPosition() - startPosition.getHorizontalPosition();
        int yVector = finalPosition.getVerticalPosition() - startPosition.getVerticalPosition();

        int hcf = hcf(xVector, yVector);
        yVector = yVector / hcf;
        xVector = xVector / hcf;

        Position searchPosition = startPosition;
        while (!searchPosition.equals(finalPosition)){
            searchPosition = board.getPosition(searchPosition.getHorizontalPosition() + xVector, searchPosition.getVerticalPosition() + yVector);
            if (!searchPosition.isEmpty() && !searchPosition.equals(finalPosition)) return false;
        }
        return true;
    }

    private int hcf(int a, int b){
        if (b == 0){
            return Math.abs(a);
        }else {
            return Math.abs(hcf(b, a % b));
        }
    }
}
