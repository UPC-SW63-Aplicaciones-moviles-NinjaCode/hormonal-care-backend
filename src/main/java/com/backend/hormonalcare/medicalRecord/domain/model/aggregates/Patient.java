package com.backend.hormonalcare.medicalRecord.domain.model.aggregates;

import com.backend.hormonalcare.medicalRecord.domain.model.commands.CreatePatientCommand;
import com.backend.hormonalcare.medicalRecord.domain.model.valueobjects.PatientRecordId;
import com.backend.hormonalcare.medicalRecord.domain.model.valueobjects.ProfileId;
import com.backend.hormonalcare.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Patient extends AuditableAbstractAggregateRoot<Patient> {

    private String typeofblood;

    @Embedded
    @Column(name = "patientRecord_id")
    private final PatientRecordId patientRecordId;

    @Embedded
    private ProfileId profileId;

    @Getter
    @Column(name = "doctor_id")
    private Long doctor;


    public Patient() {
        this.typeofblood = "";
        this.patientRecordId = new PatientRecordId();
        this.doctor = null;
    }
    public Patient(Long profileId, String typeofblood, Long doctor) {
        this.profileId = new ProfileId(profileId);
        this.typeofblood = typeofblood;
        this.patientRecordId = new PatientRecordId();
        this.doctor = doctor;
    }
    public Patient(ProfileId profileId, String typeofblood, Long doctor) {
        this.profileId = profileId;
        this.typeofblood = typeofblood;
        this.patientRecordId = new PatientRecordId();
        this.doctor = doctor;
    }

    public Patient(CreatePatientCommand command, ProfileId profileId, Long doctor) {
        this.typeofblood = command.typeofblood();
        this.profileId = profileId;
        this.patientRecordId = new PatientRecordId();
        this.doctor = doctor;
    }
    public Patient updateInformation(String typeofblood) {
        this.typeofblood = typeofblood;

        return this;
    }
    public Patient updateDoctorId(Long doctor) {
        this.doctor = doctor;
        return this;
    }
    public String getPatientRecordId() {return this.patientRecordId.patientRecordId();}
    public Long getProfileId() {return this.profileId.profileId();}


}
