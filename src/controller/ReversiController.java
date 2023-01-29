package controller;

import java.util.ArrayList;

import interfaces.ReversiControllerInterface;

import java.awt.event.*;

import model.ReversiModel;
import structures.*;
import view.ReversiView;

public class ReversiController implements ReversiControllerInterface {
    private ReversiModel theModel;
    private ReversiView theView;
    
    public ReversiController(ReversiModel theModel, ReversiView theView) {
        this.theView = theView;
		this.theModel = theModel;

        
    }

    public void tileClicked(Coords coords) {
        
    }

    private void gameOver(BoardChange change) {

    }
}
