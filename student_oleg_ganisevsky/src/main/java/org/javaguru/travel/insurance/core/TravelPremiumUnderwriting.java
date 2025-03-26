package org.javaguru.travel.insurance.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
public class TravelPremiumUnderwriting {
    DateTimeService dateTimeService = new DateTimeService();

    BigDecimal calculatePremium(TravelCalculatePremiumRequest request) {
        return dateTimeService.calculateAgreementPrice(request.getAgreementDateFrom(), request.getAgreementDateTo());
    }
}