package Game.manager;

import Game.factor.Direction;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Room;

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

    public void moveEveryEnemyOneFurther(RoomManager roomManager)
    {

        moveFreddyOneRoomFurther(roomManager);
        moveBonnieOneRoomFurther();
        moveChicaOneRoomFurther();
        increaseFoxxysStageByOne();
    }

    private void moveFreddyOneRoomFurther(RoomManager roomManager)
    {
        Enemy freddy = enemyMap.get(EnemyName.FREDDY);
        if (freddy.canIMove()){

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
                default -> throw new IllegalArgumentException("Bewegung funktioniert nicht.");
            };
            Room nextRoom = whereAmI.getNextRoom(newDirection);
            RoomName nameOfNextRoom = nextRoom.getRoomName();
            roomManager.moveEnemy(EnemyName.FREDDY, nameOfNextRoom);
        }
    }

    private void moveBonnieOneRoomFurther(RoomManager roomManager)
    {
        Enemy bonnie = enemyMap.get(EnemyName.BONNIE);
        Room whereAmI = bonnie.getWhereAmI();
        RoomName currentRoomName = whereAmI.getRoomName();
        Direction newDirection = switch (currentRoomName)
        {
            case RoomName.SHOWSTAGE -> randomDirectionSouth1West1();
            case RoomName.DININGAREA, RoomName.BACKSTAGE   ->Direction.SOUTH1; // Backstage
            case RoomName.WESTHALL -> randomDirectionSouth1West1();

                        moveCurrentRoomToNeighbor(Direction.SOUTH1); // West Hall
                        break;
                    case RoomName.WESTHALL:
                        if (randomBoolean())
                        {
                            moveCurrentRoomToNeighbor(Direction.SOUTH1); // West Hall Corner
                            break;
                        }
                        else
                        {
                            moveCurrentRoomToNeighbor(Direction.WEST1); // Supply Closet
                            break;
                        }
                    case RoomName.WESTHALLCORNER:
                        if (randomBoolean())
                        {
                            moveCurrentRoomToNeighbor(Direction.NORTH); // Supply Closet
                            break;
                        }
                        else
                        {
                            moveCurrentRoomToNeighbor(Direction.EAST); // West Door
                            break;
                        }
                    case RoomName.SUPPLYCLOSET:
                        moveCurrentRoomToNeighbor(Direction.EAST); // West Hall
                        break;
                }
                Room nextRoom = whereAmI.getNextRoom(newDirection);
                RoomName nameOfNextRoom = nextRoom.getRoomName();
                roomManager.moveEnemy(EnemyName.FREDDY, nameOfNextRoom);
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

    private void moveChicaOneRoomFurther()
    {
        Enemy chica = enemyMap.get(EnemyName.CHICA);
        chica.makeBonnieMoveToHisNextRoom();
    }

    private void increaseFoxxysStageByOne()
    {
        Enemy foxxy = enemyMap.get(EnemyName.FOXXY);
        foxxy.increaseFoxxysNextStage();
    }

}
