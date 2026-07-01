package com.uni.petfinder.cuidadores;

// RF 3.3: desactiva la recepción de alertas.
public class DisableAlertsCommand implements AlertCommand {

    @Override
    public void execute(CaregiverProfile profile) {
        profile.setReceivesAlerts(false);
    }
}
