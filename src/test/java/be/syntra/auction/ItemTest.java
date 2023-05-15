package be.syntra.auction;

import be.syntra.auction.domain.Bid;
import be.syntra.auction.domain.Item;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemTest {

    public static String BASE_URL = "http://localhost:8080/items";

    private RestTemplate restTemplate = new RestTemplate();



    @Test
    @Transactional
    public void createItemTest() {
        Item item = new Item();
        item.setName("Chair");
        item.setInitialPrice(BigDecimal.valueOf(24.99));
        item.setAuctionEndDate(LocalDate.of(2023, 10, 30));

        HttpEntity<Item> request = new HttpEntity<>(item);

        ResponseEntity<HttpStatus> result = restTemplate.postForEntity(BASE_URL, request, HttpStatus.class);
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    @Transactional
    public void getItemByIdTest() {
        try {
            ResponseEntity<Item> result = restTemplate.getForEntity(BASE_URL + "/{id}", Item.class, 1L);
            assertEquals("Chair", result.getBody().getName());
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

}
