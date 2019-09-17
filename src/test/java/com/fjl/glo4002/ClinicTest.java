package com.fjl.glo4002;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {


    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheDoctorWaitingList() {
        Clinic clinic = new Clinic(HealthCenter.TriageType.FIFO, HealthCenter.TriageType.FIFO);
        Patient patient = new Patient("Jack", 2, HealthCenter.VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);

        assertEquals(1,clinic.getDoctorQueue().queue.size());
    }

    @Test
    public void whenTriagingPatientWithTheFlu_thenPatientIsNotAddedToTheRadiologyWaitingList() {

        Clinic clinic = new Clinic(HealthCenter.TriageType.FIFO, HealthCenter.TriageType.FIFO);
        Patient patient = new Patient("Jack", 2, HealthCenter.VisibleSymptom.FLU);

        clinic.triagePatient(patient);

        assertEquals(0,clinic.getRadiologyQueue().queue.size());
    }

    @Test
    public void whenTriagingPatientWithABrokenBone_thenPatientIsAddedToTheRadiologyWaitingList() {

        Clinic clinic = new Clinic(HealthCenter.TriageType.FIFO, HealthCenter.TriageType.FIFO);
        Patient patient = new Patient("Jack", 2, HealthCenter.VisibleSymptom.BROKEN_BONE);

        clinic.triagePatient(patient);

        assertEquals(1,clinic.getRadiologyQueue().queue.size());
    }

    @Test
    public void whenTriagingPatientWithASprain_thenPatientIsAddedToTheRadiologyWaitingList() {

        Clinic clinic = new Clinic(HealthCenter.TriageType.FIFO, HealthCenter.TriageType.FIFO);
        Patient patient = new Patient("Jack", 2, HealthCenter.VisibleSymptom.SPRAIN);

        clinic.triagePatient(patient);

        assertEquals(1,clinic.getRadiologyQueue().queue.size());
    }




}
