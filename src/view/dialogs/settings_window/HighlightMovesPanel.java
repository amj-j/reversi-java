package view.dialogs.settings_window;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

import interfaces.ReversiViewInterface;
import interfaces.HighlightMovesListener;
import view.DefaultViewSettings;
import view.input_components.HighlightMovesChanger;

public class HighlightMovesPanel extends JPanel {
    HighlightMovesChanger highlightMovesChanger;

    public HighlightMovesPanel(ReversiViewInterface view) {
        highlightMovesChanger = new HighlightMovesChanger(view);
        setLayout(new BorderLayout());
        add(highlightMovesChanger, BorderLayout.CENTER);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = new Font(DefaultViewSettings.FONT_NAME, Font.PLAIN, getHeight()/3);
                highlightMovesChanger.setFont(font);
                highlightMovesChanger.setForeground(DefaultViewSettings.FONT_COLOR);
            }
        });
    }

    public void resetCheckBox() {
        highlightMovesChanger.reset();
    }

    public void addHighlightMovesListener(HighlightMovesListener listener) {
        highlightMovesChanger.addListener(listener);
    }
}
