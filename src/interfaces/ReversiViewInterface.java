package interfaces;

import java.util.EnumMap;

import structures.*;

public interface ReversiViewInterface {
    public EnumMap<Owner, Player> getPlayers();
    public boolean areMovesHighlighted();
    public boolean isSingleplayer();
    public void resetToDefault();
    
    public void addTileClickedListener(TileClickedListener listener);
    public void addNewGameListener(NewGameListener listener);
    public void addPlayerNameListener(PlayerNameListener listener);
    public void addHighlightMovesListener(HighlightMovesListener listener);
    public void addSingleplayerListener(SingleplayerListener listener);
    public void addBoardSizeListener(BoardSizeListener listener);
    public void addResetSettingsListener(ResetSettingsListener listener);
}
