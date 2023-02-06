package view.dialogs.settings_window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.EnumMap;

import structures.*;
import interfaces.PlayerNameListener;
import interfaces.ReversiViewInterface;
import view.DefaultViewSettings;
import view.input_components.PlayerNameChanger;

public class PlayerNamesPanel extends JPanel implements ComponentListener {
    
    JLabel title;
    PlayerNameChanger player1Struct;
    PlayerNameChanger player2Struct;
    
    public PlayerNamesPanel(ReversiViewInterface view) {
        EnumMap <Owner, Player> players = view.getPlayers();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Player names");
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, getWidth()/16);
        title.setFont(font);
        add(title);

        player1Struct = new PlayerNameChanger(players.get(Owner.PLAYER_1));
        player2Struct = new PlayerNameChanger(players.get(Owner.PLAYER_2));
        add(player1Struct);
        add(player2Struct);
        addComponentListener(this);
    }

    public void setFont() {
        int fontSize = Math.min(getHeight(), getWidth()) /6;
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, fontSize);
        this.title.setForeground(DefaultViewSettings.FONT_COLOR);
        this.title.setFont(font);
    }

    public void addListener(PlayerNameListener listener) {
        player1Struct.addListener(listener);
        player2Struct.addListener(listener);
    }

    public void componentResized(ComponentEvent e) { setFont(); }
    public void componentMoved(ComponentEvent e) {}
    public void componentShown(ComponentEvent e) {}
    public void componentHidden(ComponentEvent e) {}
}
