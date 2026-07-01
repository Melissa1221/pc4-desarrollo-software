package com.uni.petfinder.cuidadores;

public class NameValidator extends ProfileValidator {

    @Override
    protected boolean check(CaregiverProfile profile) {
        return profile.getName() != null && !profile.getName().isBlank();
    }
}
