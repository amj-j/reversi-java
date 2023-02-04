package view.input_components;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import interfaces.ResetSettingsListener;

public class ResetSettingsButton extends JButton implements ActionListener {
    
    ArrayList<ResetSettingsListener> listeners = new ArrayList<>();

    public ResetSettingsButton() {
        super("Reset Settings");
        addActionListener(this);
    }

    public void addListener(ResetSettingsListener listener) {
        listeners.add(listener);
    }

    public void actionPerformed(ActionEvent e) {
        for (ResetSettingsListener it : listeners) {
            it.resetSettings();
        }
    }
}
