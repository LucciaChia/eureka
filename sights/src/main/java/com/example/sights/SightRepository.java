package com.example.sights;

import com.example.sights.domain.Sight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface SightRepository extends JpaRepository<Sight, Long> {

    default List<Sight> findAllInACountry(String country) {

        List<Sight> all = findAll();
        List<Sight> countrySights = new ArrayList<>();
        for (Sight sight: all) {
            if (sight.getCountryShortcut().equals(country)) {
                countrySights.add(sight);
            }
        }
        return countrySights;
    }
}
