package view;

import java.awt.*;
import javax.swing.*;

public class BoardView extends JPanel {
    TileView[][] tiles;
    private final int size;

    public BoardView(int boardSize) {
        this.size = boardSize;
        tiles = new TileView[size][size];
        setLayout(new GridLayout(size, size));
        initTiles();
    }

    private void initTiles() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                tiles[x][y] = new TileView();
                this.add(tiles[x][y]);
                if ((x%2 == 0 && y%2 == 0) || (x%2 == 1 && y%2 == 1)) {
                    tiles[x][y].setBackground(DefaultViewSettings.TILE_COLOR1);
                }
                else {
                    tiles[x][y].setBackground(DefaultViewSettings.TILE_COLOR2); 
                }
            }
        }
    }
}
