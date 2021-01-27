public abstract class Card {
    private final String name;
    private boolean isHidden;
    private Location location;
    private static Board board;

    public Card(String name) {
        this.name = name;
        this.isHidden = true;
    }

    public Card(String name, boolean hidden, Location loc) {
        this.name = name;
        this.isHidden = hidden;
        this.location = loc;
    }

    public abstract void action(MonsterCard var1);

    public boolean isHidden() {
        return this.isHidden;
    }

    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static Board getBoard() {
        return board;
    }

    public static void setBoard(Board board) {
        board = board;
    }

    public String getName() {
        return this.name;
    }

}
