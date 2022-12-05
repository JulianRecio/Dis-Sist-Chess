package ChessGame;

import Interfaces.Board;

import java.util.List;

public class ChessBoard implements Board {
    private List<Position> positions;

    public ChessBoard(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public Position getPosition(int verticalPosition, int horizontalPosition) {
        for(Position position : positions){
            if (verticalPosition == position.getVerticalPosition() && horizontalPosition == position.getHorizontalPosition()) return position;
        }
        return null;
    }


}
