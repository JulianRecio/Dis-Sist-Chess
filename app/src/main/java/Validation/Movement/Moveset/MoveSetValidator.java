package Validation.Movement.Moveset;

import Enums.PieceType;
import Interfaces.MovementValidator;

import java.util.Map;

public interface MoveSetValidator {
    Map<PieceType, MovementValidator> loadMoveSetValidators();
}
