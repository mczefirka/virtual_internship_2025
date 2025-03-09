package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class TravelCalculatePremiumRequestValidatorTest {
    @Test
    public void givenRequest_whenValidateRequest_thenDoNotReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();
        request.setPersonFirstName("Sigma");
        request.setPersonLastName("Male");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list is empty, the test passes
        assertTrue(validator.validate(request).isEmpty());
    }

    @Test
    public void givenRequestWithoutFirstName_whenValidateRequest_thenReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();

        // Request without personFirstName field
//        request.setPersonFirstName("Sigma");
        request.setPersonLastName("Male");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list isn't empty, the test passes
        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    public void givenRequestWithEmptyFirstName_whenValidateRequest_thenReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();

        // Request with empty personFirstName field
        request.setPersonFirstName("");
        request.setPersonLastName("Male");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list isn't empty, the test passes
        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    public void givenRequestWithoutLastName_whenValidateRequest_thenReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();

        // Request without personLastName field
        request.setPersonFirstName("Sigma");
//        request.setPersonLastName("Male");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list isn't empty, the test passes
        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    public void givenRequestWithEmptyLastName_whenValidateRequest_thenReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();

        // Request with empty personLastName field
        request.setPersonFirstName("Sigma");
        request.setPersonLastName("");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list isn't empty, the test passes
        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    public void givenRequestWithoutFirstNameAndLastName_whenValidateRequest_thenReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();

        // Request without personFirstName and personLastName fields
/*      request.setPersonFirstName("Sigma");
        request.setPersonLastName("Male");*/
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list isn't empty, the test passes
        assertFalse(validator.validate(request).isEmpty());
    }

    @Test
    public void givenRequestWithoutAgreementDateFrom_whenValidateRequest_thenReturnErrors() {
        // Populate request fields
        var request = new TravelCalculatePremiumRequest();

        // Request without agreementDateFrom field
        request.setPersonFirstName("Sigma");
        request.setPersonLastName("Male");
//        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        var validator = new TravelCalculatePremiumRequestValidator();

        // Check whether the validator created an error list. If the list isn't empty, the test passes
        assertFalse(validator.validate(request).isEmpty());
    }
}
