package Game.text_message;

import static Game.mechanic.InputMechanic.toBeContinued;
import static Game.text_message.Color.*;

public class DeathMessages
{


    public static void FreedysKill(){
        System.out.println("=============================================================================================");
        System.out.println("============================================================================================="+red);
        System.out.println("You are hearing music playing, it's a calm friendly melody, probably played a lot for kids.");
        System.out.println();
        System.out.println("You are feeling a big relief, while also wondering where its coming from.");
        System.out.println();
        System.out.println("The lights are turning off, it's pitch black right now.");
        System.out.println();
        System.out.println("You are seeing 2 eyes twinkling inside the left door.");
        System.out.println();
        System.out.println("It's Freddy staring into your soul. He somehow has a relaxing impact on you.");
        System.out.println(reset+"=============================================================================================");
        System.out.println("=============================================================================================");
        toBeContinued();
        System.out.println(grey+"You are feeling tired and close your eyes");
        System.out.println("The last moment you have of your life is the calming music playing."+reset);
        System.out.println();
        youDiedMessage();
    }

    public static void BonniesKill()
    {
        System.out.println("=============================================================================================");
        System.out.println("============================================================================================="+red);
        System.out.println("You are feeling positive about surviving the night.");
        System.out.println();
        System.out.println("You are pretty confident to have everyone under your control.");
        System.out.println();
        System.out.println("You are wondering where Bonnie could be, you haven't seen him in a while.");
        System.out.println();
        System.out.println("You are not to worried about him because he is easy to handle and barely even movens around.");
        System.out.println();
        System.out.println("You didn't realise, Boonie is already at your door recognizing you as his victim.");
        System.out.println(reset+"=============================================================================================");
        System.out.println("=============================================================================================");
        toBeContinued();
        System.out.println(grey+"You didn't even see it coming.");
        System.out.println("The last moment you have of your life is just red, everything is red and you only hear something screaming at you."+reset);
        System.out.println();
        youDiedMessage();
    }

    public static void ChicasKill(){
        System.out.println("=============================================================================================");
        System.out.println("============================================================================================="+red);
        System.out.println("You are seeing Chica entering your office.");
        System.out.println();
        System.out.println("You are pretty confused, because she is brining a cupcake to you.");
        System.out.println();
        System.out.println("You are thinking, is this over now, could she really try to be friends with me.");
        System.out.println();
        System.out.println("You are smiling believing to finally be friends with them.");
        System.out.println();
        System.out.println("You didn't understand, that she just holds it on her plate.");
        System.out.println(reset+"=============================================================================================");
        System.out.println("=============================================================================================");
        toBeContinued();
        System.out.println(grey+"You are trying to taste the sweet sweet cupcake, but it's too late.");
        System.out.println("The last moment you have of your life is you reaching out for the cupcake."+reset);
        System.out.println();
        youDiedMessage();
    }
    public static void FoxxysKill()
    {
        System.out.println("=============================================================================================");
        System.out.println("============================================================================================="+red);
        System.out.println("You are hearing loud steps running towards you.");
        System.out.println();
        System.out.println("You are feeling the fear rising inside your Body.");
        System.out.println();
        System.out.println("You are reaching out for the close doors button and your tablet slips out of your hands, it gets absolutely shattered.");
        System.out.println();
        System.out.println("You are staring in the hallway, but its already too late.");
        System.out.println();
        System.out.println("You can't move your body, you are feared too much to be able to move.");
        System.out.println(reset+"=============================================================================================");
        System.out.println("=============================================================================================");
        toBeContinued();
        System.out.println(grey+"Your life is fading away in front of you.");
        System.out.println("The last moment you have of your life is Foxxys terrifying scream, while he's jumping into your face."+reset);
        System.out.println();
        youDiedMessage();
    }

    private static void youDiedMessage(){
        System.out.println(red+"""
                 /$$     /$$ /$$$$$$  /$$   /$$       /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$$$$$$  /$$
                |  $$   /$$//$$__  $$| $$  | $$      | $$__  $$|_  $$_/| $$_____/| $$__  $$| $$
                 \\  $$ /$$/| $$  \\ $$| $$  | $$      | $$  \\ $$  | $$  | $$      | $$  \\ $$| $$
                  \\  $$$$/ | $$  | $$| $$  | $$      | $$  | $$  | $$  | $$$$$   | $$  | $$| $$
                   \\  $$/  | $$  | $$| $$  | $$      | $$  | $$  | $$  | $$__/   | $$  | $$|__/
                    | $$   | $$  | $$| $$  | $$      | $$  | $$  | $$  | $$      | $$  | $$   \s
                    | $$   |  $$$$$$/|  $$$$$$/      | $$$$$$$/ /$$$$$$| $$$$$$$$| $$$$$$$/ /$$
                    |__/    \\______/  \\______/       |_______/ |______/|________/|_______/ |__/"""+reset);
    }
}
