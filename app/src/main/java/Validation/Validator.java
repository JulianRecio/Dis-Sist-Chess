package Validation;

import ChessGame.Position;
import Enums.GameMode;
import Exceptions.InvalidMoveException;
import Exceptions.PositionWithoutPieceException;
import Exceptions.VictoryException;
import Interfaces.Board;
import Validation.Victory.CheckMateValidation;
import Validation.Victory.VictoryValidation;

public class Validator {

    private MoveValidator moveValidator;
    private PositionValidator positionValidator;
    private AvailablePathValidator availablePathValidator;
    private CheckValidator checkValidator;
    private VictoryValidation victoryValidation;

    public Validator(GameMode gameMode) {
        this.moveValidator = new MoveValidator(gameMode);
        this.positionValidator = new PositionValidator();
        this.availablePathValidator = new AvailablePathValidator();
        this.checkValidator = new CheckValidator(moveValidator, availablePathValidator);
        this.victoryValidation = selectVictoryConditionsForGameMode(gameMode);
    }


    public boolean validateMove(boolean turn, Board board, Position startPosition, Position finalPosition) throws InvalidMoveException, PositionWithoutPieceException {
        if(
                positionValidator.validate(turn,board, startPosition, finalPosition) // funciona
                && moveValidator.validate(turn, startPosition, finalPosition) // funciona
                && availablePathValidator.validate(board, startPosition, finalPosition) // funciona
                // && checkValidator.validateMove(turn,board, startPosition, finalPosition) // no funciona
        ){
            return true;
        }else{
            return false;
        }
    }

    public void validateVictory(boolean turn, Board board, Position startPosition, Position finalPosition) throws VictoryException {
        if (victoryValidation.validateVictory(turn, board, startPosition, finalPosition)){
            String player = turn ? "Whites" : "Blacks";
            throw new VictoryException(player + " win!");
        }
    }

    private VictoryValidation selectVictoryConditionsForGameMode(GameMode gameMode) {
        return switch (gameMode){
            case CLASSIC, CAPABLANCA -> new CheckMateValidation(this);
            default -> null;
        };
    }

}
