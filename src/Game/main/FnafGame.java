package Game.main;

import Game.factor.EnemyName;
import Game.manager.PizzeriaManager;

public class FnafGame
{

    public static void runGame()
    {
        PizzeriaManager pizzeriaManager = new PizzeriaManager();
        System.out.println(pizzeriaManager.getEnemyManager().getEnemyMap().get(EnemyName.FREDDY).getLevel());

        for (int i = 0; i <=20 ; i++) {
            System.out.println("Round: "+i);

        }
    }
}
