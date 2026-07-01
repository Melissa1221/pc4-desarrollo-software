package com.uni.petfinder;

import com.uni.petfinder.alertas.AlertCenter;
import com.uni.petfinder.alertas.AlertObserver;
import com.uni.petfinder.alertas.LostPet;
import com.uni.petfinder.busqueda.ImageQuery;
import com.uni.petfinder.busqueda.SearchIntent;
import com.uni.petfinder.busqueda.SearchStrategy;
import com.uni.petfinder.busqueda.SearchStrategyFactory;
import com.uni.petfinder.cuidadores.BaseCaregiver;
import com.uni.petfinder.cuidadores.CaregiverProfile;
import com.uni.petfinder.cuidadores.CaregiverProfileBuilder;
import com.uni.petfinder.cuidadores.CaregiverRole;
import com.uni.petfinder.cuidadores.ProfessionalRole;
import com.uni.petfinder.cuidadores.SpecializedRole;

import java.util.List;

// Demo que ejercita los tres módulos con sus patrones.
public class App {

    public static void main(String[] args) {

        System.out.println("=== Módulo 1: alertas (Observer + Singleton) ===");
        AlertCenter center = AlertCenter.getInstance();

        // un cuidador se suscribe a las alertas de su zona.
        AlertObserver ana = pet ->
                System.out.println("Ana recibe alerta: " + pet.getName() + " perdido cerca");
        center.subscribe(ana, -12.021, -77.031);

        // otro cuidador está lejos, no debería recibir la alerta.
        AlertObserver luis = pet ->
                System.out.println("Luis recibe alerta: " + pet.getName());
        center.subscribe(luis, -12.20, -76.90);

        LostPet firulais = new LostPet("Firulais", "perro", "criollo", "foto.jpg",
                "collar rojo", "owner-1", -12.02, -77.03);
        center.reportLostPet(firulais, 1.0); // radio 1 km

        System.out.println("\n=== Módulo 2: buscador por imagen (Strategy + Factory) ===");
        ImageQuery query = new ImageQuery("mascota.png");
        query.put("species", "perro");
        for (SearchIntent intent : SearchIntent.values()) {
            SearchStrategy strategy = SearchStrategyFactory.create(intent);
            System.out.println("Intención " + intent + ":");
            for (String r : strategy.search(query)) {
                System.out.println("  - " + r);
            }
        }

        System.out.println("\n=== Módulo 3: cuidadores (Builder + Decorator) ===");
        CaregiverProfile profile = new CaregiverProfileBuilder()
                .name("María")
                .acceptSpecies("perro")
                .acceptSpecies("gato")
                .acceptSize("pequeño")
                .givesMedication(true)
                .verifyId(true)
                .build();
        System.out.println("Perfil de " + profile.getName()
                + " | público: " + profile.isPublic()
                + " | especies: " + profile.getAcceptedSpecies());

        // roles combinados con Decorator.
        CaregiverRole role = new SpecializedRole(new ProfessionalRole(new BaseCaregiver("María")));
        System.out.println(role.description());

        // RF 3.3: interruptor de alertas.
        profile.toggleAlerts(false);
        System.out.println("¿Recibe alertas? " + profile.receivesAlerts());
    }
}
