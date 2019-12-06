package com.profesorp.countriesservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.profesorp.countriesservice.entities.Countries;

import java.util.Optional;

public interface CountriesRepository extends JpaRepository <Countries,String>{

    Optional<Countries> findByCountryShortcut(String countryShortcut);
}
