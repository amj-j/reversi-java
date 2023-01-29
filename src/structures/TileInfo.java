package structures;

public class TileInfo {
    public Coords coords;
    public Owner owner;

    public TileInfo(Coords coords, Owner owner) {
        this.coords = coords;
        this.owner = owner;
    }
}
