package com.uni.petfinder.alertas;

public class FoundState implements ReportState {

    @Override
    public String name() {
        return "ENCONTRADO";
    }

    @Override
    public ReportState next() {
        return new ClosedState();
    }
}
