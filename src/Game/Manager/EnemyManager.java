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
        Enemy freddy    = createEnemy(EnemyName.FREDDY, roomManager.allRooms.get(RoomName.SHOWSTAGE), 5);
        Enemy bonnie    = createEnemy(EnemyName.BONNIE, roomManager.allRooms.get(RoomName.SHOWSTAGE), 3);
        Enemy chica     =  createEnemy(EnemyName.CHICA, roomManager.allRooms.get(RoomName.SHOWSTAGE), 4);
        Enemy foxxy     = createEnemy(EnemyName.FOXXY, roomManager.allRooms.get(RoomName.PIRATECOVE), 7);

        allEnemiesMap.put(EnemyName.FREDDY, freddy);
        allEnemiesMap.put(EnemyName.BONNIE, bonnie);
        allEnemiesMap.put(EnemyName.CHICA, chica);
        allEnemiesMap.put(EnemyName.FOXXY, foxxy);

        return allEnemiesMap;
    }
    private Enemy createEnemy(EnemyName name, Room startingPosition, int level){
        return new Enemy(name,startingPosition,level);
    }
}
