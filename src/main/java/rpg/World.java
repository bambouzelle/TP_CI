package rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import rpg.exceptions.CharacterDead;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class World {
    private List<Character> aliveCharacters;
    private List<Character> deadCharacters;
    private List<Quest> quests;

    public World() {
        this.aliveCharacters = new ArrayList<>();
        this.quests = new ArrayList<>();
    }

    public void addCharacter(Character character) {
        this.aliveCharacters.add(character);
    }

    public Character getAliveCharacter(String name) {
        return this.aliveCharacters.stream().filter(character -> character.getName().equals(name)).findFirst().orElse(null);
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void deleteCharacter(Character character) {

        if (this.isDead(character)) {
            this.deadCharacters.remove(character);
        }
        else {
            this.aliveCharacters.remove(character);
        }

    }

    public void deleteQuest(Quest quest) {
        this.quests.remove(quest);
    }

    public boolean isDead(String character) {
        return this.deadCharacters.stream().map(Character::getName).toList().contains(character);
    }

    public boolean isDead(Character character) {
        return this.deadCharacters.contains(character);
    }

    public void characterAttack(String name1, String name2) {

        if (this.isDead(name1) && this.isDead(name2)) {
            throw new CharacterDead("Un des personnages est mort !");
        }

        Character character1 = this.getAliveCharacter(name1);
        Character character2 = this.getAliveCharacter(name2);

        character1.attack(character2);

        if (!character2.isAlive()) {
            this.characterDies(character2);
        }
    }

    public void characterDies(Character character) {
        this.aliveCharacters.remove(character);
        this.deadCharacters.add(character);
    }
}
