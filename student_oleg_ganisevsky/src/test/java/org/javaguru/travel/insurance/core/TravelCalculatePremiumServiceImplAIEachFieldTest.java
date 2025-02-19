package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplAIEachFieldTest {

    DateTimeService dateTimeService = new DateTimeService();
    private final TravelCalculatePremiumServiceImpl service = new TravelCalculatePremiumServiceImpl(dateTimeService);

    @Test
    void testCalculatePremium_PersonFirstName() {
        String firstName = "Alice";
        // Set other fields with dummy values
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName(firstName);
        request.setPersonLastName("Dummy");
        Date dateFrom = new Date();
        request.setAgreementDateFrom(dateFrom);
        Date dateTo = new Date(dateFrom.getTime() + 1_000L);
        request.setAgreementDateTo(dateTo);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(firstName, response.getPersonFirstName(), "First name does not match");
    }

    @Test
    void testCalculatePremium_PersonLastName() {
        String lastName = "Smith";
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Dummy");
        request.setPersonLastName(lastName);
        Date dateFrom = new Date();
        request.setAgreementDateFrom(dateFrom);
        Date dateTo = new Date(dateFrom.getTime() + 1_000L);
        request.setAgreementDateTo(dateTo);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(lastName, response.getPersonLastName(), "Last name does not match");
    }

    @Test
    void testCalculatePremium_AgreementDateFrom() {
        Date dateFrom = new Date();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Dummy");
        request.setPersonLastName("Dummy");
        request.setAgreementDateFrom(dateFrom);
        Date dateTo = new Date(dateFrom.getTime() + 1_000L);
        request.setAgreementDateTo(dateTo);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(dateFrom, response.getAgreementDateFrom(), "Agreement start date does not match");
    }

    @Test
    void testCalculatePremium_AgreementDateTo() {
        Date dateTo = new Date();
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Dummy");
        request.setPersonLastName("Dummy");
        Date dateFrom = new Date(dateTo.getTime() - 1_000L);
        request.setAgreementDateFrom(dateFrom);
        request.setAgreementDateTo(dateTo);

        TravelCalculatePremiumResponse response = service.calculatePremium(request);
        assertEquals(dateTo, response.getAgreementDateTo(), "Agreement end date does not match");
    }
}
