package com.uni.petfinder.cuidadores;

import java.util.ArrayList;
import java.util.List;

// Producto del Builder: perfil de un cuidador con sus restricciones.
public class CaregiverProfile {

    private String name;
    private List<String> acceptedSpecies = new ArrayList<>();
    private List<String> acceptedSizes = new ArrayList<>();
    private boolean givesMedication;
    private boolean idVerified;      // RNF 3.1
    private boolean receivesAlerts;  // RF 3.3

    public String getName() {
        return name;
    }

    public List<String> getAcceptedSpecies() {
        return acceptedSpecies;
    }

    public List<String> getAcceptedSizes() {
        return acceptedSizes;
    }

    public boolean givesMedication() {
        return givesMedication;
    }

    // RNF 3.1: el perfil solo se habilita si el documento fue validado.
    public boolean isPublic() {
        return idVerified;
    }

    // RF 3.3: interruptor de alertas del módulo 1.
    public boolean receivesAlerts() {
        return receivesAlerts;
    }

    public void toggleAlerts(boolean on) {
        this.receivesAlerts = on;
    }

    // acceso de paquete: solo el builder arma el perfil.
    void setName(String name) {
        this.name = name;
    }

    void addSpecies(String s) {
        acceptedSpecies.add(s);
    }

    void addSize(String s) {
        acceptedSizes.add(s);
    }

    void setMedication(boolean b) {
        this.givesMedication = b;
    }

    void setIdVerified(boolean b) {
        this.idVerified = b;
    }
}
