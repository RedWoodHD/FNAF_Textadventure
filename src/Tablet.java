import Game.object.Camera;

public class Tablet {
    private Camera selectedCamera;

    public Camera getSelectedCamera() {
        return selectedCamera;
    }

    public Tablet setSelectedCamera(Camera selectedCamera) {
        this.selectedCamera = selectedCamera;
        return this;
    }
}
