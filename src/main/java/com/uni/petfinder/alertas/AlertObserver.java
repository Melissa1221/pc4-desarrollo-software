package com.uni.petfinder.alertas;

// Observer: quien quiera recibir alertas de mascotas perdidas.
public interface AlertObserver {
    void onLostPet(LostPet pet);
}
