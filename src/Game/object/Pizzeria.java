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
    /**Diese Methode liefert einen schnelleren Zugriff auf {@link Enemy}'s.
     * Sie nimmt den {@link EnemyName} des gewünschten {@link Enemy}'s und gibt diesen zurück.
     * @param enemyName dieser Parameter bestimmt welcher {@link Enemy} zurückgeliefert wird.
     * @return gibt einen {@link Enemy} zurück.
     */
    public Enemy getEnemy (EnemyName enemyName){
        return enemyMap.get(enemyName);
    }

    /**
     * Diese Methode liefert einen schnelleren Zugriff, auf den {@link Room} in dem sich der {@link Enemy} befindet.<br>
     * Sie nimmt den {@link EnemyName} des gewünschten {@link Enemy}'s und gibt dessen {@link Room} zurück.<br>
     * @param enemyName dieser Parameter bestimmt von welchem {@link Enemy} der {@link Enemy#whereAmI} {@link Room} zurückgeliefert werden soll.
     * @return gibt den {@link Enemy#whereAmI} {@link Room} zurück.
     */
    public Room getEnemyRoom (EnemyName enemyName){
        return enemyMap.get(enemyName).getWhereAmI();
    }

    /**
     * Diese Methode liefert einen schnelleren Zugriff auf alle {@link Room}'s der {@link Pizzeria}<br>
     *Sie nimmt den {@link RoomName} des gewünschten {@link Room}'s und gibt diesen {@link Room} zurück.<br>
     * @param roomName dieser Parameter bestimmt welcher {@link Room} aus der {@link #roomMap} zurückgeliefert werden soll.
     * @return gibt den Value ({@link Room}) aus der {@link #roomMap} mit dem Key {@link RoomName} zurück.
     */
    public Room getRoom (RoomName roomName){
        return roomMap.get(roomName);
    }

    /**
     * Diese Methode liefert einen schnelleren Zugriff auf den {@link EnemyName} von den gewünschten {@link Enemy}'s<br>
     * Sie nimmt den {@link EnemyName} des gewünschten {@link Enemy}'s und gibt diesen {@link EnemyName} zurück.<br>
     * @param enemy dieser Parameter bestimmt von welchem {@link Enemy} der {@link EnemyName} zurückgeliefert werden soll.
     * @return gibt den {@link EnemyName} vom
     */

    public EnemyName getEnemyName(Enemy enemy){
        return enemy.getName();
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
