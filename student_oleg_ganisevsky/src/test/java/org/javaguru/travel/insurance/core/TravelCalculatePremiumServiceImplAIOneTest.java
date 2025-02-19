package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplAIOneTest {

    DateTimeService dateTimeService = new DateTimeService();
    private final TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl(dateTimeService);

    @Test
    void testCalculatePremium_AllFields() {
        // Prepare test data
        String firstName = "John";
        String lastName = "Doe";
        Date dateFrom = new Date();
        Date dateTo = new Date(dateFrom.getTime() + 86_400_000L); // +1 day

        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest(firstName, lastName, dateFrom, dateTo);

        // Execute the method under test
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Verify that all fields are correctly passed
        assertEquals(firstName, response.getPersonFirstName(), "First name does not match");
        assertEquals(lastName, response.getPersonLastName(), "Last name does not match");
        assertEquals(dateFrom, response.getAgreementDateFrom(), "Agreement start date does not match");
        assertEquals(dateTo, response.getAgreementDateTo(), "Agreement end date does not match");
    }
}
