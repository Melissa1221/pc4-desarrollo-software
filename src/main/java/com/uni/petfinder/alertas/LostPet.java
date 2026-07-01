package com.uni.petfinder.alertas;

// RF 1.1: mascota reportada como perdida por su dueño.
public class LostPet {

    private final String name;
    private final String species;
    private final String breed;
    private final String photo;
    private final String description;
    private final String ownerId;
    private final double lat;
    private final double lon;

    public LostPet(String name, String species, String breed, String photo,
                   String description, String ownerId, double lat, double lon) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.photo = photo;
        this.description = description;
        this.ownerId = ownerId;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    // RF 1.2: coordenadas del reporte.
    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    // RNF 1.2: el id del dueño no se expone al ciudadano que avista.
    public String getOwnerId() {
        return ownerId;
    }

    public String getDescription() {
        return description;
    }
}
