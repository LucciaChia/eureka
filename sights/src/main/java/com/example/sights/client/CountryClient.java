package com.example.sights.client;

import com.example.sights.SightBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "countries-service")
public interface CountryClient {

    @GetMapping("/{country}")
    SightBean getCountry(@PathVariable("country") String country);

}
