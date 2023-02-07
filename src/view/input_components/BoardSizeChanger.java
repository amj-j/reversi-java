package view.input_components;

import java.util.ArrayList;
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

    public void reset() {
        
    }

    public void addListener(BoardSizeListener listener) {
        listeners.add(listener);
    }
}
