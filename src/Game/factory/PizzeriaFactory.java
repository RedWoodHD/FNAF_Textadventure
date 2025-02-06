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
 * Diese Klasse repräsentiert eine Pizzeria. Sie verwaltet alle nötigen Objekte für die Pizzeria.<br>
 * Diese Klasse soll es vereinfachen die {@link Pizzeria} zu nutzen.<br>
 * Sie hat einen {@link RoomFactory} fürs Verwalten der {@link Room}'s.<br>
 * Sie hat einen {@link EnemyManager} fürs Verwalten der {@link Enemy}'s.<br>
 * Sie hat eine {@link Map} fürs Speichern aller {@link Room}'s.<br>
 * Sie hat eine {@link Map} fürs Speichern aller {@link Enemy}'s.<br>
 * Sie hat eine {@link Pizzeria} mit den notwendigen Bedingungen fürs Erstellen.<br>
 * {@link int}
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

