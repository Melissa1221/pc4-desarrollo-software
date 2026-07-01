package com.uni.petfinder.busqueda;

import java.util.List;

// RF 2.5: verificar pérdida contrasta con las alertas activas. Búsqueda no
// implementada; aquí iría el cruce con la base de alertas.
public class LostCheckSearch extends SearchTemplate {

    @Override
    protected List<String> search(ImageQuery query) {
        return List.of("(coincidencias contra las alertas activas)");
    }
}
