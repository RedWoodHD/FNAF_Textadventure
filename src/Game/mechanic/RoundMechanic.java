package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.factor.PossibleUserCommands;
import Game.manager.EnemyManager;
import Game.manager.PizzeriaManager;
import Game.object.Enemy;
import Game.object.Pizzeria;
import Game.text_message.Color;
import Game.text_message.GameInformation;
import Game.text_message.RoomArt;

public class RoundMechanic
{
    private final EnemyManager enemyManager;

    public RoundMechanic(EnemyManager enemyManager)
    {
        this.enemyManager = enemyManager;
    }

    public void startRound(int roundNumber,Pizzeria pizzeria)
    {
//        Alle Gegner Variablen zuweisen um diese besser zu nutzen.
        Color colors = new Color();
        GameInformation gameInformation = new GameInformation();
        Enemy freddy = pizzeria.getEnemy(EnemyName.FREDDY);
        Enemy bonnie = pizzeria.getEnemy(EnemyName.BONNIE);
        Enemy chica = pizzeria.getEnemy(EnemyName.CHICA);
        Enemy foxxy = pizzeria.getEnemy(EnemyName.FOXXY);

//        Make Everyone walk his way to the door
        if (roundNumber > 3)
        {
//            Gegner bewegen sich

            freddy.makeFreddyMoveToHisNextRoom();
            bonnie.makeBonnieMoveToHisNextRoom();
            chica.makeChicaMoveToHerNextRoom();
            foxxy.increaseFoxxysNextStage();

            freddy.getWhereAmI().setWhatEnemyIsInsideMe(freddy);
            bonnie.getWhereAmI().setWhatEnemyIsInsideMe(bonnie);
            chica.getWhereAmI().setWhatEnemyIsInsideMe(chica);
            foxxy.getWhereAmI().setWhatEnemyIsInsideMe(foxxy);

        }

//        Printe Mapstatus
        gameInformation.printRoundHeader(roundNumber);

//        gameInformation.printBonnieInCloset();
        getPizzeria().setEnergyLeft(getPizzeria().getEnergyLeft() - 2);
        System.out.println("Energylevel: " + getPizzeria().getEnergyLeft());

        InputMechanic inputMechanic = new InputMechanic();
        reactToUserInput();

        if (bonnie.getMyRoomsName().equals(RoomName.SUPPLYCLOSET))
        {
            RoomArt roomArt = new RoomArt();
            roomArt.printBonnieInsideCloset();
        }
//

//        Printe alle Positionen
//        System.out.print(red + freddy.getName() + reset + "Befindet sich in:  " + red + freddy.getMyRoomsName() + reset);
//        System.out.println(" "+freddy.isHaveIBeenObserved());
//        System.out.print(red + bonnie.getName() + reset + "Befindet sich in:  " + red + bonnie.getMyRoomsName() + reset);
//        System.out.println(" "+bonnie.isHaveIBeenObserved());
//        System.out.print(red + chica.getName() + reset + "Befindet sich in:  " + red + chica.getMyRoomsName() + reset);
//        System.out.println(" "+chica.isHaveIBeenObserved());
//        System.out.print(red + foxxy.getName() + reset + "Befindet sich in:  " + red + foxxy.getWhereAmI().getPirateCoveOpeningStage() + reset);
//        System.out.println(" "+foxxy.isHaveIBeenObserved());
    }

    public void reactToUserInput()
    {
        InputMechanic inputMechanic = new InputMechanic();
        String userInput = inputMechanic.askUserForHisMove();

        PossibleUserCommands possibleUserCommands = PossibleUserCommands.interpretUserInput(userInput);
        if (possibleUserCommands != null)
        {
            switch (possibleUserCommands)
            {
                case SKIP -> handleSkipCommand();
                case USE_CAMERA -> handleUseCameraCommand();
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

    private void handleUseCameraCommand()
    {
    }

    private void handleSkipCommand()
    {
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
