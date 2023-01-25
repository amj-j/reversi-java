package model;

import java.util.ArrayList;

import graphic_info.*;
import utils.Defaults;

public class ReversiModel implements ReversiModelInterface {
    private Board board = new Board(Defaults.BOARD_SIZE);
    private BoardChange boardChange;
    private ArrayList<Coords> playableTiles = new ArrayList<Coords>();
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

    public void setPlayableTiles() {
        this.playableTiles = new ArrayList<Coords>();
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
                    if (line == null) {
                        continue;
                    }
                    if (line.size() > 0) {
                        Coords playable = new Coords(line.get(line.size() - 1));
                        playable.moveBy(neighbour.getXY());
                        if (board.getTileOwner(playable) == Owner.NONE) {
                            this.playableTiles.add(playable);
                        }
                    }
                }
            }
        }
    }

    public boolean canPlay(Coords coords) {
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

    public BoardChange getBoardChange() {
        return this.boardChange;
    }

    public ArrayList<Coords> getPlayableTiles() {
        return this.playableTiles;
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
}
