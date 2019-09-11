package com.fjl.glo4002;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {



    @Test
    public void triageOnePatientMigraineFIFO()
    {
        Clinic clinic = new Clinic();
        Clinic.Patient patient = new Clinic.Patient("John", 4, Clinic.VisibleSymptom.MIGRAINE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),1,"doctorQueue should have length 1");
        assertEquals(clinic.getDoctorQueue().get(0),patient,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),0,"radiologyQueue should be empty");
    }



    @Test
    public void triageTwoPatientFIFO(){

        Clinic clinic = new Clinic();
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
        Clinic clinic = new Clinic();
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
        Clinic clinic = new Clinic();
        Clinic.Patient patient = new Clinic.Patient("Bob", 4, Clinic.VisibleSymptom.BROKEN_BONE);
        clinic.triagePatient(patient);

        assertEquals(clinic.getDoctorQueue().size(),1,"doctorQueue should have length 1");
        assertEquals(clinic.getDoctorQueue().get(0),patient,"First patient is not the new patient");
        assertEquals(clinic.getRadiologyQueue().size(),1,"radiologyQueue should have length 1");
        assertEquals(clinic.getRadiologyQueue().get(0),patient,"First radiology patient is not the new patient");
    }

}
