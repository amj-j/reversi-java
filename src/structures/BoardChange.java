package structures;

import java.util.ArrayList;
import java.util.EnumMap;

public class BoardChange {
    public ArrayList<TileInfo> changedTokens = new ArrayList<TileInfo>();;
    public TileInfo addedToken;
    public EnumMap<Owner, Integer> tokenCounts = new EnumMap<>(Owner.class);

    public BoardChange() {}

    public BoardChange(TileInfo addedToken, EnumMap<Owner, Integer> tokenCounts) {
        this.addedToken = addedToken;
        this.tokenCounts = tokenCounts;
    }
}
