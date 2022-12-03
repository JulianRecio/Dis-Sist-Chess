package ChessGame;

import Enums.Color;
import Enums.PieceType;

public class Piece {
    private int id;
    private PieceType type;
    private Color color;

    public Piece(int id, PieceType type, Color color) {
        this.id = id;
        this.type = type;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public PieceType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

}
