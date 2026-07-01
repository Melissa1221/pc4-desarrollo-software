package com.uni.petfinder.busqueda;

// RF 2.1 / RNF 2.1: consulta que llega al buscador. Los metadatos van en
// un mapa (JSON plano) para que el motor sea intercambiable.
import java.util.HashMap;
import java.util.Map;

public class ImageQuery {

    private final String imageFile;
    private final Map<String, String> metadata = new HashMap<>();

    public ImageQuery(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void put(String key, String value) {
        metadata.put(key, value);
    }

    public String get(String key) {
        return metadata.get(key);
    }
}
