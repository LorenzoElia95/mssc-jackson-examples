package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getBeerDto();

        String json = objectMapper.writeValueAsString(beerDto);

        System.out.println(json);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"6a6d4c68-b716-4abb-bf7e-92f77ad89d9e\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":14215644,\"price\":12.99,\"createdDate\":\"2023-10-31T16:30:45-0400\",\"lastUpdatedDate\":\"2023-10-31T16:30:45.741087+01:00\"}";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        System.out.println(beerDto);


    }
}