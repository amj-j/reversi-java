package model;

import model.graphic_info.BoardInfo;

public interface ReversiModelInterface {
    public void newGame(int boardSize, boolean multiplayer);
    public void tileClicked(Coords coords);
    public BoardInfo getChangeOnBoard();
    public BoardInfo getBoardStatus();
    public boolean endOfGame();
}
