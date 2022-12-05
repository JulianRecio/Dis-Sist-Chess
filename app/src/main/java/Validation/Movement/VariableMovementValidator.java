package Validation.Movement;

import ChessGame.Position;
import Interfaces.MovementValidator;

import java.util.HashSet;
import java.util.Set;

public class VariableMovementValidator extends AbstractMovementValidator{
    private int x;
    private int y;
    private int limit;

    public VariableMovementValidator() {
        super(new HashSet<>());
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) {
        int subX = Math.abs(finalPosition.getHorizontalPosition() - x);
        boolean restByX = subX % x == 0;
        boolean underHorizontalLimit = subX/x <= limit;

        int subY = Math.abs(finalPosition.getHorizontalPosition() - y);
        boolean restByY = subY % y == 0;
        boolean underVerticalLimit = subY/y <= limit;

        return super.validateMove(turn, startPosition, finalPosition) && restByX && restByY && underHorizontalLimit && underVerticalLimit && ((subY/y) == (subX/x));
    }
    }
