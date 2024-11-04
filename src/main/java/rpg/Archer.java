package rpg;

public class Archer extends Character {

    public Archer(String name) {
        super(name);
        this.addSpell(new Spell("Piercing Arrow", 15, 10));
        this.addSpell(new Spell("Volley of Arrows", 10, 15));
    }

    // Spécialisation pour l'archer
    public void camouflage() {
        System.out.println(this.name + " utilise le camouflage pour éviter les attaques.");
        // Logique pour réduire les chances de recevoir des dégâts
    }
}
