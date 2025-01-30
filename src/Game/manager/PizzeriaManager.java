package Game.manager;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.factory.RoomFactory;
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
public class PizzeriaManager
{
    private Map<RoomName, Room> pizzeriaAllRooms;
    private Map<EnemyName, Enemy> pizzeriaAllEnemies;
    private Map<CameraName, Camera> pizzeriaAllCameras;
    private Pizzeria pizzeria;

    public PizzeriaManager()
    {
        RoomFactory roomManager = new RoomFactory();
        EnemyManager enemyManager = new EnemyManager(roomManager);
//        CameraManager cameraManager = new CameraManager(roomManager.getAllRooms(),);
        pizzeriaAllRooms = roomManager.getAllRooms();
        pizzeriaAllEnemies = enemyManager.getEnemyMap();
//        pizzeriaAllCameras = cameraManager.getAllCameras();
        pizzeria = new Pizzeria(100, pizzeriaAllRooms, pizzeriaAllEnemies, pizzeriaAllCameras);
    }

//    public CameraManager getCameraManager()
//    {
//        return cameraManager;
//    }
//
//    public PizzeriaManager setCameraManager(CameraManager cameraManager)
//    {
//        this.cameraManager = cameraManager;
//        return this;
//    }

    public Map<CameraName, Camera> getPizzeriaAllCameras()
    {
        return pizzeriaAllCameras;
    }

    public PizzeriaManager setPizzeriaAllCameras(Map<CameraName, Camera> pizzeriaAllCameras)
    {
        this.pizzeriaAllCameras = pizzeriaAllCameras;
        return this;
    }

//    public RoomManager getRoomManager()
//    {
//        return roomManager;
//    }
//
//    public PizzeriaManager setRoomManager(RoomManager roomManager)
//    {
//        this.roomManager = roomManager;
//        return this;
//    }

    public Map<RoomName, Room> getPizzeriaAllRooms()
    {
        return pizzeriaAllRooms;
    }

    public PizzeriaManager setPizzeriaAllRooms(Map<RoomName, Room> pizzeriaAllRooms)
    {
        this.pizzeriaAllRooms = pizzeriaAllRooms;
        return this;
    }

//    public EnemyManager getEnemyManager()
//    {
//        return enemyManager;
//    }

//    public PizzeriaManager setEnemyManager(EnemyManager enemyManager)
//    {
//        this.enemyManager = enemyManager;
//        return this;
//    }

    public Map<EnemyName, Enemy> getPizzeriaAllEnemies()
    {
        return pizzeriaAllEnemies;
    }

    public PizzeriaManager setPizzeriaAllEnemies(Map<EnemyName, Enemy> pizzeriaAllEnemies)
    {
        this.pizzeriaAllEnemies = pizzeriaAllEnemies;
        return this;
    }

    public Pizzeria getPizzeria()
    {
        return pizzeria;
    }

    public PizzeriaManager setPizzeria(Pizzeria pizzeria)
    {
        this.pizzeria = pizzeria;
        return this;
    }
}

