package ChessGame;

import Enums.Color;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;

import java.util.ArrayList;
import java.util.List;

public class PieceMover {

    private static final PieceMover instance = new PieceMover();
    private List<Position> castlingMoves;

    public PieceMover() {
        this.castlingMoves = new ArrayList<>();
    }

    public static PieceMover getInstance() {
        return PieceMover.instance;
    }

    public void moveCastling(Position[] move) {
        castlingMoves.add(move[0]);
        castlingMoves.add(move[1]);
    }

    public void movePiece(Board board, Position startPosition, Position finishPosition){

        if (!castlingMoves.isEmpty()) {
            Position kingsPosition = castlingMoves.get(0);
            Position rooksPosition = castlingMoves.get(1);

            try {
                board.movePiece(kingsPosition,rooksPosition);
                board.movePiece(rooksPosition,kingsPosition);
            } catch (PositionWithoutPieceException ignored) {

            }
            finally {
                this.castlingMoves = new ArrayList<>();
            }
        }
        try {
            board.movePiece(startPosition, finishPosition);
        } catch (PositionWithoutPieceException ignored) {

        }

    }

}
