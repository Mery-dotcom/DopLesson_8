package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {

        super(health, damage, name, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coefficent = RPG_Game.random.nextInt(2) + 1;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && this != hero) {
                hero.setDamage(hero.getDamage() * coefficent);
                System.out.println("Magic " + this.getName() + " increased "
                        + hero.getName() + "'s damage by " + coefficent * this.getDamage());
            }
        }
    }
}
