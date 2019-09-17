package com.fjl.glo4002;

import java.util.ArrayList;

public class PatientQueue{

    public ArrayList<Patient> queue = new ArrayList<>();
    public Clinic.TriageType triageType;

    public PatientQueue(Clinic.TriageType triageType){

        this.triageType = triageType;
    }

    public void addPatient(Patient patient) {

        if (triageType == HealthCenter.TriageType.FIFO) {
            queue.add(patient);
        } else if (triageType == HealthCenter.TriageType.GRAVITY) {
            if (patient.getGravity() > 5) {
                queue.add(0, patient);
            } else {
                queue.add(patient);
            }
        }

    }

}
