package controller;

import interfaces.ReversiControllerInterface;

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
    
    public ReversiController() {
        this.theModel = new ReversiModel();
        this.theView = new ReversiView(theModel.getBoardSize());

        theModel.addListener(theView);
        theView.addTileClickedListener(this);
        theView.addNewGameListener(this);
        theView.addPlayerNameListener(this);
        theView.addHighlightMovesListener(this);
        theView.addSingleplayerListener(this);
        theView.addBoardSizeListener(this);
        theView.addResetSettingsListener(this);


        theModel.newGame();
        theView.setVisible(true);
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
    }    

    public void resetSettings() {
        
    }

    public void setSingleplayer(boolean bool) {
        theModel.setSingleplayer(bool);
    }

    public void tileClicked(Coords chosenTile) {
        theModel.playTurn(chosenTile);
    }
}
