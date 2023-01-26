package model;

import java.util.ArrayList;

import graphic_info.BoardChange;
import graphic_info.Coords;

public interface ReversiModelInterface {
    public void newGame(int boardSize, boolean singleplayer);
    public int getBoardSize();
    public void toggleCurrPlayer();
    public boolean canPlay(Coords coords, ArrayList<Coords> playableTiles);
    public boolean isSingleplayer();
    public BoardChange getBoardStatus();
    public ArrayList<Coords> getPlayableTiles();
    public BoardChange play(Coords coords);
    public Coords calcBestMove();
    public boolean isBoardFull();
}
