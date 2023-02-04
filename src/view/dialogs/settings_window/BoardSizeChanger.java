package view.dialogs.settings_window;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import interfaces.BoardSizeListener;

public class BoardSizeChanger extends JPanel implements ActionListener {
    JLabel writing;
    JButton choice;

    ArrayList<BoardSizeListener> listeners = new ArrayList<>();
    
    public BoardSizeChanger() {
        writing = new JLabel("Board Size");
        choice = new JButton("Choose...");
        choice.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void addListener(BoardSizeListener listener) {
        listeners.add(listener);
    }
}
