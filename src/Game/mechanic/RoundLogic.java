package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.PossibleUserCommand;
import Game.factor.RoomName;
import Game.manager.CameraManager;
import Game.manager.EnemyManager;
import Game.manager.PizzeriaManager;
import Game.manager.RoomManager;
import Game.object.Player;
import Game.text_message.Color;
import Game.text_message.DeathMessage;
import Game.text_message.GameInformation;
import Game.text_message.Map;

import static Game.text_message.Color.*;

public class RoundLogic
{
    private final PizzeriaManager pizzeriaManager;

    public RoundLogic(PizzeriaManager pizzeriaManager)
    {
        this.pizzeriaManager = pizzeriaManager;
    }

    public void startRound(int roundNumber, Player player)
    {

        Color colors = new Color();
        RoomManager roomManager = pizzeriaManager.getRoomManager();
        EnemyManager enemyManager = pizzeriaManager.getEnemyManager();
        CameraManager cameraManager = pizzeriaManager.getCameraManager();
        roomManager.setEnemyManager(enemyManager);
        GameInformation gameInformation = new GameInformation();
        if (roundNumber == 1)
        {
            roomManager.addEnemyToRoom(EnemyName.FREDDY, RoomName.SHOWSTAGE);
            roomManager.addEnemyToRoom(EnemyName.BONNIE, RoomName.SHOWSTAGE);
            roomManager.addEnemyToRoom(EnemyName.CHICA, RoomName.SHOWSTAGE);
            roomManager.addEnemyToRoom(EnemyName.FOXXY, RoomName.PIRATECOVE);
        }

//        Make Everyone walk his way to the door

//        Printe Mapstatus
        gameInformation.printRoundHeader(roundNumber);

//        gameInformation.printBonnieInCloset();
        pizzeriaManager.decreasePizzeriaEnergyLevel(2);
        if (pizzeriaManager.getPizzeria().getEnergyLeft() > 0)
        {
            System.out.println("Energylevel: " + pizzeriaManager.getPizzeria().getEnergyLeft());
        }
        else
        {
            System.out.println(red + "NO ENERGY" + reset);
        }

        InputLogic inputMechanic = new InputLogic();
        reactToUserInput(cameraManager, pizzeriaManager, inputMechanic, enemyManager, player);


        if (roundNumber > 3)
        {
//            Gegner bewegen sich
            enemyManager.moveEveryEnemyOneFurther(roomManager, player);
            if (enemyManager.getEnemy(EnemyName.FOXXY).getWhereAmI().getPirateCoveOpeningStage() >= 4)
            {
                DeathMessage.FoxxysKill();
                player.setAlive(false);
            }
        }
        roomManager.openDoors();
    }

    public void reactToUserInput(
            CameraManager cameraManager,
            PizzeriaManager pizzeriaManager,
            InputLogic inputMechanic,
            EnemyManager enemyManager,
            Player player)
    {
        RoomManager roomManager = pizzeriaManager.getRoomManager();
        int pizzeriaEnergyLeft = pizzeriaManager.getPizzeria().getEnergyLeft();

        String userInput = inputMechanic.askUserForHisMove();
        PossibleUserCommand possibleUserCommands = PossibleUserCommand.interpretUserInput(userInput);
        if (possibleUserCommands != null)
        {
            if (pizzeriaEnergyLeft > 0)
            {
                switch (possibleUserCommands)
                {
                    case SKIP -> handleSkipCommand(cameraManager, enemyManager, roomManager);
                    case USE_CAMERA ->
                            handleUseCameraCommand(cameraManager, pizzeriaManager, inputMechanic, enemyManager);
                    case CLOSEDOORS -> handleCloseDoorsCommand(roomManager, pizzeriaManager, cameraManager);
                    case PRINTMAP ->
                            handlePrintMapCommand(cameraManager, pizzeriaManager, inputMechanic, enemyManager, player);
                    case EXIT_GAME -> handleExitGameCommand(player);
                }
            }
            else
            {
                if (possibleUserCommands == PossibleUserCommand.SKIP)
                {
                    handleSkipCommand(cameraManager, enemyManager, roomManager);
                }
                else
                {
                    System.out.println("You have no Energy left, you can only skip!");
                }
            }
        }
        else
        {
            System.out.println("Wrong Input");
        }
    }

    private void handlePrintMapCommand(CameraManager cameraManager, PizzeriaManager pizzeriaManager, InputLogic inputMechanic, EnemyManager enemyManager, Player player)
    {
        Map.printMap();
        reactToUserInput(cameraManager, pizzeriaManager, inputMechanic, enemyManager, player);
    }

    private void handleSkipCommand(CameraManager cameraManager, EnemyManager enemyManager, RoomManager roomManager)
    {
        System.out.println(blue + "Round skipped" + reset);
        roomManager.printEnemiesNextToOffice(enemyManager);
        cameraManager.resetTabletsCameraAccess();
    }

    private void handleCloseDoorsCommand(RoomManager roomManager, PizzeriaManager pizzeriaManager, CameraManager cameraManager)
    {
        roomManager.closeDoors();
        pizzeriaManager.decreasePizzeriaEnergyLevel(15);
        cameraManager.resetTabletsCameraAccess();
    }

    private void handleExitGameCommand(Player player)
    {
        player.setAlive(false);
    }

    private void handleUseCameraCommand(CameraManager cameraManager, PizzeriaManager pizzeriaManager, InputLogic inputMechanic, EnemyManager enemyManager)
    {
        cameraManager.printCameraAccess();
        cameraManager.useChosenCamera(inputMechanic.askUserForCameraUse(), pizzeriaManager.getPizzeria(), enemyManager);
        pizzeriaManager.decreasePizzeriaEnergyLevel(2);
    }

    /**
     * Diese Methode wird genutzt, um einen Zufällig generierten {@link boolean} zu erzeugen.<br>
     * Dafür wird die {@link Math#random()} Methode genutzt um eine zufällige Zahl zwischen 1 und 2 zu berechnen.
     *
     * @return Gebe {@link true} zurück, wenn die zufällige Zahl 1 ist, ansonsten gebe {@link false} zurück.
     */
    public static boolean randomBoolean()
    {
        if ((int) (Math.random() * 2) + 1 == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
