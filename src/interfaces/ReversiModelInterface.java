package interfaces;

import structures.*;

public interface ReversiModelInterface {
    public void newGame();
    public void setBoardSize(int size);
    public void setSingleplayer(boolean singleplayer);
    public void addListener(ReversiModelListener listener);
    public int getBoardSize();
    public boolean isSingleplayer();  
    public BoardChange getBoardStatus(); 
    public void playTurn(Coords chosenTile); 
    public void sendPlayableTiles();
    public void resetToDefault();
}
