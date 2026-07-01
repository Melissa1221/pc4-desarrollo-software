package com.uni.petfinder.busqueda;

import java.util.List;

// RF 2.3: adopción devuelve solo protectoras/ONGs. La búsqueda real no se
// implementa; se deja el punto donde iría el motor.
public class AdoptionSearch extends SearchTemplate {

    @Override
    protected List<String> search(ImageQuery query) {
        return List.of("(resultados del catálogo de protectoras/ONGs)");
    }
}
