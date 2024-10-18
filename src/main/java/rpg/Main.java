package rpg;

public class Main {
    public static void main(String[] args) {
        // Création de plusieurs personnages
        Character gandalf = new Character("Gandalf", "Mage");
        Character legolas = new Character("Legolas", "Archer");

        // Affichage des personnages
        System.out.println(gandalf.displayCharacter());
        System.out.println(legolas.displayCharacter());

        // Augmenter le niveau de Gandalf
        gandalf.levelUp();
        System.out.println(gandalf.displayCharacter()); // Niveau de Gandalf après levelUp
    }
}
