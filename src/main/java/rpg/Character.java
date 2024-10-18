package rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Character {

    private String name;
    private int level;
    private String classType;
    private int health;
    private List<Quest> quests;

    public Character(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.level = 1;
        this.health = 100;
        this.quests = new ArrayList<>();
    }

    public void levelUp() {
        this.level++;
    }

    public String displayCharacter() {
        return "Nom: " + this.name + ", Classe: " + this.classType + ", Niveau: " + this.level;
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }
}

