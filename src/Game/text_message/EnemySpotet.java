package Game.text_message;

import Game.object.Enemy;

public class EnemySpotet
{
    Enemy enemy;

    public EnemySpotet(Enemy enemy)
    {
        this.enemy = enemy;
    }

    public static String randomEnemyOutput(Enemy enemy){
        switch (enemy.getName()){
            case FREDDY -> {
                return "You are seeing a brown bear";
            }
            case BONNIE -> {
                return "You are seeing a blue bunny";
            }
            case CHICA -> {
                return "You are seeing a yeelow Chicken";
            }
            case FOXXY -> {
                return "You are seeing a red Fox";
            }
        }
        return "SHEEEESH nobody is Home";
    }
}
