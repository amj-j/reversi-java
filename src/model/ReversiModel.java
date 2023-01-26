package model;

import java.util.ArrayList;

import graphic_info.*;
import utils.Defaults;

public class ReversiModel implements ReversiModelInterface {
    private Board board = new Board(Defaults.BOARD_SIZE);
    private boolean singleplayer = false;
    private Owner currPlayer;
    private Owner otherPlayer;

    public void newGame(int boardSize, boolean singleplayer) {
        this.board = new Board(boardSize);
        this.singleplayer = singleplayer;
        initTokens();
    }

    public int getBoardSize() {
        return board.getSize();
    }

    public void toggleCurrPlayer() {
        Owner tmp = currPlayer;
        currPlayer = otherPlayer;
        otherPlayer = tmp;
    }

    public ArrayList<Coords> getPlayableTiles() {
        ArrayList<Coords> playableTiles = new ArrayList<Coords>();
        Coords coords = new Coords(0,0);
        for (int x = 0; x < board.getSize(); ++x) {
            coords.x = x;
            for (int y = 0; y < board.getSize(); ++y) {
                coords.y = y;
                if (board.getTileOwner(coords) != currPlayer) {
                    continue;
                }
                for (Neighbours neighbour : Neighbours.values()) {
                    ArrayList<Coords> line = getLine(neighbour, otherPlayer, coords);
                    if (line == null || line.size() == 0) {
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
        return playableTiles;
    }

    public boolean canPlay(Coords coords, ArrayList<Coords> playableTiles) {
        for (Coords i : playableTiles) {
            if (coords.x == i.x && coords.y == i.y) {
                return true;
            }
        }
        return false;
    }

    public boolean isSingleplayer() {
        return this.singleplayer;
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

    public BoardChange play(Coords coords) {
        BoardChange currChange = new BoardChange();
        board.setTileOwner(currPlayer, coords);
        currChange.addedToken = new TileInfo(coords, currPlayer);
        for (Neighbours neighbour : Neighbours.values()) {
            ArrayList<Coords> line = getLine(neighbour, otherPlayer, coords);
            if (line == null || line.size() == 0) {
                continue;
            }
            Coords endOfLine = new Coords(line.get(line.size() - 1));
            endOfLine.moveBy(neighbour.getXY());
            if (board.getTileOwner(endOfLine) == currPlayer) {
                for (Coords it : line) {
                    board.setTileOwner(currPlayer, it);
                    currChange.changedTokens.add(new TileInfo(new Coords(it), currPlayer));
                }
            }
        }
        currChange.tokenCounts = board.getTokenCounts();
        return currChange;
    }

    public Coords calcBestMove() {
        ArrayList<Coords> playableTiles = getPlayableTiles();
        int maxTurnedTiles = 0;
        Coords bestTile = null;
        for (Coords tile : playableTiles) {
            int turnedTiles = 0;
            for (Neighbours neighbour : Neighbours.values()) {
                ArrayList<Coords> line = getLine(neighbour, otherPlayer, tile);
                if (line == null || line.size() == 0) {
                    continue;
                }
                Coords endOfLine = new Coords(line.get(line.size() - 1));
                endOfLine.moveBy(neighbour.getXY());
                if (board.getTileOwner(endOfLine) == currPlayer) {
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

    public void initTokens() {
        int size = board.getSize();
        Coords tokenCoords = new Coords(size/2, size/2);
        board.setTileOwner(Owner.PLAYER_1, tokenCoords);
        tokenCoords.x -= 1;
        board.setTileOwner(Owner.PLAYER_2, tokenCoords);
        tokenCoords.y -= 1;
        board.setTileOwner(Owner.PLAYER_1, tokenCoords);
        tokenCoords.x += 1;
        board.setTileOwner(Owner.PLAYER_2, tokenCoords);
    }

    private ArrayList<Coords> getLine(Neighbours direction, Owner lineOwner, Coords start) {
        Coords curr = new Coords(start);
        curr.moveBy(direction.getXY());
        ArrayList<Coords> line = new ArrayList<Coords>();
        while (board.getTileOwner(curr) == lineOwner) {
            line.add(new Coords(curr));
            curr.moveBy(direction.getXY());
        }
        if (board.getTileOwner(curr) == null) {
            return null;
        }
        return line;
    }

    public boolean isBoardFull() {
        int p1TokenCount = board.getTokenCount(Owner.PLAYER_1);
        int p2TokenCount = board.getTokenCount(Owner.PLAYER_2);
        int boardSize = board.getSize();
        if (p1TokenCount + p2TokenCount >= boardSize) {
            return true;
        }
        else {
            return false;
        }
    }
}
