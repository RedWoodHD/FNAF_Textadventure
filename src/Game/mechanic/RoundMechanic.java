package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.PossibleUserCommands;
import Game.factor.RoomName;
import Game.manager.CameraManager;
import Game.manager.EnemyManager;
import Game.manager.PizzeriaManager;
import Game.manager.RoomManager;
import Game.object.Player;
import Game.text_message.Color;
import Game.text_message.GameInformation;

public class RoundMechanic
{
    private final PizzeriaManager pizzeriaManager;

    public RoundMechanic(PizzeriaManager pizzeriaManager)
    {
        this.pizzeriaManager = pizzeriaManager;
    }

    public void startRound(int roundNumber, Player player)
    {

        Color colors = new Color();
        RoomManager roomManager = pizzeriaManager.getRoomManager();
        EnemyManager enemyManager = pizzeriaManager.getEnemyManager();
        CameraManager  cameraManager = pizzeriaManager.getCameraManager();
        roomManager.setEnemyManager(enemyManager);
        GameInformation gameInformation = new GameInformation();
        if (roundNumber == 1){
            roomManager.addEnemyToRoom(EnemyName.FREDDY, RoomName.SHOWSTAGE);
            roomManager.addEnemyToRoom(EnemyName.BONNIE, RoomName.SHOWSTAGE);
            roomManager.addEnemyToRoom(EnemyName.CHICA, RoomName.SHOWSTAGE);
            roomManager.addEnemyToRoom(EnemyName.FOXXY, RoomName.PIRATECOVE);
        }

//        Make Everyone walk his way to the door

//        Printe Mapstatus
        gameInformation.printRoundHeader(roundNumber);

//        gameInformation.printBonnieInCloset();
        pizzeriaManager.decreasePizzeriaEnergyLevel();
        System.out.println("Energylevel: " + pizzeriaManager.getPizzeria().getEnergyLeft());

        InputMechanic inputMechanic = new InputMechanic();
        reactToUserInput(cameraManager,pizzeriaManager,inputMechanic, enemyManager);

        if (roundNumber > 3)
        {
//            Gegner bewegen sich
            enemyManager.moveEveryEnemyOneFurther(roomManager,player);
            if (enemyManager.getEnemy(EnemyName.FOXXY).getWhereAmI().getPirateCoveOpeningStage() == 4){
                System.out.println(EnemyName.FOXXY+" killed you!");
                player.setAlive(false);
            }
        }

    }

    public void reactToUserInput(CameraManager cameraManager, PizzeriaManager pizzeriaManager, InputMechanic inputMechanic, EnemyManager enemyManager)
    {
        String userInput = inputMechanic.askUserForHisMove();
        PossibleUserCommands possibleUserCommands = PossibleUserCommands.interpretUserInput(userInput);
        if (possibleUserCommands != null)
        {
            switch (possibleUserCommands)
            {
                case SKIP -> handleSkipCommand(cameraManager);
                case USE_CAMERA -> handleUseCameraCommand(cameraManager, pizzeriaManager, inputMechanic, enemyManager);
                case CLOSE_LEFT_DOOR -> handleCloseLeftDoorCommand();
                case CLOSE_RIGHT_DOOR -> handleCloseRightDoorCommand();
                case EXIT_GAME -> handleExitGameCommand();
            }
        }
        else
        {
            System.out.println("Wrong Input");
        }
    }

    private void handleExitGameCommand()
    {

    }

    private void handleCloseRightDoorCommand()
    {
    }

    private void handleCloseLeftDoorCommand()
    {
    }

    private void handleUseCameraCommand(CameraManager cameraManager, PizzeriaManager pizzeriaManager,InputMechanic inputMechanic,EnemyManager enemyManager)
    {
        cameraManager.printCameraAccess();
        cameraManager.useChosenCamera(inputMechanic.askUserForCameraUse(),pizzeriaManager.getPizzeria(),enemyManager);
        pizzeriaManager.decreasePizzeriaEnergyLevel();
    }

    private void handleSkipCommand(CameraManager cameraManager)
    {
        cameraManager.resetTablet();
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
