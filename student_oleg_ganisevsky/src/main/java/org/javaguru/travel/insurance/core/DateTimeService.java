package org.javaguru.travel.insurance.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeService {
    public BigDecimal calculateAgreementPrice (Date agreementDateFrom, Date agreementDateTo){
        LocalDate localDate1 = agreementDateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = agreementDateTo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new BigDecimal(java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2));
    }
}
