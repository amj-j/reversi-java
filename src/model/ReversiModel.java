package model;

import java.util.ArrayList;

import structures.*;
import interfaces.ReversiModelListener;
import interfaces.ReversiModelInterface;
import model.game.*;

public class ReversiModel implements ReversiModelInterface {
    private Game game;
    ArrayList<ReversiModelListener> listeners = new ArrayList<>();

    public void newGame() {
        int boardSize = DefaultSettings.BOARD_SIZE;
        boolean singleplayer = DefaultSettings.SINGLEPLAYER;
        if (singleplayer) {
            this.game = new Singleplayer(boardSize, listeners);
        }
        else {
            this.game = new Multiplayer(boardSize, listeners);
        }
    }

    public void newGame(int boardSize, boolean singleplayer) {
        if (singleplayer) {
            this.game = new Singleplayer(boardSize, listeners);
        }
        else {
            this.game = new Multiplayer(boardSize, listeners);
        }
    }

    public void addListener(ReversiModelListener listener) {
        listeners.add(listener);
    }

    public int getBoardSize() {
        if (game == null) {
            return DefaultSettings.BOARD_SIZE;
        }
        return game.getBoardSize();
    }

    public boolean isSingleplayer() {
        if (game instanceof Singleplayer) {
            return true;
        }
        else {
            return false;
        }
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
