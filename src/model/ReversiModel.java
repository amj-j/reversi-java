package model;

import java.util.ArrayList;

import structures.*;
import interfaces.ReversiModelListener;
import interfaces.ReversiModelInterface;
import model.game.*;

public class ReversiModel implements ReversiModelInterface {
    private Game game;
    private int boardSize = DefaultSettings.BOARD_SIZE;
    private boolean singleplayer = DefaultSettings.SINGLEPLAYER;;
    ArrayList<ReversiModelListener> listeners = new ArrayList<>();

    public void newGame() {
        sendNewGame();
        if (singleplayer) {
            this.game = new Singleplayer(boardSize, listeners);
        }
        else {
            this.game = new Multiplayer(boardSize, listeners);
        }
    }

    public void sendNewGame() {
        for (ReversiModelListener listener : listeners) {
            listener.newGame(boardSize, singleplayer);
        }
    }

    public void sendPlayableTiles() {
        if (game != null) {
            game.sendPlayableTiles();
        }
    }

    public void addListener(ReversiModelListener listener) {
        listeners.add(listener);
    }

    public void setBoardSize(int size) {
        this.boardSize = size;
        newGame();
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
        newGame();
    }

    public int getBoardSize() {
        return this.boardSize;
    }

    public boolean isSingleplayer() {
        return this.singleplayer;
    }

    public BoardChange getBoardStatus() {
        return game.getBoardStatus();
    }

    public void playTurn(Coords chosenTile) {
        try {
            game.playTurn(chosenTile);
        } catch (GameOverException e) {

        }
    }
}
