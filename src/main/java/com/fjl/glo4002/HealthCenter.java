package com.fjl.glo4002;

public abstract class HealthCenter {


    protected PatientQueue doctorQueue;
    protected PatientQueue radiologyQueue;

    public PatientQueue getNurseQueue() {
        return nurseQueue;
    }

    protected PatientQueue nurseQueue;


    public PatientQueue getDoctorQueue() {
        return doctorQueue;
    }

    public PatientQueue getRadiologyQueue() {
        return radiologyQueue;
    }

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
}
