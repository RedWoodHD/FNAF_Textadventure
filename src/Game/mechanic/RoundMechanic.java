package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Pizzeria;

public class RoundMechanic
{
    public void startRound(int roundNumber, Pizzeria pizzeria)
    {
        Enemy freddy = pizzeria.getEnemy(EnemyName.FREDDY);
        Enemy bonnie = pizzeria.getEnemy(EnemyName.BONNIE);
        Enemy chica = pizzeria.getEnemy(EnemyName.CHICA);
        Enemy foxxy = pizzeria.getEnemy(EnemyName.FOXXY);

        System.out.print("Round: " +roundNumber);
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft()-2);
        System.out.println(" Energy: "+pizzeria.getEnergyLeft());
        if (roundNumber == 10) {
//            Ändere das in eine Methode get Enemy spare dir Methoden Aufrufe!!!
            if (pizzeria.getEnemyRoom(EnemyName.FREDDY).equals(pizzeria.getRoom(RoomName.OFFICE))) {
                System.out.println(""+pizzeria.getEnemyName(freddy));
            }
        }
    }
}
