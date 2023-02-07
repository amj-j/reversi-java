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
    TogglePlayerColorsListener,
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
        if (bool == true) {
            theModel.sendPlayableTiles();
        }
    }

    public void startNewGame() {
        theModel.newGame();
    }

    public void nameChanged(String newName, Player player) {
        player.setName(newName);
        theView.viewNameChange(player);
    }   

    public void resetSettings() {
        theModel.resetToDefault();
        theView.resetToDefault();
        theModel.sendPlayableTiles();
    }

    public void setSingleplayer(boolean bool) {
        theModel.setSingleplayer(bool);
    }

    public void toggleColors() {
        theView.togglePlayerColors();;
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
