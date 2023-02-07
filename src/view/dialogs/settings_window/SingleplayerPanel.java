package view.dialogs.settings_window;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JPanel;

import interfaces.ReversiViewInterface;
import interfaces.SingleplayerListener;
import view.DefaultViewSettings;
import view.input_components.SingleplayerChanger;

public class SingleplayerPanel extends JPanel {
    SingleplayerChanger singleplayerChanger;

    public SingleplayerPanel(ReversiViewInterface view) {
        singleplayerChanger = new SingleplayerChanger(view);
        setLayout(new BorderLayout());
        add(singleplayerChanger, BorderLayout.CENTER);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Font font = new Font(DefaultViewSettings.FONT_NAME, Font.PLAIN, getHeight()/3);
                singleplayerChanger.setFont(font);
                singleplayerChanger.setForeground(DefaultViewSettings.FONT_COLOR);
            }
        });
    }

    public void resetCheckBox() {
        singleplayerChanger.reset();
    }

    public void addSingleplayerListener(SingleplayerListener listener) {
        singleplayerChanger.addListener(listener);
    }
}
