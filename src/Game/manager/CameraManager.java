package Game.manager;

import Game.factor.CameraName;
import Game.factor.RoomName;
import Game.object.Camera;
import Game.object.Pizzeria;
import Game.object.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CameraManager
{
    private final Map<RoomName, Room> allRooms;
    private final Map<CameraName, Camera> allCameras;


    public CameraManager(Map<RoomName, Room> allRooms,Map<CameraName, Camera> allCameras)
    {
        this.allRooms = allRooms;
        allCameras = ;
    }



    public Map<CameraName, Camera> getAllCameras()
    {
        return allCameras;
    }
}
