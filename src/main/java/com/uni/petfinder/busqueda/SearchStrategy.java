package com.uni.petfinder.busqueda;

import java.util.List;

// Strategy: cada intención de búsqueda resuelve la consulta a su manera.
public interface SearchStrategy {
    List<String> search(ImageQuery query);
}
