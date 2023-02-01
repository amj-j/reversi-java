package model.game;

import java.util.ArrayList;

import structures.*;
import model.GameOverException;
import interfaces.ReversiModelListener;

public class Multiplayer extends Game {
    Owner currPlayer;

    public Multiplayer(int boardSize, ArrayList<ReversiModelListener> listeners) {
        super(boardSize, listeners);
    }

    @Override
    public void playTurn(Coords chosenTile) throws GameOverException {
        if (!canPlay(chosenTile)) {
            return;
        }
        BoardChange boardChange = play(currPlayer, chosenTile);
        sendBoardChange(boardChange);
        if (isBoardFull()) {
            sendGameOver(getWinner());
            return;
        }
        setPlayableTiles(currPlayer.opponent());
        if (playableTiles.isEmpty()) {
            sendPassMove(currPlayer.opponent());
            setPlayableTiles(currPlayer);
            if (playableTiles.isEmpty()) {
                sendPassMove(currPlayer.opponent());
                sendGameOver(getWinner());
                return;
            }
        }
        else {
            sendPlayableTiles();
            currPlayer = currPlayer.opponent();
        }
        
    }
}
