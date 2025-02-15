package org.javaguru.travel.insurance.rest;

import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class TravelCalculatePremiumResponse {

    private String personFirstName;
    private String personLastName;
    private Date agreementDateFrom;
    private Date agreementDateTo;
    private BigDecimal agreementPrice;

    public TravelCalculatePremiumResponse() {
    }

    public TravelCalculatePremiumResponse(String personFirstName, String personLastName, Date agreementDateFrom, Date agreementDateTo) {
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.agreementDateFrom = agreementDateFrom;
        this.agreementDateTo = agreementDateTo;
        this.agreementPrice = calculateAgreementPrice(agreementDateFrom, agreementDateTo);
    }

    private BigDecimal calculateAgreementPrice (Date agreementDateFrom, Date agreementDateTo){
        LocalDate localDate1 = agreementDateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = agreementDateTo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new BigDecimal(java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2));
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
