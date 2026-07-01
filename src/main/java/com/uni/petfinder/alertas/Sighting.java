package com.uni.petfinder.alertas;

// RF 1.3: avistamiento registrado por un ciudadano anónimo.
public class Sighting {

    private final String photo;
    private final double lat;
    private final double lon;

    public Sighting(String photo, double lat, double lon) {
        this.photo = photo;
        this.lat = lat;
        this.lon = lon;
    }

    public String getPhoto() {
        return photo;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
