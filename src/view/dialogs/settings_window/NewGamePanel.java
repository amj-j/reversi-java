package view.dialogs.settings_window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import interfaces.NewGameListener;
import view.input_components.NewGameButton;

public class NewGamePanel extends JPanel {
    NewGameButton newGameButton;

    public NewGamePanel() {
        newGameButton = new NewGameButton();
        setLayout(new BorderLayout());
        add(newGameButton, BorderLayout.CENTER);
    }

    public void addNewGameListener(NewGameListener listener) {
        newGameButton.addListener(listener);
    }

    public void addCloseWindowListener(ActionListener listener) {
        newGameButton.addActionListener(listener);
    }

    @Override
    public void setMaximumSize(Dimension d) {
        super.setMaximumSize(d);
        newGameButton.setMaximumSize(new Dimension(d.width/2, d.height/2));
    }
}
