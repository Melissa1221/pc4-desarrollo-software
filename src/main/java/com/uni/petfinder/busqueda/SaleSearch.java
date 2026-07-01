package com.uni.petfinder.busqueda;

import java.util.Arrays;
import java.util.List;

// RF 2.4: en venta solo se muestran criaderos comerciales certificados.
public class SaleSearch implements SearchStrategy {

    @Override
    public List<String> search(ImageQuery query) {
        return Arrays.asList(
                "Criadero Los Andes (certificado) - ejemplar en venta",
                "Criadero Norte (certificado) - ejemplar en venta");
    }
}
