package rpg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RPGController {

    private World world;

    @Autowired
    public RPGController(World world) {
        this.world = world;
    }

    @PostMapping("/characters")
    public Character createCharacter(@RequestBody Character character) {
        world.addCharacter(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED).getBody();
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return world.getAliveCharacters();
    }

    @PostMapping("/quests")
    public Character addQuestToCharacter(@RequestParam String characterName, @RequestBody Quest quest) {
        for (Character character : world.getAliveCharacters()) {
            if (character.getName().equals(characterName)) {
                character.addQuest(quest);
                return character;
            }
        }
        return null;
    }

    @PostMapping("/attaque")
    public void characterAttaque(@RequestParam String characterName1, @RequestBody String characterName2) {
        this.world.characterAttack(characterName1, characterName2);
    }
}

