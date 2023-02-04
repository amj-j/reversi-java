package view.dialogs.settings_window;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.*;
import view.input_components.*;

public class SettingsWindow extends JDialog implements ActionListener {

    PlayerNamesPanel playerNamesChanger;
    BoardSizeChanger boardSizeChanger;
    SingleplayerChanger singleplayerChanger;
    HighlightMovesChanger highlightMovesChanger;

    ResetSettingsButton resetSettingsButton;
    JButton closeButton;
    JPanel buttonPanel;

    public SettingsWindow(Window owner, ReversiViewInterface view) {
        super(owner);
        setLayout(new BorderLayout());
        playerNamesChanger = new PlayerNamesPanel(view);
        boardSizeChanger = new BoardSizeChanger();
        singleplayerChanger = new SingleplayerChanger(view);
        highlightMovesChanger = new HighlightMovesChanger(view);
        add(playerNamesChanger);
        add(boardSizeChanger);
        add(singleplayerChanger);
        add(highlightMovesChanger);
        initButtons();
    }

    private void initButtons() {
        resetSettingsButton = new ResetSettingsButton();
        closeButton = new JButton("Close");
        buttonPanel = new JPanel();
        resetSettingsButton.addActionListener(this);
        closeButton.addActionListener(this);
        buttonPanel.add(resetSettingsButton);
        buttonPanel.add(closeButton);
        add(buttonPanel);
    }

    public void actionPerformed(ActionEvent e) {
        setModal(false);
        setVisible(false);
    }

    private void adjustSize() {
        Dimension dimension = getOwner().getSize();
        dimension.height /= 2;
        dimension.width = dimension.height*2;
        setSize(dimension);
    }

    public void open() {
        setModal(true);
        adjustSize();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    public void addPlayerNameListener(PlayerNameListener listener) {
        playerNamesChanger.addListener(listener);
    }

    public void addHighlightMovesListener(HighlightMovesListener listener) {
        highlightMovesChanger.addListener(listener);
    }

    public void addSingleplayerListener(SingleplayerListener listener) {
        singleplayerChanger.addListener(listener);
    }

    public void addBoardSizeListener(BoardSizeListener listener) {
        boardSizeChanger.addListener(listener);
    }

    public void addResetSettingsListener(ResetSettingsListener listener) {
        resetSettingsButton.addListener(listener);
    }
}
