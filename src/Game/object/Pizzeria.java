package Game.object;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import java.util.Map;

public class Pizzeria
{
    private Integer energyLeft;
    private  Map<RoomName, Room> roomMap;
    private  Map<EnemyName,Enemy> enemyMap;
    private final Map<CameraName,Camera> cameraMap;


    public Pizzeria(Integer energyLeft, Map<RoomName, Room> roomMap, Map<EnemyName, Enemy> enemyMap, Map<CameraName, Camera> cameraMap)
    {
        this.energyLeft = energyLeft;
        this.roomMap = roomMap;
        this.enemyMap = enemyMap;
        this.cameraMap = cameraMap;
    }
    /**Diese Methode liefert einen schnelleren Zugriff auf {@link Enemy}'s.
     * Sie nimmt den {@link EnemyName} des gewünschten {@link Enemy}'s und gibt diesen zurück.
     * @param enemyName dieser Parameter bestimmt welcher {@link Enemy} zurückgeliefert wird.
     * @return gibt einen {@link Enemy} zurück.
     */
    public Enemy getEnemy (EnemyName enemyName){
        return enemyMap.get(enemyName);
    }

    public Map<RoomName, Room> getRoomMap()
    {
        return roomMap;
    }
    public Map<EnemyName, Enemy> getEnemyMap()
    {
        return enemyMap;
    }
    public Integer getEnergyLeft() {
        return energyLeft;
    }

    public Pizzeria setEnergyLeft(Integer energyLeft) {
        this.energyLeft = energyLeft;
        return this;
    }

    public Map<CameraName, Camera> getCameraMap()
    {
        return cameraMap;
    }
}
