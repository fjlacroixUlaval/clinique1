package com.fjl.glo4002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunityCenterTest {


    @Test
    public void triagePatientsFIFO()
    {
        CommunityCenter communityCenter = new CommunityCenter(Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 4, Clinic.VisibleSymptom.MIGRAINE);
        communityCenter.triagePatient(patient);
        Clinic.Patient patient2 = new Clinic.Patient("Charles", 4, Clinic.VisibleSymptom.BROKEN_BONE);
        communityCenter.triagePatient(patient2);
        Clinic.Patient patient3 = new Clinic.Patient("Bob", 7, Clinic.VisibleSymptom.BROKEN_BONE);
        communityCenter.triagePatient(patient3);

        assertEquals(communityCenter.getNurseQueue().size(),3,"doctorQueue should have length 3");
        assertEquals(communityCenter.getNurseQueue().get(2),patient3,"First patient is not the new patient");

    }

    @Test
    public void triagePatientsGravity()
    {
        CommunityCenter communityCenter = new CommunityCenter(Clinic.TriageType.GRAVITY);
        Clinic.Patient patient = new Clinic.Patient("Alice", 4, Clinic.VisibleSymptom.MIGRAINE);
        communityCenter.triagePatient(patient);
        Clinic.Patient patient2 = new Clinic.Patient("Charles", 4, Clinic.VisibleSymptom.BROKEN_BONE);
        communityCenter.triagePatient(patient2);
        Clinic.Patient patient3 = new Clinic.Patient("Bob", 7, Clinic.VisibleSymptom.BROKEN_BONE);
        communityCenter.triagePatient(patient3);

        assertEquals(communityCenter.getNurseQueue().size(),3,"doctorQueue should have length 3");
        assertEquals(communityCenter.getNurseQueue().get(0),patient3,"First patient is not the new patient");

    }


    @Test
    public void ignoreLowGravityPatientFIFO()
    {
        CommunityCenter communityCenter = new CommunityCenter(Clinic.TriageType.FIFO);
        Clinic.Patient patient = new Clinic.Patient("Alice", 1, Clinic.VisibleSymptom.MIGRAINE);
        communityCenter.triagePatient(patient);

        assertEquals(communityCenter.getNurseQueue().size(),0,"NurseQueue should have length 0");

    }

    @Test
    public void ignoreLowGravityPatientGravity()
    {
        CommunityCenter communityCenter = new CommunityCenter(Clinic.TriageType.GRAVITY);
        Clinic.Patient patient = new Clinic.Patient("Alice", 1, Clinic.VisibleSymptom.MIGRAINE);
        communityCenter.triagePatient(patient);

        assertEquals(communityCenter.getNurseQueue().size(),0,"NurseQueue should have length 0");

    }


}
