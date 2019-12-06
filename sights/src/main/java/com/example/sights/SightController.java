package com.example.sights;

import com.example.sights.domain.Sight;
import com.example.sights.services.SightAndCapitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class SightController {

    HashMap<Integer, Integer> timePort = new HashMap<>();

    @Autowired
    private SightAndCapitalService sightAndCapitalService;

    @Autowired
    private SightRepository sightRepository;

    @Autowired
    private Environment environment;

    @GetMapping("/sights/{countryShortcut}")
    public List<Sight> getSightsInCountry(@PathVariable String countryShortcut) {
        List<Sight> sightsInACountry = new ArrayList<>();
        sightsInACountry = sightRepository.findAllInACountry(countryShortcut);
        System.out.println("Sights in a Country: ");
        sightsInACountry.stream().forEach(sight -> System.out.println(sight.toString()));
        System.out.println("Capital of this Country: \n" + sightAndCapitalService.getCountryInfo(countryShortcut).toString());
        return sightsInACountry;
    }
}
