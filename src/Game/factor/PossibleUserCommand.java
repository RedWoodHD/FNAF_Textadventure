package Game.factor;

/**
 * Diese Klasse representiert alle erlaubten Nutzereingaben mit Aliasen.
 */
public enum PossibleUserCommand
{
    SKIP("Skip", " Skip Round", "1"),
    USE_CAMERA("Use Camera", "Camera", "Open Camera" , "2"),
    CLOSEDOORS("Close Door", " Close Doors", "3"),
    PRINTMAP("Print Map", "Map", "4"),
    EXIT_GAME("Exit Game","Leave", "Exit", "5");

    private final String[] commandAliases;

    PossibleUserCommand(String... commandAliases)
    {
        this.commandAliases = commandAliases;
    }

    public String[] getCommandAliases()
    {
        return commandAliases;
    }

    /**
     * Diese Methode überprüft einen {@link String userInput} und gibt den entsprechenden Befehl zurück.<br>
     * Sie überprüft nach alle Aliasen der möglichen {@link PossibleUserCommand} und gibt diesen Zurück.<br>
     * Sollte keiner gefunden werden wird {@code null} zurückgegeben.
     * @param userInput Die Eingabe des Benutzers als {@link String}.
     * @return Den {@link PossibleUserCommand} oder {@code null}.
     */

    public static PossibleUserCommand interpretUserInput(String userInput)
    {
        PossibleUserCommand[] allComands = PossibleUserCommand.values();
        for(PossibleUserCommand command : allComands)
        {
            for(String commandAlias : command.getCommandAliases())
            {
                if(commandAlias.equalsIgnoreCase(userInput))
                {
                    return command;
                }
            }
        }
        return null;
    }
}
