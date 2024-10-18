package rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Character {

    private String name;
    private int level;
    private String classType;
    private int health;

    public Character(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.level = 1;
        this.health = 100;
    }

    public void levelUp() {
        this.level++;
    }

    public String displayCharacter() {
        return "Nom: " + this.name + ", Classe: " + this.classType + ", Niveau: " + this.level;
    }
}

