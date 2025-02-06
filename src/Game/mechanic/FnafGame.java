package Game.mechanic;

import Game.factor.CameraName;
import Game.factory.PizzeriaFactory;
import Game.manager.CameraManager;
import Game.manager.EnemyManager;
import Game.manager.PizzeriaManager;
import Game.manager.RoomManager;
import Game.object.Player;
import Game.object.Tablet;
import Game.text_message.GameInformation;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static Game.text_message.Map.printMap;

public class FnafGame
{
    public static void runGame()
    {
        Player player = new Player();

            Tablet tablet = new Tablet();
            while (player.getTablet() == null)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("To start the game, press any button to pick up the Tablet!");
                try{
                    scanner.nextLine();
                    player.setTablet(tablet);
                    GameInformation.printExplainingText();
                }
                catch (NoSuchElementException e){
                    System.out.println("Nuhhh uhhh, Gonna start anyway :D");
                    player.setTablet(tablet);
                    GameInformation.printExplainingText();
                }
            }
//        Factory
            PizzeriaFactory pizzeriaFactory = new PizzeriaFactory();
//        Manager
            RoomManager roomManager = new RoomManager(pizzeriaFactory.getPizzeria().getRoomMap());
            EnemyManager enemyManager = new EnemyManager(pizzeriaFactory.getPizzeria().getEnemyMap());
            CameraManager cameraManager = new CameraManager(pizzeriaFactory.getPizzeria().getRoomMap(), pizzeriaFactory.getPizzeria().getCameraMap(), tablet.setWhatCameraDoILookAt(pizzeriaFactory.getPizzeria().getCameraMap().get(CameraName.FREECAM)));
            PizzeriaManager pizzeriaManager = new PizzeriaManager(pizzeriaFactory.getPizzeria(), roomManager, enemyManager, cameraManager);
//        Machanic
            RoundMechanic roundMechanic = new RoundMechanic(pizzeriaManager);
            InputMechanic inputMechanic = new InputMechanic();
            for (int i = 1; i <= 20; i++)
            {
                if (player.isAlive()){
                    roundMechanic.startRound(i,player);
                } else {
                    return;
                }
            }
        GameInformation.print6AM();
        }
}
