package com.projetmeteo.meteo.Gestion;

import java.util.List;

import com.projetmeteo.meteo.ClasseMeteo.WeatherDataCity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

// Marque cette interface comme un composant Spring, géré par le conteneur Spring
@Component
public interface WeatherDataRepository extends JpaRepository<WeatherDataCity, Long> {
    // Recherche toutes les entrées WeatherDataCity par adresse
    List<WeatherDataCity> findAllByaddress(String address);

    // Recherche toutes les entrées WeatherDataCity par adresse résolue
    List<WeatherDataCity> findAllByResolvedAddress(String resolvedAddress);

    // Recherche toutes les entrées WeatherDataCity par ID (version int)
    List<WeatherDataCity> findById(int id);

    // Récupère toutes les entrées WeatherDataCity
    List<WeatherDataCity> findAll();
}