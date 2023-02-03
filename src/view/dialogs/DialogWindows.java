package view.dialogs;

import javax.swing.JFrame;

public class DialogWindows {
    public GameOver gameOver;

    public DialogWindows(JFrame owner) {
        gameOver = new GameOver(owner);
    }
}
