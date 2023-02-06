package controller;

import model.ReversiModel;
import structures.*;
import view.ReversiView;
import interfaces.*;

public class ReversiController implements ReversiControllerInterface,
    BoardSizeListener, 
    HighlightMovesListener,
    NewGameListener,
    PlayerNameListener,
    ResetSettingsListener,
    SingleplayerListener,
    TileClickedListener
{

    private ReversiModel theModel;
    private ReversiView theView;
    
    public ReversiController(ReversiModel theModel, ReversiView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    public void changeBoardSize(int size) {
        theModel.setBoardSize(size);
    }

    public void setHighlightMoves(boolean bool) {
        theView.setHighlightMoves(bool);
    }

    public void startNewGame() {
        theModel.newGame();
    }

    public void nameChanged(String newName, Player player) {
        player.setName(newName);
        theView.viewNameChange(player);
    }   

    public void resetSettings() {
        
    }

    public void setSingleplayer(boolean bool) {
        theModel.setSingleplayer(bool);
    }

    public void tileClicked(Coords chosenTile) {
        new Thread() {
            @Override
            public void run() {
                theModel.playTurn(chosenTile);
            }
        }.start();
    }
}
