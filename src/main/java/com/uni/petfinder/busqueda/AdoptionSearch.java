package com.uni.petfinder.busqueda;

import java.util.Arrays;
import java.util.List;

// RF 2.3: en adopción solo se devuelven resultados de protectoras/ONGs.
public class AdoptionSearch implements SearchStrategy {

    @Override
    public List<String> search(ImageQuery query) {
        return Arrays.asList(
                "ONG Patitas Felices - perro similar en adopción",
                "Protectora San Roque - perro similar en adopción");
    }
}
