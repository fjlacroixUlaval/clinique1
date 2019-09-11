package com.fjl.glo4002;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {



    @Test
    public void triageOnePatientMigraineFIFO()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.FIFO,Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("John", 4, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),1,"doctorQueue should have length 1");
        assertEquals(clinic.getDoctorQueue().get(0),patient,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should be empty");
    }



    @Test
    public void triageTwoPatientFIFO(){

        Clinic clinic = new Clinic(Clinic.TriageType.FIFO,Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 4, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);
        Clinic.Patient patient2 = new Clinic.Patient("Bob", 4, Clinic.VisibleSymptom.FLU);
        clinic.triagePatient(patient2);

        assertEquals(clinic.getDoctorQueue().size(),2,"doctorQueue should have length 1");
        assertEquals(clinic.getDoctorQueue().get(1),patient2,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should be empty");
    }

    @Test
    public void triageOnePatientSprainFIFO()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.FIFO,Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Bob", 4, Clinic.VisibleSymptom.SPRAIN);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),1,"doctorQueue should have length 1");
        assertEquals(clinic.getDoctorQueue().get(0),patient,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),1,"radiologyQueue should have length 1");
        assertEquals(clinic.getRadiologyQueue().get(0),patient,"First radiology patient is not the new patient");
    }

    @Test
    public void triageOnePatientBrokenBoneFIFO()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.FIFO,Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Bob", 4, Clinic.VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),1,"doctorQueue should have length 1");
        assertEquals(clinic.getDoctorQueue().get(0),patient,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),1,"radiologyQueue should have length 1");
        assertEquals(clinic.getRadiologyQueue().get(0),patient,"First radiology patient is not the new patient");
    }


    @Test
    public void triageTwoPatientsGravity()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.GRAVITY,Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 4, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);
        Clinic.Patient patient2 = new Clinic.Patient("Bob", 7, Clinic.VisibleSymptom.FLU);
        clinic.triagePatient(patient2);

        assertEquals(clinic.getDoctorQueue().size(),2,"doctorQueue should have length 2");
        assertEquals(clinic.getDoctorQueue().get(0),patient2,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should be empty");
    }


    @Test
    public void triageThreePatientsGravityWithRadiology()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.GRAVITY,Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 4, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);
        Clinic.Patient patient2 = new Clinic.Patient("Charles", 4, Clinic.VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(patient2);
        Clinic.Patient patient3 = new Clinic.Patient("Bob", 7, Clinic.VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(patient3);

        assertEquals(clinic.getDoctorQueue().size(),3,"doctorQueue should have length 3");
        assertEquals(clinic.getDoctorQueue().get(0),patient3,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),2,"radiologyQueue should be length 2");
        assertEquals(clinic.getRadiologyQueue().get(1),patient3,"New patient is not the last patient");

    }


    @Test
    public void triageThreePatientsDoctorQueueGravityAndRadiologyQueueGravity()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.GRAVITY, Clinic.TriageType.GRAVITY);
        Clinic.Patient patient = new Clinic.Patient("Alice", 4, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);
        Clinic.Patient patient2 = new Clinic.Patient("Charles", 4, Clinic.VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(patient2);
        Clinic.Patient patient3 = new Clinic.Patient("Bob", 7, Clinic.VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(patient3);

        assertEquals(clinic.getDoctorQueue().size(),3,"doctorQueue should have length 3");
        assertEquals(clinic.getDoctorQueue().get(0),patient3,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),2,"radiologyQueue should be length 2");
        assertEquals(clinic.getRadiologyQueue().get(0),patient3,"New patient is not the last patient");

    }

    @Test
    public void ignoreLowGravityPatientDoctorFIFORadiologyFIFO()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.FIFO, Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 1, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),0,"doctorQueue should have length 0");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should have length 0");

    }

    @Test
    public void ignoreLowGravityPatientDoctorFIFORadiologyGravity()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.FIFO, Clinic.TriageType.GRAVITY);
        Clinic.Patient patient = new Clinic.Patient("Alice", 1, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),0,"doctorQueue should have length 0");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should have length 0");

    }

    @Test
    public void ignoreLowGravityPatientDoctorGravityRadiologyFIFO()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.GRAVITY, Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 1, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),0,"doctorQueue should have length 0");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should have length 0");

    }

    @Test
    public void ignoreLowGravityPatientDoctorGravityRadiologyGravity()
    {
        Clinic clinic = new Clinic(Clinic.TriageType.GRAVITY, Clinic.TriageType.GRAVITY);
        Clinic.Patient patient = new Clinic.Patient("Alice", 1, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),0,"doctorQueue should have length 0");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should have length 0");

    }


}
