package rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rpg.enums.Difficulty;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    private World world;
    private Character character;
    private Quest quest;

    @BeforeEach
    void setUp() {
        world = new World();
        character = new Character("Jean", "Warrior");
        quest = new Quest("Tuer le dragon", Difficulty.MEDIUM, 2);
    }

    @Test
    void addCharacter() {
        world.addCharacter(character);
        assertEquals(character, world.getCharacters().getFirst());
    }

    @Test
    void addQuest() {
    }

    @Test
    void deleteCharacter() {
    }

    @Test
    void deleteQuest() {
    }
}