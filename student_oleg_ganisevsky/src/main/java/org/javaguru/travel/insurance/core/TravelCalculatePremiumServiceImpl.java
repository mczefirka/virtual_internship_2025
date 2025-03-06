package org.javaguru.travel.insurance.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
    private final DateTimeService dateTimeService;

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {
        //Populate response fields from request
        var response = new TravelCalculatePremiumResponse();
        response.setPersonFirstName(request.getPersonFirstName());
        response.setPersonLastName(request.getPersonLastName());
        response.setAgreementDateFrom(request.getAgreementDateFrom());
        response.setAgreementDateTo(request.getAgreementDateTo());

        response.setAgreementPrice(dateTimeService
                .calculateAgreementPrice(request.getAgreementDateFrom(), request.getAgreementDateTo()));

        return response;
    }

}
