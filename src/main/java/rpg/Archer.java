package rpg;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.addSpell(new Spell("Piercing Arrow", 15, 10));
        this.addSpell(new Spell("Volley of Arrows", 10, 15));
    }

    // Spécialisation pour l'archer
    public void camouflage() {
        log.info("{} utilise le camouflage pour éviter les attaques.", this.getName());
        // Logique pour réduire les chances de recevoir des dégâts
    }
}
