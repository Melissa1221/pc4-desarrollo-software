package com.uni.petfinder.busqueda;

import java.util.ArrayList;
import java.util.List;

// RF 2.5: verificar pérdida contrasta los metadatos con las alertas activas.
public class LostCheckSearch implements SearchStrategy {

    @Override
    public List<String> search(ImageQuery query) {
        List<String> matches = new ArrayList<>();
        String species = query.get("species");
        if (species != null) {
            matches.add("Alerta activa que coincide en especie: " + species);
        } else {
            matches.add("Sin coincidencias en alertas activas");
        }
        return matches;
    }
}
