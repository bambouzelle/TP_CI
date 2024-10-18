package rpg;
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
        return character;
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

