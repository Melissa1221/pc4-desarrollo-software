package com.uni.petfinder.alertas;

import java.util.ArrayList;
import java.util.List;

// Subject del patrón Observer: mantiene la lista de suscriptores y les avisa
// cuando se reporta una mascota perdida dentro de su radio (RF 1.4).
public class AlertCenter {

    private final List<Subscription> subs = new ArrayList<>();

    public void subscribe(AlertObserver obs, double lat, double lon) {
        subs.add(new Subscription(obs, lat, lon));
    }

    public void unsubscribe(AlertObserver obs) {
        subs.removeIf(s -> s.obs == obs);
    }

    public void reportLostPet(LostPet pet, double radiusKm) {
        for (Subscription s : subs) {
            if (distanceKm(pet.getLat(), pet.getLon(), s.lat, s.lon) <= radiusKm) {
                s.obs.onLostPet(pet);
            }
        }
    }

    private double distanceKm(double lat1, double lon1, double lat2, double lon2) {
        double dLat = (lat1 - lat2) * 111;
        double dLon = (lon1 - lon2) * 111;
        return Math.sqrt(dLat * dLat + dLon * dLon);
    }

    private static class Subscription {
        final AlertObserver obs;
        final double lat;
        final double lon;

        Subscription(AlertObserver obs, double lat, double lon) {
            this.obs = obs;
            this.lat = lat;
            this.lon = lon;
        }
    }
}
