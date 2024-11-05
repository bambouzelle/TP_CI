package rpg.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpellNotFound extends RuntimeException {

    private String spellName;

    public SpellNotFound(String spellName) {
        this.spellName = spellName;
    }
}
