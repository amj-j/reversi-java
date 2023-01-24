package model.game;

import model.board.Board;
import model.graphic_info.*;

public abstract class Game {
    protected Board board;
    protected BoardInfo boardInfo;
    
    public Game(int boardSize) { 
        this.board = new Board(boardSize);
    }

    public void turn() {}
}
