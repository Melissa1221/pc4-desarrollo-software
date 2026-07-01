package com.uni.petfinder.busqueda;

import java.util.List;

// RF 2.4: venta muestra solo criaderos certificados. Búsqueda no implementada.
public class SaleSearch extends SearchTemplate {

    @Override
    protected List<String> search(ImageQuery query) {
        return List.of("(resultados de criaderos comerciales certificados)");
    }
}
