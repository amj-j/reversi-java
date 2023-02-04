package view.dialogs.settings_window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.EnumMap;

import structures.*;
import interfaces.PlayerNameListener;
import interfaces.ReversiViewInterface;
import view.DefaultViewSettings;

public class PlayerNamesChanger extends JPanel {
    
    JLabel title;
    PlayerStruct player1Struct;
    PlayerStruct player2Struct;
    
    public PlayerNamesChanger(ReversiViewInterface view) {
        EnumMap <Owner, Player> players = view.getPlayers();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        title = new JLabel("Player names");
        Font font = new Font(DefaultViewSettings.FONT_NAME, Font.BOLD, getWidth()/6);
        title.setFont(font);
        add(title);

        player1Struct = new PlayerStruct(players.get(Owner.PLAYER_1));
        player2Struct = new PlayerStruct(players.get(Owner.PLAYER_2));
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


    private class PlayerStruct extends JPanel implements ActionListener {
        Player player;
        JTextField playerName;
        JButton playerSaveButton;
        ArrayList<PlayerNameListener> listeners = new ArrayList<>();

        public PlayerStruct(Player player) {
            this.player = player;
            this.playerName = new JTextField(player.getName());
            this.playerSaveButton = new JButton("Save");
            add(this.playerName);
            add(this.playerSaveButton);
            playerSaveButton.addActionListener(this);
        }
        
        public void actionPerformed(ActionEvent e) {
            for (PlayerNameListener it : listeners) {
                it.nameChanged(playerName.getText(), player);
            }
        }

        public void addListener(PlayerNameListener listener) {
            listeners.add(listener);
        }
    }

}
