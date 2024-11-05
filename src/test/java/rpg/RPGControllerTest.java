package rpg;

import org.junit.jupiter.api.BeforeEach;
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
class RPGControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private HttpHeaders headers;
    private String characterJson;

    @BeforeEach
    void setUp() {
        // JSON avec le champ "type" pour indiquer la sous-classe Guerrier
        characterJson = """
            {
                "type": "guerrier",
                "name": "Aragorn",
                "level": 1,
                "health": 100,
                "mana": 100
            }
            """;

        // Configuration de l'en-tête pour indiquer le type JSON
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    void testCreateCharacter() {

        // Création de la requête avec le JSON et les en-têtes
        HttpEntity<String> request = new HttpEntity<>(characterJson, headers);

        // Envoi de la requête POST avec le JSON brut
        ResponseEntity<Character> response = restTemplate.postForEntity("/api/characters", request, Character.class);

        // Vérification de la réponse
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue(); // Statut HTTP 200 (Created)
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Aragorn");
    }
}

