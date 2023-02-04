package view.dialogs.settings_window;

import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import interfaces.SingleplayerListener;
import interfaces.ReversiViewInterface;


public class SingleplayerChanger extends JCheckBox implements ActionListener {
    
    ArrayList<SingleplayerListener> listeners = new ArrayList<>();

    public SingleplayerChanger(ReversiViewInterface view) {
        super("Singleplayer", view.isSingleplayer());
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        boolean bool = isSelected();
        for (SingleplayerListener it : listeners) {
            it.setSingleplayer(bool);
        }
    }

    public void addListener(SingleplayerListener listener) {
        listeners.add(listener);
    }

}
