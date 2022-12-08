package Validation.Movement.Moveset;

import Enums.PieceType;
import Interfaces.MoveSetValidator;
import Interfaces.MovementValidator;
import Validation.Movement.*;
import Validation.Movement.Restrictions.CaptureNotAllowedValidator;
import Validation.Movement.Restrictions.OneDirectionMovementValidator;
import Validation.Movement.Restrictions.OneTimeUseMovementValidator;
import Validation.Movement.Restrictions.UnderLimitMovementValidator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ClassicMoveSetValidator implements MoveSetValidator {

    @Override
    public Map<PieceType, MovementValidator> loadMoveSetValidators() {
        Map<PieceType, MovementValidator> piecesMoveSetMap = new HashMap<>();

        //Pawn move set
        Set<MovementValidator> pawnMoveSet = new HashSet<>();

        Set<MovementValidator> regularMoveRestrictions = new HashSet<>();
        regularMoveRestrictions.add(new UnderLimitMovementValidator(1));
        regularMoveRestrictions.add(new OneDirectionMovementValidator());
        regularMoveRestrictions.add(new CaptureNotAllowedValidator());

        Set<MovementValidator> firstMoveDoubleTileRestrictions = new HashSet<>();
        firstMoveDoubleTileRestrictions.add(new UnderLimitMovementValidator(2));
        firstMoveDoubleTileRestrictions.add(new OneTimeUseMovementValidator());
        firstMoveDoubleTileRestrictions.add(new OneDirectionMovementValidator());
        firstMoveDoubleTileRestrictions.add(new CaptureNotAllowedValidator());

        pawnMoveSet.add(new VerticalValidator(regularMoveRestrictions));
        pawnMoveSet.add(new VerticalValidator(firstMoveDoubleTileRestrictions));
        pawnMoveSet.add(new CaptureMovementValidator());
        MovementValidator pawnMovement = new PieceMovementValidator(pawnMoveSet);

        piecesMoveSetMap.put(PieceType.PAWN, pawnMovement);

        //Knight move set
        Set<MovementValidator> knightMoveSet = new HashSet<>();

        knightMoveSet.add(new VariableMovementValidator(1,2,1));
        knightMoveSet.add(new VariableMovementValidator(2,1,1));
        MovementValidator knightMovement = new PieceMovementValidator(knightMoveSet);

        piecesMoveSetMap.put(PieceType.KNIGHT, knightMovement);

        //Rook move set
        Set<MovementValidator> rookMoveSet = new HashSet<>();

        Set<MovementValidator> rookRestrictions = new HashSet<>();

        rookRestrictions.add(new OneTimeUseMovementValidator());
        rookMoveSet.add(new HorizontalValidator());
        rookMoveSet.add(new VerticalValidator());
        MovementValidator rookMovement = new PieceMovementValidator(rookMoveSet);

        piecesMoveSetMap.put(PieceType.ROOK, rookMovement);

        //Bishop move set
        Set<MovementValidator> bishopMoveSet = new HashSet<>();

        bishopMoveSet.add(new DiagonalValidator());
        MovementValidator bishopMovement = new PieceMovementValidator(bishopMoveSet);

        piecesMoveSetMap.put(PieceType.BISHOP, bishopMovement);

        //Queen move set
        Set<MovementValidator> queenMoveSet = new HashSet<>();

        queenMoveSet.add(new HorizontalValidator());
        queenMoveSet.add(new VerticalValidator());
        queenMoveSet.add(new DiagonalValidator());
        MovementValidator queenMovement = new PieceMovementValidator(queenMoveSet);

        piecesMoveSetMap.put(PieceType.QUEEN, queenMovement);

        //King move set
        Set<MovementValidator> kingMoveSet = new HashSet<>();

        Set<MovementValidator> kingMovementRestrictions = new HashSet<>();
        kingMovementRestrictions.add(new UnderLimitMovementValidator(1));

        Set<MovementValidator> kingCastlingRestrictions = new HashSet<>();
        kingCastlingRestrictions.add(new CastlingValidator(kingCastlingRestrictions, PieceType.KING, PieceType.ROOK));

        kingMoveSet.add(new HorizontalValidator(kingMovementRestrictions));
        kingMoveSet.add(new VerticalValidator(kingMovementRestrictions));
        kingMoveSet.add(new DiagonalValidator(kingMovementRestrictions));
        MovementValidator kingMovement = new PieceMovementValidator(kingMoveSet);

        piecesMoveSetMap.put(PieceType.KING, kingMovement);

        return piecesMoveSetMap;
    }
}
