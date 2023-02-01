package model;

import java.util.Arrays;
import java.util.EnumMap;

import structures.*;


public class Board {
    private Owner[][] tiles;
    private final int size;
    private EnumMap<Owner, Integer> tokenCounts = new EnumMap<>(Owner.class);
    
    public Board(int boardSize) {
        tiles = new Owner[boardSize][boardSize];
        this.size = boardSize;
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(tiles[i], Owner.NONE);
        }
        tokenCounts.put(Owner.PLAYER_1, 0);
        tokenCounts.put(Owner.PLAYER_2, 0);
    }

    public Owner getTileOwner(Coords coords) {
        try {
            return tiles[coords.x][coords.y];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } 
    }

    public int getSize() {
        return this.size;
    }

    public void setTileOwner(Owner newOwner, Coords coords) {
        Owner prevOwner = getTileOwner(coords);
        if (prevOwner != newOwner) {
            tiles[coords.x][coords.y] = newOwner;
            tokenCounts.put(newOwner, tokenCounts.get(newOwner)+1);
            if (prevOwner != Owner.NONE) {
                tokenCounts.put(prevOwner, tokenCounts.get(prevOwner)-1);
            }
        }
    }

    public int getTokenCount(Owner player) {
        return this.tokenCounts.get(player);
    }

    public EnumMap<Owner, Integer> getTokenCounts() {
        return new EnumMap<Owner, Integer>(tokenCounts);
    }
}
