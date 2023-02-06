package view.dialogs.settings_window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.*;
import view.input_components.*;

public class SettingsWindow extends JDialog implements ActionListener {

    JPanel mainPanel = new JPanel();

    JPanel northWest = new JPanel();
    PlayerNamesPanel northEast;
    JPanel southWest = new JPanel();
    JPanel southEast = new JPanel();

    SingleplayerPanel nwUpper;
    HighlightMovesPanel nwLower;

    BoardSizeChanger swUpper = new BoardSizeChanger();
    NewGamePanel swLower = new NewGamePanel();

    JPanel seUpper = new JPanel();
    ResetSettingsPanel seLower = new ResetSettingsPanel();

    public SettingsWindow(Window owner, ReversiViewInterface view) {
        super(owner);

        northEast = new PlayerNamesPanel(view);
        nwUpper = new SingleplayerPanel(view);
        nwLower = new HighlightMovesPanel(view);

        mainPanel.setLayout(new GridLayout(2, 2));

        northWest.setLayout(new GridLayout(2, 1));
        southWest.setLayout(new GridLayout(2, 1));
        southEast.setLayout(new GridLayout(2, 1));

        setSizes();

        northWest.add(nwUpper);
        northWest.add(nwLower);
        southWest.add(swUpper);
        southWest.add(swLower);
        southEast.add(seUpper);
        southEast.add(seLower);
        mainPanel.add(northWest);
        mainPanel.add(northEast);
        mainPanel.add(southWest);
        mainPanel.add(southEast);
        this.add(mainPanel);

        swLower.addCloseWindowListener(this);
        seLower.addCloseWindowListener(this);
    }


    private void setSizes() {
        int width = mainPanel.getWidth();
        int height = mainPanel.getHeight();

        width /= 2;
        height /= 2;
        setSize(northWest, width, height);
        setSize(northEast, width, height);
        setSize(southWest, width, height);
        setSize(southEast, width, height);

        height /= 2;
        setSize(nwUpper, width, height);
        setSize(nwLower, width, height);
        setSize(swUpper, width, height);
        setSize(swLower, width, height);
        setSize(seUpper, width, height);
        setSize(seLower, width, height);
    }

    private void setSize(JPanel panel, int width, int height) {
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
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
        northEast.addListener(listener);
    }

    public void addHighlightMovesListener(HighlightMovesListener listener) {
        nwLower.addHighlightMovesListener(listener);
    }

    public void addSingleplayerListener(SingleplayerListener listener) {
        nwUpper.addSingleplayerListener(listener);
    }

    public void addBoardSizeListener(BoardSizeListener listener) {
        swUpper.addListener(listener);
    }

    public void addNewGameListener(NewGameListener listener) {
        swLower.addNewGameListener(listener);
    }

    public void addResetSettingsListener(ResetSettingsListener listener) {
        seLower.addResetSettingsListener(listener);
    }
}
