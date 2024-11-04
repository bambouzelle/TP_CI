package rpg;

public class Guerrier extends Character {

    public Guerrier(String name) {
        super(name);
        this.addSpell(new Spell("Power Strike", 20, 0));  // Les guerriers peuvent avoir des sorts sans coût en mana
        this.addSpell(new Spell("Whirlwind Attack", 15, 0));
    }

    // Spécialisation pour le guerrier
    public void rage() {
        System.out.println(this.name + " entre en rage, augmentant ses dégâts.");
        // Logique pour augmenter les dégâts temporairement
    }
}