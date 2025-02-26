package Game.object;

import Game.factor.Direction;
import Game.factor.EnemyName;
import Game.factor.RoomName;

import java.util.HashMap;
import java.util.Map;

/**
 * Diese Klasse, repräsentiert einen Raum, um die Karte des Spiels in Räume aufzuteilen.
 */
public class Room
{
    private RoomName roomName;
    private Map<Direction, Room> neighborRooms;
    private Camera camera;
    private final Map<EnemyName, Enemy> enemiesContained = new HashMap<>();
    private boolean doorClosed;
    private int pirateCoveOpeningStage = 1;

    public Room(RoomName roomName)

    {
        this.roomName = roomName;
    }

    public Map<EnemyName, Enemy> getEnemiesContained()
    {
        return enemiesContained;
    }


    public int getPirateCoveOpeningStage()
    {
        return pirateCoveOpeningStage;
    }

    public Room setPirateCoveOpeningStage(int pirateCoveOpeningStage)
    {
        this.pirateCoveOpeningStage = pirateCoveOpeningStage;
        return this;
    }

    public Room increasePirateCoveOpeningStage()
    {
        this.pirateCoveOpeningStage++;
        return this;
    }

    public RoomName getRoomName()
    {
        return roomName;
    }


    public Map<Direction, Room> getNeighborRooms()
    {
        return neighborRooms;
    }

    public Room setNeighborRooms(Map<Direction, Room> neighborRooms)
    {
        this.neighborRooms = neighborRooms;
        return this;
    }

    public Camera getCamera()
    {
        return camera;
    }

    public Room setCamera(Camera camera)
    {
        this.camera = camera;
        return this;
    }

    public boolean isDoorClosed()
    {
        return doorClosed;
    }

    public Room setDoorClosed(boolean doorClosed)
    {
        this.doorClosed = doorClosed;
        return this;
    }

    /**
     * @param direction
     *
     * @return
     */
    public Room getNextRoom(Direction direction)
    {
        return getNeighborRooms().get(direction);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Room room)
        {
            return room.getRoomName() == this.getRoomName();
        }
        else
        {
            return false;
        }
    }
}