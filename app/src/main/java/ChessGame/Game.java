package ChessGame;

import Interfaces.Board;
import Validation.Validator;

import java.util.List;

public class Game implements Interfaces.Game {

    private Board board;
    private List<Piece> player1Pieces;
    private List<Piece> player2Pieces;
    private boolean p1turn;
    private Validator validator;
    private List<Integer> movedPieces;

    @Override
    public void movePiece(Position startPosition,Position finalPosition) {

    }

    public Board getBoard() {
        return board;
    }

    public List<Piece> getPlayer1Pieces() {
        return player1Pieces;
    }

    public List<Piece> getPlayer2Pieces() {
        return player2Pieces;
    }

    public boolean isP1turn() {
        return p1turn;
    }
}
