package view.input_components;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import interfaces.TogglePlayerColorsListener;

public class TogglePlayerColorsButton extends JButton implements ActionListener {
    
    ArrayList<TogglePlayerColorsListener> listeners = new ArrayList<>();

    public TogglePlayerColorsButton() {
        super("Toggle Colors");
        addActionListener(this);
    }

    public void addListener(TogglePlayerColorsListener listener) {
        listeners.add(listener);
    }

    public void actionPerformed(ActionEvent e) {
        for (TogglePlayerColorsListener it : listeners) {
            it.toggleColors();
        }
    }    
}
