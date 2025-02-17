package Game.manager;

import Game.factor.Direction;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.logic.RoundLogic;
import Game.object.Enemy;
import Game.object.Player;
import Game.object.Room;
import Game.text_message.DeathMessage;

import java.util.Map;

import static Game.logic.RoundLogic.randomBoolean;

/**
 * Diese Klasse Verwaltet alle{@link Enemy}'s.<br>
 * Sie beinhaltet eine {@link java.util.HashMap} gefühlt mit {@link EnemyName} -> {@link Enemy}.<br>
 * Verwalten heißt:<br>
 * Sie liefert eine Methode {@link #getEnemy(EnemyName)} ,um einen beliebigen {@link Enemy} zurückzuliefern.<br>
 * Bewegen von einem {@link Room} zu einem anderen. {@link Room}<br>
 *Dafür benutzt sie folgende Methode:<br>
 * {@link #moveEveryEnemyOneFurther(RoomManager, Player)}
 *
 * @author EGA
 */

public class EnemyManager
{
    private final Map<EnemyName, Enemy> enemyMap;


    public EnemyManager(Map<EnemyName, Enemy> enemyMap)
    {
        this.enemyMap = enemyMap;
    }

    /**
     * Diese Methode liefert für einen übergebenen {@link EnemyName} einen passenden {@link Enemy} zurück.<br>
     * @param enemyName -> Wird genutzt um in der {@link Map} nach dem {@link Enemy} zu suchen.
     * @return {@link Enemy} der in der Map mit dem {@link EnemyName} gefunden wurde.
     */
    public Enemy getEnemy(EnemyName enemyName)

    {
        return enemyMap.get(enemyName);
    }

    /**
     * Diese Methode bewegt jeden {@link Enemy Gegner} einen {@link Room Raum} oder eine {@link Room#pirateCoveOpeningStage Raumstage} weiter.<br>
     * Dabei wird nach dem Zufalls prinzip entschieden, ob der {@link Enemy Gegner} sich bewegen darf oder nicht.<br>
     * Dafür werden die jeweiligen Methoden genutzt:<br>
     * {@link #moveFreddyOneRoomFurther(RoomManager, Player)}<br>
     * {@link #moveBonnieOneRoomFurther(RoomManager, Player)}<br>
     * {@link #moveChicaOneRoomFurther(RoomManager, Player)}<br>
     * {@link #increaseFoxxysStageByOne(RoomManager, Player)}<br>
     * @param roomManager wird genutzt um den {@link RoomManager} an die Methoden zu übergeben.
     * @param player wird genutzt um den {@link Player} an die Methoden zu übergeben.
     * @author EGA
     */
    public void moveEveryEnemyOneFurther(RoomManager roomManager, Player player)
    {

        moveFreddyOneRoomFurther(roomManager,player);
        if (!player.isAlive()){
            return;
        }
        moveBonnieOneRoomFurther(roomManager,player);
        if (!player.isAlive()){
            return;
        }
        moveChicaOneRoomFurther(roomManager,player);
        if (!player.isAlive()){
            return;
        }
        increaseFoxxysStageByOne(roomManager,player);
    }

    /**
     * Diese Methode bewegt {@link Enemy Freddy} (Enemy vom Typ {@link EnemyName#FREDDY}) zu seinem nächsten {@link Room Raum}.<br>
     * Dafür prüft sie erstmal per Zufalls Prinzip, ob dieser sich bewegen darf und bewegt ihn dann.<br>
     * Sollte der {@link Enemy Gegner } in den {@link Room Raum} mit dem Namen {@link RoomName#OFFICE} gehen, {@link Player#setAlive(boolean)  töte den Spieler}.<br>
     * @param roomManager übergebe den {@link RoomManager}, um die {@link Room Räume} zu verwalten.
     * @param player übergebe den {@link Player Spieler} um diesen töten zu können.
     * @author EGA
     */
    private void moveFreddyOneRoomFurther(RoomManager roomManager, Player player)
    {
        Enemy freddy = enemyMap.get(EnemyName.FREDDY);
        if (freddy.canIMove())
        {

            Room whereAmI = freddy.getWhereAmI();
            RoomName currentRoomName = whereAmI.getRoomName();
            Direction newDirection = switch (currentRoomName)
            {
                case RoomName.SHOWSTAGE,
                     RoomName.EASTHALL,
                     RoomName.RESTROOMS -> Direction.SOUTH1;
                case RoomName.DININGAREA -> (Direction.EAST);
                case RoomName.KITCHEN,
                     RoomName.EASTHALLCORNER -> Direction.WEST1;
                case RoomName.EASTDOOR -> tryToKill(RoomName.EASTDOOR,freddy, player);
                default -> throw new IllegalArgumentException("Bewegung funktioniert nicht.");
            };
            Room nextRoom = whereAmI.getNextRoom(newDirection);
            RoomName nameOfNextRoom = nextRoom.getRoomName();
            roomManager.moveEnemy(EnemyName.FREDDY, nameOfNextRoom);
        }
    }

