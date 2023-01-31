package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.util.ArrayList;
import java.util.EnumMap;

import structures.*;
import interfaces.ReversiModelListener;

public class ReversiView extends JFrame implements ComponentListener, WindowStateListener, ReversiModelListener {
    GameMenu menu;
    BoardView board;
    PlayerPanel topPanel;
    PlayerPanel bottomPanel;
    EnumMap<Owner, Player> players = new EnumMap<>(Owner.class);
    
    public ReversiView(int boardSize) {
        setSize(DefaultViewSettings.WINDOW_WIDTH, DefaultViewSettings.WINDOW_WIDTH);
        getContentPane().setBackground(DefaultViewSettings.BG_COLOR);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        players.put(Owner.PLAYER_1, new Player(Owner.PLAYER_1, DefaultViewSettings.PLAYER1_NAME, DefaultViewSettings.PLAYER1_COLOR));
        players.put(Owner.PLAYER_2, new Player(Owner.PLAYER_2, DefaultViewSettings.PLAYER2_NAME, DefaultViewSettings.PLAYER2_COLOR));
        
        initMenu();
        
        this.topPanel = new PlayerPanel(players.get(Owner.PLAYER_2));
        topPanel.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.setAlignmentY(TOP_ALIGNMENT);
        this.add(topPanel);

        initBoard(boardSize);

        this.bottomPanel = new PlayerPanel(players.get(Owner.PLAYER_1));
        bottomPanel.setAlignmentX(CENTER_ALIGNMENT);
        bottomPanel.setAlignmentY(BOTTOM_ALIGNMENT);
        this.add(bottomPanel);
    }

    public void initMenu() {
        this.menu = new GameMenu();
        menu.setAlignmentX(CENTER_ALIGNMENT);
        this.add(menu);
    }

    public void initBoard(int boardSize) {
        this.board = new BoardView(boardSize, this);
        board.setAlignmentX(CENTER_ALIGNMENT);
        this.add(board);
        addComponentListener(this);
        addWindowStateListener(this);
        setBoardSize();
    }

    private void setBoardSize() {
        int size = Math.min(this.getWidth(), this.getHeight());
        size /= 3;
        size *= 2;
        board.setPreferredSize(new Dimension(size, size));
        board.setMaximumSize(new Dimension(size, size));
    }

    public void componentResized(ComponentEvent e) { setBoardSize(); }
    public void windowStateChanged(WindowEvent e) { setBoardSize(); }

    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}


    public void updateBoard(BoardChange change) {
        board.updateTiles(change, players);
        players.get(Owner.PLAYER_1).setTokenCount(change.tokenCounts.get(Owner.PLAYER_1));
        players.get(Owner.PLAYER_2).setTokenCount(change.tokenCounts.get(Owner.PLAYER_2));
        repaint();
    }

    public void newPlayableTiles(ArrayList<Coords> playableTiles) {
        board.setPlayableTiles(playableTiles);
        board.repaint();
    }

    public void passMove(Owner player) {
        String playerName = players.get(player).getName();
        JWindow popup = new JWindow(this);
        int size = Math.min(this.getWidth(), this.getHeight());
        size /= 16;
        popup.setSize(8*size, size);
        popup.setBackground(new Color(0, 0, 0, 0));
        JLabel writing = new JLabel(playerName + " passes");
        Font font = new Font("Arial", Font.BOLD, 20);
        writing.setFont(font);
        writing.setHorizontalAlignment(SwingConstants.CENTER);
        popup.add(writing);    
        popup.setLocationRelativeTo(this);
        popup.setVisible(true);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        popup.setVisible(false);
        popup.dispose();
    }

    public void gameOver(Owner player) {

    }

}
