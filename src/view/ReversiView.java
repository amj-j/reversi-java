package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.EnumMap;

import structures.*;
import view.panels.BoardView;
import view.panels.GameMenu;
import view.panels.PlayerPanel;
import interfaces.*;
import view.dialogs.GameOverWindow;

public class ReversiView extends JFrame implements ReversiModelListener, ReversiViewInterface, ComponentListener, WindowStateListener {
    GameMenu menu;
    BoardView board;
    PlayerPanel topPanel;
    PlayerPanel bottomPanel;
    EnumMap<Owner, Player> players = new EnumMap<>(Owner.class);
    GameOverWindow gameOverWindow = new GameOverWindow(this);
    boolean singleplayer;
    
    public ReversiView(int boardSize) {
        setSize(DefaultViewSettings.WINDOW_WIDTH, DefaultViewSettings.WINDOW_WIDTH);
        getContentPane().setBackground(DefaultViewSettings.BG_COLOR);
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        players.put(Owner.PLAYER_1, new Player(Owner.PLAYER_1, DefaultViewSettings.PLAYER1_NAME, DefaultViewSettings.PLAYER1_COLOR));
        players.put(Owner.PLAYER_2, new Player(Owner.PLAYER_2, DefaultViewSettings.PLAYER2_NAME, DefaultViewSettings.PLAYER2_COLOR));
        
        initBoard(boardSize);
        initGameMenu();
        initPanels();
        
        this.add(menu);
        this.add(topPanel);
        this.add(board);
        this.add(bottomPanel);
        addComponentListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void newGame(int boardSize, boolean singleplayer) {
        this.singleplayer = singleplayer;
        board.newBoard(boardSize);
    }

    public void initBoard(int boardSize) {
        this.board = new BoardView(boardSize, this);
        board.setAlignmentX(CENTER_ALIGNMENT);
        addComponentListener(this);
        addWindowStateListener(this);
        setBoardPanelSize();
    }

    private void initGameMenu() {
        this.menu = new GameMenu(this, this);
        menu.setAlignmentX(CENTER_ALIGNMENT);
    }

    private void initPanels() {
        this.topPanel = new PlayerPanel(players.get(Owner.PLAYER_1));
        topPanel.setAlignmentX(CENTER_ALIGNMENT);
        topPanel.setAlignmentY(TOP_ALIGNMENT);

        this.bottomPanel = new PlayerPanel(players.get(Owner.PLAYER_2));
        bottomPanel.setAlignmentX(CENTER_ALIGNMENT);
        bottomPanel.setAlignmentY(BOTTOM_ALIGNMENT);
    }

    private void setBoardPanelSize() {
        int size = Math.min(this.getWidth(), this.getHeight());
        size /= 3;
        size *= 2;
        board.setPreferredSize(new Dimension(size, size));
        board.setMaximumSize(new Dimension(size, size));
    }

    public void componentResized(ComponentEvent e) { setBoardPanelSize(); }
    public void windowStateChanged(WindowEvent e) { setBoardPanelSize(); }

    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}


    public void updateBoard(BoardChange change) {
        board.updateTiles(change, players);
        players.get(Owner.PLAYER_1).setTokenCount(change.tokenCounts.get(Owner.PLAYER_1));
        players.get(Owner.PLAYER_2).setTokenCount(change.tokenCounts.get(Owner.PLAYER_2));
        topPanel.setValues();
        bottomPanel.setValues();
    }

    public void newPlayableTiles(ArrayList<Coords> playableTiles) {
        board.setPlayableTiles(playableTiles);
    }

    public void removePlayableTiles(ArrayList<Coords> playableTiles) {
        board.removePlayableTiles(playableTiles);
    }

    public void passMove(Owner player) {
        String playerName = players.get(player).getName();
        JWindow popup = new JWindow(this);
        int size = Math.min(this.getWidth(), this.getHeight());
        size /= 16;
        popup.setSize(8*size, size);
        popup.setBackground(new Color(0, 0, 0, 0));
        JLabel writing = new JLabel(playerName + " passes");
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, popup.getWidth()/8);
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
        String playerName = players.get(player).getName();
        gameOverWindow.open(playerName);
    }

    public EnumMap<Owner, Player> getPlayers() {
        return this.players;
    }

    public boolean isSingleplayer() {
        return this.singleplayer;
    }

    public void setHighlightMoves(boolean bool) {
        board.setHighlightMoves(bool);
    }

    public boolean areMovesHighlighted() {
        return board.areMovesHighlighted();
    }

    public void viewNameChange(Player player) {
        if (player.getOwner() == Owner.PLAYER_1) {
            topPanel.setValues();
        }
        else {
            bottomPanel.setValues();
        }
    }

    public void addTileClickedListener(TileClickedListener listener) {
        board.addListener(listener);
    }

    public void addNewGameListener(NewGameListener listener) {
        gameOverWindow.addNewGameListener(listener);
        menu.addNewGameListener(listener);
    }

    public void addPlayerNameListener(PlayerNameListener listener) {
        menu.addPlayerNameListener(listener);
    }

    public void addHighlightMovesListener(HighlightMovesListener listener) {
        menu.addHighlightMovesListener(listener);
    }

    public void addSingleplayerListener(SingleplayerListener listener) {
        menu.addSingleplayerListener(listener);
    }

    public void addBoardSizeListener(BoardSizeListener listener) {
        menu.addBoardSizeListener(listener);
    }

    public void addResetSettingsListener(ResetSettingsListener listener) {
        menu.addResetSettingsListener(listener);
    }
}
