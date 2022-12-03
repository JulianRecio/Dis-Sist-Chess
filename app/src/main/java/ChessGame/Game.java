package ChessGame;

import Enums.PieceType;
import Interfaces.Board;
import Interfaces.MovementValidator;

import java.util.List;
import java.util.NoSuchElementException;

public class Game implements Interfaces.Game {

    private Board board;
    private List<Piece> player1Pieces;
    private List<Piece> player2Pieces;
    private boolean p1turn;
    private MovementValidator movementValidator;

    //verificar de quien es el turno
    //que sea su pieza
    //que no sea una pieza invalida
    //fijarse si sigue las reglas definidas en el validador
    @Override
    public void movePiece(Position startPosition,Position finalPosition) {
        try {
        if (p1turn && startPosition.isHasPiece() && player1Pieces.contains(startPosition.getPiece())
                && startPosition.getPiece().getType() != PieceType.Invalid){
                movementValidator.validateMove(startPosition, finalPosition);
            }
        }catch (NoSuchElementException e){

        }
    }

}
