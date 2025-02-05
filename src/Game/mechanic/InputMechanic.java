package Game.mechanic;

import Game.factor.PossibleUserCommands;
import Game.text_message.GameInformation;

import java.util.NoSuchElementException;
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
        try
        {
            return scanner.nextLine();
        } catch (NoSuchElementException e)
        {
            System.out.println("!WRONG INPUT!");
        }
        return "";
    }

    public int askUserForCameraUse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose you Camera! (!Use Numbers only!)");
        try
        {
            return scanner.nextInt();
        }
        catch (NoSuchElementException e){
            System.out.println("!WRONG INPUT!");
        }
        return 0;
    }
}
