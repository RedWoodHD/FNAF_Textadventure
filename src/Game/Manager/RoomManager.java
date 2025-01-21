package Game.Manager;


import Game.Factor.Direction;
import Game.Factor.RoomName;
import Game.Object.Room;
import java.util.HashMap;
import java.util.Map;

public class RoomManager
{
    Map<RoomName, Room> allRooms = createAllRooms();


    private  Map<RoomName, Room> createAllRooms(){
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
        showStage = addNeighborRoom(showStage,Direction.SOUTH1,diningArea);
        showStage = addNeighborRoom(showStage,Direction.WEST1,backstage);
        showStage = addNeighborRoom(showStage,Direction.EAST,restrooms);

        diningArea = addNeighborRoom(diningArea,Direction.NORTH,showStage);
        diningArea = addNeighborRoom(diningArea,Direction.EAST,restrooms);
        diningArea = addNeighborRoom(diningArea,Direction.SOUTH1,westHall);
        diningArea = addNeighborRoom(diningArea,Direction.SOUTH2,eastHall);
        diningArea = addNeighborRoom(diningArea,Direction.SOUTH3,kitchen);
        diningArea = addNeighborRoom(diningArea,Direction.WEST1,backstage);
        diningArea = addNeighborRoom(diningArea,Direction.WEST2,pirateCove);

        backstage = addNeighborRoom(backstage,Direction.EAST, diningArea);
        backstage = addNeighborRoom(backstage,Direction.SOUTH1, westHall);

        pirateCove = addNeighborRoom(pirateCove, Direction.EAST, diningArea);

        restrooms = addNeighborRoom(restrooms, Direction.WEST1, diningArea);
        restrooms = addNeighborRoom(restrooms, Direction.SOUTH1, kitchen);

        kitchen = addNeighborRoom(kitchen, Direction.NORTH, diningArea);
        kitchen = addNeighborRoom(kitchen, Direction.WEST1, eastHall);

        eastHall = addNeighborRoom(eastHall, Direction.NORTH, diningArea);
        eastHall = addNeighborRoom(eastHall, Direction.SOUTH1, eastHallCorner);

        eastHallCorner = addNeighborRoom(eastHallCorner,Direction.NORTH, eastHall);
        eastHallCorner = addNeighborRoom(eastHallCorner,Direction.WEST1, eastDoor);

        eastDoor = addNeighborRoom(eastDoor, Direction.WEST1, office);
        eastDoor = addNeighborRoom(eastDoor, Direction.EAST, eastHallCorner);

        westHall = addNeighborRoom(westHall, Direction.NORTH, diningArea);
        westHall = addNeighborRoom(westHall, Direction.SOUTH1, westHallCorner);
        westHall = addNeighborRoom(westHall, Direction.WEST1, supplyCloset);

        westHallCorner = addNeighborRoom(westHallCorner, Direction.NORTH, supplyCloset);
        westHallCorner = addNeighborRoom(westHallCorner, Direction.EAST, westDoor);

        westDoor = addNeighborRoom(westDoor, Direction.EAST, office);
        westDoor = addNeighborRoom(westDoor, Direction.WEST1, westHallCorner);

        supplyCloset = addNeighborRoom(supplyCloset, Direction.EAST, westHall);

        office = addNeighborRoom(office, Direction.EAST, eastHallCorner);
        office = addNeighborRoom(office, Direction.WEST1, westHallCorner);





//        Füge der Map jeden Raum hinzu.
        allRooms.put(RoomName.SHOWSTAGE,showStage);
        allRooms.put(RoomName.DININGAREA,diningArea);
        allRooms.put(RoomName.RESTROOMS,restrooms);
        allRooms.put(RoomName.BACKSTAGE,backstage);
        allRooms.put(RoomName.PIRATECOVE,pirateCove);
        allRooms.put(RoomName.KITCHEN,kitchen);
        allRooms.put(RoomName.SUPPLYCLOSET,supplyCloset);
        allRooms.put(RoomName.EASTHALL,eastHall);
        allRooms.put(RoomName.EASTHALLCORNER,eastHallCorner);
        allRooms.put(RoomName.EASTDOOR,eastDoor);
        allRooms.put(RoomName.WESTHALL,westHall);
        allRooms.put(RoomName.WESTHALLCORNER,westHallCorner);
        allRooms.put(RoomName.WESTDOOR,westDoor);
        allRooms.put(RoomName.OFFICE,office);
        return allRooms;
    }
    private static Room createRoom(RoomName roomName)
    {
        Room room = new Room(roomName);
        return room;
    }
    private static Room addNeighborRoom(Room currentRoom, Direction direction, Room roomToAdd){

        if (currentRoom.getNeighborRooms().isEmpty()){
            Map<Direction, Room> neighborMap = new HashMap<>();
            neighborMap.put(direction, roomToAdd);
            currentRoom.setNeighborRooms(neighborMap);
            return currentRoom;
        } else {
            Map<Direction, Room> neighbormap = currentRoom.getNeighborRooms();
            neighbormap.put(direction,roomToAdd);
            currentRoom.setNeighborRooms(neighbormap);
            return currentRoom;
        }
    }
}
