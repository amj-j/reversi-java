package model.game;

import java.util.ArrayList;

import structures.*;
import model.GameOverException;
import interfaces.ReversiModelListener;
import model.DefaultSettings;

public class Multiplayer extends Game {
    Owner currPlayer = DefaultSettings.STARTING_PLAYER;

    public Multiplayer(int boardSize, ArrayList<ReversiModelListener> listeners) {
        super(boardSize, listeners);
    }

    @Override
    public void playTurn(Coords chosenTile) throws GameOverException {
        if (!canPlay(chosenTile)) {
            return;
        }
        sendRemovePlayableTiles();
        BoardChange boardChange = play(currPlayer, chosenTile);
        sendBoardChange(boardChange);
        if (isBoardFull()) {
            sendGameOver(getWinner());
            return;
        }
        setPlayableTiles(currPlayer.opponent());
        if (playableTiles.isEmpty()) {
            System.out.println("First one passes");
            sendPassMove(currPlayer.opponent());
            setPlayableTiles(currPlayer);
            if (playableTiles.isEmpty()) {
                System.out.println("Second one passes");
                sendPassMove(currPlayer);
                sendGameOver(getWinner());
                return;
            }
            else {
                sendPlayableTiles();
            }
        }
        else {
            sendPlayableTiles();
            currPlayer = currPlayer.opponent();
        }
    }
}
