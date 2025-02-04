package Game.manager;

import Game.factor.CameraName;
import Game.factor.RoomName;
import Game.object.Camera;
import Game.object.Pizzeria;
import Game.object.Room;
import Game.object.Tablet;

import java.util.Map;

public class CameraManager
{
    private final Map<RoomName, Room> allRooms;
    private final Map<CameraName, Camera> allCameras;
    private final Tablet tablet;


    public CameraManager(Map<RoomName, Room> allRooms, Map<CameraName, Camera> allCameras, Tablet tablet)
    {
        this.allRooms = allRooms;
        this.allCameras =allCameras;
        this.tablet = tablet;
    }

    public void printCameraAccess()
    {
        Camera currentCamera = tablet.getWhatCameraDoILookAt();
        System.out.println("You have Access to the following Cameras");
        int i = 1;
        if (currentCamera != null){
            for (Camera connectedCamera : currentCamera.getConnectedCameras())
            {
                System.out.print(i+"."+connectedCamera.getCameraName()+"\t");
                i++;
            }
        } else
        {
            for (Camera connectedCamera : allCameras.get(CameraName.CAM1A).getConnectedCameras())
            {
                System.out.print(i+"."+connectedCamera.getCameraName()+"\t");
                i++;
            }
        }
        System.out.println();
    }

    public void useChosenCamera(int userInput, Pizzeria pizzeria)
    {
        Camera currentCamera = tablet.getWhatCameraDoILookAt();

        switch (userInput){
            case 1:
                currentCamera.getConnectedCameras().get(0).useCamera(pizzeria);
                return;
            case 2:
                currentCamera.getConnectedCameras().get(1).useCamera(pizzeria);
                return;
            case 3:
                currentCamera.getConnectedCameras().get(2).useCamera(pizzeria);
                return;
            case 4:
                currentCamera.getConnectedCameras().get(3).useCamera(pizzeria);
                return;
            case 5:
                currentCamera.getConnectedCameras().get(4).useCamera(pizzeria);
                return;
            case 6:
                currentCamera.getConnectedCameras().get(5).useCamera(pizzeria);
                return;
            case 7:
                currentCamera.getConnectedCameras().get(6).useCamera(pizzeria);
                return;
            case 8:
                currentCamera.getConnectedCameras().get(7).useCamera(pizzeria);
                return;
            case 9:
                currentCamera.getConnectedCameras().get(8).useCamera(pizzeria);
                return;
            case 10:
                currentCamera.getConnectedCameras().get(9).useCamera(pizzeria);
                return;
            case 11:
                currentCamera.getConnectedCameras().get(10).useCamera(pizzeria);
                return;

        }
    }
}
