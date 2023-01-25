package model;

import java.util.Arrays;

import graphic_info.Coords;
import graphic_info.Owner;

public class Board {
    private Owner[][] tiles;
    private final int size;
    private int player1TokenCount;
    private int player2TokenCount;
    
    protected Board(int boardSize) {
        tiles = new Owner[boardSize][boardSize];
        this.size = boardSize;
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(tiles[i], Owner.NONE);
        }
    }

    protected Owner getTileOwner(Coords coords) {
        try {
            return tiles[coords.x][coords.y];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } 
    }

    protected int getSize() {
        return this.size;
    }

    protected void setTileOwner(Owner owner, Coords coords) {
        tiles[coords.x][coords.y] = owner;
    }

    public int getPlayer1TokenCount() {
        return this.player1TokenCount;
    }

    public int getPlayer2TokenCount() {
        return this.player2TokenCount;
    }
}
