package adapter;

import ChessGame.Piece;
import ChessGame.Position;
import Enums.Color;
import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import edu.austral.dissis.chess.gui.ChessPiece;
import edu.austral.dissis.chess.gui.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class Adapter {
    public List<ChessPiece> adaptPiece(List<Position> positions){
        List<ChessPiece> pieceList = new ArrayList<>();
        for (int i = 0; i < positions.size(); i++) {
            if (!positions.get(i).isEmpty()){
                try {
                    Piece piece = positions.get(i).getPiece();
                    edu.austral.dissis.chess.gui.Position kPosition = adaptPosition(positions.get(i));
                    String id = Integer.toString(piece.getInitialPositionValues()[0]) + Integer.toString(piece.getInitialPositionValues()[1]);
                    PlayerColor playerColor = adaptColor(piece.getColor());
                    String pieceType = adaptPieceType(piece.getType());
                    ChessPiece chessPiece = new ChessPiece(id,playerColor,kPosition, pieceType);
                    pieceList.add(chessPiece);
                } catch (PositionWithoutPieceException ignored) {
                    //posición sin pieza
                }
            }
        }
        return pieceList;
    }

    private String adaptPieceType(PieceType type) {
        return switch (type) {
            case PAWN -> "pawn";
            case ROOK -> "rook";
            case KNIGHT -> "knight";
            case BISHOP -> "bishop";
            case QUEEN -> "queen";
            case KING -> "king";
            case ARCHBISHOP -> "archbishop";
            case CHANCELLOR -> "chancellor";
            default -> "-";
        };
    }

    private PlayerColor adaptColor(Color color) {
        if (color == Color.WHITE) return PlayerColor.WHITE;
        else return PlayerColor.BLACK;
    }

    private edu.austral.dissis.chess.gui.Position adaptPosition(Position position) {
        edu.austral.dissis.chess.gui.Position kPosition = new edu.austral.dissis.chess.gui.Position(position.getVerticalPosition(), position.getHorizontalPosition());
        return kPosition;
    }

}
