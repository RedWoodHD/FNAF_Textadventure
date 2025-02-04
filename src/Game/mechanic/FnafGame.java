package Game.mechanic;

import Game.factor.CameraName;
import Game.factory.PizzeriaFactory;
import Game.manager.CameraManager;
import Game.manager.EnemyManager;
import Game.manager.PizzeriaManager;
import Game.manager.RoomManager;
import Game.object.Player;
import Game.object.Tablet;

import static Game.text_message.Map.printMap;

public class FnafGame
{
    public static void runGame()
    {
        Player player = new Player();
        Tablet tablet = new Tablet();
        if (player.getTablet() == null){
            System.out.println("To start the game, pick up the Tablet!");
        }
        player.setTablet(tablet);
//        Factory
        PizzeriaFactory pizzeriaFactory = new PizzeriaFactory();
//        Manager
        RoomManager roomManager = new RoomManager(pizzeriaFactory.getPizzeria().getRoomMap());
        EnemyManager enemyManager = new EnemyManager(pizzeriaFactory.getPizzeria().getEnemyMap());
        CameraManager cameraManager = new CameraManager(pizzeriaFactory.getPizzeria().getRoomMap(), pizzeriaFactory.getPizzeria().getCameraMap(),tablet.setWhatCameraDoILookAt(pizzeriaFactory.getPizzeria().getCameraMap().get(CameraName.FREECAM)));
        PizzeriaManager pizzeriaManager = new PizzeriaManager(pizzeriaFactory.getPizzeria(), roomManager, enemyManager, cameraManager);
//        Machanic
        RoundMechanic roundMechanic = new RoundMechanic(pizzeriaManager);
        InputMechanic inputMechanic = new InputMechanic();
        printMap();
        for (int i = 1; i <= 20; i++)
        {
            roundMechanic.startRound(i);
        }
    }
}
