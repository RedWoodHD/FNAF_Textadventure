package Game.mechanic;

import Game.factor.EnemyName;
import Game.factory.CameraFactory;
import Game.factory.EnemyFactory;
import Game.factory.RoomFactory;
import Game.manager.EnemyManager;
import Game.manager.PizzeriaManager;
import Game.manager.RoomManager;
import Game.text_message.GameInformation;

import static Game.text_message.Map.printMap;

public class FnafGame
{
    public static void runGame()
    {
        RoomFactory roomFactory = new RoomFactory();
        EnemyFactory enemyFactory = new EnemyFactory(roomFactory.getAllRooms());
        CameraFactory cameraFactory = new CameraFactory(roomFactory.getAllRooms());
        RoomManager roomManager = new RoomManager();
        EnemyManager enemyManager = new EnemyManager();
        RoundMechanic roundMechanic = new RoundMechanic();
        InputMechanic inputMechanic = new InputMechanic();

        printMap();

        for (int i = 1; i <= 20 ; i++) {
            roundMechanic.startRound(i);

        }
        GameInformation gameInformation = new GameInformation();
        gameInformation.print6AM();

    }
}
