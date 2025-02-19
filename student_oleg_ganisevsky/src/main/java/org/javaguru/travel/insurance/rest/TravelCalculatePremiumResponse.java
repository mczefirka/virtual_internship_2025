package org.javaguru.travel.insurance.rest;

import org.javaguru.travel.insurance.core.DateTimeService;

import java.math.BigDecimal;
import java.util.Date;

public class TravelCalculatePremiumResponse {
    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    private BigDecimal agreementPrice;

    DateTimeService dateTimeService = new DateTimeService();

    public TravelCalculatePremiumResponse() {
    }

    public TravelCalculatePremiumResponse(String personFirstName, String personLastName, Date agreementDateFrom, Date agreementDateTo) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.agreementDateFrom = agreementDateFrom;
        this.agreementDateTo = agreementDateTo;
        this.agreementPrice = dateTimeService.calculateAgreementPrice(agreementDateFrom, agreementDateTo);
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public Date getAgreementDateFrom() {
        return agreementDateFrom;
    }

    public Date getAgreementDateTo() {
        return agreementDateTo;
    }

    public BigDecimal getAgreementPrice() {
        return agreementPrice;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public void setAgreementDateFrom(Date agreementDateFrom) {
        this.agreementDateFrom = agreementDateFrom;
    }

    public void setAgreementDateTo(Date agreementDateTo) {
        this.agreementDateTo = agreementDateTo;
    }

}
