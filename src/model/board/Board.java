package model.board;

import java.util.Arrays;
import model.Coords;
import model.enums.TileStatus;

public class Board {
    private TileStatus[][] tiles;
    private final int size;
    
    public Board(int boardSize) {
        tiles = new TileStatus[boardSize][boardSize];
        this.size = boardSize;
        Arrays.fill(tiles, TileStatus.VACANT);
    }

    public TileStatus getTileStatus(Coords coords) {
        try {
            return tiles[coords.x][coords.y];
        }
        catch(Exception e) {
            return null;
        }
        
    }

    public int getSize() {
        return this.size;
    }

    public void setTileStatus(TileStatus status, Coords coords) {
        tiles[coords.x][coords.y] = status;
    }
}
