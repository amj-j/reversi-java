package view.dialogs.settings_window;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.*;

public class SettingsWindow extends JDialog implements ActionListener {

    PlayerNamesChanger playerNamesChanger;
    BoardSizeChanger boardSizeChanger;
    SingleplayerChanger singleplayerChanger;
    HighlightMovesChanger highlightMovesChanger;

    JButton resetSettingsButton;
    JButton closeButton;
    JPanel buttonPanel;

    ArrayList<ResetSettingsListener> resetSettingsListeners = new ArrayList<>();

    public SettingsWindow(Window owner, ReversiViewInterface view) {
        super(owner);
        setLayout(new BorderLayout());
        playerNamesChanger = new PlayerNamesChanger(view);
        boardSizeChanger = new BoardSizeChanger();
        singleplayerChanger = new SingleplayerChanger(view);
        add(playerNamesChanger);
        add(boardSizeChanger);
        add(singleplayerChanger);
        add(highlightMovesChanger);
        initButtons();
    }

    private void initButtons() {
        resetSettingsButton = new JButton("Reset Settings");
        closeButton = new JButton("Close");
        buttonPanel = new JPanel();
        resetSettingsButton.addActionListener(this);
        closeButton.addActionListener(this);
        buttonPanel.add(resetSettingsButton);
        buttonPanel.add(closeButton);
        add(buttonPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == resetSettingsButton) {
            for (ResetSettingsListener it : resetSettingsListeners) {
                it.resetSettings();
            }
        }
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
        resetSettingsListeners.add(listener);
    }
}
