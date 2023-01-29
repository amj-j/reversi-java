package model;

import graphic_info.BoardChange;

public interface BoardChangeListener {
    void updateBoardView(BoardChange change);
}
