package Tris;

public class Player {

    public String name;
    public Sign sign;
    public boolean completedTurn;

    public Player(String name, Sign sign) {
        this.name = name;
        this.sign = sign;
        this.completedTurn = true;
    }

    @Override
    public String toString() {
        return  name ;
    }
}
