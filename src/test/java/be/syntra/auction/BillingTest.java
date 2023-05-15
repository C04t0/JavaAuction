package be.syntra.auction;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BillingTest {

    public static String BASE_URL = "http://localhost:8080/users/1/pay";

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void payTest() {

    }


}
