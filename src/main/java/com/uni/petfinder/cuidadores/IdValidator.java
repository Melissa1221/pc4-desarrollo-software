package com.uni.petfinder.cuidadores;

// RNF 3.1: no se habilita el perfil sin documento validado.
public class IdValidator extends ProfileValidator {

    @Override
    protected boolean check(CaregiverProfile profile) {
        return profile.isIdVerified();
    }
}
