package Game.manager;

import Game.object.Pizzeria;

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

    public void decreasePizzeriaEnergyLevel(){
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft() - 2);
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
