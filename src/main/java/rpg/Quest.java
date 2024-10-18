package rpg;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rpg.enums.Difficulty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quest {
    private String questName;
    private Difficulty difficulty;
    private int reward;
}
