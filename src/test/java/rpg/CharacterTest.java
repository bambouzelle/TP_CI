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
}
