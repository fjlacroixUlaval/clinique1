package com.fjl.glo4002;

import java.util.ArrayList;

public class CommunityCenter {


    public Clinic.TriageType getNurseTriageType() {
        return nurseTriageType;
    }

    public void setNurseTriageType(Clinic.TriageType nurseTriageType) {
        this.nurseTriageType = nurseTriageType;
    }

    Clinic.TriageType nurseTriageType;

    public ArrayList<Clinic.Patient> getNurseQueue() {
        return nurseQueue;
    }

    public void setNurseQueue(ArrayList<Clinic.Patient> nurseQueue) {
        this.nurseQueue = nurseQueue;
    }

    private ArrayList<Clinic.Patient> nurseQueue = new ArrayList<>();


    public CommunityCenter(Clinic.TriageType nurseTriageType) {

        this.nurseTriageType = nurseTriageType;

    }

    public void triagePatient(Clinic.Patient patient) {


        if(nurseTriageType == Clinic.TriageType.FIFO){

            nurseQueue.add(patient);

        }else if(nurseTriageType == Clinic.TriageType.GRAVITY){

            if(patient.getGravity() >= 5){
                nurseQueue.add(0,patient);
            }
            else{
                nurseQueue.add(patient);
            }

        }

    }

}
