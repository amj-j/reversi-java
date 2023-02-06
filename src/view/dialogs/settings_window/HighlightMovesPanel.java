package view.dialogs.settings_window;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import interfaces.ReversiViewInterface;
import interfaces.HighlightMovesListener;
import view.input_components.HighlightMovesChanger;

public class HighlightMovesPanel extends JPanel {
    HighlightMovesChanger highlightMovesChanger;

    public HighlightMovesPanel(ReversiViewInterface view) {
        highlightMovesChanger = new HighlightMovesChanger(view);
        setLayout(new BorderLayout());
        add(highlightMovesChanger, BorderLayout.CENTER);
    }

    public void addHighlightMovesListener(HighlightMovesListener listener) {
        highlightMovesChanger.addListener(listener);
    }
}
