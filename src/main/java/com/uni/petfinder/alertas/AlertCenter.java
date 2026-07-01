package com.uni.petfinder.alertas;

import java.util.ArrayList;
import java.util.List;

// Singleton: registro central de alertas. Es el Subject del patrón Observer.
public class AlertCenter {

    private static AlertCenter instance;

    // observador -> ubicación donde escucha (para el radio del RF 1.4).
    private final List<Subscription> subs = new ArrayList<>();

    private AlertCenter() {
    }

    public static AlertCenter getInstance() {
        if (instance == null) {
            instance = new AlertCenter();
        }
        return instance;
    }

    public void subscribe(AlertObserver obs, double lat, double lon) {
        subs.add(new Subscription(obs, lat, lon));
    }

    public void unsubscribe(AlertObserver obs) {
        subs.removeIf(s -> s.obs == obs);
    }

    // RF 1.4: al reportar una mascota se notifica solo a los que están
    // dentro del radio configurable (km).
    public void reportLostPet(LostPet pet, double radiusKm) {
        for (Subscription s : subs) {
            if (distanceKm(pet.getLat(), pet.getLon(), s.lat, s.lon) <= radiusKm) {
                s.obs.onLostPet(pet);
            }
        }
    }

    // distancia aproximada en km entre dos coordenadas.
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
