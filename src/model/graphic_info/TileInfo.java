package model.graphic_info;

import model.Coords;
import model.enums.TileStatus;

public class TileInfo {
    public Coords coords;
    public TileStatus status;

    public TileInfo(Coords coords, TileStatus status) {
        this.coords = coords;
        this.status = status;
    }
}
