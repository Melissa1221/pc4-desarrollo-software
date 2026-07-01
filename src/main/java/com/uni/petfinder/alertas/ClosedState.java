package com.uni.petfinder.alertas;

public class ClosedState implements ReportState {

    @Override
    public String name() {
        return "CERRADO";
    }

    @Override
    public ReportState next() {
        return this; // estado final
    }
}
