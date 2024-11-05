package rpg;

import lombok.Getter;

/**
 * @param name Getters pour accéder aux attributs
 */
@Getter
public record Spell(String name, int damage, int manaCost) {

}
