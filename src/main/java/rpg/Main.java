package rpg;

public class Main {
    public static void main(String[] args) {
        Character mage = new Mage("Gandalf");
        Character guerrier = new Guerrier("Aragorn");
        Character archer = new Archer("Legolas");

        // Exemple de séquence de combat
        mage.attack(guerrier);       // Attaque classique
        guerrier.defend();           // Défense
        archer.useSpell("Volley of Arrows", mage); // Utilisation d'un sort
        mage.useSpell("Fireball", guerrier);       // Utilisation d'un sort
    }
}
