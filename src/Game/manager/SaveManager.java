package Game.manager;

import Game.factor.CameraName;
import Game.factor.EnemyName;
import Game.factor.RoomName;
import Game.object.Enemy;
import Game.object.Room;
import Game.object.Tablet;

import java.io.*;
import java.util.Map;

/**
 * Diese Klasse speichert und lädt den Spielstand.
 *
 * @author EGA
 */
public class SaveManager
{
    private static final String DELIMITER = ";";
    private final String enemiesStatus = "src/Game/manager/EnemiesSaveFile.txt";
    private final String gameStatusSaveFile = "src/Game/manager/GameStatusSaveFile.txt";
    private PizzeriaManager pizzeriaManager;

    public SaveManager(PizzeriaManager pizzeriaManager)
    {
        this.pizzeriaManager = pizzeriaManager;
    }

    /**
     * Speichert den Status von jedem {@link Enemy Gegner}.
     *
     * @return true wenn fertig.
     *
     * @author EGA
     */
    public boolean saveEnemiesStatus()
    {
        EnemyManager enemyManager = pizzeriaManager.getEnemyManager();
        RoomManager roomManager = pizzeriaManager.getRoomManager();
        Map<EnemyName, Enemy> enemyMap = enemyManager.getEnemyMap();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(enemiesStatus)))
        {
            for (Map.Entry<EnemyName, Enemy> EnemyEntry : enemyMap.entrySet())
            {
                final EnemyName enemyName = EnemyEntry.getKey();
                final Enemy enemy = EnemyEntry.getValue();
                final RoomName roomName = enemy.getMyRoomsName();
                final int roomStage = roomManager.getAllRoomsMap().get(roomName).getPirateCoveOpeningStage();
                final String roomStageString = Integer.toString(roomStage);
                writer.write(enemyName.name());
                writer.write(DELIMITER);
                writer.write(roomName.name());
                writer.write(DELIMITER);
                writer.write(roomStageString);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Diese Methode löscht die Spielstände.
     *
     * @author EGA
     */
    public void resetSaveFile()
    {
        File file = new File(enemiesStatus);
        File file2 = new File(gameStatusSaveFile);
        file.delete();
        file2.delete();
    }

    /**
     * Schreibt den derzeitigen GameStatus in eine SaveFile txt Datei.
     *
     * @param roundNumber die derzeitige Runden-nummer.
     *
     * @return true, wenn abgeschlossen.
     *
     * @author EGA
     */
    public boolean saveGameStatus(int roundNumber)
    {
        EnemyManager enemyManager = pizzeriaManager.getEnemyManager();
        Tablet tablet = pizzeriaManager.getCameraManager().getTablet();
        Map<EnemyName, Enemy> enemyMap = enemyManager.getEnemyMap();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(gameStatusSaveFile)))
        {
            String energyLeft = pizzeriaManager.getPizzeria().getEnergyLeft().toString();
            String roundNumberString = Integer.toString(roundNumber);
            CameraName cameraNameString = tablet.getWhatCameraDoILookAt().getCameraName();
            writer.write(energyLeft);
            writer.write(DELIMITER);
            writer.write(roundNumberString);
            writer.write(DELIMITER);
            writer.write(cameraNameString.name());
            writer.newLine();

            writer.flush();
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Diese Methode liest den Game-Status ein und sorgt dafür das dieser genutzt wird.
     *
     * @return die derzeitige Runde als {@link Integer} falls vorhanden, ansonsten 1;
     *
     * @author EGA
     */
    public int loadGameStatus()
    {
        RoomManager roomManager = pizzeriaManager.getRoomManager();
        EnemyManager enemyManager = pizzeriaManager.getEnemyManager();
        CameraManager cameraManager = pizzeriaManager.getCameraManager();
        Tablet tablet = cameraManager.getTablet();
        // Bevor geladen wird
        // Räume aufbauen und aus RoomManager rausholen.
        Map<RoomName, Room> roomMapFromRoomManager = roomManager.getAllRoomsMap();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Game/manager/GameStatusSaveFile.txt")))
        {
            Map<RoomName, Room> rooms = roomMapFromRoomManager;
            String lineContent;
            while ((lineContent = reader.readLine()) != null)
            {
                final String[] split = lineContent.split(";");
                final int energyLeft = Integer.parseInt(split[0]);
                final int roundNumber = Integer.parseInt(split[1]);
                final CameraName cameraName = CameraName.valueOf(split[2]);
                pizzeriaManager.getPizzeria().setEnergyLeft(energyLeft);
                tablet.setWhatCameraDoILookAt(cameraManager.getCamera(cameraName));
                return roundNumber;
            }
        } catch (FileNotFoundException e)
        {
            saveEnemiesStatus();
            saveGameStatus(1);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return 1;
    }

    /**
     * Diese Methode liest den Spielstand von den {@link Enemy Gegner} ein.
     *
     * @author EGA
     */
    public void loadEnemies()
    {
        EnemyManager enemyManager = pizzeriaManager.getEnemyManager();
        RoomManager roomManager = pizzeriaManager.getRoomManager();
        // EnemyManager bauen lassen.
        Map<EnemyName, Enemy> enemyMapFromEnemyManager = enemyManager.getEnemyMap();
        Map<RoomName, Room> roomMapFromRoomManager = roomManager.getAllRoomsMap();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Game/manager/EnemiesSaveFile.txt")))
        {
            Map<RoomName, Room> rooms = roomManager.getAllRoomsMap();
            String lineContent;
            while ((lineContent = reader.readLine()) != null)
            {
                final String[] split = lineContent.split(";");
                final EnemyName enemyName = EnemyName.valueOf(split[0]);
                final RoomName roomNameWhereEnemyWas = RoomName.valueOf(split[1]);
                final int state = Integer.parseInt(split[2]);

                final Enemy enemy = enemyMapFromEnemyManager.get(enemyName);
                final Room room = roomMapFromRoomManager.get(roomNameWhereEnemyWas);
                final Integer stateAsInteger = Integer.valueOf(state);

                roomManager.addEnemyToRoom(enemy.getName(), room.getRoomName());
                roomMapFromRoomManager.get(RoomName.PIRATECOVE).setPirateCoveOpeningStage(stateAsInteger);
                enemy.setWhereAmI(room);
//                camera...

            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

}
