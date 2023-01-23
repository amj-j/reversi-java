package model;
import model.board.Board;
import model.board.Tile;
import model.enums.Neighbours;
import utils.Defaults;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    
    public Game(int boardSize) {
        this.board = new Board(boardSize);
        this.player1 = new Player(Defaults.PLAYER1_NAME);
        this.player2 = new Player(Defaults.PLAYER2_NAME);

        initTokens();
    }

    private void initTokens() {
        int size = board.getSize();
        Coords tokenCoords = new Coords(size/2, size/2);

    }

    public void setTileOwnerByCoords()

    public void setPlayableTiles(Player playingPlayer) {
        for (int x = 0; x < board.getSize(); ++x) {
            for (int y = 0; y < board.getSize(); ++x) {
                if (board.getTile(x, y).getOwner() != playingPlayer) {
                    continue;
                }
                for (Neighbours neighbour : Neighbours.values()) {
                    Player owner = board.getTile(neighbour.getX(), neighbour.getY()).getOwner();
                    if (owner != null && owner != playingPlayer) {
                        followLine(neighbour.getX(), neighbour.getY(), )
                    }
                }
            }
        }
    }

    public Tile followLine(int x, int y, Player lineOwner, Neighbours nextTile) {
        Tile tile;
        do {
            x += nextTile.getX();
            y += nextTile.getY();
            tile = board.getTile(x,y);
        } while (tile.getOwner() == lineOwner);
        return tile;
    }
}
