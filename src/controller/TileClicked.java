package controller;

import java.awt.event.*;

import view.BoardView;
import view.TileView;
import model.ReversiModel;

public class TileClicked extends MouseAdapter {
    ReversiModel theModel;

    public TileClicked(ReversiModel theModel) {
        this.theModel = theModel;
    }

    @Override
    public void mouseClicked(MouseEvent click) {
        BoardView board;
        TileView tile;
        System.out.println("KLIK");
        try {
            board = (BoardView) click.getComponent();
            tile = (TileView) board.getComponentAt(click.getPoint());
        } catch(Exception e) { 
            return; 
        }
        theModel.playTurn(tile.getCoords());
    }
}
