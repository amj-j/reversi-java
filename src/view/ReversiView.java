package view;

import java.awt.*;
import javax.swing.*;

import interfaces.ReversiViewInterface;

public class ReversiView extends JFrame /*implements ReversiViewInterface*/ {
    BoardView board;
    
    public ReversiView(int boardSize) {
        board = new BoardView(boardSize);
        setSize(DefaultViewSettings.WINDOW_WIDTH, DefaultViewSettings.WINDOW_WIDTH);
        setBgColor(DefaultViewSettings.BG_COLOR);
        
        board.setSize(200, 200);
        board.setLocation(50, 50);
        add(board);
    }

    private void setBgColor(Color color) {
        setBackground(color);
    }
}
