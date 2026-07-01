package com.uni.petfinder;

import com.uni.petfinder.alertas.AlertCenter;
import com.uni.petfinder.alertas.AlertObserver;
import com.uni.petfinder.alertas.LostPet;
import com.uni.petfinder.busqueda.AdoptionSearch;
import com.uni.petfinder.busqueda.ImageQuery;
import com.uni.petfinder.busqueda.LostCheckSearch;
import com.uni.petfinder.busqueda.SaleSearch;
import com.uni.petfinder.busqueda.SearchTemplate;
import com.uni.petfinder.cuidadores.AlertSwitch;
import com.uni.petfinder.cuidadores.CaregiverProfile;
import com.uni.petfinder.cuidadores.DisableAlertsCommand;
import com.uni.petfinder.cuidadores.IdValidator;
import com.uni.petfinder.cuidadores.NameValidator;
import com.uni.petfinder.cuidadores.ProfileValidator;

import java.util.List;

// Demo que ejercita los patrones de comportamiento de cada módulo.
public class App {

    public static void main(String[] args) {

        System.out.println("=== Módulo 1: alertas (Observer + State) ===");
        AlertCenter center = new AlertCenter();

        AlertObserver ana = pet ->
                System.out.println("Ana recibe alerta: " + pet.getName() + " perdido cerca");
        center.subscribe(ana, -12.021, -77.031);

        AlertObserver luis = pet ->
                System.out.println("Luis recibe alerta: " + pet.getName());
        center.subscribe(luis, -12.20, -76.90);

        LostPet firulais = new LostPet("Firulais", "perro", "criollo", "foto.jpg",
                "collar rojo", "owner-1", -12.02, -77.03);
        System.out.println("Estado del reporte: " + firulais.getState());
        center.reportLostPet(firulais, 1.0);

        // el reporte avanza de estado (State).
        firulais.advance();
        System.out.println("Nuevo estado: " + firulais.getState());

        System.out.println("\n=== Módulo 2: buscador por imagen (Strategy + Template Method) ===");
        ImageQuery query = new ImageQuery("mascota.png");
        List<SearchTemplate> searches = List.of(
                new AdoptionSearch(), new SaleSearch(), new LostCheckSearch());
        for (SearchTemplate s : searches) {
            System.out.println(s.getClass().getSimpleName() + ": " + s.run(query));
        }

        System.out.println("\n=== Módulo 3: cuidadores (Command + Chain of Responsibility) ===");
        CaregiverProfile maria = new CaregiverProfile("María", "especializado");
        maria.acceptSpecies("perro");
        maria.setIdVerified(true);

        // cadena de validación antes de habilitar el perfil.
        ProfileValidator chain = new NameValidator();
        chain.linkWith(new IdValidator());
        System.out.println("¿Perfil habilitado? " + chain.validate(maria));

        // interruptor de alertas con Command (RF 3.3).
        AlertSwitch aSwitch = new AlertSwitch();
        aSwitch.press(new DisableAlertsCommand(), maria);
        System.out.println("¿Recibe alertas? " + maria.receivesAlerts());
    }
}
