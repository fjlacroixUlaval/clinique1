package com.fjl.glo4002;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;


public class Clinic {


    public enum TriageType {
        FIFO,
        GRAVITY
    }

    public enum VisibleSymptom {
        COLD,
        FLU,
        EBOLA,
        BROKEN_BONE,
        CHEST_PAIN,
        MIGRAINE,
        SPRAIN
    }


    public ArrayList<Patient> getDoctorQueue() {
        return doctorQueue;
    }

    public void setDoctorQueue(ArrayList<Patient> doctorQueue) {
        this.doctorQueue = doctorQueue;
    }

    private ArrayList<Patient> doctorQueue = new ArrayList<>();

    public ArrayList<Patient> getRadiologyQueue() {
        return radiologyQueue;
    }

    public void setRadiologyQueue(ArrayList<Patient> radiologyQueue) {
        this.radiologyQueue = radiologyQueue;
    }

    private ArrayList<Patient> radiologyQueue = new ArrayList<>();


    TriageType doctorTriageType;
    TriageType radiologyTriageType;

    public Clinic(TriageType doctorTriageType,TriageType radiologyTriageType) {

        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;

    }

    public void triagePatient(Patient patient) {


        if (patient.getVisibleSymptom() == VisibleSymptom.BROKEN_BONE || patient.getVisibleSymptom() == VisibleSymptom.SPRAIN) {

            if(radiologyTriageType == TriageType.FIFO) {
                radiologyQueue.add(patient);

            }else if(radiologyTriageType == TriageType.GRAVITY){

                if(patient.getGravity() >= 5){
                    radiologyQueue.add(0,patient);
                }
                else{
                    radiologyQueue.add(patient);
                }
            }
        }

        if(doctorTriageType == TriageType.FIFO) {

            doctorQueue.add(patient);


        }else if(doctorTriageType == TriageType.GRAVITY){

            if(patient.getGravity() >= 5){
                doctorQueue.add(0,patient);
            }
            else{
                doctorQueue.add(patient);
            }

        }


    }


    public static class Patient{

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGravity() {
            return gravity;
        }

        public void setGravity(int gravity) {
            this.gravity = gravity;
        }

        public VisibleSymptom getVisibleSymptom() {
            return visibleSymptom;
        }

        public void setVisibleSymptom(VisibleSymptom visibleSymptom) {
            this.visibleSymptom = visibleSymptom;
        }

        private String name;
        private int gravity;
        private VisibleSymptom visibleSymptom;

        public Patient(String name, int gravity, VisibleSymptom visibleSymptom){

            this.name = name;
            this.gravity = gravity;
            this.visibleSymptom = visibleSymptom;


        }

        public boolean equals(Patient patient){

            if(this.name == patient.getName() && this.gravity == patient.getGravity() && this.visibleSymptom == patient.getVisibleSymptom()){
                return true;
            }
            else{
                return false;
            }

        }


    }







}




