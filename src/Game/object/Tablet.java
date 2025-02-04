package Game.object;

import java.util.List;

/**
 * Diese Klasse representiert das Tablet damit der {@link Player} auf die {@link Camera}'s zugreifen kann. <br>
 * Das {@link Tablet} hat eine {@link Camera} auf die es zugreift.
 */
public class Tablet
{
    private Camera whatCameraDoILookAt;

    public Camera getWhatCameraDoILookAt()
    {
        return whatCameraDoILookAt;
    }

    public Tablet setWhatCameraDoILookAt(Camera whatCameraDoILookAt)
    {
        this.whatCameraDoILookAt = whatCameraDoILookAt;
        return this;
    }
}
