package Game.manager;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.factory.RoomFactory;
import Game.object.Enemy;
import Game.object.Room;

import java.util.HashMap;
import java.util.Map;

/**
 * Verwaltet alle{@link Enemy}'s<br>
 * Verwalten heißt:<br>
 * Erstellen
 */

public class EnemyManager
{
    private Map<EnemyName, Enemy> enemyMap;


    public EnemyManager(Map<EnemyName, Enemy> enemyMap)
    {
        this.enemyMap = enemyMap;
    }
}
