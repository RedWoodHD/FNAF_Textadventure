package Game.object;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.manager.EnemyManager;

import java.util.List;
import java.util.Map;

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

    public void useCamera(Pizzeria pizzeria, EnemyManager enemyManager)
    {
        if (pizzeria.getEnergyLeft() > 0)
        {
            Map<EnemyName, Enemy> whatDoISee = getWhatEnemyDoISee();
            Enemy freddy = enemyManager.getEnemy(FREDDY);
            if (whatDoISee == null)
            {
                System.out.println("You are seeing just an empty Room :)");
                return;
            }

            if (whatDoISee.get(FREDDY) != null)
            {
                System.out.println("You can see " + magenta + FREDDY + reset + " in the Corner of the Room");
                enemyManager.getEnemy(FREDDY).setHaveIBeenObserved(true);
            }
            if (whatDoISee.get(BONNIE) != null)
            {
                System.out.println("You can see " + blue + BONNIE + reset + " in the Corner of the Room");
                enemyManager.getEnemy(BONNIE).setHaveIBeenObserved(true);
            }
            if (whatDoISee.get(CHICA) != null)
            {
                System.out.println("You can see " + yellow + CHICA + reset + " in the Corner of the Room");
                enemyManager.getEnemy(CHICA).setHaveIBeenObserved(true);
            }
            else if (whatDoISee.get(FOXXY) != null)
            {
                System.out.println("You can see " + red + FOXXY + reset + " in Stage: " + pizzeria.getEnemy(FOXXY).getWhereAmI().getPirateCoveOpeningStage());
                enemyManager.getEnemy(FOXXY).setHaveIBeenObserved(true);
            }
            else
            {
                System.out.println("You can't see a single Animatronic :D");
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

    public Map<EnemyName, Enemy> getWhatEnemyDoISee()
    {
        return whatRoomDoILookAt.getEnemiesContained();
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
