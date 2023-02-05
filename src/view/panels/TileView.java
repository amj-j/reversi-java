package view.panels;

import java.awt.*;
import javax.swing.*;

import structures.*;
import view.DefaultViewSettings;

public class TileView extends JPanel {
    BoardView board;
    Coords coords;
    Player owner = null;
    boolean playable = false;
    
    public TileView(Coords coords, BoardView board) {
        this.board = board;
        this.coords = coords;
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("paintComponent called");
        super.paintComponent(g);
        if (owner == null && !playable) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        int diameter = Math.min(width, height) - 10;
        int x = (width - diameter) / 2;
        int y = (height - diameter) / 2;
        if (playable && board.areMovesHighlighted()) {
            g.setColor(DefaultViewSettings.PLAYABLE_TILE_COLOR);
            g.drawOval(x, y, diameter, diameter);
        }
        else if (owner != null) {
            g.setColor(owner.getColor());
            g.fillOval(x, y, diameter, diameter);
            System.out.println("Oval filled");
        }
    }

    public Coords getCoords() {
        return this.coords;
    }

    public void addToken(Player newOwner) {
        this.owner = newOwner;
        repaint();
        try {
            Thread.sleep(250);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void turnToken(Player newOwner) {
        this.owner = newOwner;
        repaint();
        try {
            Thread.sleep(250);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setPlayability(boolean playable) {
        this.playable = playable;
        repaint();
    }

    public void clearTile() {
        this.owner = null;
        this.playable = false;
    }
}
