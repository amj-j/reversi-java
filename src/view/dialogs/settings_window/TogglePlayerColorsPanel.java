package view.dialogs.settings_window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

import interfaces.TogglePlayerColorsListener;
import view.input_components.TogglePlayerColorsButton;

public class TogglePlayerColorsPanel extends JPanel {
    TogglePlayerColorsButton togglePlayerColorsButton;

    public TogglePlayerColorsPanel() {
        togglePlayerColorsButton = new TogglePlayerColorsButton();
        setLayout(new BorderLayout());
        add(togglePlayerColorsButton, BorderLayout.CENTER);
    }

    public void addTogglePlayerColorsListener(TogglePlayerColorsListener listener) {
        togglePlayerColorsButton.addListener(listener);
    }

    @Override
    public void setMaximumSize(Dimension d) {
        super.setMaximumSize(d);
        togglePlayerColorsButton.setMaximumSize(new Dimension(d.width/2, d.height/2));
    }
}
