package view.dialogs.settings_window;

import java.awt.*;
import javax.swing.*;
import java.util.EnumMap;

import structures.*;
import interfaces.PlayerNameListener;
import interfaces.ReversiViewInterface;
import view.DefaultViewSettings;
import view.input_components.PlayerNameChanger;

public class PlayerNamesPanel extends JPanel {
    
    JLabel title;
    PlayerNameChanger player1Struct;
    PlayerNameChanger player2Struct;
    
    public PlayerNamesPanel(ReversiViewInterface view) {
        EnumMap <Owner, Player> players = view.getPlayers();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Player names");
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, getWidth()/6);
        title.setFont(font);
        add(title);

        player1Struct = new PlayerNameChanger(players.get(Owner.PLAYER_1));
        player2Struct = new PlayerNameChanger(players.get(Owner.PLAYER_2));
        add(player1Struct);
        add(player2Struct);
    }

    @Override
    public void paintComponent(Graphics g) {
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, getWidth()/6);
        title.setFont(font);
        super.paintComponent(g);
    }

    public void addListener(PlayerNameListener listener) {
        player1Struct.addListener(listener);
        player1Struct.addListener(listener);
    }


    

}
