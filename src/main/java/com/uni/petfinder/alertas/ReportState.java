package com.uni.petfinder.alertas;

// State: comportamiento del reporte según su estado (activo, encontrado, cerrado).
public interface ReportState {
    String name();
    ReportState next();   // estado al que pasa cuando avanza el reporte
}
