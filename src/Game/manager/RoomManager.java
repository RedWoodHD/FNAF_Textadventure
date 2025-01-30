package Game.manager;

import Game.factor.RoomName;
import Game.object.Room;

import java.util.Map;

public class RoomManager
{
    private final Map<RoomName, Room> allRoomsMap;

    public RoomManager(Map<RoomName, Room> allRoomsMap)
    {
        this.allRoomsMap = allRoomsMap;
    }
}
