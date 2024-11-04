package rpg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RPGController {
    private List<Character> characters = new ArrayList<>();

    @PostMapping("/characters")
    public Character createCharacter(@RequestBody Character character) {
        characters.add(character);
        return new ResponseEntity<>(character, HttpStatus.CREATED).getBody();
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return characters;
    }

    @PostMapping("/quests")
    public Character addQuestToCharacter(@RequestParam String characterName, @RequestBody Quest quest) {
        for (Character character : characters) {
            if (character.getName().equals(characterName)) {
                character.addQuest(quest);
                return character;
            }
        }
        return null;
    }
}

