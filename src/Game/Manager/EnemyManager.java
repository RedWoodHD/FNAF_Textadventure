package Game.Manager;

import Game.Factor.EnemyName;
import Game.Factor.RoomName;
import Game.Object.Enemy;
import Game.Object.Room;

import java.util.HashMap;
import java.util.Map;

public class EnemyManager
{
//    public Map<EnemyName, Enemy> getAllEnemies(Map<RoomName, Room> allRooms){
//
//        Map<EnemyName, Enemy> allEnemies = new HashMap<>();
//        allEnemies.put(EnemyName.FREDDY,createEnemy(EnemyName.FREDDY,allRooms.get(),)
//
//    }

    private Enemy createEnemy(EnemyName name, Room startingPosition, int level){
        return new Enemy(name,startingPosition,level);
    }


}
