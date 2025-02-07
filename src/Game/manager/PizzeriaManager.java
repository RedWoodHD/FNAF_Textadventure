package Game.manager;

import Game.object.Camera;
import Game.object.Pizzeria;
import Game.object.Tablet;

/**
 * Diese Klasse soll die {@link Pizzeria} verwalten.<br>
 * Sie bietet eine Methode, um die {@link Pizzeria#energyLeft verbleibende Energie} zu verringern:<br>
 * -{@link #decreasePizzeriaEnergyLevel(int)} <br>
 * @author EGA
 */
public class PizzeriaManager
{
    private final Pizzeria pizzeria;
    private final RoomManager roomManager;
    private final EnemyManager enemyManager;
    private final CameraManager cameraManager;

    public PizzeriaManager(Pizzeria pizzeria, RoomManager roomManager, EnemyManager enemyManager, CameraManager cameraManager)
    {
        this.pizzeria = pizzeria;
        this.roomManager = roomManager;
        this.enemyManager = enemyManager;
        this.cameraManager = cameraManager;
    }

    /**
     *Diese Methode verringert die {@link Pizzeria#energyLeft Energie} von der {@link Pizzeria}.
     * @param value die {@link Integer Zahl}, zum Verringern.
     * @author EGA
     */
    public void decreasePizzeriaEnergyLevel(int value){
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft() - value);
    }

    public Pizzeria getPizzeria()
    {
        return pizzeria;
    }

    public RoomManager getRoomManager()
    {
        return roomManager;
    }

    public EnemyManager getEnemyManager()
    {
        return enemyManager;
    }

    public CameraManager getCameraManager()
    {
        return cameraManager;
    }
}
