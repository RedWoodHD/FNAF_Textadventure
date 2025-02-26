package Game.logic;

import Game.factor.PossibleUserCommand;
import Game.text_message.GameInformation;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputLogic
{
    /**
     * Diese Methode liefert eine {@link String Benutzereingabe} zurück.
     * Es werden erst die {@link PossibleUserCommand Möglichen Benutzereingaben} auf der Konsole ausgegeben und dann wird eingelesen was der Benutzer eingibt.
     */
    public String askUserForHisMove(){
        Scanner scanner = new Scanner(System.in);
        GameInformation gameInformation = new GameInformation();
        PossibleUserCommand userInput = null;
        gameInformation.printCommands();
        try
        {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e)
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
        catch (NoSuchElementException | IllegalStateException e){
            System.out.println("!WRONG INPUT!");
        }
        return 0;
    }

    /**
     * Diese Methode fragt den Benutzer ob er ein neues Spiel spielen möchten und gibt entweder {@link true} oder {@link false} zurück.
     * @return {@link true} bei Yes und {@link false} bei nein.
     */
    public static boolean askForNewGame(){
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.println("Do you want to play a new game?");
            System.out.println("1.Yes\t 2.No");
            String userInput =scanner.nextLine();
            if (userInput.equalsIgnoreCase("Yes") || userInput.equalsIgnoreCase("1")){
                return true;
            }
            else return false;
        } catch (NoSuchElementException | IllegalStateException e){
            System.out.println("Don't do that!");
            return false;
        }
    }

    /**
     * Diese Methode liest eine Konsolen eingabe ein und macht nichts mir dieser.
     * Der Sinn dahinter ist es eine art delay einzubauen damit der Benutzer den Text lesen kann und dann mit einer beliebigen eingabe weiter zu machen.
     */
    public static void toBeContinued(){
        Scanner scanner = new Scanner(System.in);
        try
        {
            scanner.nextLine();
        }
        catch (NoSuchElementException | IllegalStateException e){
            System.out.println("Don't do that!");
        }

    }
}
