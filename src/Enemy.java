public class Enemy {
    private String name;
    private Room whereAmI;
    private int level;
    private boolean haveIBeenObserved;

    /** Welche Wege nehmen die Animatronics
     * Freddy show stage -> dining area -> restrooms -> Kitchen -> east hall -> east hall corner
     * If door is closed wait 2 rounds, if still closed move to dining area otherwise kill player
     *
     * Boonie Show Stage -> dining area/backstage -> west hall -> supply closet/west hall corner. west hall corner -> Supply closet/west door.
     * If door is closed go to dining Area, if not kill player after 2 rounds
     *
     * Chica show stage -> dining area/restrooms -> Kitchen(no cam) -> East hall -> East hall corner -> door
     * If door is closed go to dining Area, if not kill player after 2 rounds
     *
     * Foxxy Stage 1 2 3 if Stage 4 he will kill you, if look at Foxxy freeze him for 2 rounds
     *
     *cam06 disabled Chica or Freddy make a Sound
     *
     */



    /**Die Methode liefert einen Boolean, ob der Gegner sich bewegen darf oder nicht.
     * Dazu nimmt er eine zufällige Zahl zwischen 1 und 10 und schaut, ob diese größer als sein Level ist.
     * Wenn er gesichtet wurde, wird der zufällige Wert um 2 verringert.
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

    public String getName() {
        return name;
    }

    public Enemy setName(String name) {
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
