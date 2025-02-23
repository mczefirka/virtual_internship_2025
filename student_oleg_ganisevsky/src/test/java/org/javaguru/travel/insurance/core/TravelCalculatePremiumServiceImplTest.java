package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock private DateTimeService dateTimeService;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    @Test
    public void givenRequest_whenPopulateResponsePersonFirstNameField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Check request and response personFirstName fields
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void givenRequest_whenPopulateResponsePersonLastNameField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Check request and response personLastName fields
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Check request and response agreementDateFrom fields
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateToField_thenReturnResponse() {
        // Populate request fields
        TravelCalculatePremiumRequest request = new TravelCalculatePremiumRequest("Sigma",
                "Male", new Date(), new Date());

        // Populate response fields
        TravelCalculatePremiumResponse response = service.calculatePremium(request);

        // Check request and response agreementDateTo fields
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromAndToFields_thenReturnAgreementPrice() {
        // Mockito
        // Create current date minus 2 days and current date for request
        // And BigDecimal agreementPrice for dateTimeService return
        Date agreementDateFrom = new Date(new Date().getTime() - 2 * 86_400_000L);
        Date agreementDateTo = new Date();
        BigDecimal agreementPrice = new BigDecimal("2");

        // Populate request fields
        var request = new TravelCalculatePremiumRequest("Sigma",
                "Male", agreementDateFrom, agreementDateTo);

        // Define the behaviour of the mock DateTimeService. Current date minus 2 days and current date. Return 2
        when(dateTimeService
                .calculateAgreementPrice(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(agreementPrice);

        // Instantiate TravelCalculatePremiumResponse with the TravelCalculatePremiumServiceImpl
        // and the mock DateTimeService
        var response = service.calculatePremium(request);

        assertEquals(agreementPrice, response.getAgreementPrice());
    }
}