package Validation;

import ChessGame.Game;
import ChessGame.Position;
import Exceptions.InvalidMoveException;

public class Validator {
    //verificar de quien es el turno
    //que sea su pieza
    //que no sea una pieza invalida
    //que sea un movimiento valido para la pieza
    //que sea un movimiento a una posicion que exista
    //que chequeea si hace un jaque
    //que chequee si gana el juego
    private MoveValidator moveValidator;
    private PositionValidator positionValidator;
    private AvailablePathValidator availablePathValidator;
    private CheckValidator checkValidator;
    private VictoryValidation victoryValidation;

    public boolean validateMove(Game game, Position startPosition, Position finalPosition) throws InvalidMoveException {
        if(positionValidator.validate(game.isP1turn(),game.getBoard(), startPosition, finalPosition)
                && moveValidator.validate(game.isP1turn(),game.getBoard(), startPosition, finalPosition)
                && availablePathValidator.validate(game.getBoard(), startPosition, finalPosition)
               // && checkValidator.validateMove(game.isP1turn(),game.getBoard(), startPosition, finalPosition)
        ){
            return true;
        }else{
            throw new InvalidMoveException();
        }
    }


}
