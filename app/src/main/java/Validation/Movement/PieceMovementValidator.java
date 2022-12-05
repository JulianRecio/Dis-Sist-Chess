package Validation.Movement;

import Interfaces.MovementValidator;

import java.util.Set;

public class PieceMovementValidator extends AbstractMovementValidator{
    public PieceMovementValidator(Set<MovementValidator> moves) {
        super(moves);
    }
}
