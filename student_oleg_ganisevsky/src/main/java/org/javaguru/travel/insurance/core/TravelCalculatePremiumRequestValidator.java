package org.javaguru.travel.insurance.core;

import org.javaguru.travel.insurance.dto.TravelCalculatePremiumRequest;
import org.javaguru.travel.insurance.dto.ValidationError;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
class TravelCalculatePremiumRequestValidator {

    public List<ValidationError> validate(TravelCalculatePremiumRequest request) {
        List<ValidationError> errors = new ArrayList<>();
        validatePersonFirstName(request).ifPresent(errors::add);
        validatePersonLastName(request).ifPresent(errors::add);
        validateAgreementDateFrom(request).ifPresent(errors::add);
        validateAgreementDateTo(request).ifPresent(errors::add);
        validateAgreementDateFromAndToOrder(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<ValidationError> validatePersonFirstName(TravelCalculatePremiumRequest request) {
        return (request.getPersonFirstName() == null || request.getPersonFirstName().isEmpty())
                ? Optional.of(new ValidationError("personFirstName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<ValidationError> validatePersonLastName(TravelCalculatePremiumRequest request) {
        return (request.getPersonLastName() == null || request.getPersonLastName().isEmpty())
                ? Optional.of(new ValidationError("personLastName", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<ValidationError> validateAgreementDateFrom(TravelCalculatePremiumRequest request) {
        return (request.getAgreementDateFrom() == null)
                ? Optional.of(new ValidationError("agreementDateFrom", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<ValidationError> validateAgreementDateTo(TravelCalculatePremiumRequest request) {
        return (request.getAgreementDateTo() == null)
                ? Optional.of(new ValidationError("agreementDateTo", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<ValidationError> validateAgreementDateFromAndToOrder(TravelCalculatePremiumRequest request) {
        Date agreementDateFrom = request.getAgreementDateFrom();
        Date agreementDateTo = request.getAgreementDateTo();

        if (agreementDateFrom == null) {
            return Optional.of(new ValidationError("agreementDateFrom","Must not be empty!"));
        }

        if (agreementDateTo == null) {
            return Optional.of(new ValidationError("agreementDateTo","Must not be empty!"));
        }

        try {
            LocalDate dateFrom = agreementDateFrom.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate dateTo = agreementDateTo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Check whether the date in agreementDateFrom is after the date in agreementDateTo.
            // And check whether the date in agreementDateFrom is equal the date in agreementDateTo.
            return (dateFrom.isAfter(dateTo) || dateFrom.isEqual(dateTo))
                    ? Optional.of(new ValidationError("agreementDateFrom",
                    "agreementDateFrom must be before agreementDateTo!"))
                    : Optional.empty();

        } catch (Exception e) {
            System.err.println("Unexpected error while validating agreement dates: " + e.getMessage());
            return Optional.of(new ValidationError("agreementDateFrom",
                    "Unexpected error during validation."));
        }
    }
}