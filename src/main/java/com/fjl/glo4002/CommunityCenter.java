package com.fjl.glo4002;

public class CommunityCenter extends HealthCenter implements Sortable {



    public CommunityCenter(TriageType nurseTriageType){

        nurseQueue = new PatientQueue(nurseTriageType);

    }

    @Override
    public void triagePatient(Patient patient) {

        if (patient.getGravity() == 1) {
            return;
        }

        nurseQueue.addPatient(patient);

    }
}
