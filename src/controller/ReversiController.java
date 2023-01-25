package controller;

import java.awt.event.*;

import graphic_info.*;
import model.ReversiModel;
import view.ReversiView;

public class ReversiController implements ReversiControllerInterface {
    private ReversiModel theModel;
    private ReversiView theView;
    
    public ReversiController(ReversiModel theModel, ReversiView theView) {
        this.theView = theView;
		this.theModel = theModel;

        
    }

    public void tileClicked(Coords coords) {
        if (!theModel.canPlay(coords)) {
            return;
        }
        theModel.play(coords);
        theModel.toggleCurrPlayer();
        BoardChange change = theModel.getBoardChange();
        theView.updateBoard(change);
        if (theModel.isSingleplayer()) {
            //wait 3 seconds
            theModel.playOpponent();
            theModel.toggleCurrPlayer();
            change = theModel.getBoardChange();
            theView.updateBoard(change);
        }
        if (theModel.isGameOver()) {
            gameOver(change);
        }
    }

    private void gameOver(BoardChange change) {

    }
}
