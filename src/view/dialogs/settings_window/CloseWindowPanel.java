package view.dialogs.settings_window;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CloseWindowPanel extends JPanel {
    JButton closeButton;

    public CloseWindowPanel() {
        closeButton = new JButton("Close");
        setLayout(new BorderLayout());
        add(closeButton, BorderLayout.CENTER);
    }

    public void addCloseWindowListener(ActionListener listener) {
        closeButton.addActionListener(listener);
    }

    @Override
    public void setMaximumSize(Dimension d) {
        super.setMaximumSize(d);
        closeButton.setMaximumSize(new Dimension(d.width/2, d.height/2));
    }
}
