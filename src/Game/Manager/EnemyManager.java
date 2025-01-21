package Game.Manager;

import Game.Factor.EnemyName;
import Game.Factor.RoomName;
import Game.Object.Enemy;
import Game.Object.Room;

import java.util.HashMap;
import java.util.Map;

public class EnemyManager
{
    Map<EnemyName, Enemy> enemyMap = createEnemyMap();

    private Map<EnemyName, Enemy> createEnemyMap ()
    {
        Map<EnemyName, Enemy> allEnemies = new HashMap<>();
        RoomManager roomManager = new RoomManager();
        Map<EnemyName, Enemy> allEnemiesMap = new HashMap<>();
        allEnemiesMap.put(EnemyName.FREDDY, createEnemy(EnemyName.FREDDY, roomManager.allRooms.get(RoomName.SHOWSTAGE), 5));
        allEnemiesMap.put(EnemyName.BONNIE, createEnemy(EnemyName.BONNIE, roomManager.allRooms.get(RoomName.SHOWSTAGE), 3));
        allEnemiesMap.put(EnemyName.CHICA, createEnemy(EnemyName.CHICA, roomManager.allRooms.get(RoomName.SHOWSTAGE), 4));
        allEnemiesMap.put(EnemyName.FOXXY, createEnemy(EnemyName.FOXXY, roomManager.allRooms.get(RoomName.PIRATECOVE), 7));

        return allEnemiesMap;
    }
    private Enemy createEnemy(EnemyName name, Room startingPosition, int level){
        return new Enemy(name,startingPosition,level);
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
