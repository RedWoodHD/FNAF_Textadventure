package Game.object;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.manager.PizzeriaManager;
import Game.text_message.Color;
import Game.text_message.GameInformation;

import java.util.List;

import static Game.factor.EnemyName.*;
import static Game.text_message.Color.*;

public class Camera
{
    private List<Camera> connectedCameras;
    private CameraName cameraName;
    private Room whatRoomDoILookAt;
    private boolean isPlayerLookingAtIt;

    public Camera(CameraName cameraName)
    {
        this.cameraName = cameraName;
    }

    public void useCamera(Pizzeria pizzeria)
    {
        if (pizzeria.getEnergyLeft() > 0)
        {
            Enemy whatDoISee = getWhatEnemyDoISee();
            switch (whatDoISee.getName())
            {
                case FREDDY:
                    System.out.println("You can see " + magenta + FREDDY + reset + " in the Corner of the Room");
                    whatDoISee.setHaveIBeenObserved(true);
                    break;
                case BONNIE:
                    System.out.println("You can see " + blue + BONNIE + reset + " in the Corner of the Room");
                    whatDoISee.setHaveIBeenObserved(true);
                    break;
                case CHICA:
                    System.out.println("You can see " + yellow + CHICA + reset + " in the Corner of the Room");
                    whatDoISee.setHaveIBeenObserved(true);
                    break;
                case FOXXY:
                    System.out.println("You can see " + red + CHICA + reset + " in Stage: "+whatDoISee.getWhereAmI().getPirateCoveOpeningStage());
                    whatDoISee.setHaveIBeenObserved(true);
                    break;
                default:
                    System.out.println("You can't see a single Animatronic :D");
                    break;
            }
            pizzeria.setEnergyLeft(pizzeria.getEnergyLeft() - 5);
        }
        // Kann ich die überhaupt noch benutzen? Ist noch Strom da?
        // Geprinted was ich sehe.
        // Auswirkungen auf enemies (gesehen/nicht gesehen)
        // Energie wird vom Haus abgezogen.
    }

    public CameraName getCameraName()
    {
        return cameraName;
    }

    public Camera setCameraName(CameraName cameraName)
    {
        this.cameraName = cameraName;
        return this;
    }

    public Room getWhatRoomDoILookAt()
    {
        return whatRoomDoILookAt;
    }

    public Camera setWhatRoomDoILookAt(Room whatRoomDoILookAt)
    {
        this.whatRoomDoILookAt = whatRoomDoILookAt;
        return this;
    }

    public boolean isPlayerLookingAtIt()
    {
        return isPlayerLookingAtIt;
    }

    public Camera setPlayerLookingAtIt(boolean playerLookingAtIt)
    {
        isPlayerLookingAtIt = playerLookingAtIt;
        return this;
    }

    public Enemy getWhatEnemyDoISee()
    {
        return whatRoomDoILookAt.getWhatEnemyIsInsideMe();
    }

    public List<Camera> getConnectedCameras()
    {
        return connectedCameras;
    }

    public Camera setConnectedCameras(List<Camera> connectedCameras)
    {
        this.connectedCameras = connectedCameras;
        return this;
    }
}
