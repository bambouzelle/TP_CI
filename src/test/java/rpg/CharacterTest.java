package rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.exceptions.SpellNotFound;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private Character[] characters;

    @BeforeEach
    void setUp() {
        characters = new Character[]{
                new Archer("Legolas"),
                new Mage("Gandalf"),
                new Mage("Saruman")
        };
    }

    @Test
    void testCharacterCreation() {
        Character character = characters[1];
        assertEquals(1, character.getLevel(), "Le niveau initial du personnage doit être 1");
    }

    @Test
    void testLevelUp() {
        Character character = characters[0];
        character.levelUp();
        assertEquals(2, character.getLevel(), "Le niveau doit être augmenté de 1 après un levelUp");
    }

    @Test
    void testAttaque() {
        Character character1 = characters[0];
        Character character2 = characters[1];
        int baseHealth = character2.getHealth();

        character1.attack(character2);

        assertNotEquals(baseHealth, character2.getHealth());
    }

    @Test
    void testDefense() {
        Character character1 = characters[0];
        Character character2 = characters[1];
        Character character3 = characters[2];

        character2.defend();
        character1.attack(character2);
        character1.attack(character3);

        assertTrue(character2.getHealth() > character3.getHealth());
    }

    @Test
    void sortInconnu() {
        Character character1 = characters[0];
        Character character2 = characters[1];

        assertThrows(SpellNotFound.class, () -> character1.useSpell("Sacrebleu", character2));
    }
}
