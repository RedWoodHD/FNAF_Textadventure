import java.util.List;

public class Pizzeria {
    private Integer energyLeft;
    private List<Room> rooms;
    private List<Enemy> allEnemies;



    public Pizzeria createPizzeria()
    {

    }


    public List<Enemy> getAllEnemies() {
        return allEnemies;
    }

    public Pizzeria setAllEnemies(List<Enemy> allEnemies) {
        this.allEnemies = allEnemies;
        return this;
    }

    public Integer getEnergyLeft() {
        return energyLeft;
    }

    public Pizzeria setEnergyLeft(Integer energyLeft) {
        this.energyLeft = energyLeft;
        return this;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Pizzeria setRooms(List<Room> rooms) {
        this.rooms = rooms;
        return this;
    }
}
