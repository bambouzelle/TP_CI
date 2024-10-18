package rpg;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    @Test
    public void testCharacterCreation() {
        Character character = new Character("Gandalf", "Mage");
        assertEquals(1, character.getLevel(), "Le niveau initial du personnage doit être 1");
    }

    @Test
    public void testLevelUp() {
        Character character = new Character("Legolas", "Archer");
        character.levelUp();
        assertEquals(2, character.getLevel(), "Le niveau doit être augmenté de 1 après un levelUp");
    }
}
