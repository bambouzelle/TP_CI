package rpg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RPGController {
    private List<Character> aliveCharacters = new ArrayList<>();
    private List<Character> deadCharacters = new ArrayList<>();

    @PostMapping("/characters")
    public Character createCharacter(@RequestBody Character character) {
        aliveCharacters.add(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED).getBody();
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return aliveCharacters;
    }

    @PostMapping("/quests")
    public Character addQuestToCharacter(@RequestParam String characterName, @RequestBody Quest quest) {
        for (Character character : aliveCharacters) {
            if (character.getName().equals(characterName)) {
                character.addQuest(quest);
                return character;
            }
        }
        return null;
    }

    @PostMapping("/attaque")
    public void characterAttaque(@RequestParam String characterName1, @RequestBody String characterName2) {
        Character character1 = null, character2 = null;
        for (Character character : aliveCharacters) {
            if (character.getName().equals(characterName1)) {
                character1 = character;
            }
            else if (character.getName().equals(characterName2)) {
                character2 = character;
            }
        }
        if (character1 != null && character2 != null) {
            character1.attack(character2);
            if (character2.isAlive()) {
                aliveCharacters.remove(character2);
                deadCharacters.add(character2);
            }
        }
    }
}

