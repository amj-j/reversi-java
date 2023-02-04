package view.dialogs;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import view.DefaultViewSettings;
import interfaces.NewGameListener;

public class GameOverWindow extends JDialog implements ActionListener {
    JLabel title;
    JLabel winner;
    JButton newGameButton;
    JButton showBoardButton;
    JPanel buttonPanel;
    ArrayList<NewGameListener> newGameListeners = new ArrayList<>();
    
    public GameOverWindow(Window owner) {
        super(owner);
        adjustSize();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        title = new JLabel("Game Over!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        winner = new JLabel("???");
        winner.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(winner);

        newGameButton = new JButton("New Game");
        showBoardButton = new JButton("Show Board");
        buttonPanel = new JPanel();
        newGameButton.addActionListener(this);
        showBoardButton.addActionListener(this);
        buttonPanel.add(newGameButton);
        buttonPanel.add(showBoardButton);
        add(buttonPanel);
        
    }

    private void adjustSize() {
        Dimension dimension = getOwner().getSize();
        dimension.height /= 3;
        dimension.width = dimension.height*2;
        setSize(dimension);
    }

    public void open(String winnerName) {
        setModal(true);
        adjustSize();
        setLocationRelativeTo(getOwner());
        title.setFont(new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, getWidth() /12));
        winner.setText(winnerName + " wins!");
        winner.setFont(new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, getWidth() /16));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == newGameButton) {
            for (NewGameListener it : newGameListeners) {
                it.startNewGame();
            }
        }
        setModal(false);
        setVisible(false);
    }

    public void addNewGameListener(NewGameListener listener) {
        newGameListeners.add(listener);
    }
}
