package rpg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void testCharacterCreation() {
        Character character = new Mage("Gandalf");
        assertEquals(1, character.getLevel(), "Le niveau initial du personnage doit être 1");
    }

    @Test
    void testLevelUp() {
        Character character = new Archer("Legolas");
        character.levelUp();
        assertEquals(2, character.getLevel(), "Le niveau doit être augmenté de 1 après un levelUp");
    }

    @Test
    void testAttaque() {
        Character character1 = new Archer("Legolas");
        Character character2 = new Mage("Gandalf");
        int baseHealth = character2.getHealth();

        character1.attack(character2);

        assertNotEquals(baseHealth, character2.getHealth());
    }

    @Test
    void testDefense() {
        Character character1 = new Archer("Legolas");
        Character character2 = new Mage("Gandalf");
        Character character3 = new Mage("Saruman");

        character2.defend();
        character1.attack(character2);
        character1.attack(character3);

        assertTrue(character2.getHealth() > character3.getHealth());
    }
}
