package Game.manager;

import Game.factor.Direction;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Pizzeria;
import Game.object.Room;

import java.util.Map;

/**
 *Diese Klasse verwaltet die {@link Room Räume} von der {@link Pizzeria}.<br>
 * Dafür stellt sie verschiedene Methoden zur Verfügung.<br>
 * Diese Klasse kennt den {@link EnemyManager} um {@link Enemy Gegner} von {@link Room Raum} zu {@link Room Raum} zu bewegen.
 * @author EGA
 */
public class RoomManager
{
    private final Map<RoomName, Room> allRoomsMap;
    private EnemyManager enemyManager;

    public RoomManager(Map<RoomName, Room> allRoomsMap)
    {
        this.allRoomsMap = allRoomsMap;
    }

    /**
     * Setze {@link Room#isDoorClosed()} von {@link Room Office}(Typ {@link RoomName#OFFICE Raum Name}) auf {@link true}.
     * @author EGA
     */
    public void closeDoors(){
        allRoomsMap.get(RoomName.OFFICE).setDoorClosed(true);
    }

    /**
     *Setze {@link Room#isDoorClosed()} von {@link Room Office}(Typ {@link RoomName#OFFICE Raum Name}) auf {@link false}.
     *@author EGA
     */
    public void openDoors(){
        allRoomsMap.get(RoomName.OFFICE).setDoorClosed(false);
    }

    /**
     * Diese Methode wird genutzt um die {@link Room#pirateCoveOpeningStage Stufe} von einem {@link Room Raum}, um 1 zu erhöhen.
     * @param roomName welcher {@link Room Raum} soll erhöht werden.
     * @author EGA
     */
    public void increaseStage(RoomName roomName){
        Room roomToIncrease = allRoomsMap.get(roomName);
        roomToIncrease.increasePirateCoveOpeningStage();
    }

    /**
     * Diese Methode wird genutzt um die {@link Room#pirateCoveOpeningStage Stufe} von einem {@link Room Raum}, auf 1 zurückzusetzen.
     * @param roomName welcher {@link Room Raum} soll zurückgesetzt werden.
     * @author EGA
     */
    public void resetStage(RoomName roomName){
        Room roomToReset = allRoomsMap.get(roomName);
        roomToReset.setPirateCoveOpeningStage(1);
    }
    /**
     *Diese Methode nimmt einen {@link EnemyName Gegner Namen} und einen {@link RoomName Raum Namen}, <br>
     * um einen {@link Enemy Gegner} in einen {@link Room Raum} zu bewegen.
     * @param enemyName welcher {@link Enemy Gegner} soll hinzugefügt werden.
     * @param roomName von welchem {@link Room Raum} soll hinzugefügt werden.
     * @author EGA
     */

    public void addEnemyToRoom(EnemyName enemyName, RoomName roomName)
    {
        Room room = allRoomsMap.get(roomName);
        Enemy enemyToBeAdded = enemyManager.getEnemy(enemyName);
        Map<EnemyName, Enemy> enemyMap = room.getEnemiesContained();
        enemyMap.put(enemyName, enemyToBeAdded);
        enemyToBeAdded.setWhereAmI(room);
    }

    /**
     * Diese Methode nimmt einen {@link EnemyName Gegner Namen} und einen {@link RoomName Raum Namen}, <br>
     * um einen {@link Enemy Gegner} von einem {@link Room Raum} zu entfernen.
     * @param enemyName welcher {@link Enemy Gegner} soll entfernt werden.
     * @param roomName von welchem {@link Room Raum} soll entfernt werden.
     * @author EGA
     */

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

    /**
     * Diese Methode nimmt einen {@link EnemyName Gegner Namen} und einen {@link RoomName Raum Namen}, <br>
     * um {@link Enemy Gegner} in neue {@link Room Räume} zu bewegen und direkt aus dem alten {@link Room Raum} zu entfernen.
     *
     * @param enemyName welcher {@link Enemy Gegner} soll bewegt werden.
     * @param newRoom in welchen {@link Room Raum} soll bewegt werden.
     * @author EGA
     */
    public void moveEnemy(EnemyName enemyName, RoomName newRoom)
    {
        Enemy enemy = enemyManager.getEnemy(enemyName);
        Room whereAmI = enemy.getWhereAmI();
        RoomName roomName = whereAmI.getRoomName();
        removeEnemyFromRoom(enemyName, roomName);
        addEnemyToRoom(enemyName, newRoom);
    }

    /**
     * Diese Methode gibt auf der Console aus,<br>
     * welche {@link Enemy Gegner} sich direkt neben dem {@link Room Raum} (vom Typ {@link RoomName#OFFICE Office}) befinden.
     * @param enemyManager sorgt für den Zugriff auf die {@link Enemy Gegner}.
     * @author EGA
     */
    public void printEnemiesNextToOffice(EnemyManager enemyManager)
    {
        Map<EnemyName, Enemy> enemiesWest = allRoomsMap.get(RoomName.OFFICE).getNextRoom(Direction.WEST1).getEnemiesContained();
        Map<EnemyName, Enemy> enemiesEast = allRoomsMap.get(RoomName.OFFICE).getNextRoom(Direction.EAST).getEnemiesContained();
        if (enemiesEast.get(EnemyName.FREDDY) != null)
        {
            System.out.println("You are seeing on the east window: " +enemyManager.getEnemy(EnemyName.FREDDY).getName());
        }
        if (enemiesEast.get(EnemyName.CHICA) != null)
        {
            System.out.println("You are seeing on the east door: " +enemyManager.getEnemy(EnemyName.CHICA).getName());
        }
        if (enemiesWest.get(EnemyName.BONNIE) != null)
        {
            System.out.println("You are seeing at the west window: " +enemyManager.getEnemy(EnemyName.BONNIE).getName());
        }
    }

    public RoomManager setEnemyManager(EnemyManager enemyManager)
    {
        this.enemyManager = enemyManager;
        return this;
    }

    public Map<RoomName, Room> getAllRoomsMap()
    {
        return allRoomsMap;
    }
}
