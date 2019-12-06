package com.example.sights;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SightBean {
    // nazvy premennych musia dokonale na 100% !!!!! sediet s tymi v service, z ktorej beriem informacie
    private String countryShortcut;
    private String countryName;
    private String capital;
    private int port;
}
