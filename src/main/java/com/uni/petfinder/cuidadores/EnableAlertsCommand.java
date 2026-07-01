package com.uni.petfinder.cuidadores;

// RF 3.3: activa la recepción de alertas.
public class EnableAlertsCommand implements AlertCommand {

    @Override
    public void execute(CaregiverProfile profile) {
        profile.setReceivesAlerts(true);
    }
}
