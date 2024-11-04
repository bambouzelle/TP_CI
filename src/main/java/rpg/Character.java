package rpg;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Mage.class, name = "mage"),
        @JsonSubTypes.Type(value = Guerrier.class, name = "guerrier"),
        @JsonSubTypes.Type(value = Archer.class, name = "archer")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Character {

    @Getter
    protected String name;
    protected int level;
    protected int health;
    protected int mana;
    protected List<Spell> spells;
    protected boolean isDefending;
    protected List<Quest> quests;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.health = 100;
        this.mana = 100;
        this.quests = new ArrayList<>();
        this.spells = new ArrayList<>();
        this.isDefending = false;
    }

    public void levelUp() {
        this.level++;
        this.health = 100 + (10 * this.level);
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public void attack(Character opponent) {
        int baseDamage = 10 * this.level;
        System.out.println(this.name + " attaque " + opponent.getName() + " et inflige " + baseDamage + " points de dégâts.");
        opponent.takeDamage(baseDamage);
    }

    public void defend() {
        this.isDefending = true;
        System.out.println(this.name + " se défend et réduira les dégâts reçus au prochain tour.");
    }

    public void useSpell(String spellName, Character opponent) {
        for (Spell spell : spells) {
            if (spell.getName().equalsIgnoreCase(spellName) && this.mana >= spell.getManaCost()) {
                System.out.println(this.name + " utilise " + spell.getName() + " contre " + opponent.getName());
                opponent.takeDamage(spell.getDamage());
                this.mana -= spell.getManaCost();
                return;
            }
        }
        System.out.println(this.name + " n'a pas suffisamment de mana ou ne connaît pas ce sort.");
    }

    public void takeDamage(int damage) {
        if (isDefending) {
            damage /= 2;
            isDefending = false;
        }
        this.health -= damage;
        System.out.println(this.name + " reçoit " + damage + " points de dégâts.");
    }

    // Méthode pour vérifier si le personnage est en vie
    public boolean isAlive() {
        return this.health > 0;
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }
}


