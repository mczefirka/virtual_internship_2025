package org.javaguru.travel.insurance.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateTimeServiceTest {
    DateTimeService dateTimeService = new DateTimeService();

    @Test
    public void givenRequest_whenCalculateAgreementPrice_thenReturnAgreementPrice() {
        // Check calculateAgreementPrice method in DateTimeService class
        assertEquals(new BigDecimal("2"),
                dateTimeService.calculateAgreementPrice(new Date(new Date().getTime() - 2 * 86_400_000L),
                        new Date()));
    }
}
