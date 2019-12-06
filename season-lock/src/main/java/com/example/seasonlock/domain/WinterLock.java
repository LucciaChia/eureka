package com.example.seasonlock.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class WinterLock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String countryShortcut;

    private LocalDate day;
}
