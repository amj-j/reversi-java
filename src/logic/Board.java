package logic;
import utils.Defaults;

public class Board {
    private Tile[][] tiles;
    private final int size;

    public Board() {
        tiles = new Tile[Defaults.BOARD_SIZE][Defaults.BOARD_SIZE];
        this.size = Defaults.BOARD_SIZE; 
    }
    
    public Board(int boardSize) {
        tiles = new Tile[boardSize][boardSize];
        this.size = boardSize;
        
    }

    public Tile getTile(int x, int y) {
        try {
            return tiles[x][y];
        }
        catch(Exception e) {
            return null;
        }
        
    }

    public Tile getNeighbour(Neighbours neighbour) {
        try {
            return tiles[neighbour.getX()][neighbour.getY()];
        }
        catch(Exception e) {
            return null;
        }
    }

    public int getSize() {
        return this.size;
    }
}
