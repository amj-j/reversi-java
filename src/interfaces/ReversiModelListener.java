package interfaces;

import java.util.ArrayList;

import structures.*;

public interface ReversiModelListener {
    public void newGame(int boardSize, boolean singleplayer);
    public void updateBoard(BoardChange change);
    public void newPlayableTiles(ArrayList<Coords> playableTiles);
    public void removePlayableTiles(ArrayList<Coords> playableTiles);
    public void passMove(Owner player);
    public void gameOver(Owner winner);
    public void stall(int millis);
}
