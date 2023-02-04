package view.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.EnumMap;

import structures.*;
import view.DefaultViewSettings;

public class BoardView extends JPanel {
    TileView[][] tiles;
    private int size;
    private boolean highlightMoves = DefaultViewSettings.HIGHLIGHT_MOVES;

    public BoardView(int boardSize, Container parent) {
        this.size = boardSize;
        tiles = new TileView[size][size];
        setBackground(DefaultViewSettings.BG_COLOR);
        setLayout(new GridLayout(size, size));
        initTiles();
    }

    public void newBoard(int size) {
        this.size = size;
        removeAll();
        initTiles();
    }

    private void initTiles() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tiles[x][y] = new TileView(new Coords(x, y), this);
                if ((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1)) {
                    tiles[x][y].setBackground(DefaultViewSettings.TILE_COLOR1);
                }
                else {
                    tiles[x][y].setBackground(DefaultViewSettings.TILE_COLOR2); 
                }
                this.add(tiles[x][y]);
            }
        }
    }

    public void updateTiles(BoardChange change, EnumMap<Owner, Player> players) {
        if (change.addedToken != null) {
            TileView addedTokenTile = tiles[change.addedToken.coords.x][change.addedToken.coords.y];
            addedTokenTile.addToken(players.get(change.addedToken.owner));
        }
        for (TileInfo info : change.changedTokens) {
            tiles[info.coords.x][info.coords.y].turnToken(players.get(info.owner));
        }
    }

    public void setPlayableTiles(ArrayList<Coords> playableTiles) {
        if (!highlightMoves) {
            return;
        }
        for (Coords coords : playableTiles) {
            tiles[coords.x][coords.y].setPlayability(true);
        }
    }

    public void removePlayableTiles(ArrayList<Coords> playableTiles) {
        for (Coords coords : playableTiles) {
            tiles[coords.x][coords.y].setPlayability(false);
        }
    }

    public boolean areMovesHighlighted() {
        return this.highlightMoves;
    }

    public void setHighlightMoves(boolean bool) {
        this.highlightMoves = bool;
        repaint();
    }
}
