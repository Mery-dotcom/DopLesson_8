package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ludoman extends Hero{


    public Ludoman(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.STEAL_HEALTH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int theFirstDice = RPG_Game.random.nextInt(6) +1;
        int theSecondDice = RPG_Game.random.nextInt(6) +1;

        System.out.println(this.getName() + " throw game dice");

        if (theFirstDice == theSecondDice) {
            int damageToBoss = theFirstDice * theSecondDice;
            boss.setHealth(boss.getHealth() - damageToBoss);
            System.out.println("Same dice. " + this.getName() + " damaged Boss with " + damageToBoss + " damage.");
        } else {
            int damageToHero = theFirstDice + theSecondDice;
            int random = RPG_Game.random.nextInt(heroes.length);
            Hero chooseOneHero = heroes[random];
            while (chooseOneHero == this) {
                random = RPG_Game.random.nextInt();
                chooseOneHero = heroes[random];
            }
            chooseOneHero.setHealth(chooseOneHero.getHealth() - damageToHero);
            System.out.println("Different dice. " + this.getName() + " damaged " +
                    chooseOneHero.getName() + " with " + damageToHero + " damage.");
        }
    }
}
