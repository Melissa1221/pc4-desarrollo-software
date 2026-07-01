package com.uni.petfinder.cuidadores;

import java.util.ArrayList;
import java.util.List;

// Perfil de un cuidador. RF 3.1 / RF 3.2: rol y restricciones de servicio.
public class CaregiverProfile {

    private final String name;
    private final String role;               // solidario, profesional, especializado
    private final List<String> species = new ArrayList<>();
    private boolean idVerified;              // RNF 3.1
    private boolean receivesAlerts = true;   // RF 3.3

    public CaregiverProfile(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void acceptSpecies(String s) {
        species.add(s);
    }

    public List<String> getSpecies() {
        return species;
    }

    public boolean isIdVerified() {
        return idVerified;
    }

    public void setIdVerified(boolean v) {
        this.idVerified = v;
    }

    public boolean receivesAlerts() {
        return receivesAlerts;
    }

    public void setReceivesAlerts(boolean v) {
        this.receivesAlerts = v;
    }
}
