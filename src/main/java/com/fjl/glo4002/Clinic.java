package com.fjl.glo4002;


public class Clinic extends HealthCenter implements Sortable {


    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        doctorQueue = new PatientQueue(doctorTriageType);
        radiologyQueue = new PatientQueue(radiologyTriageType);
    }

    @Override
    public void triagePatient(Patient patient) {

        if (patient.getGravity() == 1) {
            return;
        }

        doctorQueue.addPatient(patient);

        if (patient.getVisibleSymptom() == VisibleSymptom.BROKEN_BONE || patient.getVisibleSymptom() == VisibleSymptom.SPRAIN) {
            radiologyQueue.addPatient(patient);
        }

    }


}




