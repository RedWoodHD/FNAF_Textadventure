package Game.factory;

import Game.factor.Direction;
import Game.factor.RoomName;
import Game.object.Room;
import java.util.HashMap;
import java.util.Map;

/**
 * Diese Klasse erzeugt alle {@link Room Räume}.
 */
public class RoomFactory
{
    private final Map<RoomName, Room> allRooms;

    public RoomFactory()
    {
        allRooms = createAllRooms();
    }

    private Map<RoomName, Room> createAllRooms()
    {
        Map<RoomName, Room> allRooms = new HashMap<>();

//        Erstelle jeden Raum ohne Nachbarräume.
        Room showStage = createRoom(RoomName.SHOWSTAGE);
        Room diningArea = createRoom(RoomName.DININGAREA);
        Room restrooms = createRoom(RoomName.RESTROOMS);
        Room backstage = createRoom(RoomName.BACKSTAGE);
        Room pirateCove = createRoom(RoomName.PIRATECOVE);
        Room kitchen = createRoom(RoomName.KITCHEN);
        Room supplyCloset = createRoom(RoomName.SUPPLYCLOSET);
        Room eastHall = createRoom(RoomName.EASTHALL);
        Room eastHallCorner = createRoom(RoomName.EASTHALLCORNER);
        Room eastDoor = createRoom(RoomName.EASTDOOR);
        Room westHall = createRoom(RoomName.WESTHALL);
        Room westHallCorner = createRoom(RoomName.WESTHALLCORNER);
        Room westDoor = createRoom(RoomName.WESTDOOR);
        Room office = createRoom(RoomName.OFFICE);

//        Erstelle für jeden Raum die Nachbarräume.
        addNeighborRoom(showStage, Direction.SOUTH1, diningArea);
        addNeighborRoom(showStage, Direction.WEST1, backstage);
        addNeighborRoom(showStage, Direction.EAST, restrooms);
        addNeighborRoom(showStage, Direction.RESET, diningArea);

        addNeighborRoom(diningArea, Direction.NORTH, showStage);
        addNeighborRoom(diningArea, Direction.EAST, restrooms);
        addNeighborRoom(diningArea, Direction.SOUTH1, westHall);
        addNeighborRoom(diningArea, Direction.SOUTH2, eastHall);
        addNeighborRoom(diningArea, Direction.SOUTH3, kitchen);
        addNeighborRoom(diningArea, Direction.WEST1, backstage);
        addNeighborRoom(diningArea, Direction.WEST2, pirateCove);
        addNeighborRoom(diningArea, Direction.RESET, diningArea);

        addNeighborRoom(backstage, Direction.EAST, diningArea);
        addNeighborRoom(backstage, Direction.SOUTH1, westHall);
        addNeighborRoom(backstage, Direction.RESET, diningArea);

        addNeighborRoom(pirateCove, Direction.EAST, diningArea);
        addNeighborRoom(pirateCove, Direction.RESET, diningArea);

        addNeighborRoom(restrooms, Direction.WEST1, diningArea);
        addNeighborRoom(restrooms, Direction.SOUTH1, kitchen);
        addNeighborRoom(restrooms, Direction.RESET, diningArea);

        addNeighborRoom(kitchen, Direction.NORTH, diningArea);
        addNeighborRoom(kitchen, Direction.WEST1, eastHall);
        addNeighborRoom(kitchen, Direction.RESET, diningArea);

        addNeighborRoom(eastHall, Direction.NORTH, diningArea);
        addNeighborRoom(eastHall, Direction.SOUTH1, eastHallCorner);
        addNeighborRoom(eastHall, Direction.RESET, diningArea);

        addNeighborRoom(eastHallCorner, Direction.NORTH, eastHall);
        addNeighborRoom(eastHallCorner, Direction.WEST1, eastDoor);
        addNeighborRoom(eastHallCorner, Direction.RESET, diningArea);

        addNeighborRoom(eastDoor, Direction.WEST1, office);
        addNeighborRoom(eastDoor, Direction.EAST, eastHallCorner);
        addNeighborRoom(eastDoor, Direction.RESET, diningArea);

        addNeighborRoom(westHall, Direction.NORTH, diningArea);
        addNeighborRoom(westHall, Direction.SOUTH1, westHallCorner);
        addNeighborRoom(westHall, Direction.WEST1, supplyCloset);
        addNeighborRoom(westHall, Direction.RESET, diningArea);

        addNeighborRoom(westHallCorner, Direction.NORTH, supplyCloset);
        addNeighborRoom(westHallCorner, Direction.EAST, westDoor);
        addNeighborRoom(westHallCorner, Direction.RESET, diningArea);

        addNeighborRoom(westDoor, Direction.EAST, office);
        addNeighborRoom(westDoor, Direction.WEST1, westHallCorner);
        addNeighborRoom(westDoor, Direction.RESET, diningArea);

        addNeighborRoom(supplyCloset, Direction.EAST, westHall);
        addNeighborRoom(supplyCloset, Direction.RESET, diningArea);

        addNeighborRoom(office, Direction.EAST, eastDoor);
        addNeighborRoom(office, Direction.WEST1, westDoor);
        addNeighborRoom(office, Direction.RESET, diningArea);


//        Füge der Map jeden Raum hinzu.
        allRooms.put(RoomName.SHOWSTAGE, showStage);
        allRooms.put(RoomName.DININGAREA, diningArea);
        allRooms.put(RoomName.RESTROOMS, restrooms);
        allRooms.put(RoomName.BACKSTAGE, backstage);
        allRooms.put(RoomName.PIRATECOVE, pirateCove);
        allRooms.put(RoomName.KITCHEN, kitchen);
        allRooms.put(RoomName.SUPPLYCLOSET, supplyCloset);
        allRooms.put(RoomName.EASTHALL, eastHall);
        allRooms.put(RoomName.EASTHALLCORNER, eastHallCorner);
        allRooms.put(RoomName.EASTDOOR, eastDoor);
        allRooms.put(RoomName.WESTHALL, westHall);
        allRooms.put(RoomName.WESTHALLCORNER, westHallCorner);
        allRooms.put(RoomName.WESTDOOR, westDoor);
        allRooms.put(RoomName.OFFICE, office);
        return allRooms;
    }

    private Room createRoom(RoomName roomName)
    {
        Room room = new Room(roomName);
        return room;
    }

    private void addNeighborRoom(Room currentRoom, Direction direction, Room roomToAdd)
    {

        if (currentRoom.getNeighborRooms() == null) {
            Map<Direction, Room> neighborMap = new HashMap<>();
            neighborMap.put(direction, roomToAdd);
            currentRoom.setNeighborRooms(neighborMap);
        } else if (currentRoom.getNeighborRooms() != null){
            Map<Direction, Room> neighbormap2 = currentRoom.getNeighborRooms();
            neighbormap2.put(direction, roomToAdd);
            currentRoom.setNeighborRooms(neighbormap2);
        }
    }

    public Map<RoomName, Room> getAllRooms()
    {
        return allRooms;
    }
}
