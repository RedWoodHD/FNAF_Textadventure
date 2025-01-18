package Game.Manager;


import Game.Factor.Direction;
import Game.Factor.RoomName;
import Game.Object.Room;
import java.util.HashMap;
import java.util.Map;

public class RoomManager
{
    public Map<RoomName, Room> getAllRooms(){
        Map<RoomName, Room> allRooms = new HashMap<>();

//        Erstelle jeden Raum ohne Nachbarräume.
        Room showStage = createRoom(RoomName.SHOWSTAGE);
        Room diningArea = createRoom(RoomName.DININGAREA);
        Room restrooms = createRoom(RoomName.RESTROOMS);
        Room backstage = createRoom(RoomName.BACKSTAGE);
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
        System.out.println(showStage.getNeighborRooms().get(Direction.SOUTH1).getRoomName());
        showStage = addNeighborRoom(showStage,Direction.WEST1,backstage);
        System.out.println(showStage.getNeighborRooms().get(Direction.WEST1).getRoomName());
        showStage = addNeighborRoom(showStage,Direction.EAST,restrooms);
        System.out.println(showStage.getNeighborRooms().get(Direction.EAST).getRoomName());





//        Füge der Map jeden Raum hinzu.
        allRooms.put(RoomName.SHOWSTAGE,showStage);
        allRooms.put(RoomName.DININGAREA,diningArea);
        allRooms.put(RoomName.RESTROOMS,restrooms);
        allRooms.put(RoomName.BACKSTAGE,backstage);
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
    private Room createRoom(RoomName roomName)
    {
        Room room = new Room(roomName);
        return room;
    }
    private Room addNeighborRoom (Room currentRoom,Direction direction ,Room roomToAdd){

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
