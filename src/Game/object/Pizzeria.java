package Game.object;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import java.util.Map;

public class Pizzeria
{
    private Integer energyLeft;
    private Map<RoomName, Room> roomMap;
    private Map<EnemyName,Enemy> enemyMap;

    public Pizzeria(Integer energyLeft, Map<RoomName, Room> roomMap, Map<EnemyName, Enemy> enemyMap)
    {
        this.energyLeft = energyLeft;
        this.roomMap = roomMap;
        this.enemyMap = enemyMap;
    }
    public Pizzeria buildPizzeria(Integer energyLeft, Map<RoomName, Room> roomMap, Map<EnemyName, Enemy> enemyMap){
        return new Pizzeria(energyLeft, roomMap, enemyMap);
}

    public Map<RoomName, Room> getRoomMap()
    {
        return roomMap;
    }

    public Pizzeria setRoomMap(Map<RoomName, Room> roomMap)
    {
        this.roomMap = roomMap;
        return this;
    }

    public Map<EnemyName, Enemy> getEnemyMap()
    {
        return enemyMap;
    }

    public Pizzeria setEnemyMap(Map<EnemyName, Enemy> enemyMap)
    {
        this.enemyMap = enemyMap;
        return this;
    }

    public Integer getEnergyLeft() {
        return energyLeft;
    }

    public Pizzeria setEnergyLeft(Integer energyLeft) {
        this.energyLeft = energyLeft;
        return this;
    }


}
