package interfaces;

import structures.BoardChange;
public interface ReversiModelInterface {
    public void newGame(int boardSize, boolean singleplayer);
    public void addListener(BoardEventListener listener);
    public int getBoardSize();
    public boolean isSingleplayer();  
    public BoardChange getBoardStatus();  
}
