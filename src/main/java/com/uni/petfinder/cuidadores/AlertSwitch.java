package com.uni.petfinder.cuidadores;

// Invoker del Command: el interruptor que dispara la acción sobre el perfil.
public class AlertSwitch {

    public void press(AlertCommand command, CaregiverProfile profile) {
        command.execute(profile);
    }
}
