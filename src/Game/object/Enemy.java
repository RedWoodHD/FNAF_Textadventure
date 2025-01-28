package Game.object;

import Game.factor.Direction;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.mechanic.RoundMechanic;

import static Game.mechanic.RoundMechanic.randomBoolean;

public class Enemy
{
    private EnemyName name;
    private Room whereAmI;
    private int level;
    private boolean haveIBeenObserved;

    /**
     * {@code Welche Wege nehmen die Animatronics.}<br>
     * Freddy show stage -> dining area -> restrooms -> Kitchen -> east hall -> east hall corner<br>
     * If door is closed wait 2 rounds, if still closed move to dining area otherwise kill player<br>
     * <br>
     * Boonie Show Stage -> dining area/backstage -> west hall -> supply closet/west hall corner. west hall corner -> Supply closet/west door.<br>
     * If door is closed go to dining Area, if not kill player after 2 rounds.<br>
     * <br>
     * Chica show stage -> dining area/restrooms -> Kitchen(no cam) -> East hall -> East hall corner -> door<br>
     * If door is closed go to dining Area, if not kill player after 2 rounds<br>
     * <br>
     * Foxxy Stage 1 2 3 if Stage 4 he will kill you, if look at Foxxy freeze him for 2 rounds<br>
     * <br>
     * cam06 disabled Chica or Freddy make a Sound
     */


    public Enemy(EnemyName name, Room whereAmI, int level)
    {
        this.name = name;
        this.whereAmI = whereAmI;
        this.level = level;
    }

    public void makeFreddyMoveToHisNextRoom()
    {
        if (canIMove()) {
            if (name.equals(EnemyName.FREDDY)) {
                switch (whereAmI.getRoomName()) {
                    case RoomName.SHOWSTAGE, RoomName.EASTHALL, RoomName.RESTROOMS:
                        moveCurrentRoomToNeighbor(Direction.SOUTH1);
                        break;
                    case RoomName.DININGAREA:
                        moveCurrentRoomToNeighbor(Direction.EAST);
                        break;
                    case RoomName.KITCHEN, RoomName.EASTHALLCORNER:
                        moveCurrentRoomToNeighbor(Direction.WEST1);
                        break;
                }
            }
        }
    }


    public void makeBonnieMoveToHisNextRoom()
    {
        if (canIMove()) {
            if (name.equals(EnemyName.BONNIE)) {
                switch (whereAmI.getRoomName()) {
                    case RoomName.SHOWSTAGE:
                        if (randomBoolean()) {
                            moveCurrentRoomToNeighbor(Direction.SOUTH1); // Dining Area
                            break;
                        } else {
                            moveCurrentRoomToNeighbor(Direction.WEST1); // Backstage
                            break;
                        }
                    case RoomName.DININGAREA, RoomName.BACKSTAGE:
                        moveCurrentRoomToNeighbor(Direction.SOUTH1); // West Hall
                        break;
                    case RoomName.WESTHALL:
                        if (randomBoolean()) {
                            moveCurrentRoomToNeighbor(Direction.SOUTH1); // West Hall Corner
                            break;
                        } else {
                            moveCurrentRoomToNeighbor(Direction.WEST1); // Supply Closet
                            break;
                        }
                    case RoomName.WESTHALLCORNER:
                        if (randomBoolean()) {
                            moveCurrentRoomToNeighbor(Direction.NORTH); // Supply Closet
                            break;
                        } else {
                            moveCurrentRoomToNeighbor(Direction.EAST); // West Door
                            break;
                        }
                    case RoomName.SUPPLYCLOSET:
                        moveCurrentRoomToNeighbor(Direction.EAST); // West Hall
                        break;
                }
            }
        }
    }

