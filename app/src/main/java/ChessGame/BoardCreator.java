package ChessGame;

import Enums.Color;
import Enums.PieceType;
import Interfaces.Board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardCreator {

    public Board create(int xLimit, int yLimit){
        List<Position> positions = new ArrayList<>(xLimit*yLimit);
        for (int number = 1; number <= yLimit ; number++) {
            for (int letter = 1; letter <= xLimit; letter++) {
                Position position = new Position(letter, number);
                positions.add(position);
            }
        }
        return new ChessBoard(positions);
    }

}
