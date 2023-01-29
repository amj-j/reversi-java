package model;

import structures.*;
import utils.Defaults;
import interfaces.BoardEventListener;
import interfaces.ReversiModelInterface;
import model.game.*;

public class ReversiModel implements ReversiModelInterface {
    private Game game;

    public ReversiModel() {
        newGame(Defaults.BOARD_SIZE, Defaults.SINGLEPLAYER);
    }

    public void newGame(int boardSize, boolean singleplayer) {
        if (singleplayer) {
            this.game = new Singleplayer(boardSize);
        }
        else {
            this.game = new Multiplayer(boardSize);
        }
    }

    public void addListener(BoardEventListener listener) {
        game.addListener(listener);
    }

    public int getBoardSize() {
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