    /**
     * Diese Methode setzt den {@link Enemy#whereAmI} {@link Room} von dem {@link Enemy} {@link EnemyName#CHICA} auf den nächsten {@link Room}.<br>
     * Dazu wird die {@link Enemy#moveCurrentRoomToNeighbor(Direction)} Methode genutzt, um den Raum vom jeweiligen {@link Enemy} zu ändern.<br>
     * Im {@link Enemy} wird erklärt wie sich die einzelnen {@link Enemy}'s bewegen können, bzw. welche Wege ihnen offen stehen.
     */
    public void makeChicaMoveToHerNextRoom()
    {
        if (canIMove()) {
            if (whereAmI != null) {
                if (name.equals(EnemyName.CHICA)) {
                    switch (whereAmI.getRoomName()) {
                        case RoomName.SHOWSTAGE:
                            if (RoundMechanic.randomBoolean()) {
                                moveCurrentRoomToNeighbor(Direction.SOUTH1); // Dining Area
                                break;
                            } else {
                                moveCurrentRoomToNeighbor(Direction.EAST); // Restrooms
                                break;
                            }
                        case RoomName.DININGAREA:
                            moveCurrentRoomToNeighbor(Direction.SOUTH3); // Kitchen
                            break;
                        case RoomName.RESTROOMS:
                            moveCurrentRoomToNeighbor(Direction.SOUTH1); // Kitchen
                            break;
                        case RoomName.KITCHEN, RoomName.EASTHALLCORNER:
                            moveCurrentRoomToNeighbor(Direction.WEST1); // East Hall / East Door
                            break;
                        case RoomName.EASTHALL:
                            moveCurrentRoomToNeighbor(Direction.SOUTH1); // East Hall Corner
                            break;
                    }
                }
            }
        }
    }

    /**
     * Diese Methode erhöht den Wert {@link Room#pirateCoveOpeningStage} von
     * dem {@link Room} {@link Enemy#whereAmI}in dem sich der {@link Enemy} {@link EnemyName#FOXXY} befindet.
     */

    public void increaseFoxxysNextStage()
    {
        if (canIMove()) {
            if (name.equals(EnemyName.FOXXY)) {
                whereAmI.increasePirateCoveOpeningStage();
            }
        }
    }

    /**
     * Diese Methode sorgt für einen schnelleren Zugriff auf den {@link RoomName} vom {@link Room} in dem sich der {@link Enemy} befindet.<br>
     * Nutze die Methode {@link Room#getRoomName()} für den Zugriff aufs {@link Enum} -> {@link RoomName}.
     *
     * @return gebe den {@link RoomName} vom {@link #whereAmI} zurück.
     */
    public RoomName getMyRoomsName()
    {
        return whereAmI.getRoomName();
    }


    /**
     * Die Methode liefert einen {@link boolean}, ob der {@link Enemy} sich bewegen darf oder nicht.<br>
     * Dazu nimmt er eine zufällige Zahl zwischen 1 und 10 und schaut, ob diese größer als sein {@link Enemy#level} ist.<br>
     * Wenn er gesichtet wurde {@link Enemy#haveIBeenObserved}, wird der zufällige {@link int} um 2 verringert.<br>
     *
     * @return True oder False
     */
    public boolean canIMove()
    {
        int number = (int) (Math.random() * 12) + 1;
        if (haveIBeenObserved) {
            number = number - 2;
        }
        if (number < level) {
            return true;
        } else return false;

    }

    private void moveCurrentRoomToNeighbor(Direction direction)
    {
        if (whereAmI != null) {
            setWhereAmI(whereAmI.getNextRoom(direction));
        }
    }

    public int getLevel()
    {
        return level;
    }

    public Enemy setLevel(int level)
    {
        this.level = level;
        return this;
    }

    public EnemyName getName()
    {
        return name;
    }

    public Enemy setName(EnemyName name)
    {
        this.name = name;
        return this;
    }

    public Room getWhereAmI()
    {
        return whereAmI;
    }

    public Enemy setWhereAmI(Room whereAmI)
    {
        this.whereAmI = whereAmI;
        return this;
    }

    public boolean isHaveIBeenObserved()
    {
        return haveIBeenObserved;
    }

    public Enemy setHaveIBeenObserved(boolean haveIBeenObserved)
    {
        this.haveIBeenObserved = haveIBeenObserved;
        return this;
    }
}