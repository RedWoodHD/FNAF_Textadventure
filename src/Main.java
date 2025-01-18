import Game.Main.FnafGame;

import java.util.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main
{

    final static String red = "\u001b[31m";
    final static String green = "\u001b[32m";
    final static String yellow = "\u001b[33m";
    final static String blue = "\u001b[34m";
    final static String magenta = "\u001b[35m";
    final static String cyan = "\u001b[36m";
    final static String grey = "\u001b[37m";

    final static String reset = "\u001b[0m";

    public static void main(String[] args)
    {
        FnafGame.runGame();


        Pizzeria pizzeria = createPizzaria();
        pizzeria = startGame(pizzeria);
        Tablet gameTablet = new Tablet();
        Player userCharacter = new Player();
        userCharacter.setTablet(gameTablet);

    }


    private static Pizzeria startGame(Pizzeria pizzeria)
    {
        explainingText();
        printMap();
        showCommands();

        Scanner scanner = new Scanner(System.in);

        boolean isGameOver = false;
        int i = 0;
        while (!isGameOver) {
            i++;
            if (i > 20) {
                System.out.println();
                System.out.println("!!! YOU WON !!!");
                isGameOver = true;
                break;
            }
            System.out.println("Round" + i + " Move: ");
            String userInput = scanner.nextLine();

            pizzeria = roundMoveOfAllEnemy(pizzeria);

            if (pizzeria.getAllEnemies().getFirst().getName().equals("Freddy")) {
//                System.out.println("You are facing: "+ pizzeria.getAllEnemies().getFirst().getName());
            }
        }
        return pizzeria;
    }


    private static Pizzeria roundMoveOfAllEnemy(Pizzeria pizzeria)
    {
        boolean freddy = pizzeria.getAllEnemies().getFirst().canIMove();
        boolean boonie = pizzeria.getAllEnemies().get(2).canIMove();
        boonie = true;
        boolean chica = pizzeria.getAllEnemies().get(3).canIMove();
        boolean foxxy = pizzeria.getAllEnemies().getLast().canIMove();
        pizzeria.getAllEnemies().getLast().getWhereAmI().setPirateCoveOpeningStage(1);

        if (freddy) {
            pizzeria.getAllEnemies().getFirst().setWhereAmI(moveToNextRoom(pizzeria, "Freddy"));
            System.out.println(red + "" + pizzeria.getAllEnemies().getFirst().getName() + "" + reset + " is currenty in: " + magenta + "" + pizzeria.getAllEnemies().getFirst().getWhereAmI().getRoomName() + "" + reset + ".");
        }
        if (boonie) {
            pizzeria.getAllEnemies().get(1).setWhereAmI(moveToNextRoom(pizzeria, "Boonie"));
            System.out.println(red + "" + pizzeria.getAllEnemies().get(1).getName() + "" + reset + " is currenty in: " + magenta + "" + pizzeria.getAllEnemies().get(1).getWhereAmI().getRoomName() + "" + reset + ".");
        }
        if (chica) {
            pizzeria.getAllEnemies().get(2).setWhereAmI(moveToNextRoom(pizzeria, "Chica"));
            System.out.println(red + "" + pizzeria.getAllEnemies().get(2).getName() + "" + reset + " is currenty in: " + magenta + "" + pizzeria.getAllEnemies().get(2).getWhereAmI().getRoomName() + "" + reset + ".");
        }
        if (foxxy) {
            pizzeria.getAllEnemies().getLast().setWhereAmI(moveToNextRoom(pizzeria, "Foxxy"));
            System.out.println(red + "" + pizzeria.getAllEnemies().getLast().getName() + "" + reset + " is currenty at Stage: " + magenta + "" + pizzeria.getAllEnemies().getLast().getWhereAmI().getPirateCoveOpeningStage() + "" + reset + ".");
        }


        return pizzeria;

    }


    private static Room moveToNextRoom(Pizzeria pizzeria, String enemyName)
    {


        switch (enemyName) {
            case "Freddy":
                return freddysPath(pizzeria.getAllEnemies().getFirst().getWhereAmI());
            case "Boonie":
                return booniesPath(pizzeria.getAllEnemies().get(1).getWhereAmI());
            case "Chica":
                return chicasPath(pizzeria.getAllEnemies().get(2).getWhereAmI());
            case "Foxxy":
//                mache was
                break;

        }


        return pizzeria.getRooms().getLast();
    }


    private static Room freddysPath(Room currentRoom)
    {
        RoomName currentRoomsName = currentRoom.getRoomName();

        switch (currentRoomsName) {

            case RoomName.SHOWSTAGE, RoomName.EASTHALL, RoomName.RESTROOMS:
                return currentRoom.getNextRoom(Direction.SOUTH1);

            case RoomName.DININGAREA:
                return currentRoom.getNextRoom(Direction.EAST);

            case RoomName.KITCHEN, RoomName.EASTHALLCORNER:
                return currentRoom.getNextRoom(Direction.WEST1);

        }
        return currentRoom;
    }


    private static Room booniesPath(Room currentRoom)
    {
        RoomName currentRoomsName = currentRoom.getRoomName();

        System.out.println("Boonie war grade in: " + currentRoomsName);
        switch (currentRoomsName) {

            case RoomName.SHOWSTAGE:
                if (randomBoolean()) {
                    return currentRoom.getNextRoom(Direction.SOUTH1); // Dining Area

                } else {
                    return currentRoom.getNextRoom(Direction.WEST1); // Backstage

                }
            case RoomName.DININGAREA:
                return currentRoom.getNextRoom(Direction.SOUTH1); // West Hall

            case RoomName.BACKSTAGE:
                return currentRoom.getNextRoom(Direction.SOUTH1); // West Hall

            case RoomName.WESTHALL:
                if (randomBoolean()) {
                    return currentRoom.getNextRoom(Direction.SOUTH1); // West Hall Corner

                } else {
                    return currentRoom.getNextRoom(Direction.WEST1); // Supply Closet

                }
            case RoomName.WESTHALLCORNER:
                if (randomBoolean()) {
                    return currentRoom.getNextRoom(Direction.NORTH); // Supply Closet

                } else {
                    return currentRoom.getNextRoom(Direction.EAST); // West Door

                }
            case RoomName.SUPPLYCLOSET:
                return currentRoom.getNextRoom(Direction.EAST); // West Hall

        }
        return currentRoom;
    }

    private static Room chicasPath(Room currentRoom)
    {
        RoomName currentRoomsName = currentRoom.getRoomName();

        switch (currentRoomsName) {

            case RoomName.SHOWSTAGE:
                if (randomBoolean()) {
                    return currentRoom.getNextRoom(Direction.SOUTH1); // Dining Area

                } else {
                    return currentRoom.getNextRoom(Direction.EAST); // Restrooms

                }
            case RoomName.DININGAREA:
                return currentRoom.getNextRoom(Direction.SOUTH3); // Kitchen

            case RoomName.RESTROOMS:
                return currentRoom.getNextRoom(Direction.SOUTH1); // Kitchen

            case RoomName.KITCHEN, RoomName.EASTHALLCORNER:
                return currentRoom.getNextRoom(Direction.WEST1); // East Hall / East Door

            case RoomName.EASTHALL:
                return currentRoom.getNextRoom(Direction.SOUTH1); // East Hall Corner


        }
        return currentRoom;
    }

    private static Room foxxysPath(Room currentRoom)
    {
        return currentRoom.setPirateCoveOpeningStage(+1);
    }

    private static int randomInt()
    {
        int number = (int) (Math.random() * 10) + 1;


        return number;
    }

    private static boolean randomBoolean()
    {
        if ((int) (Math.random() * 2) + 1 == 1) {
            return true;
        } else return false;
    }


    /**
     * Die Methode nimmt 2 Übergabeparameter an und erstellt einen Enemy daraus.
     *
     * @param name             Der Name des Gegners.
     * @param startingPosition Der Raum an dem der Gegner zum Start spawnt.
     * @return Gebe einen vollständigen Enemy zurück ausnahme ohne den Wert "haveIBeenObserved".
     */

    private static Enemy createAnimatronic(String name, Room startingPosition, int level)
    {
        Enemy animatronic = new Enemy();
        animatronic.setName(name);
        animatronic.setWhereAmI(startingPosition);
        animatronic.setLevel(level);
        return animatronic;
    }


    private static void showInformation()
    {
        explainingText();
    }

    private static void explainingText()
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

    private static void showCommands()
    {
        System.out.println("1.Open Tablet\t 2.Exit Tablet\t 3.showCommands\t 4.Exit Game");
    }

    private static void printMap()
    {
        System.out.print(magenta);
        System.out.println("""
                                  ┌──────┐
                                  │CAM 1A├─────────────┐
                                  └─┬────┘             │
                                    │                  │
                   ┌─────┐ ┌────┬───┴──┬───────────────┴─────────┐
                   │     ├─┤    │CAM 1B│                         │ ┌───┐
                   │     ├─┤    └──────┘                         ├─┤ ┌─┴────┐
                ┌──┴───┐ │ │                                     ├─┤ │CAM 7 ├┐
                │CAM 5 │ │ │                                     │ │ └─┬─┬──┘│
                └──┬───┘ │ │                                     │ │   ├─┤   │
                   └─────┘┌┴─────┐                               │ │   │ └───┘
                     ┌────┤CAM 1C│                               │ │   │ ┌───┐
                     │    └┬─────┘                               │ │   ├─┤   │
                     └─────┴───────┬┬─────────────┬┬────┬┬───────┘ └───┘ └───┘
                                 ┌─┴┴─┐         ┌─┴┴─┐ ┌┴┴───────────┐
                        ┌─────┐  │    │         │    │ │        ┌────┴─┐
                     ┌──┴───┐ ├─┬┴────┴┐       ┌┴────┴┐│        │CAM 6 │
                     │CAM 3 │ ├─┤CAM 2A│       │CAM 4A││        └────┬─┘
                     └──┬───┘ │ ├──────┤       ├──────┤└─────────────┘
                        │     │ ├──────┤┌─────┐├──────┤
                        └─────┘ │CAM 2B├┤ YOU ├┤CAM 4B│
                                └┬────┬┴┤  ▓  ├┴┬────┬┘
                                 └────┘ └─────┘ └────┘
                """);
        System.out.print(reset);
// ┼,┬,┴,├,┤,═,║,┌,┐,└,┘,─,│,
    }


    //    Make Feature if 1 Round skipped free chose of cams
    public static void test()
    {
    }

    /**
     * Diese Methode erstellt die ganze Pizzeria mit allen Räumen und Kameras.
     * Gegner werden auch schon erstellt da diese für die Kameras notwendig sind.
     *
     * @return liefere eine vollständige Pizzeria zurück.
     */
    private static Pizzeria createPizzaria()
    {
        Pizzeria pizzeria = new Pizzeria();
        pizzeria.setEnergyLeft(100);

//        Erstelle alle Kameras

        Camera cam1A = new Camera();
        Camera cam1B = new Camera();
        Camera cam1C = new Camera();
        Camera cam5 = new Camera();
        Camera cam7 = new Camera();
        Camera cam6 = new Camera();
        Camera cam4A = new Camera();
        Camera cam4B = new Camera();
        Camera cam2A = new Camera();
        Camera cam2B = new Camera();
        Camera cam3 = new Camera();

        Camera none = new Camera();

//        Erstelle Listen für jede Kamera, um ihr zu sagen, auf welche Kameras sie Zugriff hat.
        List<Camera> wiresCam1A = new ArrayList<>();
        wiresCam1A.add(cam1B);
        wiresCam1A.add(cam1C);
        wiresCam1A.add(cam7);
        cam1A.setConnectedCameras(wiresCam1A);

        List<Camera> wiresCam1B = new ArrayList<>();
        wiresCam1B.add(cam1C);
        wiresCam1B.add(cam1A);
        wiresCam1B.add(cam7);
        wiresCam1B.add(cam5);
        cam1B.setConnectedCameras(wiresCam1B);

        List<Camera> wiresCam1C = new ArrayList<>();
        wiresCam1C.add(cam1A);
        wiresCam1C.add(cam1B);
        wiresCam1C.add(cam2A);
        cam1C.setConnectedCameras(wiresCam1C);

        List<Camera> wiresCam5 = new ArrayList<>();
        wiresCam5.add(cam1B);
        wiresCam5.add(cam1C);
        cam5.setConnectedCameras(wiresCam5);

        List<Camera> wiresCam7 = new ArrayList<>();
        wiresCam7.add(cam6);
        wiresCam7.add(cam1C);
        cam7.setConnectedCameras(wiresCam7);

        List<Camera> wiresCam6 = new ArrayList<>();
        wiresCam7.add(cam1C);
        wiresCam7.add(cam4A);
        cam6.setConnectedCameras(wiresCam6);

        List<Camera> wiresCam4A = new ArrayList<>();
        wiresCam4A.add(cam4B);
        wiresCam4A.add(cam1C);
        wiresCam4A.add(cam6);
        cam4A.setConnectedCameras(wiresCam4A);

        List<Camera> wiresCam4B = new ArrayList<>();
        wiresCam4B.add(cam4A);
        wiresCam4B.add(cam2B);
        cam4B.setConnectedCameras(wiresCam4B);

        List<Camera> wiresCam2A = new ArrayList<>();
        wiresCam2A.add(cam3);
        wiresCam2A.add(cam2B);
        cam2A.setConnectedCameras(wiresCam2A);

        List<Camera> wiresCam2B = new ArrayList<>();
        wiresCam2B.add(cam2A);
        wiresCam2B.add(cam3);
        cam2B.setConnectedCameras(wiresCam2B);

        List<Camera> wiresCam3 = new ArrayList<>();
        wiresCam3.add(cam2A);
        wiresCam3.add(cam1C);
        cam3.setConnectedCameras(wiresCam3);


//        Erstelle alle Räume
        Room showStage = new Room();       //Index 0
        Room diningArea = new Room();       //Index 1
        Room backstage = new Room();       //Index 2
        Room pirateCove = new Room();       //Index 3
        Room restrooms = new Room();       //Index 4
        Room kitchen = new Room();       //Index 5
        Room eastHall = new Room();       //Index 6
        Room eastHallCorner = new Room();       //Index 7
        Room eastDoor = new Room();       //Index 8
        Room westHall = new Room();       //Index 9
        Room westHallCorner = new Room();       //Index 10
        Room westDoor = new Room();       //Index 11
        Room office = new Room();       //Index 12
        Room supplyCloset = new Room();       //Index 13

        showStage.setRoomName(RoomName.SHOWSTAGE);
        showStage.setCamera(cam1A);
        Map<Direction, Room> showStageNeighborMap = new HashMap<>();
        showStageNeighborMap.put(Direction.SOUTH1, diningArea);
        showStageNeighborMap.put(Direction.WEST1, backstage);
        showStageNeighborMap.put(Direction.EAST, restrooms);
        showStage.setNeighborRooms(showStageNeighborMap);

        diningArea.setRoomName(RoomName.DININGAREA);
        diningArea.setCamera(cam1B);
        Map<Direction, Room> diningAreaNeighborMap = new HashMap<>();
        diningAreaNeighborMap.put(Direction.NORTH, showStage);
        diningAreaNeighborMap.put(Direction.EAST, restrooms);
        diningAreaNeighborMap.put(Direction.SOUTH1, westHall);
        diningAreaNeighborMap.put(Direction.SOUTH2, eastHall);
        diningAreaNeighborMap.put(Direction.SOUTH3, kitchen);
        diningAreaNeighborMap.put(Direction.WEST1, backstage);
        diningAreaNeighborMap.put(Direction.WEST2, pirateCove);
        diningArea.setNeighborRooms(diningAreaNeighborMap);

        backstage.setRoomName(RoomName.BACKSTAGE);
        backstage.setCamera(cam5);
        Map<Direction, Room> backstageNeighborMap = new HashMap<>();
        backstageNeighborMap.put(Direction.EAST, diningArea);
        backstageNeighborMap.put(Direction.SOUTH1, westHall);
        backstage.setNeighborRooms(backstageNeighborMap);

        pirateCove.setRoomName(RoomName.PIRATECOVE);
        pirateCove.setCamera(cam1C);
        Map<Direction, Room> pirateCoveNeighborMap = new HashMap<>();
        pirateCoveNeighborMap.put(Direction.EAST, diningArea);
        pirateCove.setNeighborRooms(pirateCoveNeighborMap);


        restrooms.setRoomName(RoomName.RESTROOMS);
        restrooms.setCamera(cam7);
        Map<Direction, Room> restRoomsNeighborMap = new HashMap<>();
        restRoomsNeighborMap.put(Direction.WEST1, diningArea);
        restRoomsNeighborMap.put(Direction.SOUTH1, kitchen);
        restrooms.setNeighborRooms(restRoomsNeighborMap);

        kitchen.setRoomName(RoomName.KITCHEN);
        kitchen.setCamera(cam6);
        Map<Direction, Room> kitchenNeighborMap = new HashMap<>();
        kitchenNeighborMap.put(Direction.NORTH, diningArea);
        kitchenNeighborMap.put(Direction.WEST1, eastHall);
        kitchen.setNeighborRooms(kitchenNeighborMap);

        eastHall.setRoomName(RoomName.EASTHALL);
        eastHall.setCamera(cam4A);
        Map<Direction, Room> eastHall1NeighborMap = new HashMap<>();
        eastHall1NeighborMap.put(Direction.NORTH, diningArea);
        eastHall1NeighborMap.put(Direction.SOUTH1, eastHallCorner);
        eastHall.setNeighborRooms(eastHall1NeighborMap);

        eastHallCorner.setRoomName(RoomName.EASTHALLCORNER);
        eastHallCorner.setCamera(cam4B);
        Map<Direction, Room> eastHall2NeighborMap = new HashMap<>();
        eastHall2NeighborMap.put(Direction.NORTH, eastHall);
        eastHall2NeighborMap.put(Direction.WEST1, eastDoor);
        eastHallCorner.setNeighborRooms(eastHall2NeighborMap);

        eastDoor.setRoomName(RoomName.EASTDOOR);
        Map<Direction, Room> eastDoorNeighborMap = new HashMap<>();
        eastDoorNeighborMap.put(Direction.WEST1, office);
        eastDoorNeighborMap.put(Direction.EAST, eastHallCorner);
        eastDoor.setNeighborRooms(eastDoorNeighborMap);

        westHall.setRoomName(RoomName.WESTHALL);
        westHall.setCamera(cam2A);
        Map<Direction, Room> westHall1NeighborMap = new HashMap<>();
        westHall1NeighborMap.put(Direction.NORTH, diningArea);
        westHall1NeighborMap.put(Direction.SOUTH1, westHallCorner);
        westHall1NeighborMap.put(Direction.WEST1, supplyCloset);
        westHall.setNeighborRooms(westHall1NeighborMap);

        westHallCorner.setRoomName(RoomName.WESTHALLCORNER);
        westHallCorner.setCamera(cam2B);
        Map<Direction, Room> westHall2NeighborMap = new HashMap<>();
        westHall2NeighborMap.put(Direction.NORTH, supplyCloset);
        westHall2NeighborMap.put(Direction.EAST, westDoor);
        westHallCorner.setNeighborRooms(westHall2NeighborMap);

        westDoor.setRoomName(RoomName.WESTDOOR);
        Map<Direction, Room> westDoorNeighboorMap = new HashMap<>();
        westDoorNeighboorMap.put(Direction.EAST, office);
        westDoorNeighboorMap.put(Direction.WEST1, westHallCorner);
        westDoor.setNeighborRooms(westDoorNeighboorMap);

        supplyCloset.setRoomName(RoomName.SUPPLYCLOSET);
        supplyCloset.setCamera(cam3);
        Map<Direction, Room> supplyClosetNeighborMap = new HashMap<>();
        supplyClosetNeighborMap.put(Direction.EAST, westHall);
        supplyCloset.setNeighborRooms(supplyClosetNeighborMap);

        office.setRoomName(RoomName.OFFICE);
        office.setCamera(none);
        office.setDoorClosed(true);
        Map<Direction, Room> officeNeighborMap = new HashMap<>();
        officeNeighborMap.put(Direction.EAST, eastHallCorner);
        officeNeighborMap.put(Direction.WEST1, westHallCorner);
        office.setNeighborRooms(officeNeighborMap);


//Füge alle Räume einer Liste zu
        List<Room> allRooms = new ArrayList<>();
        allRooms.add(showStage);
        allRooms.add(diningArea);
        allRooms.add(backstage);
        allRooms.add(pirateCove);
        allRooms.add(restrooms);
        allRooms.add(kitchen);
        allRooms.add(eastHall);
        allRooms.add(eastHallCorner);
        allRooms.add(westHall);
        allRooms.add(westHallCorner);
        allRooms.add(westDoor);
        allRooms.add(office);
        allRooms.add(supplyCloset);

        pizzeria.setRooms(allRooms);


//        Erstelle alle Gegner
        Enemy freddy = createAnimatronic("Freddy", showStage, 6);
        Enemy bonnie = createAnimatronic("Bonnie", showStage, 3);
        Enemy chica = createAnimatronic("Chica", showStage, 4);
        Enemy foxxy = createAnimatronic("Foxxy", pirateCove, 7);


//        Erstelle eine Gegnerliste um diese der Pizzeria zu übergeben.
        List<Enemy> allEnemies = new ArrayList<>();
        allEnemies.add(freddy);
        allEnemies.add(bonnie);
        allEnemies.add(chica);
        allEnemies.add(foxxy);
//            Übergebe der Pizzeria ihre Gegner
        pizzeria.setAllEnemies(allEnemies);

        return pizzeria;
    }
}