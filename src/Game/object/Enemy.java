package Game.object;

import Game.factor.EnemyName;

public class Enemy
{
    private EnemyName name;
    private Room whereAmI;
    private int level;
    private boolean haveIBeenObserved;

    /** {@code Welche Wege nehmen die Animatronics.}<br>
     * Freddy show stage -> dining area -> restrooms -> Kitchen -> east hall -> east hall corner<br>
     * If door is closed wait 2 rounds, if still closed move to dining area otherwise kill player<br>
     *<br>
     * Boonie Show Stage -> dining area/backstage -> west hall -> supply closet/west hall corner. west hall corner -> Supply closet/west door.<br>
     * If door is closed go to dining Area, if not kill player after 2 rounds.<br>
     *<br>
     * Chica show stage -> dining area/restrooms -> Kitchen(no cam) -> East hall -> East hall corner -> door<br>
     * If door is closed go to dining Area, if not kill player after 2 rounds<br>
     *<br>
     * Foxxy Stage 1 2 3 if Stage 4 he will kill you, if look at Foxxy freeze him for 2 rounds<br>
     *<br>
     *cam06 disabled Chica or Freddy make a Sound
     *
     */


    public Enemy(EnemyName name, Room whereAmI, int level)
    {
        this.name = name;
        this.whereAmI = whereAmI;
        this.level = level;
    }



    /**Die Methode liefert einen {@link boolean}, ob der {@link Enemy} sich bewegen darf oder nicht.<br>
     * Dazu nimmt er eine zufällige Zahl zwischen 1 und 10 und schaut, ob diese größer als sein {@link Enemy#level} ist.<br>
     * Wenn er gesichtet wurde {@link Enemy#haveIBeenObserved}, wird der zufällige {@link int} um 2 verringert.<br>
     * @return True oder False
     */
    public boolean canIMove(){
        int number = (int) (Math.random() * 12) +1;
        if(haveIBeenObserved){
            number = number - 2;
        }
        if (number < level ){
            return true ;
        } else return false;

    }
    public int getLevel() {
        return level;
    }

    public Enemy setLevel(int level) {
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

    public Room getWhereAmI() {
        return whereAmI;
    }

    public Enemy setWhereAmI(Room whereAmI) {
        this.whereAmI = whereAmI;
        return this;
    }

    public boolean isHaveIBeenObserved() {
        return haveIBeenObserved;
    }

    public Enemy setHaveIBeenObserved(boolean haveIBeenObserved) {
        this.haveIBeenObserved = haveIBeenObserved;
        return this;
    }
}