package rpg.exceptions;

public class CharacterDead extends RuntimeException {
    public CharacterDead(String message) {
        super(message);
    }
}
