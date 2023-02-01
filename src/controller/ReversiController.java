package controller;

import interfaces.ReversiControllerInterface;

import model.ReversiModel;
import structures.*;
import view.ReversiView;

public class ReversiController implements ReversiControllerInterface {
    private ReversiModel theModel;
    private ReversiView theView;
    
    public ReversiController(ReversiModel theModel, ReversiView theView) {
        this.theView = theView;
		this.theModel = theModel;
        theModel.addListener(theView);
        theView.addTileClickedListener(new TileClicked(theModel));
        theModel.newGame();
    }
}
