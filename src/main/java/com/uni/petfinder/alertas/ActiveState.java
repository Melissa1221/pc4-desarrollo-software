package com.uni.petfinder.alertas;

public class ActiveState implements ReportState {

    @Override
    public String name() {
        return "ACTIVO";
    }

    @Override
    public ReportState next() {
        return new FoundState();
    }
}