    /**
     * Diese Methode bewegt {@link Enemy Bonnie} (Enemy vom Typ {@link EnemyName#BONNIE}) zu seinem nächsten {@link Room Raum}.<br>
     * Dafür prüft sie erstmal per Zufalls Prinzip, ob dieser sich bewegen darf und bewegt ihn dann.<br>
     * Sollte der {@link Enemy Gegner } in den {@link Room Raum} mit dem Namen {@link RoomName#OFFICE} gehen, {@link Player#setAlive(boolean)  töte den Spieler}.<br>
     * @param roomManager übergebe den {@link RoomManager}, um die {@link Room Räume} zu verwalten.
     * @param player übergebe den {@link Player Spieler} um diesen töten zu können.
     * @author EGA
     */

    private void moveBonnieOneRoomFurther(RoomManager roomManager, Player player)
    {
        Enemy bonnie = enemyMap.get(EnemyName.BONNIE);
        if (bonnie.canIMove())
        {

            Room whereAmI = bonnie.getWhereAmI();
            RoomName currentRoomName = whereAmI.getRoomName();
            Direction newDirection = switch (currentRoomName)
            {
                case RoomName.SHOWSTAGE,
                     RoomName.WESTHALL -> randomDirectionSouth1West1();
                case RoomName.DININGAREA,
                     RoomName.BACKSTAGE -> Direction.SOUTH1;
                case RoomName.WESTHALLCORNER -> randomDirectionNorthEast();
                case RoomName.SUPPLYCLOSET -> Direction.EAST;
                case RoomName.WESTDOOR -> tryToKill(RoomName.WESTDOOR,bonnie,player);
                default -> throw new IllegalArgumentException("Bewegung funktioniert nicht.");
            };
            Room nextRoom = whereAmI.getNextRoom(newDirection);
            RoomName nameOfNextRoom = nextRoom.getRoomName();
            roomManager.moveEnemy(EnemyName.BONNIE, nameOfNextRoom);
        }
    }

    /**
     * Diese Methode bewegt {@link Enemy Chica} (Enemy vom Typ {@link EnemyName#CHICA}) zu seinem nächsten {@link Room Raum}.<br>
     * Dafür prüft sie erstmal per Zufalls Prinzip, ob dieser sich bewegen darf und bewegt ihn dann.<br>
     * Sollte der {@link Enemy Gegner } in den {@link Room Raum} mit dem Namen {@link RoomName#OFFICE} gehen, {@link Player#setAlive(boolean)  töte den Spieler}.<br>
     * @param roomManager übergebe den {@link RoomManager}, um die {@link Room Räume} zu verwalten.
     * @param player übergebe den {@link Player Spieler} um diesen töten zu können.
     * @author EGA
     */

    private void moveChicaOneRoomFurther(RoomManager roomManager, Player player)
    {
        Enemy chica = enemyMap.get(EnemyName.CHICA);
        if (chica.canIMove())
        {
            Room whereAmI = chica.getWhereAmI();
            RoomName currentRoomName = whereAmI.getRoomName();
            Direction newDirection = switch (currentRoomName)
            {
                case RoomName.SHOWSTAGE -> randomDirectionSouth1East();
                case RoomName.DININGAREA -> Direction.SOUTH3;
                case RoomName.RESTROOMS,
                     RoomName.EASTHALL -> Direction.SOUTH1;
                case RoomName.KITCHEN,
                     RoomName.EASTHALLCORNER -> Direction.WEST1;
                case EASTDOOR -> tryToKill(RoomName.EASTDOOR,chica,player);
                default -> throw new IllegalArgumentException("Bewegung funktioniert nicht.");
            };
            if (newDirection == null){
                newDirection = Direction.RESET;
            }
            Room nextRoom = whereAmI.getNextRoom(newDirection);
            RoomName nameOfNextRoom = nextRoom.getRoomName();
            roomManager.moveEnemy(EnemyName.CHICA, nameOfNextRoom);
        }
    }

    /**
     * Diese Methode erhöht, die {@link Room#pirateCoveOpeningStage Raumstage} vom {@link Room Raum}, <br> in dem sich {@link Enemy Foxxy} (Enemy vom Typ {@link EnemyName#FOXXY} ) befinden.<br>
     * Das passiert basierend auf:<br>
     * -Ist {@link Enemy Foxxy} gesichtet worden. ({@link Enemy#haveIBeenObserved })<br>
     * -Darf sich {@link Enemy Foxxy} bewegen, das wird mithilfe der {@link Enemy#canIMove()} Methode geprüft. <br>
     *
     */
    private void increaseFoxxysStageByOne(RoomManager roomManager, Player player)
    {
        Enemy foxxy = enemyMap.get(EnemyName.FOXXY);
        RoomName currentRoomName = foxxy.getWhereAmI().getRoomName();
        if (foxxy.isHaveIBeenObserved()){
            roomManager.resetStage(currentRoomName);
            foxxy.setHaveIBeenObserved(false);
        } else if (foxxy.canIMove()){
            roomManager.increaseStage(currentRoomName);
        }
    }

