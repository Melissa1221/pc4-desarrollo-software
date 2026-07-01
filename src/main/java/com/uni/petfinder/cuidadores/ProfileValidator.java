package com.uni.petfinder.cuidadores;

// Chain of Responsibility: cada validador revisa una condición y, si pasa,
// deja seguir al siguiente. Se usa para habilitar el perfil (RNF 3.1).
public abstract class ProfileValidator {

    private ProfileValidator next;

    public ProfileValidator linkWith(ProfileValidator next) {
        this.next = next;
        return next;
    }

    public boolean validate(CaregiverProfile profile) {
        if (!check(profile)) {
            return false;
        }
        if (next == null) {
            return true;
        }
        return next.validate(profile);
    }

    protected abstract boolean check(CaregiverProfile profile);
}
