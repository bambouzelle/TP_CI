package rpg;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RpgApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RPGControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateCharacter() {
        // JSON avec le champ "type" pour indiquer la sous-classe Guerrier
        String characterJson = """
            {
                "type": "guerrier",
                "name": "Aragorn",
                "level": 1,
                "health": 100,
                "mana": 100
            }
            """;

        // Configuration de l'en-tête pour indiquer le type JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Création de la requête avec le JSON et les en-têtes
        HttpEntity<String> request = new HttpEntity<>(characterJson, headers);

        // Envoi de la requête POST avec le JSON brut
        ResponseEntity<Character> response = restTemplate.postForEntity("/api/characters", request, Character.class);

        // Vérification de la réponse
        assertThat(response.getStatusCodeValue()).isEqualTo(201); // Statut HTTP 201 (Created)
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Aragorn");
    }
}

