package rpg;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Mage extends Character {

    public Mage(String name) {
        super(name);
        this.addSpell(new Spell("Fireball", 25, 20));
        this.addSpell(new Spell("Ice Blast", 20, 15));
    }

    public void meditate() {
        log.info("{} médite pour regagner du mana.", this.name);
        this.mana += 30;
    }
}
