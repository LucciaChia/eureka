package com.example.sights.services;

import com.example.sights.SightBean;
import com.example.sights.client.CountryClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SightAndCapitalService {

    private final CountryClient countryClient;

    public SightBean getCountryInfo(String countryShortcut) {
        SightBean sightBean = new SightBean("xy", "Unknown Country", "Unknown City", 9999);
        try {
            sightBean = countryClient.getCountry(countryShortcut);
        } catch (FeignException fex) {
            System.out.println("THERE IS NO COUNTRY LIKE \"" + countryShortcut + "\" IN A LIST !!!");
        }
        return sightBean;
    }
}
