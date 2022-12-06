package edu.austral.dissis.chess

import ChessGame.Game
import ChessGame.Position
import Enums.GameMode
import Exceptions.InvalidMoveException
import Exceptions.PositionWithoutPieceException
import Exceptions.VictoryException
import adapter.Adapter
import edu.austral.dissis.chess.gui.*

class ChessEngine() : GameEngine {

    private val game : Game = Game(GameMode.CLASSIC);
    private val adapter: Adapter = Adapter();

    override fun applyMove(move: Move): MoveResult {
        try {
        game.movePiece(move.from.row, move.from.column, move.to.row, move.to.column)
        val pieces = adapter.adaptPiece(game.board.positions)
        return NewGameState(pieces, if(game.isP1turn) PlayerColor.WHITE else PlayerColor.BLACK)
        } catch (e: InvalidMoveException){
            return InvalidMove(e.message.toString())
        } catch (e: PositionWithoutPieceException){
            return InvalidMove(e.message.toString())
        } catch (e: VictoryException){
            return GameOver(if (game.isP1turn) PlayerColor.BLACK else PlayerColor.WHITE)
        }
    }

    override fun init(): InitialState {
        val pieces = adapter.adaptPiece(game.board.positions);
        val height = game.board.height;
        return InitialState(BoardSize(height, height), pieces, PlayerColor.WHITE);
    }

}