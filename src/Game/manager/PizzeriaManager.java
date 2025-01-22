package Game.manager;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Pizzeria;
import Game.object.Room;
import java.util.Map;

/**Diese Klasse repräsentiert eine Pizzeria. Sie verwaltet alle nötigen Objekte für die Pizzeria.
 * Diese Klasse soll es vereinfachen die {@link Pizzeria} zu nutzen.
 * Sie hat einen {@link RoomManager} fürs Verwalten der {@link Room}'s.
 * Sie hat einen {@link EnemyManager} fürs Verwalten der {@link Enemy}'s.
 * Sie hat eine {@link Map} fürs Speichern aller {@link Room}'s.
 * Sie hat eine {@link Map} fürs Speichern aller {@link Enemy}'s.
 * Sie hat eine {@link Pizzeria} mit den notwendigen Bedingungen fürs Erstellen.
 */
public class PizzeriaManager
{
    private RoomManager roomManager = new RoomManager();
    private EnemyManager enemyManager = new EnemyManager();
    private Map<RoomName, Room> pizzeriaAllRooms = roomManager.getAllRooms();
    private Map<EnemyName, Enemy> pizzeriaAllEnemies = enemyManager.getEnemyMap();
    private Pizzeria pizzeria = new Pizzeria(100, pizzeriaAllRooms, pizzeriaAllEnemies);



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

