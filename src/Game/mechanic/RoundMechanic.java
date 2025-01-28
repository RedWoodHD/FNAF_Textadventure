package Game.mechanic;

import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.factor.UserInput;
import Game.object.Enemy;
import Game.object.Pizzeria;
import Game.text_message.Color;
import Game.text_message.GameInformation;
import Game.text_message.RoomArt;

public class RoundMechanic
{
    public void startRound(int roundNumber, Pizzeria pizzeria)
    {
//        Alle Gegner Variablen zuweisen um diese besser zu nutzen.
        Color colors = new Color();
        GameInformation gameInformation = new GameInformation();
        Enemy freddy = pizzeria.getEnemy(EnemyName.FREDDY);
        Enemy bonnie = pizzeria.getEnemy(EnemyName.BONNIE);
        Enemy chica = pizzeria.getEnemy(EnemyName.CHICA);
        Enemy foxxy = pizzeria.getEnemy(EnemyName.FOXXY);

//        Make Everyone walk his way to the door
        if (roundNumber > 3){
//            Gegner bewegen sich
//            System.out.println(roundNumber+"WTFFF");
            freddy.makeFreddyMoveToHisNextRoom();
            bonnie.makeBonnieMoveToHisNextRoom();
            chica.makeChicaMoveToHerNextRoom();
            foxxy.increaseFoxxysNextStage();
        }


//        Printe Mapstatus
        gameInformation.printRoundHeader(roundNumber);

//        gameInformation.printBonnieInCloset();
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft() - 2);
        System.out.println("Energylevel: " + pizzeria.getEnergyLeft());

        InputMechanic inputMechanic = new InputMechanic();
        reactToUserInput();

        if (bonnie.getMyRoomsName().equals(RoomName.SUPPLYCLOSET)){
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
    public void reactToUserInput(){
        InputMechanic inputMechanic = new InputMechanic();
        String userInput = inputMechanic.askUserForHisMove();

        if (UserInput.interpretUserInput(userInput) != null){
            System.out.println("Right Input my Friend!");
            if (userInput.equalsIgnoreCase(UserInput.SKIP.toString())){
                return;
            }
            if (userInput.equalsIgnoreCase(UserInput.USE_CAMERA.toString())){

            }
        }
        else
        {
            System.out.println("Wrong Input my Friend");
        }
    }
    /**
     * Diese Methode wird genutzt, um einen Zufällig generierten {@link boolean} zu erzeugen.<br>
     * Dafür wird die {@link Math#random()} Methode genutzt um eine zufällige Zahl zwischen 1 und 2 zu berechnen.
     *
     * @return Gebe {@link true} zurück, wenn die zufällige Zahl 1 ist, ansonsten gebe {@link false} zurück.
     */
    public static boolean randomBoolean()
    {
        if ((int) (Math.random() * 2) + 1 == 1) {
            return true;
        } else return false;
    }
}
