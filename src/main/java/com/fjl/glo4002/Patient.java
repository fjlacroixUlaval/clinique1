package com.fjl.glo4002;

public class Patient {

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

    public HealthCenter.VisibleSymptom getVisibleSymptom() {
        return visibleSymptom;
    }


    private String name;
    private int gravity;
    private HealthCenter.VisibleSymptom visibleSymptom;

    public Patient(String name, int gravity, HealthCenter.VisibleSymptom visibleSymptom) {

        this.name = name;
        this.gravity = gravity;
        this.visibleSymptom = visibleSymptom;


    }

    public boolean equals(Patient patient) {

        if (this.name == patient.getName() && this.gravity == patient.getGravity() && this.visibleSymptom == patient.getVisibleSymptom()) {
            return true;
        } else {
            return false;
        }
    }

}

