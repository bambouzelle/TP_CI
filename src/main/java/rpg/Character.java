package rpg;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import rpg.exceptions.SpellNotFound;

import java.util.*;

@Slf4j
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

    private String name;
    private int level;
    private int health;
    private int mana;
    private List<Spell> spells;
    private boolean isDefending;
    private List<Quest> quests;

    protected Character(String name) {
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
        log.info("{} attaque {} et inflige {} points de dégâts.", this.name, opponent.getName(), baseDamage);
        opponent.takeDamage(baseDamage);
    }

    public void defend() {
        this.isDefending = true;
        log.info("{} se défend et réduira les dégâts reçus au prochain tour.", this.name);
    }

    public void useSpell(String spellName, Character opponent) {
        for (Spell spell : spells) {
            if (spell.name().equalsIgnoreCase(spellName) && this.mana >= spell.manaCost()) {
                log.info("{} utilise {} contre {}", this.name, spell.name(), opponent.getName());
                opponent.takeDamage(spell.damage());
                this.mana -= spell.manaCost();
                return;
            }
        }
        log.info("{} n'a pas suffisamment de mana ou ne connaît pas ce sort.", this.name);
        throw new SpellNotFound(spellName);
    }

    public void takeDamage(int damage) {
        if (isDefending) {
            damage /= 2;
            isDefending = false;
        }
        this.health -= damage;
        log.info("{} reçoit {} points de dégâts.", this.name, damage);
    }

    // Méthode pour vérifier si le personnage est en vie
    public boolean isAlive() {
        return this.health > 0;
    }

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void recupererMana(int mana) {
        this.mana += mana;
    }
}


