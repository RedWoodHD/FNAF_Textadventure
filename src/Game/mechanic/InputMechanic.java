package Game.mechanic;

import Game.factor.PossibleUserCommands;
import Game.text_message.GameInformation;

import java.util.Scanner;

public class InputMechanic
{
    /**
     *
     */
    public String askUserForHisMove(){
        Scanner scanner = new Scanner(System.in);
        GameInformation gameInformation = new GameInformation();
        PossibleUserCommands userInput = null;
        gameInformation.printCommands();
//        System.out.println("Wie möchten Sie reagieren?");
//        String userConsoleInput = scanner.nextLine();
//        UserInput.interpretUserInput(userConsoleInput);
//        if (UserInput.interpretUserInput(userConsoleInput) != null){
//            System.out.println("You will exit now!");
//        }
        return scanner.nextLine();
    }

    public int askUserForCameraUse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose you Camera! (!Use Numbers only!)");
        return scanner.nextInt();
    }
}
