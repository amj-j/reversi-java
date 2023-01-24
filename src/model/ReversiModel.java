package model;

import model.game.*;
import utils.Defaults;

public class ReversiModel implements ReversiModelInterface {
    private Game game;

    public ReversiModel() {

    }

    public void newGame(int boardSize, boolean multiplayer) {
        if (multiplayer) {
            this.game = new Multiplayer(boardSize);
        }
        else {
            this.game = new Singleplayer(boardSize);
        }
        
    }

    public void tileClicked(Coords coords) {
        game.turn();
    }
}
