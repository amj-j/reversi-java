package view.dialogs.settings_window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.*;
import view.DefaultViewSettings;
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
    ResetSettingsPanel swLower = new ResetSettingsPanel();

    JPanel seUpper = new JPanel();
    CloseWindowPanel seLower = new CloseWindowPanel();

    public SettingsWindow(Window owner, ReversiViewInterface view) {
        super(owner);

        northEast = new PlayerNamesPanel(view);
        nwUpper = new SingleplayerPanel(view);
        nwLower = new HighlightMovesPanel(view);

        mainPanel.setLayout(new GridLayout(2, 2));

        northWest.setLayout(new GridLayout(2, 1));
        southWest.setLayout(new GridLayout(2, 1));
        southEast.setLayout(new GridLayout(2, 1));

        adjustWindowSize();
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

        Color noColor = new Color(0,0,0,0);
        mainPanel.setBackground(noColor);
        northWest.setBackground(noColor);
        northEast.setBackground(noColor);
        southWest.setBackground(noColor);
        southEast.setBackground(noColor);
        nwUpper.setBackground(noColor);
        nwLower.setBackground(noColor);
        swUpper.setBackground(noColor);
        swLower.setBackground(noColor);
        seUpper.setBackground(noColor);
        seLower.setBackground(noColor);
        setBackground(DefaultViewSettings.BG_COLOR);
    }


    private void setSizes() {
        int width = mainPanel.getWidth();
        int height = mainPanel.getHeight();

        width /= 2;
        height /= 2;
        setPreciseSize(northWest, width, height);
        setPreciseSize(northEast, width, height);
        setPreciseSize(southWest, width, height);
        setPreciseSize(southEast, width, height);

        height /= 2;
        setPreciseSize(nwUpper, width, height);
        setPreciseSize(nwLower, width, height);
        setPreciseSize(swUpper, width, height);
        setPreciseSize(swLower, width, height);
        setPreciseSize(seUpper, width, height);
        setPreciseSize(seLower, width, height);
    }

    private void setPreciseSize(JPanel panel, int width, int height) {
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));
    }

    public void actionPerformed(ActionEvent e) {
        setModal(false);
        setVisible(false);
    }

    private void adjustWindowSize() {
        Dimension dimension = getOwner().getSize();
        dimension.height /= 2;
        dimension.width = dimension.height*2;
        setSize(dimension);
    }

    public void open() {
        setModal(true);
        adjustWindowSize();
        setSizes();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        setSizes();
        super.paint(g);
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

    public void addResetSettingsListener(ResetSettingsListener listener) {
        swLower.addResetSettingsListener(listener);
    }
}
