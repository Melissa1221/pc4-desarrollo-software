package com.uni.petfinder.busqueda;

import java.util.List;

// Strategy: contrato común de una búsqueda por imagen. Cada intención es una
// estrategia distinta e intercambiable (RNF 2.1).
public interface SearchStrategy {
    List<String> run(ImageQuery query);
}
