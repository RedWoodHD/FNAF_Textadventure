package Game.manager;

import Game.factor.CameraName;
import Game.object.Camera;
import Game.object.Pizzeria;
import Game.object.Tablet;

import java.util.Map;

/**
 * Diese Klasse soll die {@link Camera Kamera}'s verwalten.<br>
 * Sie bietet die nötigen Methoden, um die {@link Camera Camera}'s für verschiedene Zwecke zu nutzen:<br>
 * -{@link #printCameraAccess()} <br>
 * -{@link #useChosenCamera(int, Pizzeria, EnemyManager)} <br>
 *  Die Klasse kann auch das {@link Tablet} reseten. -> {@link #resetTabletsCameraAccess()}.
 * @author EGA
 */
public class CameraManager
{
    private final Map<CameraName, Camera> allCameras;
    private final Tablet tablet;


    public CameraManager( Map<CameraName, Camera> allCameras, Tablet tablet)
    {
        this.allCameras = allCameras;
        this.tablet = tablet;
    }

    /**
     * Diese Methode gibt auf der Console aus, welche {@link Camera kamera}'s wir benutzen können.<br>
     * Reine Ausgabe, basierend auf der {@link Camera Kamera} die wir als letztes genutzt haben.<br>
     * @author EGA
     */
    public void printCameraAccess()
    {
        Camera currentCamera = tablet.getWhatCameraDoILookAt();
        System.out.println("You have Access to the following Cameras");
        int i = 1;
        if (currentCamera != null)
        {
            for (Camera connectedCamera : currentCamera.getConnectedCameras())
            {
                System.out.print(i + "." + connectedCamera.getCameraName() + "\t");
                i++;
            }
        }
        else
        {
            for (Camera connectedCamera : allCameras.get(CameraName.CAM1A).getConnectedCameras())
            {
                System.out.print(i + "." + connectedCamera.getCameraName() + "\t");
                i++;
            }
        }
        System.out.println();
    }

    /**
     * Diese Methode verarbeitet die {@link Integer Benutzereingabe}.
     * @param userInput Die {@link Integer Zahl} die der Benutzer eingegeben hat.
     * @param pizzeria Die {@link Pizzeria} in der wir uns befinden.
     * @param enemyManager Der {@link EnemyManager} den wir nutzen, um auf die {@link Game.object.Enemy Gegner} zuzugreifen.
     * @author EGA
     */

    public void useChosenCamera(int userInput, Pizzeria pizzeria, EnemyManager enemyManager)
    {
        Camera currentCamera = tablet.getWhatCameraDoILookAt();
        try
        {
            switch (userInput)
            {
                case 1:
                    Camera cam = currentCamera.getConnectedCameras().get(0);
                    cam.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam);
                    return;
                case 2:
                    Camera cam1 = currentCamera.getConnectedCameras().get(1);
                    cam1.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam1);
                    return;
                case 3:
                    Camera cam2 = currentCamera.getConnectedCameras().get(2);
                    cam2.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam2);
                    return;
                case 4:
                    Camera cam3 = currentCamera.getConnectedCameras().get(3);
                    cam3.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam3);
                    return;
                case 5:
                    Camera cam4 = currentCamera.getConnectedCameras().get(4);
                    cam4.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam4);
                    return;
                case 6:
                    Camera cam5 = currentCamera.getConnectedCameras().get(5);
                    cam5.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam5);
                    return;
                case 7:
                    Camera cam6 = currentCamera.getConnectedCameras().get(6);
                    cam6.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam6);
                    return;
                case 8:
                    Camera cam7 = currentCamera.getConnectedCameras().get(7);
                    cam7.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam7);
                    return;
                case 9:
                    Camera cam8 = currentCamera.getConnectedCameras().get(8);
                    cam8.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam8);
                    return;
                case 10:
                    Camera cam9 = currentCamera.getConnectedCameras().get(9);
                    cam9.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam9);
                    return;
                case 11:
                    Camera cam10 = currentCamera.getConnectedCameras().get(10);
                    cam10.useCamera(pizzeria, enemyManager);
                    tablet.setWhatCameraDoILookAt(cam10);
                    return;
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Wrong Input! Use shown Numbers only!");
        }
    }

    /**
     * Diese Methode setzt die{@link Camera Kamera} auf die das {@link Tablet} zugriff hat,<br>
     * wieder auf die {@link Camera Kamera} -> {@link CameraName#FREECAM}.
     */
    public void resetTabletsCameraAccess()
    {
        tablet.setWhatCameraDoILookAt(allCameras.get(CameraName.FREECAM));
    }

    public Tablet getTablet()
    {
        return tablet;
    }
    public Camera getCamera(CameraName cameraName){
        return allCameras.get(cameraName);
    }
}
