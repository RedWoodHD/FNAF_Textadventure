package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Pizzeria;

public class RoundMechanic
{
    public void startRound(int roundNumber, Pizzeria pizzeria)
    {

        System.out.print("Round: " +roundNumber);
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft()-2);
        System.out.println(" Energy: "+pizzeria.getEnergyLeft());
        pizzeria.getEnemyMap().get(EnemyName.FREDDY).setWhereAmI(pizzeria.getRoomMap().get(RoomName.OFFICE));
        if (roundNumber == 10) {
            if (pizzeria.getEnemyMap().get(EnemyName.FREDDY).getWhereAmI().equals(pizzeria.getRoomMap().get(RoomName.OFFICE))) {
                System.out.println(pizzeria.getEnemyMap().get(EnemyName.FREDDY).getName());
            }
        }
    }
}
