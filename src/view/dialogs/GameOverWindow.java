package view.dialogs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import view.DefaultViewSettings;
import view.input_components.NewGameButton;
import interfaces.NewGameListener;

public class GameOverWindow extends JDialog implements ActionListener {
    JLabel title;
    JLabel winner;
    NewGameButton newGameButton;
    JButton showBoardButton;
    JPanel buttonPanel;
    
    public GameOverWindow(Window owner) {
        super(owner);
        adjustSize();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setBackground(DefaultViewSettings.BG_COLOR);

        title = new JLabel("Game Over!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBackground(DefaultViewSettings.BG_COLOR);
        add(title);

        winner = new JLabel("???");
        winner.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBackground(DefaultViewSettings.BG_COLOR);
        add(winner);

        newGameButton = new NewGameButton();
        showBoardButton = new JButton("Show Board");
        buttonPanel = new JPanel();
        buttonPanel.setBackground(DefaultViewSettings.BG_COLOR);
        newGameButton.addActionListener(this);
        showBoardButton.addActionListener(this);
        buttonPanel.add(newGameButton);
        buttonPanel.add(showBoardButton);
        add(buttonPanel);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setButtonsSize();
                setFont();
            }
        });
    }

    private void setButtonsSize() {
        int width = Math.min(getHeight(), getWidth()) / 6;
        Dimension d = new Dimension(width, width/2);
        newGameButton.setMaximumSize(d);
        newGameButton.setMaximumSize(d);
    }

    private void adjustSize() {
        Dimension dimension = getOwner().getSize();
        dimension.height /= 3;
        dimension.width = dimension.height*2;
        setSize(dimension);
    }

    public void setFont() {
        int fontSize = Math.min(getHeight(), getWidth()) /5;
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, fontSize);
        title.setForeground(DefaultViewSettings.FONT_COLOR);
        title.setFont(font);
        fontSize = Math.min(getHeight(), getWidth()) /7;
        font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, fontSize);
        winner.setForeground(DefaultViewSettings.FONT_COLOR);
        winner.setFont(font);
    }

    public void open(String winnerName) {
        setModal(true);
        adjustSize();
        setLocationRelativeTo(getOwner());
        winner.setText(winnerName + " wins!");
        setButtonsSize();
        setFont();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setModal(false);
        setVisible(false);
    }

    public void addNewGameListener(NewGameListener listener) {
        newGameButton.addListener(listener);
    }
}
