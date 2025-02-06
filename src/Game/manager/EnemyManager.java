package Game.manager;

import Game.factor.Direction;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Player;
import Game.object.Room;
import Game.text_message.DeathMessages;
import Game.text_message.DeathMessages.*;

import java.util.Map;

import static Game.mechanic.RoundMechanic.randomBoolean;

/**
 * Verwaltet alle{@link Enemy}'s<br>
 * Verwalten heißt:<br>
 * Erstellen
 */

public class EnemyManager
{
    private final Map<EnemyName, Enemy> enemyMap;


    public EnemyManager(Map<EnemyName, Enemy> enemyMap)
    {
        this.enemyMap = enemyMap;
    }

    public Enemy getEnemy(EnemyName enemyName)
    {
        return enemyMap.get(enemyName);
    }

    public void moveEveryEnemyOneFurther(RoomManager roomManager, Player player)
    {

        moveFreddyOneRoomFurther(roomManager,player);
        returnIfPlayerIsDead(player);
        moveBonnieOneRoomFurther(roomManager,player);
        returnIfPlayerIsDead(player);
        moveChicaOneRoomFurther(roomManager,player);
        returnIfPlayerIsDead(player);
        increaseFoxxysStageByOne(roomManager,player);
    }

    private void returnIfPlayerIsDead(Player player)
    {
        if (player.isAlive()){
            return;
        }
        else return return;
    }


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
                case RoomName.WESTHALLCORNER -> randomDirectionNorthEAST();
                case RoomName.SUPPLYCLOSET -> Direction.EAST;
                case RoomName.WESTDOOR -> tryToKill(RoomName.WESTDOOR,bonnie,player);
                default -> throw new IllegalArgumentException("Bewegung funktioniert nicht.");
            };
            Room nextRoom = whereAmI.getNextRoom(newDirection);
            RoomName nameOfNextRoom = nextRoom.getRoomName();
            roomManager.moveEnemy(EnemyName.BONNIE, nameOfNextRoom);
        }
    }


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
                    DeathMessages.FreedysKill();
                    player.setAlive(false);
                    return Direction.RESET;
                }
                else if (enemy.getName().equals(EnemyName.CHICA))
                {
                    DeathMessages.ChicasKill();
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
                    DeathMessages.BonniesKill();
                    player.setAlive(false);
                    return Direction.RESET;
                }
            }
        }
        return Direction.RESET;
    }
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

    private Direction randomDirectionNorthEAST()
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


}
