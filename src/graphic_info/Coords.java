package graphic_info;

public class Coords {
    public int x;
    public int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coords(Coords source) {
        this.x = source.x;
        this.y = source.y;
    }

    public void moveBy(Coords coords) {
        this.x += coords.x;
        this.y += coords.y;
    }
}
