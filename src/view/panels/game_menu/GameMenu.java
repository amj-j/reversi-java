package view.panels.game_menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.*;
import view.dialogs.settings_window.SettingsWindow;

public class GameMenu extends JPanel {
    NewGameButton newGameButton;
    JButton settingsButton;

    SettingsWindow settings;

    public GameMenu(Window owner, ReversiViewInterface view) {
        newGameButton = new NewGameButton();
        add(newGameButton);

        settingsButton = new JButton("Settings");
        add(settingsButton);
        settings = new SettingsWindow(owner, view);
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings.open();
            }
        });
    }
    
    public void addNewGameListener(NewGameListener listener) {
        newGameButton.addListener(listener);
    }

    public void addPlayerNameListener(PlayerNameListener listener) {
        settings.addPlayerNameListener(listener);
    }

    public void addHighlightMovesListener(HighlightMovesListener listener) {
        settings.addHighlightMovesListener(listener);
    }

    public void addSingleplayerListener(SingleplayerListener listener) {
        settings.addSingleplayerListener(listener);
    }

    public void addBoardSizeListener(BoardSizeListener listener) {
        settings.addBoardSizeListener(listener);
    }

    public void addResetSettingsListener(ResetSettingsListener listener) {
        settings.addResetSettingsListener(listener);
    }
}
