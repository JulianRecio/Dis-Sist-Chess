package Validation.Victory;

import ChessGame.Position;
import Enums.Color;
import Exceptions.InvalidMoveException;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;
import Validation.Validator;

import java.util.List;

public class CheckMateValidation implements VictoryValidation{

    private final Validator validator;

    public CheckMateValidation(Validator validator) {
        this.validator = validator;
    }
    @Override
    public boolean validateVictory(boolean turn, Board board, Position startPosition, Position finalPosition) {
         Color color = turn ? Color.WHITE : Color.BLACK;
        List<Position> boardPositions = board.getPositions();

        for (Position position : boardPositions) {
            try {
                if (!position.isEmpty() && position.getPiece().getColor() == color){
                    for (Position targetPosition: boardPositions) {
                        try {
                            if (validator.validateMove(turn, board, position, targetPosition)){
                                return false;
                            }
                        } catch (InvalidMoveException ignored) {
                            continue;
                        }
                    }
                }
            } catch (PositionWithoutPieceException ignored) {
                continue;
            }
        }

        return true;
    }


}
