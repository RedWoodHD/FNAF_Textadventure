package Game.mechanic;

import Game.factor.EnemyName;
import Game.manager.PizzeriaManager;
import Game.text_message.GameInformation;

import static Game.text_message.Map.printMap;

public class FnafGame
{
    public static void runGame()
    {
        PizzeriaManager pizzeriaManager = new PizzeriaManager();
        RoundMechanic roundMechanic = new RoundMechanic();
        InputMechanic inputMechanic = new InputMechanic();
        System.out.println(pizzeriaManager.getEnemyManager().getEnemyMap().get(EnemyName.FREDDY).getLevel());
        printMap();

        for (int i = 1; i <= 20 ; i++) {
            roundMechanic.startRound(i,pizzeriaManager.getPizzeria());
//            pizzeriaManager.getPizzeria().getRoomMap().get(RoomName.OFFICE).setCamera()

        }
        GameInformation gameInformation = new GameInformation();
        gameInformation.print6AM();

    }
}
