package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.junit.jupiter.api.BeforeEach;
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
public class TravelPremiumUnderwritingTest {
    @Mock private DateTimeService dateTimeService;
    @InjectMocks
    private TravelPremiumUnderwriting premiumUnderwriting;

    private TravelCalculatePremiumRequest request;
    // agreementPrice == days between agreementDateFrom and agreementDateTo.
    BigDecimal agreementPrice = new BigDecimal("2");

    @BeforeEach
    public void setUp() {
        request = populateRequest();

        // Define the behaviour of the mock DateTimeService.
        // Current date minus 2 days and current date. Return agreementPrice == 2.
        when(dateTimeService.calculateAgreementPrice(request.getAgreementDateFrom(), request.getAgreementDateTo()))
                .thenReturn(agreementPrice);
    }

    @Test
    public void givenRequest_whenCalculateAgreementPrice_thenReturnAgreementPrice() {
        // Check calculatePremium method in TravelPremiumUnderwriting class.
        assertEquals(agreementPrice, premiumUnderwriting.calculatePremium(request));
    }

    /**
     * Populate request fields. Set "Sigma" for personFirstName field,
     * "Male" for personLastName,
     * current date minus 2 days for agreementDateFrom
     * and current date for agreementDateTo
     */
    private TravelCalculatePremiumRequest populateRequest() {
        var request = new TravelCalculatePremiumRequest();

        request.setPersonFirstName("Sigma");
        request.setPersonLastName("Male");
        request.setAgreementDateFrom(new Date(new Date().getTime() - 2 * 86_400_000L));
        request.setAgreementDateTo(new Date());

        return request;
    }
}