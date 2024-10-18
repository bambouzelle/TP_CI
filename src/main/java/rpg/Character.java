package rpg;

public class Character {

    private String name;
    private int level;
    private String classType;

    public Character(String name, String classType) {
        this.name = name;
        this.classType = classType;
        this.level = 1;
    }

    public void levelUp() {
        this.level++;
    }

    public String getName() { return name;}

    public String getClassType() { return classType; }

    public int getLevel() { return level; }

    public String displayCharacter() {
        return "Nom: " + this.name + ", Classe: " + this.classType + ", Niveau: " + this.level;
    }
}

