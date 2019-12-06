package com.example.sightsservice;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Sight {

    @Id
    private int sightId;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String countryName;

    @Transient
    int port;
}
