package model.graphic_info;

import java.util.ArrayList;

public class BoardInfo {
    public final ArrayList<TileInfo> changedTiles;   
    public final int player1TokenCount;
    public final int player2TokenCount;

    public BoardInfo(ArrayList<TileInfo> changedTiles, int player1TokenCount, int player2TokenCount) {
        this.changedTiles = changedTiles;
        this.player1TokenCount = player1TokenCount;
        this.player2TokenCount = player2TokenCount;
    }
}