    /**
     * Diese Methode prüft, ob der {@link Room Raum} vom Typ {@link RoomName#OFFICE Office} geöffnet ist oder nicht <br>
     * {@link Player#setAlive(boolean) töte den Spieler}gegebenenfalls.
     * @param roomName in welchem {@link Room Raum} befinde ich mich gerade.
     * @param enemy welcher {@link Enemy Gegner} möchte den {@link Room Raum} wechseln.
     * @param player welcher {@link Player Spieler} soll getötet werden, falls möglich.
     * @return {@link Direction#RESET Direction.RESET} um den {@link Enemy Gegner} zurückzusetzen.
     * @author EGA
     */

    private Direction tryToKill(RoomName roomName,Enemy enemy, Player player)
    {
        if (roomName.equals(RoomName.EASTDOOR))
        {
            if (enemy.getWhereAmI().getNextRoom(Direction.WEST1).isDoorClosed())
            {
                return Direction.RESET;
            } else
            {
                if (enemy.getName().equals(EnemyName.FREDDY)){
                    DeathMessage.FreedysKill();
                    player.setAlive(false);
                    return Direction.RESET;
                }
                else if (enemy.getName().equals(EnemyName.CHICA))
                {
                    DeathMessage.ChicasKill();
                    player.setAlive(false);
                    return Direction.RESET;
                }
            }
        }else
        {
            if (roomName.equals(RoomName.WESTDOOR))
            {
                if (enemy.getWhereAmI().getNextRoom(Direction.EAST).isDoorClosed())
                {
                    return Direction.RESET;
                }
                else
                {
                    DeathMessage.BonniesKill();
                    player.setAlive(false);
                    return Direction.RESET;
                }
            }
        }
        return Direction.RESET;
    }

    /**
     * Gibt zufällig entweder {@link Direction#SOUTH1} oder {@link Direction#EAST} zurück.<br>
     * Diese Methode verwendet die {@link RoundLogic#randomBoolean()} Methode, um eine zufällige Entscheidung zu treffen:<br>
     * - Wenn die zufällige Entscheidung wahr ist, wird {@link Direction#SOUTH1} zurückgegeben.<br>
     * - Wenn die zufällige Entscheidung falsch ist, wird {@link Direction#EAST} zurückgegeben.<br>
     * @return Eine zufällig ausgewählte Richtung, entweder {@link Direction#SOUTH1} oder {@link Direction#EAST}.
     */

    private Direction randomDirectionSouth1East()
    {
        if (randomBoolean())
        {
            return Direction.SOUTH1;
        }
        else
        {
            return Direction.EAST;
        }
    }
    /**
     * Gibt zufällig entweder {@link Direction#NORTH} oder {@link Direction#EAST} zurück.<br>
     * Diese Methode verwendet die {@link RoundLogic#randomBoolean()} Methode, um eine zufällige Entscheidung zu treffen:<br>
     * - Wenn die zufällige Entscheidung wahr ist, wird {@link Direction#NORTH} zurückgegeben.<br>
     * - Wenn die zufällige Entscheidung falsch ist, wird {@link Direction#EAST} zurückgegeben.<br>
     * @return Eine zufällig ausgewählte Richtung, entweder {@link Direction#NORTH} oder {@link Direction#EAST}.
     */

    private Direction randomDirectionNorthEast()
    {
        if (randomBoolean())
        {
            return Direction.NORTH;
        }
        else
        {
            return Direction.EAST;
        }
    }

    /**
     * Gibt zufällig entweder {@link Direction#SOUTH1} oder {@link Direction#WEST1} zurück.<br>
     * Diese Methode verwendet die {@link RoundLogic#randomBoolean()} Methode, um eine zufällige Entscheidung zu treffen:<br>
     * - Wenn die zufällige Entscheidung wahr ist, wird {@link Direction#SOUTH1} zurückgegeben.<br>
     * - Wenn die zufällige Entscheidung falsch ist, wird {@link Direction#WEST1} zurückgegeben.<br>
     * @return Eine zufällig ausgewählte Richtung, entweder {@link Direction#SOUTH1} oder {@link Direction#WEST1}.
     */
    private Direction randomDirectionSouth1West1()
    {
        if (randomBoolean())
        {
            return Direction.SOUTH1;
        }
        else
        {
            return Direction.WEST1;
        }
    }

    public Map<EnemyName, Enemy> getEnemyMap()
    {
        return enemyMap;
    }
}
