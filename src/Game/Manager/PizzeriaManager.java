package Game.Manager;

import Game.Factor.EnemyName;
import Game.Factor.RoomName;
import Game.Object.Enemy;
import Game.Object.Room;
import java.util.Map;

public class PizzeriaManager
{
    RoomManager roomManager = new RoomManager();
    EnemyManager enemyManager = new EnemyManager();
    Map<RoomName, Room> pizzeriaAllRooms = roomManager.allRooms;
    Map<EnemyName, Enemy> pizzeriaAllEnemies = enemyManager.enemyMap;

    public RoomManager getRoomManager()
    {
        return roomManager;
    }

    public PizzeriaManager setRoomManager(RoomManager roomManager)
    {
        this.roomManager = roomManager;
        return this;
    }

    public Map<RoomName, Room> getPizzeriaAllRooms()
    {
        return pizzeriaAllRooms;
    }

    public PizzeriaManager setPizzeriaAllRooms(Map<RoomName, Room> pizzeriaAllRooms)
    {
        this.pizzeriaAllRooms = pizzeriaAllRooms;
        return this;
    }

    public EnemyManager getEnemyManager()
    {
        return enemyManager;
    }

    public PizzeriaManager setEnemyManager(EnemyManager enemyManager)
    {
        this.enemyManager = enemyManager;
        return this;
    }

    public Map<EnemyName, Enemy> getPizzeriaAllEnemies()
    {
        return pizzeriaAllEnemies;
    }

    public PizzeriaManager setPizzeriaAllEnemies(Map<EnemyName, Enemy> pizzeriaAllEnemies)
    {
        this.pizzeriaAllEnemies = pizzeriaAllEnemies;
        return this;
    }
}

