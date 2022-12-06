package ChessGame;

import Enums.PieceType;
import Exceptions.PositionWithoutPieceException;
import Interfaces.Board;

public class Promoter {

    private final PieceType promoted;
    private final PieceType promotion;

    public Promoter(PieceType promoted, PieceType promotion) {
        this.promoted = promoted;
        this.promotion = promotion;
    }

    public void verifyForPromotion(boolean p1turn, Board board, Position startPosition, Position finishPosition) {
        try {
            if (finishPosition.isEmpty()) return;
            if (finishPosition.getPiece().getType() != promoted) return;
            if (p1turn){
                if (finishPosition.getVerticalPosition() == board.getHeight()){
                    finishPosition.getPiece().setPromotion(promotion);
                }
            }else{
                if (finishPosition.getVerticalPosition() == 1){
                    finishPosition.getPiece().setPromotion(promotion);
                }
            }

        } catch (PositionWithoutPieceException ignored) {

        }
    }

}
