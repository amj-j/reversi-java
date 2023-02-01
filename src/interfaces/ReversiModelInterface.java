package interfaces;

import structures.*;

public interface ReversiModelInterface {
    public void newGame();
    public void newGame(int boardSize, boolean singleplayer);
    public void addListener(ReversiModelListener listener);
    public int getBoardSize();
    public boolean isSingleplayer();  
    public BoardChange getBoardStatus(); 
    public void playTurn(Coords chosenTile); 
}
