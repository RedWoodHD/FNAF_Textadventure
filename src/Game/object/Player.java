package Game.object;

/**
 * Diese Klasse representiert den Spieler.<br>
 * Der Spieler hat einen {@link boolean}, ob er noch am Leben ist.<br>
 * Der Spieler hat einen {@link boolean}, ob er das {@link Tablet} besitzt.<br>
 */
public class Player
{
    private boolean isAlive = true;
    private Tablet tablet;

    public Player setAlive(boolean alive)
    {
        isAlive = alive;
        return this;
    }

    public Tablet getTablet()
    {
        return tablet;
    }

    public Player setTablet(Tablet tablet)
    {
        this.tablet = tablet;
        return this;
    }

    public boolean isAlive()
    {
        return isAlive;
    }
}

