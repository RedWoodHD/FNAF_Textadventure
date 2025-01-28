package Game.object;

import Game.factor.CameraName;

import java.util.List;

public class Camera
{
    private List<Camera> connectedCameras;
    private CameraName cameraName;
    private boolean isPlayerLookingAtIt;

    public Camera(CameraName cameraName)
    {
        this.cameraName = cameraName;
    }

    public void useCamera(){
        // Kann ich die überhaupt noch benutzen? Ist noch Strom da?
        // Geprinted was ich sehe.
        // Auswirkungen auf enemies (gesehen/nicht gesehen)
        // Energie wird vom Haus abgezogen.
    }

    public Enemy getWhatEnemyDoISee(){

    }

    public List<Camera> getConnectedCameras() {
        return connectedCameras;
    }

    public Camera setConnectedCameras(List<Camera> connectedCameras) {
        this.connectedCameras = connectedCameras;
        return this;
    }
}
