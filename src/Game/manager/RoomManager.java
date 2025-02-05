package Game.manager;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Room;

import java.util.Map;

public class RoomManager
{
    private final Map<RoomName, Room> allRoomsMap;
    private EnemyManager enemyManager;

    public RoomManager(Map<RoomName, Room> allRoomsMap)
    {
        this.allRoomsMap = allRoomsMap;
    }

    public void increaseStage(RoomName roomName){
        Room roomToIncrease = allRoomsMap.get(roomName);
        roomToIncrease.increasePirateCoveOpeningStage();
    }
    public void resetStage(RoomName roomName){
        Room roomToReset = allRoomsMap.get(roomName);
        roomToReset.setPirateCoveOpeningStage(1);
    }
    public void addEnemyToRoom(EnemyName enemyName, RoomName roomName)
    {
        Room room = allRoomsMap.get(roomName);
        Enemy enemyToBeAdded = enemyManager.getEnemy(enemyName);
        Map<EnemyName, Enemy> enemyMap = room.getEnemiesContained();
        enemyMap.put(enemyName, enemyToBeAdded);
        enemyToBeAdded.setWhereAmI(room);
    }

    public void removeEnemyFromRoom(EnemyName enemyName, RoomName roomName)
    {
        if (allRoomsMap.get(roomName).getEnemiesContained() != null)
        {
            Room room = allRoomsMap.get(roomName);
            Map<EnemyName, Enemy> enemyMap = room.getEnemiesContained();
            enemyMap.remove(enemyName);
            Enemy enemy = enemyManager.getEnemy(enemyName);
            enemy.setWhereAmI(null);
        }
    }

    public void moveEnemy(EnemyName enemyName, RoomName newRoom)
    {
        Enemy enemy = enemyManager.getEnemy(enemyName);
        Room whereAmI = enemy.getWhereAmI();
        RoomName roomName = whereAmI.getRoomName();
        removeEnemyFromRoom(enemyName, roomName);
        addEnemyToRoom(enemyName, newRoom);
    }

    public RoomManager setEnemyManager(EnemyManager enemyManager)
    {
        this.enemyManager = enemyManager;
        return this;
    }
}
