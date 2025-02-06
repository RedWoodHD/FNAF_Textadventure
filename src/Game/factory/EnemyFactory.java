package Game.factory;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Room;

import java.util.HashMap;
import java.util.Map;

public class EnemyFactory
{
    private final Map<RoomName, Room> roomMap;
    private final Map<EnemyName , Enemy> allEnemiesMap;

    public EnemyFactory(Map<RoomName, Room> roomMap)
    {
        this.roomMap = roomMap;
        this.allEnemiesMap = createEnemyMap();
    }

    /**
     * Die Methode erstellt eine HashMap mit allen Gegner und ihren <br> start Bedingungen [{@link EnemyName}, Start {@link Room}, Schwierigkeits {@link Enemy#level}]
     *
     * @return Die HashMap mit allen erstellten Gegnern.
     */
    private Map<EnemyName, Enemy> createEnemyMap()
    {

        Map<EnemyName, Enemy> allEnemiesMap = new HashMap<>();
        allEnemiesMap.put(EnemyName.FREDDY, createEnemy(EnemyName.FREDDY, roomMap.get(RoomName.SHOWSTAGE), 7));
        allEnemiesMap.put(EnemyName.BONNIE, createEnemy(EnemyName.BONNIE, roomMap.get(RoomName.SHOWSTAGE), 5));
        allEnemiesMap.put(EnemyName.CHICA, createEnemy(EnemyName.CHICA, roomMap.get(RoomName.SHOWSTAGE), 6));
        allEnemiesMap.put(EnemyName.FOXXY, createEnemy(EnemyName.FOXXY, roomMap.get(RoomName.PIRATECOVE), 0));

        return allEnemiesMap;
    }

    private Enemy createEnemy(EnemyName name, Room startingPosition, int level)
    {
        return new Enemy(name, startingPosition, level);
    }

    public Map<EnemyName, Enemy> getAllEnemiesMap()
    {
        return allEnemiesMap;
    }
}
