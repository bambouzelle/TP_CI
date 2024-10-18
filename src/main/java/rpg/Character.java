package src.main.java.rpg;

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
}
