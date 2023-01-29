package structures;

public enum Owner {
    NONE,
    PLAYER_1,
    PLAYER_2;

    public Owner opponent() {
        if (this == PLAYER_1) {
            return PLAYER_2;
        }
        else if (this == PLAYER_2) {
            return PLAYER_1;
        }
        else {
            return NONE;
        }
    }
}
