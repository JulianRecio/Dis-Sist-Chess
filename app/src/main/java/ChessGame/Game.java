package ChessGame;

import Enums.GameMode;
import Exceptions.InvalidMoveException;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;
import Validation.Validator;

import java.awt.*;
import java.util.List;

public class Game implements Interfaces.Game {

    private final GameMode gameMode;
    private final Board board;
    private boolean p1turn;
    private final Validator validator;
    private PieceMover pieceMover;


    public Game(GameMode gameMode) {
        this.gameMode = gameMode;
        this.board = generateBoard(gameMode);
        this.p1turn = true;
        this.validator = new Validator(gameMode);
    }

    private Board generateBoard(GameMode gameMode) {
        //Solo genera el board clasico
        switch (gameMode){
            default -> {
                BoardCreator boardCreator = new BoardCreator();
                Board board = boardCreator.create(8, 8);
                PieceCreator pieceCreator = new PieceCreator();
                pieceCreator.insertPiecesInBoard(board, gameMode);
                return board;
            }
        }
    }

    @Override
    public void movePiece(int startX, int startY, int finishX, int finishY) throws PositionWithoutPieceException, InvalidMoveException {
        Position startPosition = board.getPosition(startX, startY);
        Position finishPosition = board.getPosition(finishX, finishY);

        if (!validator.validateMove(p1turn,board, startPosition, finishPosition)) throw new InvalidMoveException();
        pieceMover.movePiece(board, startPosition, finishPosition);
        // promoter.verifyForPromotion(p1turn,board, startPosition, finishPosition);
        this.p1turn = !this.p1turn;
        validator.validateVictory(p1turn,board, startPosition, finishPosition);
    }

    public Board getBoard() {
        return board;
    }

    public boolean isP1turn() {
        return p1turn;
    }
}
