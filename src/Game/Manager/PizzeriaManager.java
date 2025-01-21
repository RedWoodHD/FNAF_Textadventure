package Game.Manager;

import Game.Factor.RoomName;
import Game.Object.Room;
import java.util.Map;

public class PizzeriaManager
{
    RoomManager roomManager = new RoomManager();
    Map<RoomName, Room> pizzeriaAllRooms = roomManager.allRooms;

    public RoomManager getRoomManager()
    {
        return roomManager;
    }

    public PizzeriaManager setRoomManager(RoomManager roomManager)
    {
        this.roomManager = roomManager;
        return this;
    }

    public Map<RoomName, Room> getPizzeriaAllRooms()
    {
        return pizzeriaAllRooms;
    }

    public PizzeriaManager setPizzeriaAllRooms(Map<RoomName, Room> pizzeriaAllRooms)
    {
        this.pizzeriaAllRooms = pizzeriaAllRooms;
        return this;
    }
}

