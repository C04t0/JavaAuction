package be.syntra.auction;

import be.syntra.auction.domain.Address;
import be.syntra.auction.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserTest {

    public static String BASE_URL = "http://localhost:8080/users";

    private RestTemplate restTemplate = new RestTemplate();


    @Test
    void registerUserTest() {
        User user = new User();
        Address billings = new Address("Sleepstraat", "9000", "Gent");
        user.setUsername("Corto");
        user.setFirstName("Johny");
        user.setLastName("Rotten");
        user.setBillingAddress(billings);

        HttpEntity<User> request = new HttpEntity<>(user);

        ResponseEntity<HttpStatus> result = restTemplate.postForEntity(BASE_URL + "/register", request, HttpStatus.class);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    void deleteUserTest() {

    }

}
