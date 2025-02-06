package Game.text_message;

/**
 * Informiere den Spieler über die wichtigsten Teile der Geschichte.
 * Nutze die Methode {@link #printExplainingText()}
 */
public class GameInformation
{
    /**
     * Gebe auf der Konsole die Geschichte des Spiels aus.
     * Nutze hierfür die standard print Methode.
     */
    public static void printExplainingText()
    {
        System.out.println("Your Name is Mike Schmidt, you are working for Freddy Fazbear´s Pizza as the night Guard.");
        System.out.println("Freddy Fazbear´s Pizza, is a successful family restaurant, its secret are their mascots that are loved by children.");
        System.out.println("However during the night the animatronic mascots Freddy, Bonnie, Chica and Foxy become hostile.");
        System.out.println("They start roaming the building, if they find you, they mistake you for an endoskeleton without a suit.");
        System.out.println("The animatronics try to forcefully stuff you into a suit, killing you in the process.");
        System.out.println();
        System.out.println("Your goal is it to survive the night till 6am (all 20 rounds) and leave the place alive.");
        System.out.println();
        System.out.println("");
    }

    public void printCommands()
    {
        System.out.println("1.Skip\t 2.Use Camera\t 3.Close Doors\t 4.Print Map\t 5.Exit Game");
    }

    private void printRoundNumber(int roundNumber)
    {
        RoundArt roundArt = new RoundArt();
        switch (roundNumber) {
            case 1:
                System.out.print(roundArt.round01);
                break;
            case 2:
                System.out.print(roundArt.round02);
                break;
            case 3:
                System.out.print(roundArt.round03);
                break;
            case 4:
                System.out.print(roundArt.round04);
                break;
            case 5:
                System.out.print(roundArt.round05);
                break;
            case 6:
                System.out.print(roundArt.round06);
                break;
            case 7:
                System.out.print(roundArt.round07);
                break;
            case 8:
                System.out.print(roundArt.round08);
                break;
            case 9:
                System.out.print(roundArt.round09);
                break;
            case 10:
                System.out.print(roundArt.round10);
                break;
            case 11:
                System.out.print(roundArt.round11);
                break;
            case 12:
                System.out.print(roundArt.round12);
                break;
            case 13:
                System.out.print(roundArt.round13);
                break;
            case 14:
                System.out.print(roundArt.round14);
                break;
            case 15:
                System.out.print(roundArt.round15);
                break;
            case 16:
                System.out.print(roundArt.round16);
                break;
            case 17:
                System.out.print(roundArt.round17);
                break;
            case 18:
                System.out.print(roundArt.round18);
                break;
            case 19:
                System.out.print(roundArt.round19);
                break;
            case 20:
                System.out.print(roundArt.round20);
                break;
        }
    }

    public void printRoundHeader(int roundNumber)
    {
        System.out.println("╔══════════════════════════════════════════════════════════════════════════");
        printRoundNumber(roundNumber);
        System.out.println("╚══════════════════════════════════════════════════════════════════════════");
    }

    public void printBonnieInCloset()
    {
        RoomArt roomArt = new RoomArt();
        roomArt.printBonnieInsideCloset();

    }

    public static void print6AM()
    {
        System.out.println("""
                ░▒▓████████▓▒░░▒▓███████▓▒░      ░▒▓████████▓▒░▒▓████████▓▒░       ░▒▓██████▓▒░░▒▓██████████████▓▒░ \s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓██▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓██▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░       ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓██▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░\s
                ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓██▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░\s
                ░▒▓████████▓▒░░▒▓██████▓▒░       ░▒▓████████▓▒░▒▓████████▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░\s
                                                                                                                  \s
                """);
    }
}
//╔════════════════════╗
//╚════════════════════╝
