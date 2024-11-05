package rpg;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Guerrier extends Character {

    public Guerrier(String name) {
        super(name);
        this.addSpell(new Spell("Power Strike", 20, 0));  // Les guerriers peuvent avoir des sorts sans coût en mana
        this.addSpell(new Spell("Whirlwind Attack", 15, 0));
    }

    // Spécialisation pour le guerrier
    public void rage() {
        log.info("{} entre en rage, augmentant ses dégâts.", this.getName());
        // Logique pour augmenter les dégâts temporairement
    }
}