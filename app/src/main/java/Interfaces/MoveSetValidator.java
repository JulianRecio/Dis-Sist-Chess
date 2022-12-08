package Interfaces;

import Enums.PieceType;

import java.util.Map;

public interface MoveSetValidator {
    Map<PieceType, MovementValidator> loadMoveSetValidators();
}
