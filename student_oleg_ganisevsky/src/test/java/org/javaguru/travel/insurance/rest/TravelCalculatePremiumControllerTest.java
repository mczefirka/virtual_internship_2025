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

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TravelCalculatePremiumControllerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    public void givenRequest_whenRestControllerIsCalled_thenDoNotExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : "I AM",
                                "personLastName" : "MUSIC",
                                "agreementDateFrom" : "2025-03-15",
                                "agreementDateTo" : "2025-04-12"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is("I AM")))
                .andExpect(jsonPath("personLastName", is("MUSIC")))
                .andExpect(jsonPath("agreementDateFrom", is("2025-03-15")))
                .andExpect(jsonPath("agreementDateTo", is("2025-04-12")))
                .andExpect(jsonPath("agreementPrice", is(28)))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutFirstName_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : null,
                                "personLastName" : "MUSIC",
                                "agreementDateFrom" : "2025-03-15",
                                "agreementDateTo" : "2025-04-12"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutLastName_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : "I AM",
                                "personLastName" : null,
                                "agreementDateFrom" : "2025-03-15",
                                "agreementDateTo" : "2025-04-12"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutDateFrom_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : "I AM",
                                "personLastName" : "MUSIC",
                                "agreementDateFrom" : null,
                                "agreementDateTo" : "2025-04-12"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutDateTo_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : "I AM",
                                "personLastName" : "MUSIC",
                                "agreementDateFrom" : "2025-03-15",
                                "agreementDateTo" : null
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

    @Test
    public void givenRequestWithoutFields_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : null,
                                "personLastName" : null,
                                "agreementDateFrom" : null,
                                "agreementDateTo" : null
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

    @Test
    public void givenRequestWithDateFromIsAfterDateTo_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : "I AM",
                                "personLastName" : "MUSIC",
                                "agreementDateFrom" : "2026-03-15",
                                "agreementDateTo" : "2025-04-12"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

    @Test
    public void givenRequestWithDateFromIsEqualDateTo_whenRestControllerIsCalled_thenExpectErrors() throws Exception {
        mockMvc.perform(post("/insurance/travel/")
                        .content("""
                                {\
                                "personFirstName" : "I AM",
                                "personLastName" : "MUSIC",
                                "agreementDateFrom" : "2025-03-15",
                                "agreementDateTo" : "2025-03-15"
                                }""")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("personFirstName", is(nullValue())))
                .andExpect(jsonPath("personLastName", is(nullValue())))
                .andExpect(jsonPath("agreementDateFrom", is(nullValue())))
                .andExpect(jsonPath("agreementDateTo", is(nullValue())))
                .andExpect(jsonPath("agreementPrice", is(nullValue())))
                .andReturn();
    }

}
