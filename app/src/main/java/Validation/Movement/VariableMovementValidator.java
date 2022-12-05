package Validation.Movement;

import ChessGame.Position;
import Exceptions.PositionWithoutPieceException;
import Interfaces.MovementValidator;

import java.util.HashSet;
import java.util.Set;

public class VariableMovementValidator extends AbstractMovementValidator{
    private int x;
    private int y;
    private int limit;

    public VariableMovementValidator(int x ,int y, int limit) {
        super(new HashSet<>());
        this.x = x;
        this.y = y;
        this.limit = limit;
    }

    @Override
    public boolean validateMove(boolean turn, Position startPosition, Position finalPosition) throws PositionWithoutPieceException {
        int subX = Math.abs(finalPosition.getHorizontalPosition() - x);
        boolean restByX = subX % x == 0;
        boolean underHorizontalLimit = subX/x <= limit;

        int subY = Math.abs(finalPosition.getHorizontalPosition() - y);
        boolean restByY = subY % y == 0;
        boolean underVerticalLimit = subY/y <= limit;

        return super.validateMove(turn, startPosition, finalPosition) && restByX && restByY && underHorizontalLimit && underVerticalLimit && ((subY/y) == (subX/x));
    }
    }
