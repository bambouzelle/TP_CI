package rpg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RpgApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RPGControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateCharacter() {
        Character character = new Character("Aragorn", "Guerrier");

        ResponseEntity<Character> response = restTemplate.postForEntity("/api/characters", character, Character.class);
        assertThat(response.getBody().getName()).isEqualTo("Aragorn");
        assertThat(response.getBody().getClassType()).isEqualTo("Guerrier");
    }
}

