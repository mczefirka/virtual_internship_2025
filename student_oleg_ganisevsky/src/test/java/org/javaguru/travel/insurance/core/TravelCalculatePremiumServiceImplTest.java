package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {

    DateTimeService dateTimeService = new DateTimeService();
    TravelCalculatePremiumServiceImpl calculatePremiumImpl = new TravelCalculatePremiumServiceImpl(dateTimeService);

    @Test
    public void givenRequest_whenPopulateResponsePersonFirstNameField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response personFirstName fields
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void givenRequest_whenPopulateResponsePersonLastNameField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response personLastName fields
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response agreementDateFrom fields
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateToField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response agreementDateTo fields
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromAndToFields_thenReturnAgreementPrice() {
        // Populate request fields. Create current date minus 2 days and current date
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(new Date().getTime() - 2 * 86_400_000L), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response agreementPrice fields
        assertEquals(new BigDecimal("2"), response.getAgreementPrice());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateInDateTimeServiceClass_thenReturnAgreementPrice() {
        // Check calculateAgreementPrice method from DateTimeService class
        assertEquals(new BigDecimal("2"),
                dateTimeService.calculateAgreementPrice(new Date(new Date().getTime() - 2 * 86_400_000L), new Date()));
    }

}