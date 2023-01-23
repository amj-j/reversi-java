package model.board;

import model.Coords;
import model.Player;

public class Board {
    private Tile[][] tiles;
    private final int size;
    
    public Board(int boardSize) {
        tiles = new Tile[boardSize][boardSize];
        this.size = boardSize;
        
    }

    public Tile getTile(Coords coords) {
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

    public void setTileOwner(Player newOwner, Coords coords) {

    }
}
