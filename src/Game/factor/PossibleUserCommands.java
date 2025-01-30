package Game.factor;

public enum PossibleUserCommands
{
    SKIP("Skip", " Skip Round", "1"),
    USE_CAMERA("Use Camera", "Camera", "Open Camera" , "2"),
    CLOSE_LEFT_DOOR("Close Left Door", " Close Left", " 3"),
    CLOSE_RIGHT_DOOR("Close Right Door", " Close Right", "4"),
    EXIT_GAME("Exit Game","Leave", "Exit", "5");

    private final String[] commandAliases;

    PossibleUserCommands(String... commandAliases)
    {
        this.commandAliases = commandAliases;
    }

    public String[] getCommandAliases()
    {
        return commandAliases;
    }

    public static PossibleUserCommands interpretUserInput(String userInput)
    {
        PossibleUserCommands[] allComands = PossibleUserCommands.values();
        for(PossibleUserCommands command : allComands)
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
