import java.util.Map;

public class Room {
    private RoomName roomName;
    private Map<Direction, Room> neighborRooms;
    private Camera camera ;
    private boolean doorClosed;
    private int pirateCoveOpeningStage = 0;


    public int getPirateCoveOpeningStage() {
        return pirateCoveOpeningStage;
    }

    public Room setPirateCoveOpeningStage(int pirateCoveOpeningStage) {
        this.pirateCoveOpeningStage = pirateCoveOpeningStage;
        return this;
    }

    public RoomName getRoomName() {
        return roomName;
    }

    public Room setRoomName(RoomName roomName) {
        this.roomName = roomName;
        return this;
    }

    public Map<Direction, Room> getNeighborRooms() {
        return neighborRooms;
    }

    public Room setNeighborRooms(Map<Direction, Room> neighborRooms) {
        this.neighborRooms = neighborRooms;
        return this;
    }

    public Camera getCamera() {
        return camera;
    }

    public Room setCamera(Camera camera) {
        this.camera = camera;
        return this;
    }

    public boolean isDoorClosed() {
        return doorClosed;
    }

    public Room setDoorClosed(boolean doorClosed) {
        this.doorClosed = doorClosed;
        return this;
    }

    public Room getNextRoom(Direction direction){

        return getNeighborRooms().get(direction);
    }
}
