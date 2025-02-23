package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.rest.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.rest.TravelCalculatePremiumResponse;
import org.springframework.stereotype.Component;

@Component
class TravelCalculatePremiumServiceImpl implements TravelCalculatePremiumService {
    private final DateTimeService dateTimeService;

    TravelCalculatePremiumServiceImpl(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @Override
    public TravelCalculatePremiumResponse calculatePremium(TravelCalculatePremiumRequest request) {

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
