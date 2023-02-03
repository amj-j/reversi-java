package controller;

import interfaces.ReversiControllerInterface;

import model.ReversiModel;
import structures.*;
import view.ReversiView;

public class ReversiController implements ReversiControllerInterface {
    private ReversiModel theModel;
    private ReversiView theView;
    
    public ReversiController() {
        this.theModel = new ReversiModel();
        this.theView = new ReversiView(theModel.getBoardSize());
        theModel.addListener(theView);
        theView.addTileClickedListener(new TileClicked(theModel));
        theModel.newGame();
        theView.setVisible(true);
    }
}
