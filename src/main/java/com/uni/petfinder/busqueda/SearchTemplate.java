package com.uni.petfinder.busqueda;

import java.util.List;

// Template Method: fija el flujo de una búsqueda (validar -> buscar -> formatear)
// y deja que cada intención complete el paso concreto de búsqueda.
public abstract class SearchTemplate implements SearchStrategy {

    // método plantilla (a la vez implementa la estrategia): el orden no cambia.
    @Override
    public final List<String> run(ImageQuery query) {
        validate(query);
        List<String> results = search(query);
        return format(results);
    }

    private void validate(ImageQuery query) {
        if (query.getImageFile() == null) {
            throw new IllegalArgumentException("Falta la imagen");
        }
    }

    // paso que cada intención define a su manera.
    protected abstract List<String> search(ImageQuery query);

    protected List<String> format(List<String> results) {
        return results; // hook por defecto; una intención puede sobrescribirlo.
    }
}
