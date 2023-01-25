package graphic_info;

import java.util.ArrayList;

public class BoardChange {
    public ArrayList<TileInfo> changedTokens;
    public final TileInfo addedToken;
    public final int player1TokenCount;
    public final int player2TokenCount;

    public BoardChange(TileInfo addedToken, int player1TokenCount, int player2TokenCount) {
        this.changedTokens = new ArrayList<TileInfo>();
        this.addedToken = addedToken;
        this.player1TokenCount = player1TokenCount;
        this.player2TokenCount = player2TokenCount;
    }
}
