package com.backend.hormonalcare.medicalRecord.interfaces.rest.transform;

import com.backend.hormonalcare.medicalRecord.domain.model.aggregates.Doctor;
import com.backend.hormonalcare.medicalRecord.interfaces.rest.resources.DoctorResource;

public class DoctorResourceFromEntityAssembler {
    public static DoctorResource toResourceFromEntity(Doctor entity){
        return new DoctorResource(
            entity.getProfessionalIdentificationNumber().professionalIdentificationNumber(),
            entity.getSubSpecialty().subSpecialty(),
            entity.getCertification().certification(),
            entity.getAppointmentFee(),
            entity.getSubscriptionId(),
            entity.getProfileId(),
                entity.getDoctorRecordId()
        );
    }
}

