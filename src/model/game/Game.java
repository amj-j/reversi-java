package model.game;

import java.util.ArrayList;

import interfaces.ReversiModelListener;
import model.*;
import structures.*;

public abstract class Game {
    private Board board = new Board(DefaultSettings.BOARD_SIZE);
    protected ArrayList<Coords> playableTiles = new ArrayList<>();
    ArrayList<ReversiModelListener> listeners = new ArrayList<>();

    public Game(int boardSize, ArrayList<ReversiModelListener> listeners) {
        this.board = new Board(boardSize);
        this.listeners = listeners;
        initGame();
    }

    public void addListener(ReversiModelListener listener) {
        this.listeners.add(listener);
    }

    public void sendBoardChange(BoardChange change) {
        for (ReversiModelListener listener : listeners) {
            listener.updateBoard(change);
        }
    }

    public void sendPlayableTiles() {
        for (ReversiModelListener listener : listeners) {
            listener.newPlayableTiles(playableTiles);
        }
    }

    public void sendRemovePlayableTiles() {
        for (ReversiModelListener listener : listeners) {
            listener.removePlayableTiles(playableTiles);
        }
    }

    public void sendPassMove(Owner player) {
        for (ReversiModelListener listener : listeners) {
            listener.passMove(player);
        }
    }

    public void sendGameOver(Owner winner) throws GameOverException {
        for (ReversiModelListener listener : listeners) {
            listener.gameOver(winner);
        }
        throw new GameOverException();
    }

    public void sendStall(int millis) {
        for (ReversiModelListener listener : listeners) {
            listener.stall(millis);
        }
    }

    public void playTurn(Coords chosenTile) throws GameOverException {}

    public int getBoardSize() {
        return board.getSize();
    }

    public void initGame() {
        int size = board.getSize();
        BoardChange initChange = new BoardChange();
        Coords tokenCoords = new Coords(size/2, size/2);
        board.setTileOwner(Owner.PLAYER_1, tokenCoords);
        initChange.changedTokens.add(new TileInfo(new Coords(tokenCoords), Owner.PLAYER_1));
        tokenCoords.x -= 1;
        board.setTileOwner(Owner.PLAYER_2, tokenCoords);
        initChange.changedTokens.add(new TileInfo(new Coords(tokenCoords), Owner.PLAYER_2));
        tokenCoords.y -= 1;
        board.setTileOwner(Owner.PLAYER_1, tokenCoords);
        initChange.changedTokens.add(new TileInfo(new Coords(tokenCoords), Owner.PLAYER_1));
        tokenCoords.x += 1;
        board.setTileOwner(Owner.PLAYER_2, tokenCoords);
        initChange.changedTokens.add(new TileInfo(new Coords(tokenCoords), Owner.PLAYER_2));
        setPlayableTiles(DefaultSettings.STARTING_PLAYER);
        initChange.tokenCounts = board.getTokenCounts();
        sendBoardChange(initChange);
        sendPlayableTiles();
    }

    public BoardChange getBoardStatus() {
        BoardChange status = new BoardChange(null, board.getTokenCounts());
        for (int x = 0; x < board.getSize(); ++x) {
            for (int y = 0; y < board.getSize(); ++y) {
                Coords coords = new Coords(x,y);
                TileInfo tile = new TileInfo(coords, board.getTileOwner(coords));
                status.changedTokens.add(tile);
            }
        }
        return status;
    }

    protected void setPlayableTiles(Owner player) {
        playableTiles.clear();
        Coords tile = new Coords(0,0);
        for (int x = 0; x < board.getSize(); ++x) {
            tile.x = x;
            for (int y = 0; y < board.getSize(); ++y) {
                tile.y = y;
                if (board.getTileOwner(tile) != player) {
                    continue;
                }
                for (Neighbours neighbour : Neighbours.values()) {
                    ArrayList<Coords> line = getLine(neighbour, player.opponent(), tile);
                    if (line == null) {
                        continue;
                    }                    
                    Coords endOfLine = new Coords(line.get(line.size() - 1));
                    endOfLine.moveBy(neighbour.getXY());
                    if (board.getTileOwner(endOfLine) == Owner.NONE) {
                        playableTiles.add(endOfLine);
                    }
                }
            }
        }
    }

    protected boolean canPlay(Coords coords) {
        for (Coords i : playableTiles) {
            if (coords.x == i.x && coords.y == i.y) {
                return true;
            }
        }
        return false;
    }

    protected BoardChange play(Owner player, Coords tile) {
        BoardChange currChange = new BoardChange();
        board.setTileOwner(player, tile);
        currChange.addedToken = new TileInfo(tile, player);
        for (Neighbours neighbour : Neighbours.values()) {
            ArrayList<Coords> line = getLine(neighbour, player.opponent(), tile);
            if (line == null) {
                continue;
            }
            Coords endOfLine = new Coords(line.get(line.size() - 1));
            endOfLine.moveBy(neighbour.getXY());
            if (board.getTileOwner(endOfLine) == player) {
                for (Coords it : line) {
                    board.setTileOwner(player, it);
                    currChange.changedTokens.add(new TileInfo(new Coords(it), player));
                }
            }
        }
        currChange.tokenCounts = board.getTokenCounts();
        return currChange;
    }

    protected Coords calcBestMove(Owner player) {
        int maxTurnedTiles = 0;
        Coords bestTile = null;
        for (Coords tile : playableTiles) {
            int turnedTiles = 0;
            for (Neighbours neighbour : Neighbours.values()) {
                ArrayList<Coords> line = getLine(neighbour, player.opponent(), tile);
                if (line == null) {
                    continue;
                }
                Coords endOfLine = new Coords(line.get(line.size() - 1));
                endOfLine.moveBy(neighbour.getXY());
                if (board.getTileOwner(endOfLine) == player) {
                    turnedTiles += line.size();
                }
            }
            if (turnedTiles > maxTurnedTiles) {
                maxTurnedTiles = turnedTiles;
                bestTile = tile;
            }
        }
        return bestTile;
    }

    protected ArrayList<Coords> getLine(Neighbours direction, Owner lineOwner, Coords start) {
        Coords curr = new Coords(start);
        curr.moveBy(direction.getXY());
        if (board.getTileOwner(curr) != lineOwner) {
            return null;
        }
        ArrayList<Coords> line = new ArrayList<Coords>();
        while (board.getTileOwner(curr) == lineOwner) {
            line.add(new Coords(curr));
            curr.moveBy(direction.getXY());
        }
        if (board.getTileOwner(curr) == null ) {
            return null;
        }
        return line;
    }

    protected boolean isBoardFull() {
        int p1 = board.getTokenCount(Owner.PLAYER_1);
        int p2 = board.getTokenCount(Owner.PLAYER_2);
        int boardSize = board.getSize();
        if (p1 + p2 >= boardSize*boardSize) {
            return true;
        }
        else {
            return false;
        }
    }

    protected Owner getWinner() {
        int p1 = board.getTokenCount(Owner.PLAYER_1);
        int p2 = board.getTokenCount(Owner.PLAYER_2);
        if (p1 > p2) {
            return Owner.PLAYER_1;
        }
        else if (p2 > p1) {
            return Owner.PLAYER_2;
        }
        else {
            return Owner.NONE;
        }
    }

    
}
