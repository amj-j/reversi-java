package logic;
import utils.Defaults;

public class Game {
    private Board board = new Board(8);
    Player player1 = new Player(Defaults.PLAYER1_NAME);
    Player player2 = new Player(Defaults.PLAYER2_NAME);
    
    public Game() {
        
    }

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

    public void followLine(int x, int y, Player lineOwner, Neighbours neighbour) {
        
    }
}
