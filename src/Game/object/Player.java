package Game.object;

/**
 * Diese Klasse representiert den Spieler.<br>
 * Der Spieler hat einen {@link boolean}, ob er noch am Leben ist.<br>
 * Der Spieler hat einen {@link boolean}, ob er das {@link Tablet} besitzt.<br>
 */
public class Player
{
    private boolean isAlive = true;
    private boolean hasTablet;

    public boolean isAlive()
    {
        return isAlive;
    }

    public Player setAlive(boolean alive)
    {
        isAlive = alive;
        return this;
    }

    public boolean isHasTablet()
    {
        return hasTablet;
    }

    public Player setHasTablet(boolean hasTablet)
    {
        this.hasTablet = hasTablet;
        return this;
    }
}

