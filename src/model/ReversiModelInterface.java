package model;

import java.util.ArrayList;

import graphic_info.Owner;
import graphic_info.BoardChange;
import graphic_info.Coords;

public interface ReversiModelInterface {
    public void newGame(int boardSize, boolean singleplayer);
    public int getBoardSize();
    public void toggleCurrPlayer();
    public void setPlayableTiles(Owner owner);
    public boolean canPlay(Coords coords);
    public boolean isSingleplayer();
    public void play(Coords coords);
    public void playOpponent();
    public BoardChange getBoardChange();
    public BoardChange getBoardStatus();
    public ArrayList<Coords> getPlayableTiles();
    public boolean isGameOver();
}
