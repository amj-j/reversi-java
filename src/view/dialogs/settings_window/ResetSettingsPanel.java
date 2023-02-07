package view.dialogs.settings_window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;

import interfaces.ResetSettingsListener;
import view.input_components.ResetSettingsButton;

public class ResetSettingsPanel extends JPanel {
    ResetSettingsButton resetSettingsButton;

    public ResetSettingsPanel() {
        resetSettingsButton = new ResetSettingsButton();
        setLayout(new BorderLayout());
        add(resetSettingsButton, BorderLayout.CENTER);
    }

    public void addResetSettingsListener(ResetSettingsListener listener) {
        resetSettingsButton.addListener(listener);
    }

    @Override
    public void setMaximumSize(Dimension d) {
        super.setMaximumSize(d);
        resetSettingsButton.setMaximumSize(new Dimension(d.width/2, d.height/2));
    }
}
