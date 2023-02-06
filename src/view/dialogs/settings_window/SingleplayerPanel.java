package view.dialogs.settings_window;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import interfaces.ReversiViewInterface;
import interfaces.SingleplayerListener;
import view.input_components.SingleplayerChanger;

public class SingleplayerPanel extends JPanel {
    SingleplayerChanger singleplayerChanger;

    public SingleplayerPanel(ReversiViewInterface view) {
        singleplayerChanger = new SingleplayerChanger(view);
        setLayout(new BorderLayout());
        add(singleplayerChanger, BorderLayout.CENTER);
    }

    public void addSingleplayerListener(SingleplayerListener listener) {
        singleplayerChanger.addListener(listener);
    }
}
