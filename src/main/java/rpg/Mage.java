package rpg;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Mage extends Character {

    public Mage(String name) {
        super(name);
        this.addSpell(new Spell("Fireball", 25, 20));
        this.addSpell(new Spell("Ice Blast", 20, 15));
    }

    public void meditate() {
        System.out.println(this.name + " médite pour regagner du mana.");
        this.mana += 30;
    }
}
