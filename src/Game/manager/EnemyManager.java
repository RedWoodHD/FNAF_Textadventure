package Game.manager;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * Verwaltet alle{@link Enemy}'s<br>
 * Verwalten heißt:<br>
 * Erstellen {@link #createEnemy(EnemyName, Room, int)}
 */

public class EnemyManager
{
    private Map<EnemyName, Enemy> enemyMap = createEnemyMap();


    /**
     * Die Methode erstellt eine HashMap mit allen Gegner und ihren <br> start Bedingungen [{@link EnemyName}, Start {@link Room}, Schwierigkeits {@link Enemy#level}]
     *
     * @return Die HashMap mit allen erstellten Gegnern.
     */
    private Map<EnemyName, Enemy> createEnemyMap()
    {
        RoomManager roomManager = new RoomManager();
        Map<EnemyName, Enemy> allEnemiesMap = new HashMap<>();
        allEnemiesMap.put(EnemyName.FREDDY, createEnemy(EnemyName.FREDDY, roomManager.getAllRooms().get(RoomName.SHOWSTAGE), 5));
        allEnemiesMap.put(EnemyName.BONNIE, createEnemy(EnemyName.BONNIE, roomManager.getAllRooms().get(RoomName.SHOWSTAGE), 3));
        allEnemiesMap.put(EnemyName.CHICA, createEnemy(EnemyName.CHICA, roomManager.getAllRooms().get(RoomName.SHOWSTAGE), 4));
        allEnemiesMap.put(EnemyName.FOXXY, createEnemy(EnemyName.FOXXY, roomManager.getAllRooms().get(RoomName.PIRATECOVE), 7));

        return allEnemiesMap;
    }

    private Enemy createEnemy(EnemyName name, Room startingPosition, int level)
    {
        return new Enemy(name, startingPosition, level);
    }

    public Map<EnemyName, Enemy> getEnemyMap()
    {
        return enemyMap;
    }

    public EnemyManager setEnemyMap(Map<EnemyName, Enemy> enemyMap)
    {
        this.enemyMap = enemyMap;
        return this;
    }
}
