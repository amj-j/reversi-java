package view.dialogs;

import javax.swing.JFrame;

public class DialogWindows {
    public GameOverWindow gameOver;

    public DialogWindows(JFrame owner) {
        gameOver = new GameOverWindow(owner);
    }
}
