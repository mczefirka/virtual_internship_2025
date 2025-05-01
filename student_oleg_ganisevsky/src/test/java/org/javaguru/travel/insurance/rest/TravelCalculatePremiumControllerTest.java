package org.javaguru.travel.insurance.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelCalculatePremiumControllerTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private JsonFileReader fileReader;

    @Test
    public void givenRequest_whenRestControllerIsCalled_thenDoNotExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_success.json");

        // Compare controller response with expected response
        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_success.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutFirstName_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_firstName_not_provided.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_firstName_not_provided.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutLastName_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_lastName_not_provided.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_lastName_not_provided.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutDateFrom_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_agreementDateFrom_not_provided.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_agreementDateFrom_not_provided.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutDateTo_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_agreementDateTo_not_provided.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_agreementDateTo_not_provided.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutFields_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_allFields_not_provided.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_allFields_not_provided.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithDateFromIsAfterDateTo_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_dateFrom_is_after_dateTo.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_dateFrom_is_after_dateTo.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void givenRequestWithDateFromIsEqualDateTo_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        String expectedJson = fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumResponse_dateFrom_is_equal_dateTo.json");

        mockMvc.perform(post("/insurance/travel/")
                        .content(fileReader.readJsonFromFile("src/test/resources/rest/TravelCalculatePremiumRequest_dateFrom_is_equal_dateTo.json"))
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

}