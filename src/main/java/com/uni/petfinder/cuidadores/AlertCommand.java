package com.uni.petfinder.cuidadores;

// Command: acción sobre un perfil de cuidador.
public interface AlertCommand {
    void execute(CaregiverProfile profile);
}
