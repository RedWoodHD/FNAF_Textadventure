package Game.main;

import Game.factor.EnemyName;
import Game.manager.PizzeriaManager;
import Game.mechanic.RoundMechanic;

public class FnafGame
{

    public static void runGame()
    {
        PizzeriaManager pizzeriaManager = new PizzeriaManager();
        RoundMechanic roundMechanic = new RoundMechanic();
        System.out.println(pizzeriaManager.getEnemyManager().getEnemyMap().get(EnemyName.FREDDY).getLevel());

        for (int i = 1; i <= 20 ; i++) {
            roundMechanic.startRound(i,pizzeriaManager.getPizzeria());
            System.out.println("/"+pizzeriaManager.getPizzeria().getEnergyLeft());
        }
    }
}
