package com.fjl.glo4002;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommunityCenterTest {

    @Test
    public void whenTriagingPatient_thenPatientIsAddedToTheNurseWaitingList() {
        CommunityCenter communityCenter = new CommunityCenter(HealthCenter.TriageType.FIFO);
        Patient patient = new Patient("Jack", 2, HealthCenter.VisibleSymptom.SPRAIN);

        communityCenter.triagePatient(patient);

        assertEquals(1,communityCenter.getNurseQueue().queue.size());
    }

    @Test
    public void whenTriagingPatient_ifPatientHasGravity1_thenPatientIsNotAddedToTheNurseWaitingList() {
        CommunityCenter communityCenter = new CommunityCenter(HealthCenter.TriageType.FIFO);
        Patient patient = new Patient("Jack", 1, HealthCenter.VisibleSymptom.SPRAIN);

        communityCenter.triagePatient(patient);

        assertEquals(0,communityCenter.getNurseQueue().queue.size());
    }

}
