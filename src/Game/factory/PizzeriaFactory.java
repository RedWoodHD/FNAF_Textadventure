package Game.factory;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.manager.EnemyManager;
import Game.object.Camera;
import Game.object.Enemy;
import Game.object.Pizzeria;
import Game.object.Room;

import java.util.Map;

/**
 * Diese Klasse erstellt eine {@link Pizzeria}, mit allen nötigen Objekten.<br>
 * @author EGA
 */
public class PizzeriaFactory
{
    private final Pizzeria pizzeria;

    public PizzeriaFactory()
    {
        RoomFactory roomFactory = new RoomFactory();
        CameraFactory cameraFactory = new CameraFactory(roomFactory.getAllRooms());
        EnemyFactory enemyFactory = new EnemyFactory(roomFactory.getAllRooms());
        pizzeria = new Pizzeria(102, roomFactory.getAllRooms(), enemyFactory.getAllEnemiesMap(), cameraFactory.getAllCameras());
    }

    public Pizzeria getPizzeria()
    {
        return pizzeria;
    }
}

