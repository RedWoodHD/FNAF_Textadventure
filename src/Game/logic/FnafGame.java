package Game.logic;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.factory.PizzeriaFactory;
import Game.manager.*;
import Game.object.Enemy;
import Game.object.Player;
import Game.object.Room;
import Game.object.Tablet;
import Game.text_message.GameInformation;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static Game.logic.InputLogic.askForNewGame;

/**
 * Diese Klasse representiert das Spiel.<br>
 * Hier wird mit der {@link #runGame()} methode das Spiel gestartet.
 */
public class FnafGame
{

    private static Initializer initialize;
    private static int roundNumber = 1;

    /**
     * Führt das Spiel aus. Das Spiel gilt als gewonnen, wenn der {@link Player Spieler} 20 Runden überlebt.
     */
    public static void runGame()
    {
        initialize = initialize();
        SaveManager saveManager = new SaveManager(initialize.roundLogic.getPizzeriaManager());
        roundNumber = saveManager.loadGameStatus();
        saveManager.loadEnemies();

            while (roundNumber <= 20)
            {
                if (initialize.player().isAlive())
                {
                    initialize.roundLogic().startRound(roundNumber, initialize.player(),saveManager);
                }
                else
                {
                    if (askForNewGame())
                    {
                        saveManager.resetSaveFile();
                        runGame();
                    }
                    else
                    {
                        return;
                    }
                }
                roundNumber++;
            }

            if (initialize.player.isAlive())
            {
                GameInformation.print6AM();
            }
    }

    /**
     * Initialisiert das Spiel und ihre notwendigen Objekte.
     *
     * @return den initializer in dem alle wichtigen Objekte liegen.
     *
     * @author EGA
     */
    private static Initializer initialize()
    {
//        Player & Tablet
            Player player = new Player();
            Tablet tablet = new Tablet();
            runGameStart(player, tablet);
//        Factory
            PizzeriaFactory pizzeriaFactory = new PizzeriaFactory();
//        Manager
            RoomManager roomManager = new RoomManager(pizzeriaFactory.getPizzeria().getRoomMap());
            EnemyManager enemyManager = new EnemyManager(pizzeriaFactory.getPizzeria().getEnemyMap());
            roomManager.setEnemyManager(enemyManager);
            CameraManager cameraManager = new CameraManager(pizzeriaFactory.getPizzeria().getCameraMap(), tablet.setWhatCameraDoILookAt(pizzeriaFactory.getPizzeria().getCameraMap().get(CameraName.FREECAM)));
            PizzeriaManager pizzeriaManager = new PizzeriaManager(pizzeriaFactory.getPizzeria(), roomManager, enemyManager, cameraManager);
//        logic
            RoundLogic roundLogic = new RoundLogic(pizzeriaManager);
            return new Initializer(player, roundLogic);
    }

    private record Initializer(Player player, RoundLogic roundLogic)
    {
    }


    /**
     * Sage dem Benutzer er soll das Spiel starten und eine beliebige Taste drücken.<br>
     * Führe die Methode :{@link GameInformation#printExplainingText() printExplainingText} aus um den Benutzer über das Spiel zu informieren.
     *
     * @param player {@link Player Spieler} um zu schauen, ob er das {@link Tablet} aufgehoben hat.
     * @param tablet {@link Tablet} um dem {@link Player Spieler} das {@link Tablet} zu geben.
     *
     * @author EGA
     */
    private static void runGameStart(Player player, Tablet tablet)
    {
        while (player.getTablet() == null)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("To start the game, press any button to pick up the Tablet!");
            try
            {
                scanner.nextLine();
                player.setTablet(tablet);
                GameInformation.printExplainingText();
            } catch (NoSuchElementException e)
            {
                System.out.println("Nuhhh uhhh, Gonna start anyway :D");
                player.setTablet(tablet);
                GameInformation.printExplainingText();
            }
        }
    }

    public Map<RoomName, Room> getRoomMap()
    {
        return initialize.roundLogic().getPizzeriaManager().getPizzeria().getRoomMap();
    }

    public Map<EnemyName, Enemy> getEnemyMap()
    {
        return initialize.roundLogic().getPizzeriaManager().getEnemyManager().getEnemyMap();
    }

    public static int getRoundNumber()
    {
        return roundNumber;
    }

    public static void setRoundNumber(int roundNumber)
    {
        FnafGame.roundNumber = roundNumber;
    }
}
