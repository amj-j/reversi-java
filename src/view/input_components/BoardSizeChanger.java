package view.input_components;

import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import interfaces.BoardSizeListener;
import view.DefaultViewSettings;

public class BoardSizeChanger extends JPanel {
    JLabel writing;
    JButton choice;

    ArrayList<BoardSizeListener> listeners = new ArrayList<>();
    
    public BoardSizeChanger() {
        writing = new JLabel("Board Size");
        choice = new JButton("Choose...");
        add(writing);
        add(choice);
        initPopupMenu();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = new Font(DefaultViewSettings.FONT_NAME, Font.PLAIN, getHeight()/3);
                writing.setFont(font);
                writing.setForeground(DefaultViewSettings.FONT_COLOR);
            }
        });
    }

    public void initPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem six = new JMenuItem("6x6");
        JMenuItem eight = new JMenuItem("8x8");
        JMenuItem ten = new JMenuItem("10x10");
        JMenuItem twelve = new JMenuItem("12x12");

        ActionListener menuItemListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int newSize = 0;
                if (event.getSource() == six) { newSize = 6; }
                else if (event.getSource() == eight) { newSize = 8; }
                else if (event.getSource() == ten) { newSize = 10; }
                else if (event.getSource() == twelve) { newSize = 12; }
                for (BoardSizeListener it : listeners) {
                    it.changeBoardSize(newSize);
                }
            }
        };

        six.addActionListener(menuItemListener);
        eight.addActionListener(menuItemListener);
        ten.addActionListener(menuItemListener);
        twelve.addActionListener(menuItemListener);

        popupMenu.add(six);
        popupMenu.add(eight);
        popupMenu.add(ten);
        popupMenu.add(twelve);
        choice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popupMenu.show(choice, choice.getWidth(), 0);
            }
        });
    }

    public void reset() {
        
    }

    public void addListener(BoardSizeListener listener) {
        listeners.add(listener);
    }
}
