package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Pizzeria;
import Game.text_message.Color;

import static Game.text_message.Color.*;

public class RoundMechanic
{
    public void startRound(int roundNumber, Pizzeria pizzeria)
    {
//        Alle Gegner Variablen zuweisen um diese besser zu nutzen.
        Color colors = new Color();
        Enemy freddy = pizzeria.getEnemy(EnemyName.FREDDY);
        Enemy bonnie = pizzeria.getEnemy(EnemyName.BONNIE);
        Enemy chica = pizzeria.getEnemy(EnemyName.CHICA);
        Enemy foxxy = pizzeria.getEnemy(EnemyName.FOXXY);
//        Make Everyone walk his way to the door
//        Make Ranodm factor if they can move or not, with the enemy Level
        freddy.makeFreddyMoveToHisNextRoom();
        bonnie.makeBonnieMoveToHisNextRoom();
        chica.makeChicaMoveToHerNextRoom();
        foxxy.increaseFoxxysNextStage();
//        Printe Mapstatus
        System.out.print("Round: " +roundNumber);
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft()-2);
        System.out.println(" Energy: "+pizzeria.getEnergyLeft());

//        Printe alle Positionen
        System.out.println(red+freddy.getName()+reset+"Befindet sich in:  "+red+freddy.getMyRoomsName()+reset);
        System.out.println(red+bonnie.getName()+reset+"Befindet sich in:  "+red+bonnie.getMyRoomsName()+reset);
        System.out.println(red+chica.getName()+reset+"Befindet sich in:  "+red+chica.getMyRoomsName()+reset);
        System.out.println(red+foxxy.getName()+reset+"Befindet sich in:  "+red+foxxy.getWhereAmI().getPirateCoveOpeningStage()+reset);
    }

    /**
     * Diese Methode wird genutzt, um einen Zufällig generierten {@link boolean} zu erzeugen.<br>
     * Dafür wird die {@link Math#random()} Methode genutzt um eine zufällige Zahl zwischen 1 und 2 zu berechnen.
     * @return Gebe {@link true} zurück, wenn die zufällige Zahl 1 ist, ansonsten gebe {@link false} zurück.
     */
    public static boolean randomBoolean()
    {
        if ((int) (Math.random() * 2) + 1 == 1) {
            return true;
        } else return false;
    }
}
