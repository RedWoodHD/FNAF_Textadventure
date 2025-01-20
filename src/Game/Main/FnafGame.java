package Game.Main;

import Game.Factor.RoomName;
import Game.Manager.RoomManager;
import Game.Object.Room;

import java.util.Map;

public class FnafGame
{

    public static void runGame()
    {
        Map<RoomName, Room> allRooms;
        allRooms = RoomManager.getAllRooms();
    }
}
