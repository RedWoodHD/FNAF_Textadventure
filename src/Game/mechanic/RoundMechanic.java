package Game.mechanic;

import Game.object.Pizzeria;

public class RoundMechanic
{
    public void startRound(int roundNumber, Pizzeria pizzeria)
    {

        System.out.print("Round: " +roundNumber);
        pizzeria.setEnergyLeft(pizzeria.getEnergyLeft()-10);
        System.out.print(" Energy: "+pizzeria.getEnergyLeft());

    }
}
