package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TravelCalculatePremiumServiceImplTest {

    @Mock private TravelCalculatePremiumRequestValidator requestValidator;
    @Mock private TravelPremiumUnderwriting premiumUnderwriting;
    @InjectMocks
    private TravelCalculatePremiumServiceImpl service;

    private TravelCalculatePremiumRequest request;
    // agreementPrice == days between agreementDateFrom and agreementDateTo.
    BigDecimal agreementPrice = new BigDecimal("2");

    @BeforeEach
    public void setUp(){
        request = populateRequest();

        // Define the behaviour of the mock TravelCalculatePremiumRequestValidator.
        // Return list without elements. This means that we don't have validation errors.
        when(requestValidator.validate(request)).thenReturn(List.of());

        // Define the behaviour of the mock TravelPremiumUnderwriting.
        // Current date minus 2 days and current date. Return agreementPrice == 2.
        // I use lenient() because test with errors check throw UnnecessaryStubbingException.
        lenient().when(premiumUnderwriting.calculatePremium(request)).thenReturn(agreementPrice);
    }

    @Test
    public void givenRequest_whenPopulateResponsePersonFirstNameField_thenReturnResponse() {
        // Populate response fields
        var response = service.calculatePremium(request);

        // Check request and response personFirstName fields
        assertEquals(request.getPersonFirstName(), response.getPersonFirstName());
    }

    @Test
    public void givenRequest_whenPopulateResponsePersonLastNameField_thenReturnResponse() {
        // Populate response fields
        var response = service.calculatePremium(request);

        // Check request and response personLastName fields
        assertEquals(request.getPersonLastName(), response.getPersonLastName());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromField_thenReturnResponse() {
        // Populate response fields
        var response = service.calculatePremium(request);

        // Check request and response agreementDateFrom fields
        assertEquals(request.getAgreementDateFrom(), response.getAgreementDateFrom());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateToField_thenReturnResponse() {
        // Populate response fields
        var response = service.calculatePremium(request);

        // Check request and response agreementDateTo fields
        assertEquals(request.getAgreementDateTo(), response.getAgreementDateTo());
    }

    @Test
    public void givenRequest_whenPopulateResponseAgreementDateFromAndToFields_thenReturnAgreementPrice() {
        // Populate response fields
        var response = service.calculatePremium(request);

        assertEquals(agreementPrice, response.getAgreementPrice());
    }

    @Test
    public void givenRequest_whenValidatorReturnErrors_thenReturnResponseWithErrors(){
        List<ValidationError> errors = buildValidationErrorList();
        when(requestValidator.validate(request)).thenReturn(errors);

        // Populate response fields
        var response = service.calculatePremium(request);

        assertTrue(response.hasErrors());
    }

    /**Populate request fields. Set "Sigma" for personFirstName field,
     * "Male" for personLastName,
     * current date minus 2 days for agreementDateFrom
     * and current date for agreementDateTo*/
    private TravelCalculatePremiumRequest populateRequest(){
        var request = new TravelCalculatePremiumRequest();

        request.setPersonFirstName("Sigma");
        request.setPersonLastName("Male");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        return request;
    }

    private List<ValidationError> buildValidationErrorList() {
        return List.of(
                new ValidationError("field", "errorMessage")
        );
    }
}