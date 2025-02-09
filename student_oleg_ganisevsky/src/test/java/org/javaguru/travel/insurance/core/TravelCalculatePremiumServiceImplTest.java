package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TravelCalculatePremiumServiceImplTest {
    @Test
    public void givenRequest_whenPopulateResponsePersonFirstNameField_thenReturnResponse() {
        TravelCalculatePremiumServiceImpl calculatePremiumImpl = new TravelCalculatePremiumServiceImpl();

        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response fields
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void givenRequest_whenPopulateResponsePersonLastNameField_thenReturnResponse() {
        TravelCalculatePremiumServiceImpl calculatePremiumImpl = new TravelCalculatePremiumServiceImpl();

        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response fields
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromField_thenReturnResponse() {
        TravelCalculatePremiumServiceImpl calculatePremiumImpl = new TravelCalculatePremiumServiceImpl();

        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response fields
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateToField_thenReturnResponse() {
        TravelCalculatePremiumServiceImpl calculatePremiumImpl = new TravelCalculatePremiumServiceImpl();

        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = calculatePremiumImpl.calculatePremium(request);

        // Check request and response fields
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

}