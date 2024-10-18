package rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class World {
    private List<Character> characters;
    private List<Quest> quests;

    public World() {
        this.characters = new ArrayList<>();
        this.quests = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void deleteCharacter(Character character) {
        this.characters.remove(character);
    }

    public void deleteQuest(Quest quest) {
        this.quests.remove(quest);
    }
}
