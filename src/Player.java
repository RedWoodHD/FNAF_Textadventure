public class Player {
    private final Room startRoom = new Room();
    private Tablet tablet;

    public void switchCamera(){

    }

    public Room getStartRoom() {
        return startRoom;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public Player setTablet(Tablet tablet) {
        this.tablet = tablet;
        return this;
    }
}
