package controller;

import java.awt.event.*;

import view.TileView;
import model.ReversiModel;

public class TileClicked extends MouseAdapter {
    ReversiModel theModel;

    public TileClicked(ReversiModel theModel) {
        this.theModel = theModel;
    }

    @Override
    public void mouseClicked(MouseEvent click) {
        TileView tile;
        try {
            tile = (TileView) click.getComponent();
        } catch(Exception e) { return; }
        theModel.playTurn(tile.getCoords());
    }
}
